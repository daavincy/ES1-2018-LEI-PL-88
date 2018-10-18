package es.projecto.hmi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BDAHmiTest {

	@Test
	void testDoBananas() {
		BDAHmi hmi = new BDAHmi();
		assertFalse(hmi.doBananas("Bananeiro"));
	}

}
