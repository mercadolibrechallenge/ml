package com.ml.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ml.dao.IRoleDao;
import com.ml.entities.Role;



@Service
public class RoleServiceImpl implements IRolService {

	@Autowired
	private IRoleDao roleDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return (List<Role>) roleDao.findAll();
	}

	@Override
	@Transactional
	public void save(Role cliente) {
		roleDao.save(cliente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Role findOne(String id) {
		// TODO Auto-generated method stub
		return roleDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(String id) {
		roleDao.deleteById(id);
		
	}
}
