package com.clientes.controller;

import com.clientes.dto.ClientDTO;
import com.clientes.mapper.MapClientDTO;
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
    public ResponseEntity<ClientDTO> save(@RequestBody ClientDTO clientDTO) {
            Client client = MapClientDTO.mapClientDtoToClient(clientDTO);
            clientDTO = MapClientDTO.mapClientToClientDTO(clientService.create(client));
            return new ResponseEntity<>(clientDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAll() {
            List<ClientDTO> clientDTOList = MapClientDTO.mapClienListToClientDTOList(clientService.getAllClient());
            return new ResponseEntity<>(clientDTOList,HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<List<ClientDTO>> getAllByStatus() {
        List<ClientDTO> clientDTOList = MapClientDTO.mapClienListToClientDTOListStatus(clientService.getAllByStatus());
        return new ResponseEntity<>(clientDTOList,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ClientDTO> update(@RequestBody ClientDTO clientDTO) {
        Client client = MapClientDTO.mapClientDtoToClient(clientDTO);
        clientDTO = MapClientDTO.mapClientToClientDTO(clientService.update(client));
        return new ResponseEntity<>(clientDTO,null ,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id){
        Optional<Client> client = clientService.findById(id);
        if(client.isPresent()) {
            client.get().setStatus("cancelled");
            clientService.delete(client.get());
            return ResponseEntity.ok(true);
        }
        else
            return ResponseEntity.ok(false);
    }
}
