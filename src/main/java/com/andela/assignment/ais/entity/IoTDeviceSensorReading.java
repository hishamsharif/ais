package com.andela.assignment.ais.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(description = "IoT Device (Soil) Sensor Reading Data")
@Entity
@Table(name = "iot_device_sensor_readings")
@ToString
@Getter
@Setter
public class IoTDeviceSensorReading {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	// value
	@Column(name = "value", columnDefinition = "DECIMAL(10, 2) default 1")
	double value;

	// timestamp
	@Column(name = "read_timestamp", columnDefinition = "TIMESTAMP")
	private LocalDateTime readTimestamp;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "iot_device_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private IoTDevice iotDevice;

}
