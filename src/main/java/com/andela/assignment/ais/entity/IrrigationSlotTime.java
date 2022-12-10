package com.andela.assignment.ais.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(description = "Device Data")
@Entity
@Table(name = "irrigation_slot_times", indexes = {
		@Index(name = "i_irrigation_slot_times_period", columnList = "start_time,end_time") })
@ToString
@Getter
@Setter
public class IrrigationSlotTime {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "start_time", columnDefinition = "TIME")
	private LocalTime startTime;

	@Column(name = "end_time", columnDefinition = "TIME")
	private LocalTime endTime;

	// water_amount
	@Column(name = "water_quantity", columnDefinition = "DECIMAL(10, 2) default 1")
	// @Column(name = "water_quantity")
	double waterQuantity;

	// value
	@Column(name = "is_pumping", columnDefinition = "boolean default false")
	Boolean isPumping; // false=No, true=Ongoing

	// in minutes
	// @Column(name = "duration", columnDefinition = "integer default 15")
	// long duration; // = ChronoUnit.MINUTES.between(startTime, endTime);

	// @Column(name = "water_application_rate", columnDefinition = "integer default
	// 1")
	// int waterApplicationRate ;

}
