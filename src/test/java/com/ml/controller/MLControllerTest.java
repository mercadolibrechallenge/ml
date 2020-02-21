package com.ml.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

@RunWith(SpringRunner.class)
public class MLControllerTest {

	private MLController createTestSubject() {
		return new MLController();
	}

	@Test
	public void testMutant() throws Exception {
	/*	MLController testSubject;
		MLRequest mlRequest = null;
		ResponseEntity<String> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.mutant(mlRequest);
		*/
	}

	@Test
	public void testStats() throws Exception {
		/*MLController testSubject;
		Model model = null;
		StatResponse result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.stats(model);
		*/
	}
}