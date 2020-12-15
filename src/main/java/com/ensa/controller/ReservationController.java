package com.ensa.controller;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ensa.beans.Reservation;
import com.ensa.service.ReservationService;

@CrossOrigin
@RestController("*")
public class ReservationController {
	
	 @Autowired
	 private ReservationService reservationService;
	 
	 
	 @RequestMapping(value="/reservations/{id}",method=RequestMethod.GET)
	    public Reservation getResevation(@PathVariable Long id){
	        return reservationService.getOneReservationsById(id);
	    }
	 @RequestMapping(value="/reservations",method=RequestMethod.GET)
	    public List<Reservation> getAllResevation(){
	        return reservationService.getAllReservations();
	    }
	 @RequestMapping(value="/clientreservations/{id}",method=RequestMethod.GET)
	    public List<Reservation> getClientResevations(@PathVariable Long id){
	        return reservationService.getClientReservations(id);
	    }
	 @RequestMapping(value="/reservation/{id}",method=RequestMethod.POST)
	    public Reservation saveResevation(@RequestBody Reservation r,@PathVariable Long id){
	        return reservationService.saveReservation(r, id);
	    }
	 @RequestMapping(value="/reservationupdate",method=RequestMethod.PUT)
	    public Reservation updateResevation(@RequestBody Reservation r){
	        return reservationService.updateReservationsById(r);
	    }
	 @RequestMapping(value="/dayreservations",method=RequestMethod.GET)
	    public List<Reservation> dayResevations(){
		 LocalDate ld = LocalDate.now(); 
	        return reservationService.dayReservations(ld);
	    }
	 @RequestMapping(value="/deletereservation/{id}",method=RequestMethod.DELETE)
	    public boolean deleteResevation(@PathVariable Long id){
	        return reservationService.deleteReservations(id);
	    }
}
