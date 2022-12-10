package com.andela.assignment.ais.usecase.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.andela.assignment.ais.entity.IrrigationSchedule;

public interface IrrigationSchedulerService {

	// find slots scheduled to end for irrigation before currenExecutionTime
	public List<IrrigationSchedule> getCompletedIrrigationSchedules(LocalTime currenExecutionTime, LocalDate currentExecutedDate);

	// find plots scheduled for irrigation between lastExecutedTime and
	// nextExecutedTime
	// if lastExecutedTime is empty, find all slots for current day
	public List<IrrigationSchedule> getNextIrrigationSchedules(LocalTime lastExecutedTime,
			LocalTime nextExecutedTime, LocalDate currentExecutedDate);
}