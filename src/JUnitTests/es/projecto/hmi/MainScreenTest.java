package es.projecto.hmi;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.channels.NotYetConnectedException;
import java.rmi.UnexpectedException;

import org.junit.jupiter.api.Test;

class MainScreenTest {

	@Test
	void pedirUmaListaSemProviders() throws UnexpectedException, NotYetConnectedException {
		MainScreen s = new MainScreen();
		assertNull( s.getNewsList(null));
	}

	
	
}
