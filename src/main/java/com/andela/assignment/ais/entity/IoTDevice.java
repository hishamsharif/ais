package com.andela.assignment.ais.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(description = "Device Data")
@Entity
@Table(name = "iot_devices")
@ToString
@Getter
@Setter
public class IoTDevice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	// spoil_moisture_content
	@OneToOne
	@JoinColumn(name = "device_type_id")
	private IoTDeviceType deviceType;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "land_plot_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private LandPlot landPlot;
}
