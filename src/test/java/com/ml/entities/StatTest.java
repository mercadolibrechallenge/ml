package com.ml.entities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class StatTest {

	private Stat createTestSubject() {
		return new Stat();
	}

	@Test
	public void testGetId() throws Exception {
		Stat testSubject;
		Long result;

		testSubject = createTestSubject();
		result = testSubject.getId();
	}

	@Test
	public void testSetId() throws Exception {
		Stat testSubject;
		Long id = null;

		// default test
		testSubject = createTestSubject();
		testSubject.setId(id);
	}

	@Test
	public void testGetType() throws Exception {
		Stat testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getType();
	}

	@Test
	public void testSetType() throws Exception {
		Stat testSubject;
		String type = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setType(type);
	}
}