package com.ensa.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.beans.Reservation;
import com.ensa.dao.ClientRepository;
import com.ensa.dao.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepo;
	@Autowired
    private ClientRepository clientRepository;
	
	public List<Reservation> getAllReservations(){
		return reservationRepo.findAll();
		
	}
	public List<Reservation> getClientReservations(Long id){
		return reservationRepo.findByClient(id);
		
	}
	public Reservation getOneReservationsById(Long id){
		return reservationRepo.findById(id).orElse(null);
		
	}
	public Reservation updateReservationsById(Reservation r){
		Reservation temp = reservationRepo.getOne(r.getId());
		temp.setClient(r.getClient());
		temp.setDateDepart(r.getDateDepart());
		temp.setDateSortie(r.getDateSortie());
		return reservationRepo.save(temp);
		
	}
	public Reservation saveReservation(Reservation r,Long idClient) {
	  
	  r.setClient(clientRepository.findById(idClient).orElse(null));
		return reservationRepo.save(r);
	}
	public List<Reservation> dayReservations(LocalDate d){
		return reservationRepo.findByday(d);
	}
	public boolean deleteReservations(Long id){
		try {
			reservationRepo.deleteById(id);
			return true ;
		} catch (Exception e) {
			return false;
		} 
		
		
	}

}
