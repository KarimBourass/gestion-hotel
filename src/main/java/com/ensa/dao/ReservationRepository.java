package com.ensa.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ensa.beans.Reservation;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	@Query("select r from Reservation r where :x between r.dateDepart and r.dateSortie")
	public List<Reservation> findByday(@Param("x")LocalDate x);
	@Query("select r from Reservation r INNER JOIN r.client as c where c.id=:x")
	public List<Reservation> findByClient(@Param("x")Long x);

}
