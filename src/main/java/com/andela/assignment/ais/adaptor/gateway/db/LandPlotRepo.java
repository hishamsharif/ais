package com.andela.assignment.ais.adaptor.gateway.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andela.assignment.ais.entity.LandPlot;

@Repository
public interface LandPlotRepo extends JpaRepository<LandPlot, Long> {

	List<LandPlot> findByRegionContaining(String region);

}
