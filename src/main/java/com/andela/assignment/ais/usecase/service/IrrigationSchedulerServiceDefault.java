package com.andela.assignment.ais.usecase.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.andela.assignment.ais.adaptor.gateway.db.IrrigationScheduleRepo;
import com.andela.assignment.ais.entity.IrrigationSchedule;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Primary
public class IrrigationSchedulerServiceDefault implements IrrigationSchedulerService {

	final private IrrigationScheduleRepo irrigationScheduleRepo;

	public IrrigationSchedulerServiceDefault(IrrigationScheduleRepo irrigationScheduleRepo) {
		this.irrigationScheduleRepo = irrigationScheduleRepo;

	}

	public IrrigationScheduleRepo getIrrigationScheduleRepo() {
		return irrigationScheduleRepo;
	}

	@Override
	public List<IrrigationSchedule> getCompletedIrrigationSchedules(LocalDateTime currenExecutionTime) {
		log.info("Finding all slottimes currently being pumped and ends before " + currenExecutionTime);
		return this.getIrrigationScheduleRepo().findAllBySlotTimeEndBefore(currenExecutionTime);
	}

	@Override
	public List<IrrigationSchedule> getNextIrrigationSchedules(LocalDateTime lastExecutedTime,
			LocalDateTime nextExecutedTime) {
		log.info("Finding all slottimes falls between " + lastExecutedTime + " and " + nextExecutedTime);
		return this.getIrrigationScheduleRepo().findAllBySlotTimeBetween(lastExecutedTime, nextExecutedTime);
	}

}
