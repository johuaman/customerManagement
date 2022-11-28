package com.clientes.service;

import com.clientes.model.Client;
import com.clientes.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepo clientRepo;

    private String status="active";

    @Override
    public Client create(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepo.findAll();
    }

    @Override
    public void delete(Client client) {
        clientRepo.save(client);
    }

    @Override
    public Optional<Client> findById(String id) {
        return clientRepo.findById(Long.valueOf(id));
    }

    @Override
    public List<Optional<Client>> getAllByStatus() {
        return clientRepo.getAllByStatus(status);
    }
}
