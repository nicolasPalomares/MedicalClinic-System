package com.mycompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.dao.ContactDao;
import com.mycompany.domain.Contact;

/** 
 * Implementation of the iService interface for Contact entity CRUD operations.
 * Sets the generic type of the interface to Contact.
 */

@Service
public class ContactService implements iService<Contact> {
	
	@Autowired
	private ContactDao contactDao;

	/** 
	 * Transactional method in read-only mode.
	 * @return List of all entities in the database.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Contact> listEntity() {
		return (List<Contact>) contactDao.findAll();
	}

	/** 
	 * Transactional method in read-only mode.
	 * @return An entity from the database specified with an ID, or null if not found.
	 */
	@Override
	@Transactional(readOnly = true)
	public Contact findEntity(Contact contact) {
		return contactDao.findById(contact.getContactId()).orElse(null);
	}

	/** 
	 * Transactional method.
	 * Saves a new entity or updates an existing one.
	 */
	@Override
	@Transactional
	public void saveEntity(Contact contact) {
		contactDao.save(contact);
	}

	/** 
	 * Transactional method.
	 * Deletes an entity in the database.
	 */
	@Override
	@Transactional
	public void deleteEntity(Contact contact) {
		contactDao.delete(contact);
	}

}
