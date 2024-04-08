package com.mycompany.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/** 
 * This class represents a contact entity in the system. This entity should contain contact information of clients.
 * For test purposes, both parameters in this class are defined with non-existent data.
 * @param contactId - The auto increment primary key of Contact instances managed inside the database.
 * @param phoneNumber - The phone number belonging to the client.
 * @param email - The E-Mail registered to the client; it can follow any type of mail syntax (hotmail, outlook, etc.).
 * 
 * The creation of contact objects takes place when the user is creating an instance of type Client, this means that the contact is not managed independently.
 */

@Entity
@Data
@Table(name = "contact")
public class Contact {
	
	@Column(name = "contact_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long contactId;
	
	@Column(name = "phone_number")
	@NotEmpty
	private String phoneNumber;
	
	@NotEmpty
	@Email
	private String email;

}
