package es.projecto.hmi;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.nio.channels.NotYetConnectedException;
import java.rmi.UnexpectedException;

import javax.swing.JPanel;

import org.junit.jupiter.api.Test;

class HMIPresenterImplTest {

	@Test
	void pedirUmaListaSemProviders() throws UnexpectedException, NotYetConnectedException {
		HMIPresenterImpl s = new HMIPresenterImpl();
		assertNull( s.getNewsList(null));
	}

	@Test
	public void pedirUmaListaComTodosOsProviders() throws Exception {
		HMIPresenterImpl s = new HMIPresenterImpl();
		JPanel res = s.getNewsList(new String[]{"facebook","twitter","email"});
		assertNotNull(res);
	}
	
	@Test
	public void pedirUmaListaComFacebook() throws Exception {
		HMIPresenterImpl s = new HMIPresenterImpl();
		JPanel res = s.getNewsList(new String[]{"facebook"});
		assertNotNull(res);
	}
	
	@Test
	public void pedirUmaListaComTwitter() throws Exception {
		HMIPresenterImpl s = new HMIPresenterImpl();
		JPanel res = s.getNewsList(new String[]{"twitter"});
		assertNotNull(res);
	}
	
	@Test
	public void pedirUmaListaComEmail() throws Exception {
		HMIPresenterImpl s = new HMIPresenterImpl();
		JPanel res = s.getNewsList(new String[]{"email"});
		assertNotNull(res);
	}
	
	

	
	
}
