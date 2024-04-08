package com.mycompany.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.domain.Doctor;

/** 
 * DAO interface for handling Doctor entities.
 * Extends JpaRepository to inherit basic CRUD operations for Doctor entities.
 */

public interface DoctorDao extends JpaRepository<Doctor, Long> {
	
	/** 
	 * List of all doctors in the database ordered by surname in ascending order.
	 */
	List<Doctor> findAllByOrderBySurnameAsc();
}
