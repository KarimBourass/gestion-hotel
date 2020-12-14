package com.ensa.controller;

import com.ensa.beans.CategorieChambre;
import com.ensa.dao.CategorieChambreRepository;
import com.ensa.service.CategorieChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategorieChambreController {


    @Autowired
    private CategorieChambreService categorieChambreService;

    @GetMapping(value = "/categories")
    public List<CategorieChambre> getCategories(){
        return categorieChambreService.findAll();
    }

    @GetMapping(value = "/categories/{id}")
    public Optional<CategorieChambre> getCategorie(@PathVariable Long id){
        return categorieChambreService.findById(id);
    }

    @PostMapping(value = "/categories")
    public CategorieChambre saveCategorie(@RequestBody CategorieChambre categorieChambre){
        return categorieChambreService.save(categorieChambre);
    }

    @PutMapping(value = "/categories/{id}")
    public void updateCategorie(@PathVariable Long id,@RequestBody CategorieChambre categorieChambre){
        categorieChambreService.updateCategorie(id,categorieChambre);
    }

    @DeleteMapping(value = "/categories/{id}")
    public void deleteCategorie(@PathVariable Long id){
        if(categorieChambreService.findById(id) != null)
            categorieChambreService.deleteById(id);
    }


}
