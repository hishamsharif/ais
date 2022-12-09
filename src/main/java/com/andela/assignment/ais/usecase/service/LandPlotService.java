package com.andela.assignment.ais.usecase.service;

import java.util.List;

import com.andela.assignment.ais.usecase.model.IrrigationScheduleDTO;
import com.andela.assignment.ais.usecase.model.LandPlotDTO;
import com.andela.assignment.ais.usecase.model.LandPlotWithIdDTO;
import com.andela.assignment.ais.usecase.model.LandPlotWithIrrigationSchedulesDTO;
import com.andela.assignment.ais.usecase.service.exception.LandPlotNotCapturedException;
import com.andela.assignment.ais.usecase.service.exception.LandPlotNotFoundException;

public interface LandPlotService {

	LandPlotWithIdDTO addLandPlot(LandPlotDTO plot) throws LandPlotNotCapturedException;

	LandPlotWithIdDTO editLandPlot(LandPlotDTO plot, long landPlotId) throws LandPlotNotFoundException;

	LandPlotWithIrrigationSchedulesDTO configureLandPlot(IrrigationScheduleDTO config, long landPlotId)
			throws LandPlotNotFoundException;

	List<LandPlotWithIdDTO> listAllLandPlots(String region);

	LandPlotWithIdDTO findLandPlot(long landPlotId) throws LandPlotNotFoundException;

}
