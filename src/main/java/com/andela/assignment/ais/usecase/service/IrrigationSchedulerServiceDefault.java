package com.andela.assignment.ais.usecase.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.andela.assignment.ais.adaptor.gateway.db.IrrigationScheduleRepo;
import com.andela.assignment.ais.adaptor.gateway.db.IrrigationSlotTimeRepo;
import com.andela.assignment.ais.entity.IrrigationSchedule;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Primary
public class IrrigationSchedulerServiceDefault implements IrrigationSchedulerService {

	final private IrrigationScheduleRepo irrigationScheduleRepo;
	final private IrrigationSlotTimeRepo irrigationSlotTimeRepo ;

	public IrrigationSchedulerServiceDefault(IrrigationScheduleRepo irrigationScheduleRepo, IrrigationSlotTimeRepo irrigationSlotTimeRepo) {
		this.irrigationScheduleRepo = irrigationScheduleRepo;
		this.irrigationSlotTimeRepo = irrigationSlotTimeRepo ;

	}

	public IrrigationScheduleRepo getIrrigationScheduleRepo() {
		return irrigationScheduleRepo;
	}

	public IrrigationSlotTimeRepo getIrrigationSlotTimeRepo() {
		return irrigationSlotTimeRepo;
	}

	@Override
	public List<IrrigationSchedule> getCompletedIrrigationSchedules(LocalTime currenExecutionTime, LocalDate  currentExecutedDate) {
		log.info("Finding all slottimes currently being pumped and ends before " + currenExecutionTime);
		return this.getIrrigationScheduleRepo().findAllBySlotTimeEndBefore(currenExecutionTime,currentExecutedDate);
	}

	@Override
	public List<IrrigationSchedule> getNextIrrigationSchedules(LocalTime lastExecutedTime,
			LocalTime nextExecutedTime, LocalDate currentExecutedDate) {
		log.info("Finding all slottimes falls between " + lastExecutedTime + " and " + nextExecutedTime);
		return this.getIrrigationScheduleRepo().findAllBySlotTimeBetween(lastExecutedTime, nextExecutedTime,currentExecutedDate);
	}

	@Override
	public void updateSlotStatus(IrrigationSchedule t, boolean b) { 
		 t.getSlotTimes().forEach(slot -> this.getIrrigationSlotTimeRepo().updateSlotPumpingStatus(b, slot.getId()) );
	}

}
