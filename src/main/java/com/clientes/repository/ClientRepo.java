package com.clientes.repository;

import com.clientes.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client,Long> {

    @Query(value = " SELECT p FROM Client p WHERE status=?1 ")
    public List<Optional<Client>> getAllByStatus(String status);

}
