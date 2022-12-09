package com.andela.assignment.ais.adaptor.gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andela.assignment.ais.entity.IrrigationSchedule;

@Repository
public interface IrrigationScheduleRepo extends JpaRepository<IrrigationSchedule, Long> {

}
