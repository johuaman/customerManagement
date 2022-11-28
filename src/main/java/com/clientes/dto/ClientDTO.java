package com.clientes.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class ClientDTO implements Serializable {

    private static final long serialVersionUID = -600476848401055194L;

    private Long id;

    private String name;

    private String lastname;

    private String address;

    private String email;

    private String phone;

    private String status;
}
