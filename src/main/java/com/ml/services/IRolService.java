package com.ml.services;

import java.util.List;

import com.ml.entities.Role;

public interface IRolService {
	
	public List<Role> findAll();

	public void save(Role cliente);
	
	public Role findOne(String id);
	
	public void delete(String id);
	
}
