package com.att.onlinestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.onlinestore.properties.LoginProperties;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginProperties props;


	@Override
	public boolean validateUser(String name, String password) {

		String propName = props.getName();
		String propPass = props.getPassword();

		return propName.equalsIgnoreCase(name) && propPass.equalsIgnoreCase(password);

	}

	

}
