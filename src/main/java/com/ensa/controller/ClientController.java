package com.ensa.controller;

import com.ensa.beans.Client;
import com.ensa.dao.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(value="/clients")
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    @PostMapping(value ="/client")
    public Client saveClient(@RequestBody Client client){
        return clientRepository.save(client);
    }

}
