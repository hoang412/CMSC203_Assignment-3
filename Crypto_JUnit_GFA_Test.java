package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Crypto_JUnit_GFA_Test {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testStringInBound() {
		assertTrue(CryptoManager.stringInBounds("THIS TEST SHOULD SUCCEED"));
	}

}
