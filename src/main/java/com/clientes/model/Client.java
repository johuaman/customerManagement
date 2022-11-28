package com.clientes.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "cliente")
@Data
@Getter
@Setter
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (name="nombres")
	private String name;
	
	@Column (name="apellidos")
	private String lastname;
	
	@Column (name="direccion")
	private String address;
	
	@Column (name="email")
	private String email;
	
	@Column (name="celular")
	private String phone;

	@Column (name="status")
	private String status;
	
}
