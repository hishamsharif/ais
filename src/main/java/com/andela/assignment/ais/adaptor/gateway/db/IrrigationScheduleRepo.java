package com.andela.assignment.ais.adaptor.gateway.db;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.andela.assignment.ais.entity.IrrigationSchedule;

@Repository
public interface IrrigationScheduleRepo extends JpaRepository<IrrigationSchedule, Long> {

	@Query("from IrrigationSchedule s left join s.slotTimes i where i.startTime between :slotTimeStart and :slotTimeEnd and (i.isPumping = false  or i.isPumping is null)")
	List<IrrigationSchedule> findAllBySlotTimeBetween(@Param("slotTimeStart") LocalDateTime slotTimeStart,
			@Param("slotTimeEnd") LocalDateTime slotTimeEnd);

	@Query("from IrrigationSchedule s left join s.slotTimes i where i.endTime <= :slotTimeEnd and  i.isPumping = true  ")
	List<IrrigationSchedule> findAllBySlotTimeEndBefore(@Param("slotTimeEnd") LocalDateTime slotTimeEnd);

}
