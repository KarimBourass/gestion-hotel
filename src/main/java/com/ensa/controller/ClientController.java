package com.ensa.controller;

import com.ensa.beans.Client;
import com.ensa.dao.ClientRepository;
import com.ensa.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController("clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getClients(){
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable Long id){
        return clientService.findById(id);
    }

    @PostMapping
    public Client saveClient(@RequestBody Client client){
        return clientService.save(client);
    }

}
