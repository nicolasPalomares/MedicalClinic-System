package com.mycompany.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.domain.Address;

/** 
 * DAO interface for handling Address entities.
 * Extends JpaRepository to inherit basic CRUD operations for Address entities.
 */

public interface AddressDao extends JpaRepository<Address, Long> {

}
