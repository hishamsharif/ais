package com.andela.assignment.ais.usecase.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.andela.assignment.ais.entity.IrrigationSlotTime;
import com.andela.assignment.ais.entity.LandPlot;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IrrigationScheduleDTO {

	// @Schema(type = "int", description = "System maintained ref. of this irrigtion
	// schedule", example = "123")
	// private long id;

	@Schema(type = "string", description = "date from when this irrigation schedule is configured for the land plot", example = "09-Dec-2022")
	private LocalDate fromDate;

	@Schema(type = "string", description = "date till when this irrigation schedule is configured for the land plot", example = "31-Dec-2022")
	private LocalDate toDate;

	@Schema(type = "array", description = "no of slots and times for watering the land plot")
	private Set<IrrigationSlotTimeDTO> slotTimes = new HashSet<>();

}
