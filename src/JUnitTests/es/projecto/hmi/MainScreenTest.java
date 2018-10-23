package es.projecto.hmi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainScreenTest {

	@Test
	void pedirUmaListaSemProviders() {
		MainScreen s = new MainScreen();
		assertNull( s.getNewsList(null));
	}

	
	
}
