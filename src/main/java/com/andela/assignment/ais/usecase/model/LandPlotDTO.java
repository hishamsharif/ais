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
public class LandPlotDTO {

	@Schema(type = "string", description = "nearest town/city of the land plot", example = "colombo north")
	private String region;

	@Schema(type = "int", description = "GPS coordinate of the land plot - Latitude", example = "123")
	private double latitude;

	@Schema(type = "int", description = "GPS coordinate of the land plot - Longitude", example = "123")
	private double longitude;

	// plot_size is square feet <= length * breadth
	@Schema(type = "int", description = "Size of the land plot in square feet", example = "123")
	private double plotArea;

}
