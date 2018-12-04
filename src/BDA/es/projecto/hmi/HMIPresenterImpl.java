package es.projecto.hmi;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import es.projecto.facebook.conection.FacebookConection;
import es.projecto.hmi.pojos.BDAConfigs;
import es.projecto.hmi.pojos.NewsHeaders;
import es.projecto.hmi.utils.Constants;
import es.projecto.hmi.visualeelements.BomDiaAcademia;
import es.projecto.twitter.conection.TwitterMain;

/**
 * Classe que implementa o interface que habilita o GUI o acesso aos dados e inicializa a aplicação
 * @author Elvino Monteiro
 *
 */
public class HMIPresenterImpl implements HmiPresenter {

	private TwitterMain main;

	public HMIPresenterImpl() {
		main = new TwitterMain(BDAConfigs.twitter_consumerKey, BDAConfigs.twitter_consumerSecret,
				BDAConfigs.twitter_accessToken, BDAConfigs.twitter_accessTokenSecret);
	}
	
	/**
	 * Obtem uma lista de feeds do twitter que sejam publicados por contas associadas ao iscte
	 * 
	 * @return a lista obtida
	 */
	private List<NewsHeaders> getTwitterData() {
		ArrayList<NewsHeaders> result = new ArrayList<NewsHeaders>();
try {
		main.getStatuses().stream().forEach(t -> {

			result.add(new NewsHeaders(t.getId(), Constants.TWITTER_ID,
					t.getText().length() < 30 ? t.getText() : t.getText().substring(1, 30), t.getText(),
					t.getUser().getScreenName(), t.getCreatedAt()));
		});
}catch (Exception e) {
	System.err.println("twitter limit excedded");
}
		return result;
	}
	
	
	/**
	 * Obtem uma lista de feeds do facebook
	 * 
	 * @return a lista obtida
	 */
	private List<NewsHeaders> getFacebookData() {
		FacebookConection fbclient = new FacebookConection("EAAElkZB1PPCABAJqd07ZAZB1gRA6zpJBnBXAvaTFw5qoa4zkdRK7m2SsApCVWhFvLdK4Y14jQcXGuCoJnizGDUCvDJHPzxfQXD0n7FVqdALG6K3XdPiow83TVJ1zb618TgLl78w34lC3Euuz7ZBuNfZCsDIFXOjujXzw6LySLLaHZAZC3REKQwL");
		return fbclient.getUserTimelinePosts();
		
	}

	/**
	 * Obtem uma lista de feeds do email
	 * 
	 * @return a lista obtida
	 */
	private List<NewsHeaders> getEmailData() {
//		String password = "1234wasd";
//		String user = "afcmota11@gmail.com";
//		Email emailClient = new Email(user,password);
//		return emailClient.getEmails();
		return new ArrayList<>();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.projecto.hmi.HmiPresenter#getNewsFeeds()
	 */
	@Override
	public List<NewsHeaders> getNewsFeeds() {
		List<NewsHeaders> result = getFacebookData();
		result.addAll(getTwitterData());
		result.addAll(getEmailData());
		result.sort((d1,d2)-> d2.getDate().compareTo(d1.getDate()));
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.projecto.hmi.HmiPresenter#getNewsFeeds(int provider)
	 */
	@Override
	public List<NewsHeaders> getNewsFeeds(int provider) {
		switch (provider) {
		case Constants.TWITTER_ID:
			return getTwitterData();
		case Constants.FACEBOOK_ID:
			return getFacebookData();
		case Constants.EMAIL_ID:
			return getEmailData();
		default:
			return new ArrayList<>();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.projecto.hmi.HmiPresenter#closeConnections()
	 */
	@Override
	public void closeConnections() {
		// TODO close de connections opened during execution.

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.projecto.hmi.HmiPresenter#getConfigurations()
	 */
	@Override
	public void getConfigurations() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.projecto.hmi.HmiPresenter#setConfigurations(es.projecto.hmi.pojos.
	 * BDAConfigs)
	 */
	@Override
	public void setConfigurations(BDAConfigs configs) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		try {
			// Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			// handle exception
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BomDiaAcademia window = new BomDiaAcademia(new HMIPresenterImpl());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
