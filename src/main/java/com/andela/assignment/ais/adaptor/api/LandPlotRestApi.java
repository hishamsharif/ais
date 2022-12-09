package com.andela.assignment.ais.adaptor.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.andela.assignment.ais.adaptor.api.doc.LandPlotOpenApi;
import com.andela.assignment.ais.usecase.model.IrrigationScheduleDTO;
import com.andela.assignment.ais.usecase.model.IrrigationScheduleWithIdDTO;
import com.andela.assignment.ais.usecase.model.LandPlotDTO;
import com.andela.assignment.ais.usecase.model.LandPlotWithIdDTO;
import com.andela.assignment.ais.usecase.service.LandPlotService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LandPlotRestApi implements LandPlotOpenApi {

	final LandPlotService landPlotService;

	public LandPlotRestApi(LandPlotService landPlotService) {
		this.landPlotService = landPlotService;
	}

	// add a plot
	@Override
	public ResponseEntity<LandPlotWithIdDTO> addNewLandPlot(@NotNull @Valid LandPlotDTO body) throws Exception {
		log.info("add new landplot data : " + body.toString());
		LandPlotWithIdDTO resp = this.getLandPlotService().addLandPlot(body);
		return new ResponseEntity<LandPlotWithIdDTO>(resp, HttpStatus.CREATED);
	}

	// edit a plot
	@Override
	public ResponseEntity<LandPlotWithIdDTO> editLandPlot(@NotNull @Valid LandPlotDTO body, long landPlotId)
			throws Exception {
		log.info("edit landplot data : " + body.toString());
		LandPlotWithIdDTO resp = this.getLandPlotService().editLandPlot(body, landPlotId);
		return new ResponseEntity<LandPlotWithIdDTO>(resp, HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<IrrigationScheduleWithIdDTO> configureLandPlot(@NotNull @Valid IrrigationScheduleDTO body,
			long landPlotId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<LandPlotWithIdDTO>> listAllLandPlotsaAndDetails(String region) throws Exception {

		List<LandPlotWithIdDTO> plots = this.getLandPlotService().listAllLandPlots(region);
		if (plots.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(plots, HttpStatus.OK);

	}

	// find a plot
	@Override
	public ResponseEntity<LandPlotWithIdDTO> findLandPlotById(long landPlotId) throws Exception {
		log.info("findById::landPlotId = " + landPlotId);
		LandPlotWithIdDTO landPlot = null;
		landPlot = landPlotService.findLandPlot(landPlotId);
		return ResponseEntity.ok().body(landPlot);

	}

	private LandPlotService getLandPlotService() {
		return landPlotService;
	}

}
