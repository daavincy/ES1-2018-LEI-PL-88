package es.projecto.hmi;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.channels.NotYetConnectedException;
import java.rmi.UnexpectedException;

import javax.swing.JPanel;

import org.junit.jupiter.api.Test;

class MainScreenTest {

	@Test
	void pedirUmaListaSemProviders() throws UnexpectedException, NotYetConnectedException {
		MainScreen s = new MainScreen();
		assertNull( s.getNewsList(null));
	}

	@Test
	public void pedirUmaListaComTodosOsProviders() throws Exception {
		MainScreen s = new MainScreen();
		JPanel res = s.getNewsList(new String[]{"facebook","twitter","email"});
		assertNotNull(res);
	}
	
	@Test
	public void pedirUmaListaComFacebook() throws Exception {
		MainScreen s = new MainScreen();
		JPanel res = s.getNewsList(new String[]{"facebook"});
		assertNotNull(res);
	}
	
	@Test
	public void pedirUmaListaComTwitter() throws Exception {
		MainScreen s = new MainScreen();
		JPanel res = s.getNewsList(new String[]{"twitter"});
		assertNotNull(res);
	}
	
	@Test
	public void pedirUmaListaComEmail() throws Exception {
		MainScreen s = new MainScreen();
		JPanel res = s.getNewsList(new String[]{"email"});
		assertNotNull(res);
	}
	
	

	
	
}
