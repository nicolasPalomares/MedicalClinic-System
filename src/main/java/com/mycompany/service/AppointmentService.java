package com.mycompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.dao.AppointmentDao;
import com.mycompany.domain.Appointment;

/** 
 * Implementation of the iService interface for Appointment entity CRUD operations.
 * Sets the generic type of the interface to Appointment.
 */

@Service
public class AppointmentService implements iService<Appointment> {
	
	@Autowired
	private AppointmentDao appointmentDao;

	/** 
	 * Transactional method in read-only mode.
	 * @return List of all entities in the database.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Appointment> listEntity() {
		return (List<Appointment>) appointmentDao.findAll();
	}

	/** 
	 * Transactional method in read-only mode.
	 * @return An entity from the database specified with an ID, or null if not found.
	 */
	@Override
	@Transactional(readOnly = true)
	public Appointment findEntity(Appointment appointment) {
		return appointmentDao.findById(appointment.getAppointmentId()).orElse(null);
	}

	/** 
	 * Transactional method.
	 * Saves a new entity or updates an existing one.
	 */
	@Override
	@Transactional
	public void saveEntity(Appointment appointment) {
		appointmentDao.save(appointment);
	}

	/** 
	 * Transactional method.
	 * Deletes an entity in the database.
	 */
	@Override
	@Transactional
	public void deleteEntity(Appointment appointment) {
		appointmentDao.delete(appointment);
	}

}
