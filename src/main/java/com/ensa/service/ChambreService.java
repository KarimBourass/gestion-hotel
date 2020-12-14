package com.ensa.service;

import com.ensa.beans.Chambre;
import com.ensa.dao.CategorieChambreRepository;
import com.ensa.dao.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    @Autowired
    private CategorieChambreRepository categorieChambreRepository;

    public List<Chambre> findAll(String categorie, String disponibilite) {
        if( categorie == null && disponibilite == null)
            return chambreRepository.findAll();
        else if(categorie != null)
            return categorieChambreRepository.findByCategorie(categorie);
        else if(disponibilite != null)
            return chambreRepository.findByDisponibilite(disponibilite);

        return new ArrayList<>();
    }

    public Optional<Chambre> findById(Long id) {
        Optional<Chambre> chambre = chambreRepository.findById(id);
        if(chambre != null)
            return chambre;
        else
            return Optional.empty();

    }

    public Chambre save(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    public void deleteById(Long id) {
        Optional<Chambre> Chambre = chambreRepository.findById(id);
        if(Chambre != null)
            chambreRepository.deleteById(id);
    }
}
