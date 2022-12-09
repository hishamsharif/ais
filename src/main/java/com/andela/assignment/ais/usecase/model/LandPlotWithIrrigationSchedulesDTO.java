package com.andela.assignment.ais.usecase.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class LandPlotWithIrrigationSchedulesDTO extends LandPlotWithIdDTO {

	@Schema(type = "object", description = "related the land plot info")
	private IrrigationScheduleWithIdDTO landPlot;

}
