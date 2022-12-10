
package com.andela.assignment.ais.usecase.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.function.Consumer;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.andela.assignment.ais.adaptor.gateway.messaging.MqttTemplate;
import com.andela.assignment.ais.entity.IrrigationSchedule;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IrrigationActivatorServiceDefault implements IrrigationActivatorService {

	final private MqttTemplate mqttTemplate;
	final private IrrigationSchedulerService irrigationSchedulerService;
	private LocalDate lastExecutedDate;
	private LocalTime lastExecutedTime;

	public IrrigationActivatorServiceDefault(MqttTemplate mqttTemplate,
			IrrigationSchedulerService irrigationSchedulerService) {
		this.mqttTemplate = mqttTemplate;
		this.irrigationSchedulerService = irrigationSchedulerService;
		this.lastExecutedDate = LocalDate.now();
		this.lastExecutedTime  = LocalTime.now();
		
	}

	public MqttTemplate getMqttTemplate() {
		return mqttTemplate;
	}

	public IrrigationSchedulerService getIrrigationSchedulerService() {
		return irrigationSchedulerService;
	}

	public LocalTime getLastExecutedTime() {
		return lastExecutedTime;
	}

	public void setLastExecutedTime(LocalTime lastExecutedTime) {
		this.lastExecutedTime = lastExecutedTime;
	}

	public LocalDate getLastExecutedDate() {
		return lastExecutedDate;
	}

	public void setLastExecutedDate(LocalDate lastExecutedDate) {
		this.lastExecutedDate = lastExecutedDate;
	}

	@Scheduled(cron = "${irrigation.pumping.interval.cron}")
	public void pumpWater() throws InterruptedException, MqttException {
		log.info("pumping water called at " + LocalDateTime.now());

		LocalDate currentExecutedDate = LocalDate.now();
		LocalTime currentExecutedTime  = LocalTime.now();
		 

		// retrieve all schedules between last and current execution times, notify
		// relevant IoT activator to pump water via Mqtt middleware
		// update a status of pumping/relaying in the respective slot
		Consumer<IrrigationSchedule> activatorOn = t -> {
			try {
				notifyActivator(t, "ON");
			} catch (MqttException e1) {
				log.info(e1.toString());
			}
		};
		this.getIrrigationSchedulerService().getNextIrrigationSchedules(this.getLastExecutedTime(), currentExecutedTime, currentExecutedDate)
				.forEach(activatorOn);

		// retrieve all schedules that need to be ended by now, filter by status of
		// pumping is ongoing, and notify relevant IoT activator to stop pumping water
		Consumer<IrrigationSchedule> activatorOff = t -> {
			try {
				notifyActivator(t, "OFF");
			} catch (MqttException e1) {
				log.info(e1.toString());
			}
		};
		this.getIrrigationSchedulerService().getCompletedIrrigationSchedules(currentExecutedTime,currentExecutedDate).forEach(activatorOff);

		this.setLastExecutedDate(currentExecutedDate);
		this.setLastExecutedTime(currentExecutedTime);

		Thread.sleep(5000);
	}

	private void notifyActivator(IrrigationSchedule irrigationschedule1, String msg)
			throws MqttPersistenceException, MqttException {
		getMqttTemplate().publish(irrigationschedule1.getIotDevice().getId(), msg);
	}

}
