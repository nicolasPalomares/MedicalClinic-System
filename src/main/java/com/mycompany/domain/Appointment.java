package com.mycompany.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/** 
 * This class represents instances of appointments for clients and doctors. Clients and doctors saved in the database cannot be deleted if there are existing appointments
 * registered to them; if the user tries to delete these Client/Doctor objects, an error page will be loaded warning the user about this. 
 * @param appointmentId - The auto increment primary key of Appointment instances managed inside the database.
 * @param client - The client that will be registered to the appointment; this clients should already exist in the database.
 * @param doctor - The doctor that will be registered to the appointment; this doctors should already exist in the database.
 * @param date - Date of the appointment.
 * @param time - Time of the appointment, with no time zone.
 * 
 * Note: The decision of declaring date and time parameters as String was to make them as simple as possible, and to avoid convertion problems
 * between the view and the controller, being aware of the beneficts of using Date or LocalDate type objects.
 */

@Entity
@Data
@Table(name = "appointment")
public class Appointment {
	
	@Column(name = "appointment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long appointmentId;
	
	@JoinColumn(name = "client_id", referencedColumnName = "client_id")
	@ManyToOne(cascade = CascadeType.ALL)
	@Valid
	@NotNull
	private Client client;
	
	@JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id")
	@ManyToOne(cascade = CascadeType.ALL)
	@Valid
	@NotNull
	private Doctor doctor;
	
	@NotEmpty
	private String date;
	
	@NotEmpty
	private String time;

}
