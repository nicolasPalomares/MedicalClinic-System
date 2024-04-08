package com.mycompany.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.domain.Department;

/** 
 * DAO interface for handling Department entities.
 * Extends JpaRepository to inherit basic CRUD operations for Department entities.
 */

public interface DepartmentDao extends JpaRepository<Department, Long> {
	
	/** 
	 * List of all departments in the database ordered by the specialization's name in ascending order.
	 */
	List<Department> findAllByOrderBySpecializationNameAsc();
}
