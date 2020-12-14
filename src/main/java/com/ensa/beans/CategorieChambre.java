package com.ensa.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategorieChambre {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String categorieName;
    private double prix;

    @ManyToOne
    @JoinColumn(name="chambre_id")
    private Chambre chambre;
}
