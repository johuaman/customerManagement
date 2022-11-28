package com.clientes.service;

import com.clientes.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    public Client create(Client client);

    public Client update(Client client);

    public List<Client> getAllClient();

    public void delete(Client client);

    public Optional<Client> findById(String id);

    public List<Optional<Client>> getAllByStatus();
}
