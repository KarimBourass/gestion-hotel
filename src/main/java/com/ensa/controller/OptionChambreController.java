package com.ensa.controller;

import com.ensa.beans.OptionChambre;
import com.ensa.service.OptionChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OptionChambreController {
    @Autowired
    private OptionChambreService optionChambreService;

    @GetMapping(value = "/options")
    public List<OptionChambre> getOptions(){
        return optionChambreService.findAll();
    }

    @GetMapping(value = "/options/{id}")
    public Optional<OptionChambre> getOption(@PathVariable Long id){
        return optionChambreService.findById(id);
    }

    @PostMapping(value = "/options")
    public OptionChambre saveOption(@RequestBody OptionChambre optionChambre){
        return optionChambreService.save(optionChambre);
    }

    @PutMapping(value = "/options/{id}")
    public void updateOption(@PathVariable Long id,@RequestBody OptionChambre optionChambre){
        optionChambreService.updateOption(id,optionChambre);
    }

    @DeleteMapping(value = "/options/{id}")
    public void deleteCategorie(@PathVariable Long id){
        if(optionChambreService.findById(id) != null)
            optionChambreService.deleteById(id);
    }

}
