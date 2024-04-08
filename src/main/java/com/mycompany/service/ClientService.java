package com.mycompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.dao.ClientDao;
import com.mycompany.domain.Client;

/** 
 * Implementation of the iService interface for Client entity CRUD operations.
 * Sets the generic type of the interface to Client.
 */

@Service
public class ClientService implements iService<Client> {
	
	@Autowired
	private ClientDao clientDao;

	/** 
	 * Transactional method in read-only mode.
	 * @return List of all entities in the database.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Client> listEntity() {
		return (List<Client>) clientDao.findAllByOrderBySurnameAsc();
	}

	/** 
	 * Transactional method in read-only mode.
	 * @return An entity from the database specified with an ID, or null if not found.
	 */
	@Override
	@Transactional(readOnly = true)
	public Client findEntity(Client client) {
		return clientDao.findById(client.getClientId()).orElse(null);
	}

	/** 
	 * Transactional method.
	 * Saves a new entity or updates an existing one.
	 */
	@Override
	@Transactional
	public void saveEntity(Client client) {
		clientDao.save(client);
	}

	/** 
	 * Transactional method.
	 * Deletes an entity in the database.
	 */
	@Override
	@Transactional
	public void deleteEntity(Client client) {
		clientDao.delete(client);
	}

}
