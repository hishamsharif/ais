package com.andela.assignment.ais.usecase.model;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

public class IrrigationSlotTimeDTO {

	@Schema(type = "string", description = "time of a day when this irrigation scheduled for watering", example = "09-Dec-2022 6:30 AM")
	private LocalDateTime startTime;

	@Schema(type = "string", description = "time of the day when this irrigation scheduled should stop watering", example = "09-Dec-2022 7:30 AM")
	private LocalDateTime endTime;

	// water_amount
	@Schema(type = "int", description = "Amount of water configured for watering the land plot (in liters) ", example = "5")
	double waterQuantity;

}
