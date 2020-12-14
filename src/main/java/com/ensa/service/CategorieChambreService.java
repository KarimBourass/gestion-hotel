package com.ensa.service;

import com.ensa.beans.CategorieChambre;
import com.ensa.dao.CategorieChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieChambreService {

    @Autowired
    private CategorieChambreRepository categorieRepository;

    public List<CategorieChambre> findAll() {
        return categorieRepository.findAll();
    }

    public Optional<CategorieChambre> findById(Long id) {
        Optional<CategorieChambre> categorieChambre = categorieRepository.findById(id);
        if(categorieChambre != null)
            return categorieChambre;
        else
            return Optional.empty();
    }
    public CategorieChambre save(CategorieChambre categorieChambre) {
        return categorieRepository.save(categorieChambre);
    }


    public void deleteById(Long id) {
        Optional<CategorieChambre> categorieChambre = categorieRepository.findById(id);
        if(categorieChambre != null)
                categorieRepository.deleteById(id);
    }

    public void updateCategorie(Long id, CategorieChambre categorieName) {
        Optional<CategorieChambre> categorie = categorieRepository.findById(id);
        if(categorie != null)
            categorieRepository.save(categorieName);
    }
}
