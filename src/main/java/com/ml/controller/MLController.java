package com.ml.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ml.common.AdnMatriz;
import com.ml.common.EsUnMutanteException;
import com.ml.services.ADNService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
public class MLController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MLController.class);
	
	@Autowired
	private ADNService adnService;

	
	@PostMapping(value = "/mutant")
	public ResponseEntity<String> mutant(@RequestBody MLRequest mlRequest) {
		
		try{
		adnService.analizarSiEsMutanteONo(mlRequest.getDna());
		} catch (EsUnMutanteException e) {
			return  new ResponseEntity<>(
				      "Es un mutante v2",
				      HttpStatus.OK);	
		}
		
		return  new ResponseEntity<>(
				      "NO Es un mutante v2",
				      HttpStatus.FORBIDDEN);

	}
	
	
	@GetMapping(value = "/stats")
	public @ResponseBody StatResponse stats(Model model) {		
		return adnService.obtenerEstadisticasInvocacionesADN();
	}

}