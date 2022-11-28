package com.clientes.mapper;

import com.clientes.dto.ClientDTO;
import com.clientes.model.Client;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapClientDTO {

    public static ClientDTO mapClientToClientDTO(Client client){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(client, ClientDTO.class);
    }

    public static Client mapClientDtoToClient(ClientDTO clientDTO){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(clientDTO, Client.class);
    }

    public static List<ClientDTO> mapClienListToClientDTOListStatus(List<Optional<Client>> clientList){
        ModelMapper mapper = new ModelMapper();
        return clientList
                .stream()
                .map(user -> mapper.map(user.get(), ClientDTO.class))
                .collect(Collectors.toList());
    }

    public static List<ClientDTO> mapClienListToClientDTOList(List<Client> clientList){
        ModelMapper mapper = new ModelMapper();
        return clientList
                .stream()
                .map(user -> mapper.map(user, ClientDTO.class))
                .collect(Collectors.toList());
    }
}
