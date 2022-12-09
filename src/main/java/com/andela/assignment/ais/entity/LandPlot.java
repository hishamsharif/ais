package com.andela.assignment.ais.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(description = "Land Plot Data")
@Entity
@Table(name = "land_plots")
@ToString
@Getter
@Setter
public class LandPlot {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// Optimized use of ID generation in a platform independent way - use sequence
	// strategy for DB that supports it (i.e. Oracle , PostgreSQL) and otherwise
	// default to native (i.e. MySql Identity strategy)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id;

	@Column(name = "region")
	private String region;

	// @Column(name = "latitude", columnDefinition = "DECIMAL(10, 8) default 0")
	@Column(name = "latitude")
	private double latitude;

	// @Column(name = "longitude", columnDefinition = "DECIMAL(10, 8) default 0")
	@Column(name = "longitude")
	private double longitude;

	// plot_size is square feet <= length * breadth
	// @Column(name = "longitude", columnDefinition = "DECIMAL(10, 8) default 0")
	@Column(name = "plot_area")
	private double plotArea;

	// crop_type - vegetable, fruits
	// crop_stage - early, grown
	// spoil_type - clay, sandy

	// One-To-Many with (and owning by) IrrigationSchedule

}
