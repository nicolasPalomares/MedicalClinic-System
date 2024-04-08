package com.mycompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.dao.SpecializationDao;
import com.mycompany.domain.Specialization;

/** 
 * Implementation of the iService interface for Specialization entity CRUD operations.
 * Sets the generic type of the interface to Specialization.
 */

@Service
public class SpecializationService implements iService<Specialization> {
	
	@Autowired
	private SpecializationDao specializationDao;

	/** 
	 * Transactional method in read-only mode.
	 * @return List of all entities in the database.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Specialization> listEntity() {
		return (List<Specialization>) specializationDao.findAllByOrderByNameAsc();
	}

	/** 
	 * Transactional method in read-only mode.
	 * @return An entity from the database specified with an ID, or null if not found.
	 */
	@Override
	@Transactional(readOnly = true)
	public Specialization findEntity(Specialization specialization) {
		return specializationDao.findById(specialization.getSpecializationId()).orElse(null);
	}

	/** 
	 * Transactional method.
	 * Saves a new entity or updates an existing one.
	 */
	@Override
	@Transactional
	public void saveEntity(Specialization specialization) {
		specializationDao.save(specialization);
	}

	/** 
	 * Transactional method.
	 * Deletes an entity in the database.
	 */
	@Override
	@Transactional
	public void deleteEntity(Specialization specialization) {
		specializationDao.delete(specialization);
	}

}
