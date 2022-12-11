package com.andela.assignment.ais.adaptor.gateway.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.andela.assignment.ais.entity.IrrigationSlotTime;

@Repository
public interface IrrigationSlotTimeRepo extends JpaRepository<IrrigationSlotTime, Long> {
 
	    //@Transactional 
		@Modifying 
		@Query("update IrrigationSlotTime s set s.isPumping = :pumpingStatus  where s.id = :slotId  ") 
		int updateSlotPumpingStatus(@Param("pumpingStatus") boolean pumpingStatus,@Param("slotId") long slotId);
}
