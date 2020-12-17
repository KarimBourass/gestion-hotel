package com.ensa.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private int nbrChambre;
    private String adress;

    @OneToMany(mappedBy = "hotel")
    private Set<PersonnelHotel> personnels;

    public Hotel() {
    }

    public Hotel(int nbrChambre, String adress, Set<PersonnelHotel> personnels) {
        this.nbrChambre = nbrChambre;
        this.adress = adress;
        this.personnels = personnels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNbrChambre() {
        return nbrChambre;
    }

    public void setNbrChambre(int nbrChambre) {
        this.nbrChambre = nbrChambre;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Set<PersonnelHotel> getPersonnels() {
        return personnels;
    }

    public void setPersonnels(Set<PersonnelHotel> personnels) {
        this.personnels = personnels;
    }
}
