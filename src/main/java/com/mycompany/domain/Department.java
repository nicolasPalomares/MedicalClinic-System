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
 * This entity represents specific departments inside the clinic; this entity can only be managed by administrators.
 * @param departmentId - The auto increment primary key of Department instances managed inside the database.
 * @param specialization - Contains information about the medical field of the department and available services.
 * @param officeNo - Office number; it can be any number.
 */

@Entity
@Data
@Table(name = "department")
public class Department {
	
	@Column(name = "department_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long departmentId;
	
	@JoinColumn(name = "specialization_id", referencedColumnName = "specialization_id")
	@ManyToOne(cascade = CascadeType.ALL)
	@Valid
	@NotNull
	private Specialization specialization;
	
	@Column(name = "office_no")
	@NotEmpty
	private String officeNo;

}
