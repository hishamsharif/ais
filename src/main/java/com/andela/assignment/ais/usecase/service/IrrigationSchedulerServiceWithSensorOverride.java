package com.andela.assignment.ais.usecase.service;

import java.time.LocalDate;
import java.time.LocalTime;
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
	public List<IrrigationSchedule> getCompletedIrrigationSchedules(LocalTime currenExecutionTime,
			LocalDate currentExecutedDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IrrigationSchedule> getNextIrrigationSchedules(LocalTime lastExecutedTime, LocalTime nextExecutedTime,
			LocalDate currentExecutedDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSlotStatus(IrrigationSchedule t, boolean b) {
		// TODO Auto-generated method stub
		
	}

	 

	 

}
