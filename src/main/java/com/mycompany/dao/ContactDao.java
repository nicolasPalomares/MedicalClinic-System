package com.mycompany.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.domain.Contact;

/** 
 * DAO interface for handling Contact entities.
 * Extends JpaRepository to inherit basic CRUD operations for Contact entities.
 */

public interface ContactDao extends JpaRepository<Contact, Long> {

}
