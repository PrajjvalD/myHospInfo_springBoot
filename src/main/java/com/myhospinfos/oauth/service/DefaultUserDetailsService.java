package com.myhospinfos.oauth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myhospinfos.oauth.model.User;
import com.myhospinfos.oauth.repo.UserRepository;
import com.myhospinfos.oauth.repo.UserRolesRepository;


@Service
public class DefaultUserDetailsService implements UserDetailsService {

	
	// user details from db
	private final UserRepository userRepository;
	 private final UserRolesRepository userRolesRepository;
	 
	 	@Autowired
	    public DefaultUserDetailsService(UserRepository userRepository,UserRolesRepository userRolesRepository) {
	        this.userRepository = userRepository;
	        this.userRolesRepository=userRolesRepository;
	    }
	 @Override
	 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	  User user=userRepository.findByUserName(username);
	 
	  if(null == user){
	   throw new UsernameNotFoundException("No user present with username: "+username);
	  }else{
		  //System.out.println("user name from db: "+user.getUserName()+"auth code :" + user.getPassword());
	   List<String> userRoles=userRolesRepository.findRoleByUserName(username);
	   return new CustomUserDetails(user,userRoles);
	  }
	 }
}
