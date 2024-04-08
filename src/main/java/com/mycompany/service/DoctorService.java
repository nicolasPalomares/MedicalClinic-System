package com.mycompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.dao.DoctorDao;
import com.mycompany.domain.Doctor;

/** 
 * Implementation of the iService interface for Doctor entity CRUD operations.
 * Sets the generic type of the interface to Doctor.
 */

@Service
public class DoctorService implements iService<Doctor> {
	
	@Autowired
	private DoctorDao doctorDao;

	/** 
	 * Transactional method in read-only mode.
	 * @return List of all entities in the database.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Doctor> listEntity() {
		return (List<Doctor>) doctorDao.findAllByOrderBySurnameAsc();
	}

	/** 
	 * Transactional method in read-only mode.
	 * @return An entity from the database specified with an ID, or null if not found.
	 */
	@Override
	@Transactional(readOnly = true)
	public Doctor findEntity(Doctor doctor) {
		return doctorDao.findById(doctor.getDoctorId()).orElse(null);
	}

	/** 
	 * Transactional method.
	 * Saves a new entity or updates an existing one.
	 */
	@Override
	@Transactional
	public void saveEntity(Doctor doctor) {
		doctorDao.save(doctor);
	}

	/** 
	 * Transactional method.
	 * Deletes an entity in the database.
	 */
	@Override
	@Transactional
	public void deleteEntity(Doctor doctor) {
		doctorDao.delete(doctor);
	}

}
