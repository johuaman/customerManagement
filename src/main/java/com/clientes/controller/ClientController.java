package com.clientes.controller;

import com.clientes.exceptions.BussniesRulesException;
import com.clientes.model.Client;
import com.clientes.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/client")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Client> save(@RequestBody Client client) throws BussniesRulesException {
            return new ResponseEntity<Client>(clientService.create(client), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAll() throws BussniesRulesException{
            return new ResponseEntity<>(clientService.getAllClient(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Client> update(@RequestBody Client client) throws BussniesRulesException{
        return new ResponseEntity<>(clientService.update(client),null ,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) throws BussniesRulesException{
        Optional<Client> client = clientService.findById(id);
        if(client.isPresent())
            return ResponseEntity.ok(true);
        else
            return ResponseEntity.ok(false);
    }
}
