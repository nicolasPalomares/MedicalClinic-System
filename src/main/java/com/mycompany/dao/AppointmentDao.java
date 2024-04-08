package com.mycompany.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.domain.Appointment;

/** 
 * DAO interface for handling Appointment entities.
 * Extends JpaRepository to inherit basic CRUD operations for Appointment entities.
 */

public interface AppointmentDao extends JpaRepository<Appointment, Long> {

}
