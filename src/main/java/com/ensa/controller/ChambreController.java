package com.ensa.controller;

import com.ensa.beans.Chambre;
import com.ensa.dao.ChambreRepository;
import com.ensa.service.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ChambreController {

    @Autowired
    private ChambreService chambreService;

    @GetMapping(value = "/chambres")
    public List<Chambre> getChambres(
            @RequestParam(required = false) String categorie,
            @RequestParam(required = false) String disponibilite
            ){
        return chambreService.findAll(categorie,disponibilite);
    }

    @GetMapping(value = "/chambres/{id}")
    public Optional<Chambre> getChambre(@PathVariable Long id){
        return chambreService.findById(id);
    }

    @PostMapping(value = "/chambres")
    public Chambre saveChambre(@RequestBody Chambre chambre){
        return chambreService.save(chambre);
    }

    @DeleteMapping(value = "/chambres/{id}")
    public void deleteChambre(@PathVariable Long id){
        if(chambreService.findById(id) != null)
            chambreService.deleteById(id);
    }

}
