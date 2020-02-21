package com.ml.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class StatResponseTest {

	private StatResponse createTestSubject() {
		return new StatResponse(0, 0, 0.0);
	}

	@Test
	public void testGetCount_mutant_dna() throws Exception {
		StatResponse testSubject;
		long result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getCount_mutant_dna();
	}

	@Test
	public void testSetCount_mutant_dna() throws Exception {
		StatResponse testSubject;
		long count_mutant_dna = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setCount_mutant_dna(count_mutant_dna);
	}

	@Test
	public void testGetCount_human_dna() throws Exception {
		StatResponse testSubject;
		long result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getCount_human_dna();
	}

	@Test
	public void testSetCount_human_dna() throws Exception {
		StatResponse testSubject;
		long count_human_dna = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setCount_human_dna(count_human_dna);
	}

	@Test
	public void testGetRatio() throws Exception {
		StatResponse testSubject;
		double result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getRatio();
	}

	@Test
	public void testSetRatio() throws Exception {
		StatResponse testSubject;
		double ratio = 0.0;

		// default test
		testSubject = createTestSubject();
		testSubject.setRatio(ratio);
	}
}