package com.mycompany.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.ToString;

/**
 * This class represents a client entity in the system.
 * @param clientId - The auto increment primary key of Client instances managed inside the database.
 * @param name - Name of the client.
 * @param surname - Surname of the client.
 * @param lifeInsuranceType - String representing the life insurance of the client; it is managed in an array containing four types ("Basic", "Standard", "Premium" and "Gold") inside controller layer.
 * @param address - This parameter of type Address represents the residential address of the client.
 * @param contact - This parameter of type Contact contains information to contact the client.
 * @param appointments - A list containing instances of Appointment, mapped to the "client" column in the appointment table.
 */

@Entity
@Data
@ToString(exclude = "appointments")
@Table(name = "client")
public class Client {
	
	@Column(name = "client_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long clientId;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String surname;
	
	@Column(name = "life_insurance_type")
	@NotEmpty
	private String lifeInsuranceType;
	
	@JoinColumn(name = "address_id", referencedColumnName = "address_id")
	@ManyToOne(cascade = CascadeType.ALL)
	@Valid
	private Address address;
	
	@JoinColumn(name = "contact_id", referencedColumnName = "contact_id")
	@ManyToOne(cascade = CascadeType.ALL)
	@Valid
	private Contact contact;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Appointment> appointments;
	
}
