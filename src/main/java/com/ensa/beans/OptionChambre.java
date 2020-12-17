package com.ensa.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OptionChambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String optionName;

    @ManyToOne
    @JoinColumn(name="chambre_id")
    private Chambre chambre;

    public OptionChambre() {
    }

    public OptionChambre(String optionName, Chambre chambre) {
        this.optionName = optionName;
        this.chambre = chambre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }
}
