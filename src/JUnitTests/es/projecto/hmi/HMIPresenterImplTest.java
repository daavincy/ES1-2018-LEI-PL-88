package es.projecto.hmi;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.projecto.config.pojos.NewsHeaders;
import es.projecto.hmi.utils.Constants;
import es.projecto.hmi.visualeelements.BomDiaAcademia;

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

	@Test
	public void testGetWindow() throws Exception {
		assertEquals(BomDiaAcademia.class.getName(), s.getWindow().getClass().getName()); 
	}

}
