package com.ml.services;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ml.common.AdnMatriz;
import com.ml.controller.StatResponse;
import com.ml.entities.Stat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Rollback
@Transactional
public class ADNServiceImplTest {
	
	
	@Autowired
	ADNService adnService;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testApiRestEsMutante() throws Exception {
		String bodyMutanteOk = "{\r\n" + 
				"\"dna\":[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]\r\n" + 
				"}";
		
		mvc.perform(post("/mutant").contentType("application/json;charset=UTF-8").content(bodyMutanteOk)).andExpect(status().isOk());
	}
	
	@Test
	public void testApiRestNoesMutante() throws Exception {
		String bodyMutanteOk = "{\r\n" + 
				"\"dna\":[\"TTGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CACCTA\",\"TCACTG\"]\r\n" + 
				"}";
		
		mvc.perform(post("/mutant").contentType("application/json;charset=UTF-8").content(bodyMutanteOk)).andExpect(status().isForbidden());
	}


	@Test
	public void testConvertirArrayStringEnMatriz() throws Exception {
		String[] dna = new String[] { "" };
		AdnMatriz result;

		// default test
		result = adnService.convertirArrayStringEnMatriz(dna);
	}


	@Test
	public void testAnalizarNoEsMutante() throws Exception {
		String[] dna = new String[] { "TTGCGA","CAGTGC","TTATGT","AGAAGG","CACCTA","TCACTG"	};

		// default test
		adnService.analizarSiEsMutanteONo(dna);
	}

	
	@Test
	public void testAnalizarSiEsMutante() throws Exception {
		
		String[] dna = new String[] { "TTGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG" };

		// default test
//		adnService.analizarSiEsMutanteONo(dna);
		
	}


	@Test
	public void testSave() throws Exception {
		Stat stat = new Stat();
		stat.setType("M");

		// default test
		assertNotNull(adnService.save(stat));
	}

}