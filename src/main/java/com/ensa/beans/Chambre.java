package com.ensa.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
