package com.andela.assignment.ais.usecase.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class IrrigationScheduleWithIdDTO extends IrrigationScheduleDTO {

	@Schema(type = "int", description = "System maintained ref. of this irrigtion schedule", example = "123")
	private long id;

	// @Schema(type = "object", description = "related the land plot info")
	// private LandPlot landPlot;

}
