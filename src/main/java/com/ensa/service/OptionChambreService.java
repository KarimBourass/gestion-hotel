package com.ensa.service;


import com.ensa.beans.OptionChambre;
import com.ensa.dao.OptionChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OptionChambreService {
    @Autowired
    private OptionChambreRepository optionRepository;

    public List<OptionChambre> findAll() {
        return optionRepository.findAll();
    }

    public Optional<OptionChambre> findById(Long id) {
        Optional<OptionChambre> optionChambre = optionRepository.findById(id);
        if(optionChambre != null)
            return optionChambre;
        else
            return Optional.empty();
    }
    public OptionChambre save(OptionChambre optionChambre) {
        return optionRepository.save(optionChambre);
    }


    public void deleteById(Long id) {
        Optional<OptionChambre>optionChambre = optionRepository.findById(id);
        if(optionChambre != null)
            optionRepository.deleteById(id);
    }

    public void updateOption(Long id, OptionChambre optionName) {
        Optional<OptionChambre> option = optionRepository.findById(id);
        if(option != null)
            optionRepository.save(optionName);
    }
}
