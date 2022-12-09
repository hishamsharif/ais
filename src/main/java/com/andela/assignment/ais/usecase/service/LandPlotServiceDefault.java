package com.andela.assignment.ais.usecase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andela.assignment.ais.adaptor.gateway.repository.LandPlotRepo;
import com.andela.assignment.ais.entity.LandPlot;
import com.andela.assignment.ais.usecase.model.IrrigationScheduleDTO;
import com.andela.assignment.ais.usecase.model.LandPlotDTO;
import com.andela.assignment.ais.usecase.model.LandPlotWithIdDTO;
import com.andela.assignment.ais.usecase.model.LandPlotWithIrrigationSchedulesDTO;
import com.andela.assignment.ais.usecase.service.exception.LandPlotNotCapturedException;
import com.andela.assignment.ais.usecase.service.exception.LandPlotNotFoundException;
import com.andela.assignment.ais.usecase.util.EntityToDtoMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LandPlotServiceDefault implements LandPlotService {

	final private LandPlotRepo landPlotRepo;
	final private EntityToDtoMapper mapper;

	public LandPlotServiceDefault(LandPlotRepo landPlotRepo, EntityToDtoMapper mapper) {
		this.landPlotRepo = landPlotRepo;
		this.mapper = mapper;
	}

	@Override
	public LandPlotWithIdDTO addLandPlot(LandPlotDTO plot) throws LandPlotNotCapturedException {
		// add any pre-conditions ...

		// convert the dto to entity
		LandPlot landPlot = this.getMapper().convertLandPlot(plot);

		// persist via repo
		landPlot = this.getLandPlotRepo().save(landPlot);
		LandPlotWithIdDTO dto = this.getMapper().convertLandPlot(landPlot);

		return dto;
	}

	@Override
	public LandPlotWithIdDTO editLandPlot(LandPlotDTO plot, long landPlotId) throws LandPlotNotFoundException {

		// convert the dto to entity , and update if found or insert via repo
		LandPlot landPlot = this.getLandPlotRepo().findById(landPlotId).map(landPlotEntity -> {
			return this.getLandPlotRepo().save(this.getMapper().convertLandPlot(plot));
		}).orElseGet(() -> {
			return this.getLandPlotRepo().save(this.getMapper().convertLandPlot(plot));
		});
		LandPlotWithIdDTO dto = this.getMapper().convertLandPlot(landPlot);

		return dto;
	}

	@Override
	public LandPlotWithIrrigationSchedulesDTO configureLandPlot(IrrigationScheduleDTO config, long landPlotId)
			throws LandPlotNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LandPlotWithIdDTO> listAllLandPlots(String region) {

		List<LandPlotWithIdDTO> plots = new ArrayList<LandPlotWithIdDTO>();

		if (region == null)
			this.getLandPlotRepo().findAll().forEach(landPlot -> plots.add(this.getMapper().convertLandPlot(landPlot)));
		else
			this.getLandPlotRepo().findByRegionContaining(region)
					.forEach(landPlot -> plots.add(this.getMapper().convertLandPlot(landPlot)));

		return plots;
	}

	@Override
	public LandPlotWithIdDTO findLandPlot(long landPlotId) throws LandPlotNotFoundException {

		log.info("findById::landPlotId = " + landPlotId);
		LandPlot landPlot = this.getLandPlotRepo().findById(landPlotId)
				.orElseThrow(() -> new LandPlotNotFoundException("land plot not found for this ref :: " + landPlotId));

		LandPlotWithIdDTO dto = this.getMapper().convertLandPlot(landPlot);
		return dto;
	}

	private LandPlotRepo getLandPlotRepo() {
		return landPlotRepo;
	}

	private EntityToDtoMapper getMapper() {
		return mapper;
	}

}
