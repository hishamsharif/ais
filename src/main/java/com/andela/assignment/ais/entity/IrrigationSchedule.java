package com.andela.assignment.ais.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(description = "Irrigation Schedules for Land Plots  ")
@Entity
@Table(name = "irrigation_schedules")
@ToString
@Getter
@Setter
public class IrrigationSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	// find tradeoff between keeping the period in-line for filtering convenience,
	// or encapsulate the period as a separate class ?
	// from_date
	@Column(name = "from_date", columnDefinition = "DATE")
	private LocalDate fromDate;

	// to_date
	@Column(name = "to_date", columnDefinition = "DATE")
	private LocalDate toDate;

	// SlotTime
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "irrigation_schedule_id")
	private List<IrrigationSlotTime> slotTimes;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "iot_device_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private IoTDevice iotDevice;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "land_plot_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private LandPlot landPlot;

}
