package com.mycompany.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/** 
 * Role class represents the permissions an user will have. The program manages two roles: user and admin.
 * @param idRole - The auto increment primary key of Role instances managed inside the database.
 * @param name - Name of the role.
 */

@Entity
@Data
@Table(name = "role")
public class Role {
	
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long roleId;
	
	@NotEmpty
	private String name;

}
