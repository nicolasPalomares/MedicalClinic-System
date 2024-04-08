package com.mycompany.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.domain.Specialization;

/** 
 * DAO interface for handling Specialization entities.
 * Extends JpaRepository to inherit basic CRUD operations for Specialization entities.
 */

public interface SpecializationDao extends JpaRepository<Specialization, Long> {
	
	/** 
	 * List of all specializations in the database ordered by name in ascending order.
	 */
	List<Specialization> findAllByOrderByNameAsc();
}
