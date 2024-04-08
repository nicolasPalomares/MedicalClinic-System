package com.mycompany.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * Specialization class contains information about what a department is responsible for. All this information could be managed directly inside
 * the Department class, but my decision of making it a separate entity was because it could become more complex in the future; for example, it could manage
 * information about subspecialties, more kind of services, maintenance data, etc.
 * @param specializationId - The auto increment primary key of Specialization instances managed inside the database.
 * @param name - Name of the specialization; covers any type of medical field.
 * @param services - A list of services that can be offered by the field in the clinic; right now, there is only two services declared in the view layer
 * 					 that can be offered: clinic services and surgery services.
 */

@Entity
@Data
@Table(name = "specialization")
public class Specialization {
	
	@Column(name = "specialization_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long specializationId;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private List<String> services;

}
