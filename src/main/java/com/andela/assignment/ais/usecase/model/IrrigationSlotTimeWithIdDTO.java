package com.andela.assignment.ais.usecase.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class IrrigationSlotTimeWithIdDTO extends IrrigationSlotTimeDTO {

	@Schema(type = "int", description = "System maintained ref. of this irrigtion schedule slot time", example = "123")
	private long id;

}
