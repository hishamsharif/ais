package com.andela.assignment.ais.usecase.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.andela.assignment.ais.entity.IrrigationSchedule;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IrrigationSchedulerServiceWithSensorOverride implements IrrigationSchedulerService {

	final private IrrigationSchedulerService irrigationSchedulerService;

	public IrrigationSchedulerServiceWithSensorOverride(IrrigationSchedulerService irrigationSchedulerService) {

		this.irrigationSchedulerService = irrigationSchedulerService;
	}

	public IrrigationSchedulerService getIrrigationSchedulerService() {
		return irrigationSchedulerService;
	}

	@Override
	public List<IrrigationSchedule> getCompletedIrrigationSchedules(LocalDateTime currenExecutionTime) {
		log.info("To be implemented later");
		return null;
	}

	@Override
	public List<IrrigationSchedule> getNextIrrigationSchedules(LocalDateTime lastExecutedTime,
			LocalDateTime nextExecutedTime) {
		log.info("To be implemented later");
		return null;
	}

}
