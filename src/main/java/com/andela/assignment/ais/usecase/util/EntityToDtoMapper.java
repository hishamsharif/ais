package com.andela.assignment.ais.usecase.util;

import org.mapstruct.Mapper;

import com.andela.assignment.ais.entity.LandPlot;
import com.andela.assignment.ais.usecase.model.LandPlotDTO;
import com.andela.assignment.ais.usecase.model.LandPlotWithIdDTO;

@Mapper(componentModel = "spring")
public interface EntityToDtoMapper {

	// Handle conversion for Rest Api Get/Post LandPlot request/responses

	// LandPlotDTOReq to LandPlot
	LandPlot convertLandPlot(LandPlotDTO req);

	// LandPlot to LandPlotDTOResp
	LandPlotWithIdDTO convertLandPlot(LandPlot negDeal);

}
