package com.mycompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.dao.DepartmentDao;
import com.mycompany.domain.Department;

/** 
 * Implementation of the iService interface for Department entity CRUD operations.
 * Sets the generic type of the interface to Department.
 */

@Service
public class DepartmentService implements iService<Department> {
	
	@Autowired
	private DepartmentDao departmentDao;

	/** 
	 * Transactional method in read-only mode.
	 * @return List of all entities in the database.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Department> listEntity() {
		return (List<Department>) departmentDao.findAllByOrderBySpecializationNameAsc();
	}

	/** 
	 * Transactional method in read-only mode.
	 * @return An entity from the database specified with an ID, or null if not found.
	 */
	@Override
	@Transactional(readOnly = true)
	public Department findEntity(Department department) {
		return departmentDao.findById(department.getDepartmentId()).orElse(null);
	}

	/** 
	 * Transactional method.
	 * Saves a new entity or updates an existing one.
	 */
	@Override
	@Transactional
	public void saveEntity(Department department) {
		departmentDao.save(department);
	}

	/** 
	 * Transactional method.
	 * Deletes an entity in the database.
	 */
	@Override
	@Transactional
	public void deleteEntity(Department department) {
		departmentDao.delete(department);
	}

}
