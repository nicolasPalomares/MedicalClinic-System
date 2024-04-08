package com.mycompany.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.domain.Client;

/** 
 * DAO interface for handling Client entities.
 * Extends JpaRepository to inherit basic CRUD operations for Client entities.
 */

public interface ClientDao extends JpaRepository<Client, Long> {
	
	/** 
	 * List of all clients in the database ordered by surname in ascending order.
	 */
	List<Client> findAllByOrderBySurnameAsc();
}
