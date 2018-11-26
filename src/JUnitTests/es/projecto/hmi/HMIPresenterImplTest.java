package es.projecto.hmi;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.nio.channels.NotYetConnectedException;
import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.junit.jupiter.api.Test;

import es.projecto.hmi.pojos.NewsHeaders;
import es.projecto.hmi.utils.Constants;

class HMIPresenterImplTest {
	HMIPresenterImpl s = new HMIPresenterImpl();

	@Test
	void pedirUmaListaSemProviders()  {
		assertEquals(s.getNewsFeeds(0), new ArrayList<>());
	}

	@Test
	public void pedirUmaListaComTodosOsProviders() {
		List<NewsHeaders> res = s.getNewsFeeds();
		assertNotNull(res);
	}

	@Test
	public void pedirUmaListaComFacebook() {
		List<NewsHeaders> res = s.getNewsFeeds(Constants.FACEBOOK_ID);
		assertNotNull(res);
	}

	@Test
	public void pedirUmaListaComTwitter() {
		List<NewsHeaders> res = s.getNewsFeeds(Constants.TWITTER_ID);
		assertNotNull(res);
	}

	@Test
	public void pedirUmaListaComEmail() {
		List<NewsHeaders> res = s.getNewsFeeds(Constants.EMAIL_ID);
		assertNotNull(res);
	}

}
