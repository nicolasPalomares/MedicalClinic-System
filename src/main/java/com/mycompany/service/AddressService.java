package com.mycompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.dao.AddressDao;
import com.mycompany.domain.Address;

/** 
 * Implementation of the iService interface for Address entity CRUD operations.
 * Sets the generic type of the interface to Address.
 */

@Service
public class AddressService implements iService<Address> {
	
	@Autowired
	private AddressDao addressDao;

	/** 
	 * Transactional method in read-only mode.
	 * @return List of all entities in the database.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Address> listEntity() {
		return (List<Address>) addressDao.findAll();
	}

	/** 
	 * Transactional method in read-only mode.
	 * @return An entity from the database specified with an ID, or null if not found.
	 */
	@Override
	@Transactional(readOnly = true)
	public Address findEntity(Address address) {
		return addressDao.findById(address.getAddressId()).orElse(null);
	}

	/** 
	 * Transactional method.
	 * Saves a new entity or updates an existing one.
	 */
	@Override
	@Transactional
	public void saveEntity(Address address) {
		addressDao.save(address);
	}

	/** 
	 * Transactional method.
	 * Deletes an entity in the database.
	 */
	@Override
	@Transactional
	public void deleteEntity(Address address) {
		addressDao.delete(address);
	}

}
