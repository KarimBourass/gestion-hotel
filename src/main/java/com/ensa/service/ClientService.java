package com.ensa.service;

import com.ensa.beans.Client;
import com.ensa.dao.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if(client != null)
            return client;
        else
            return Optional.empty();

    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }
}
