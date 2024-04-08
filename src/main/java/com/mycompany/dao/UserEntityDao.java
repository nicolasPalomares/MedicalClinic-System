package com.mycompany.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.domain.UserEntity;

/** 
 * DAO interface for handling user authentication entities (UserProgram entity).
 * Extends JpaRepository to inherit basic CRUD operations for UserProgram entities.
 */

public interface UserEntityDao extends JpaRepository<UserEntity, Long> {
	
	/** 
	 * @return A user entity by username.
	 */
	UserEntity findByUsername(String username);

}
