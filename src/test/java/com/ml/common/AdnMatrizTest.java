package com.ml.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class AdnMatrizTest {

	private AdnMatriz createTestSubject() {
		return new AdnMatriz();
	}

	@Test
	public void testGetAdnMatriz() throws Exception {
		AdnMatriz testSubject;
		char[][] result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getAdnMatriz();
	}

	@Test
	public void testSetAdnMatriz() throws Exception {
		AdnMatriz testSubject;
		char[][] adnMatriz = new char[][] { };

		// default test
		testSubject = createTestSubject();
		testSubject.setAdnMatriz(adnMatriz);
	}

	@Test
	public void testGetTotalSecuencias() throws Exception {
		AdnMatriz testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getTotalSecuencias();
	}

	@Test
	public void testSetTotalSecuencias() throws Exception {
		AdnMatriz testSubject;
		int totalSecuencias = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setTotalSecuencias(totalSecuencias);
	}

	@Test
	public void testIncrementarEnUnoSecuencia() throws Exception {
		AdnMatriz testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.incrementarEnUnoSecuencia();
	}
	
}