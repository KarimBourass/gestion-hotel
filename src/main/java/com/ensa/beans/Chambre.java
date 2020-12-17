package com.ensa.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Chambre {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private int numeroChambre;
    private int nbrLits;

    @Column(length = 4)
    private boolean disponibilite;

    @JsonIgnore
    @OneToMany(mappedBy = "chambre")
    private Set<CategorieChambre> categories;

    @ManyToOne
    @JoinColumn(name = "personnel_id")
    private PersonnelHotel personnel;

    @JsonIgnore
    @OneToMany(mappedBy = "chambre")
    private Set<OptionChambre> options;

    public Chambre() {
    }

    public Chambre(int numeroChambre, int nbrLits, boolean disponibilite, Set<CategorieChambre> categories, PersonnelHotel personnel, Set<OptionChambre> options) {
        this.numeroChambre = numeroChambre;
        this.nbrLits = nbrLits;
        this.disponibilite = disponibilite;
        this.categories = categories;
        this.personnel = personnel;
        this.options = options;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(int numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public int getNbrLits() {
        return nbrLits;
    }

    public void setNbrLits(int nbrLits) {
        this.nbrLits = nbrLits;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public Set<CategorieChambre> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategorieChambre> categories) {
        this.categories = categories;
    }

    public PersonnelHotel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(PersonnelHotel personnel) {
        this.personnel = personnel;
    }

    public Set<OptionChambre> getOptions() {
        return options;
    }

    public void setOptions(Set<OptionChambre> options) {
        this.options = options;
    }
}
