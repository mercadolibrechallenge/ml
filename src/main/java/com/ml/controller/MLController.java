package com.ml.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ml.entities.Role;
import com.ml.services.IRolService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("ml")
public class MLController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MLController.class);
	
	@Autowired
	private IRolService roleService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public List<Role> listar(Model model) {
		LOGGER.trace("Texto TRACE");
		LOGGER.info("Texto info");
		String m = null;
		
		List<Role> roles = roleService.findAll();
		
		LOGGER.error("Texto error");
		return roles;
	}
	

}