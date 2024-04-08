package com.mycompany.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.mycompany.dao.UserEntityDao;
import com.mycompany.domain.Role;
import com.mycompany.domain.UserEntity;

/** 
 * Service class providing user-related functionality for Spring Security integration.
 * Implements UserDetailsService to facilitate user authentication and authorization.
 */

@Service("userDetailsService")
public class UserEntityService implements UserDetailsService {
	
	@Autowired
	private UserEntityDao userEntityDao;
	
	/** 
	 * Transactional method in read-only mode.
	 * Loads a user by the given username and configures the roles for that user.
	 * @return UserDetails representing the user.
	 * @throws UsernameNotFoundException if the user is not found.
	 */
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity userEntity = userEntityDao.findByUsername(username);
		
		if(userEntity == null) {
			throw new UsernameNotFoundException(username);
		}
		
		var roles = new ArrayList<GrantedAuthority>();
		
		for(Role role : userEntity.getRoles()) {
			roles.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return new User(userEntity.getUsername(), userEntity.getPassword(), roles);
		
	}

}
