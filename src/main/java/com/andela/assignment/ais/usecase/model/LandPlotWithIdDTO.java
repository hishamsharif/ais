package com.andela.assignment.ais.usecase.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LandPlotWithIdDTO extends LandPlotDTO {

	// @JsonProperty(value = "id", required = true, index = 10)
	@Schema(type = "int", description = "System maintained ref. of the land plot", example = "123")
	private long id;

}
