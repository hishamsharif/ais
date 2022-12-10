package com.andela.assignment.ais.adaptor.api.doc;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.andela.assignment.ais.usecase.model.IrrigationScheduleDTO;
import com.andela.assignment.ais.usecase.model.IrrigationScheduleWithIdDTO;
import com.andela.assignment.ais.usecase.model.LandPlotDTO;
import com.andela.assignment.ais.usecase.model.LandPlotWithIdDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.ArraySchema;

@Tag(name = "landplot", description = "The Land Plots API")
@RequestMapping("/api/landplots")
public interface LandPlotOpenApi {

	@Operation(summary = "Add a new land plot for irrigation", description = "Add a new land plot.", tags = {
			"landplot" })
	@ApiResponses(value = { @ApiResponse(description = "successful operation", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = LandPlotWithIdDTO.class)) }) })
	@PostMapping(value = "/", consumes = { "application/json" })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<LandPlotWithIdDTO> addNewLandPlot(
			@NotNull @Parameter(description = "A LandPlot object", required = true) @Valid @RequestBody LandPlotDTO body)
			throws Exception;

	@Operation(summary = "Update an existing land plot for irrigation", description = "Update an existing land plot.", tags = {
			"landplot" })
	@ApiResponses(value = { @ApiResponse(description = "successful operation", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = LandPlotWithIdDTO.class)) }) })
	@PutMapping(value = "/{landPlotId}", consumes = { "application/json" })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<LandPlotWithIdDTO> editLandPlot(
			@NotNull @Parameter(description = "Edited LandPlot object", required = true) @Valid @RequestBody LandPlotDTO body,
			@PathVariable long landPlotId) throws Exception;

	@Operation(summary = "Configure irrigation schedules for an existing land plot", description = "Configure an existing land plot.", tags = {
			"landplot" })
	@ApiResponses(value = { @ApiResponse(description = "successful operation", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = LandPlotWithIdDTO.class)) }) })
	@PutMapping(value = "/{landPlotId}/configure", consumes = { "application/json" })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<IrrigationScheduleWithIdDTO> configureLandPlot(
			@NotNull @Parameter(description = "Configure LandPlot Irrigation Schedule object", required = true) @Valid @RequestBody IrrigationScheduleDTO body,
			@PathVariable long landPlotId) throws Exception;

	@Operation(summary = "List all land plots with details, filtered by region when provided ", description = "Returns a list of land plots and their schedules", tags = {
			"landplot" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = LandPlotWithIdDTO.class)))) })
	@GetMapping(value = "/", produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<LandPlotWithIdDTO>> listAllLandPlotsaAndDetails(

			@Parameter(description = "(optional) region of land plots", required = false) @RequestParam(required = false, name = "region") String region)
			throws Exception;

	@Operation(summary = "Find land plots by system maintained unique id", description = "Returns a single land plot", tags = {
			"landplot" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LandPlotWithIdDTO.class))),
			@ApiResponse(responseCode = "400", description = "Invalid land plot ref supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "land plot not found", content = @Content) })
	@GetMapping(value = "/{landPlotId}", produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<LandPlotWithIdDTO> findLandPlotById(

			@Parameter(description = "Ref of a land plot", required = true) @PathVariable long landPlotId)
			throws Exception;
}
