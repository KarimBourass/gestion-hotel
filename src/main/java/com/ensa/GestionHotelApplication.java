package com.ensa;

import com.ensa.beans.Client;
import com.ensa.dao.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionHotelApplication implements Runnable{

    @Autowired
    private ClientRepository clientRepository;

    public static void main(String[] args) {
        SpringApplication.run(GestionHotelApplication.class, args);

    }

    @Override
    public void run() {

        Client client = new Client("Karim","karim@gmail.com","0612345678");
        clientRepository.save(client);
    }
}
