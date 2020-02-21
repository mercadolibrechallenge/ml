package com.ml.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MLRequestTest {

	private MLRequest createTestSubject() {
		return new MLRequest();
	}

	@Test
	public void testGetDna() throws Exception {
		MLRequest testSubject;
		String[] result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getDna();
	}

	@Test
	public void testSetDna() throws Exception {
		MLRequest testSubject;
		String[] dna = new String[] { "" };

		// default test
		testSubject = createTestSubject();
		testSubject.setDna(dna);
	}
}