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
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

/**
 * This class represents a doctor entity in the system.
 * @param doctorId - The auto increment primary key of Doctor instances managed inside the database.
 * @param name - Name of the doctor.
 * @param surname - Surname of the doctor.
 * @param department - Department instance represents the clinic department in wich the doctor specializes; it contains a specialization and an office number.
 * @param appointments - A list containing instances of Appointment, mapped to the "doctor" column in the appointment table.
 */

@Entity
@Data
@ToString(exclude = "appointments")
@Table(name = "doctor")
public class Doctor {
	
	@Column(name = "doctor_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long doctorId;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String surname;
	
	@JoinColumn(name = "department_id", referencedColumnName = "department_id")
	@ManyToOne(cascade = CascadeType.ALL)
	@Valid
	@NotNull
	private Department department;
	
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	private List<Appointment> appointments;
	
}
