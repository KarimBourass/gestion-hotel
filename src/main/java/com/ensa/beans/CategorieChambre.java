package com.ensa.beans;



import javax.persistence.*;

@Entity
public class CategorieChambre {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String categorieName;
    private double prix;

    @ManyToOne
    @JoinColumn(name="chambre_id")
    private Chambre chambre;

    public CategorieChambre() {
    }

    public CategorieChambre(String categorieName, double prix, Chambre chambre) {
        this.categorieName = categorieName;
        this.prix = prix;
        this.chambre = chambre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategorieName() {
        return categorieName;
    }

    public void setCategorieName(String categorieName) {
        this.categorieName = categorieName;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }
}
