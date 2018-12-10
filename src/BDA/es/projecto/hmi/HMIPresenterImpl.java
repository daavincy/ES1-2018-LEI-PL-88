package es.projecto.hmi;

import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import es.projecto.config.ConfigHelper;
import es.projecto.config.pojos.EmailConfigs;
import es.projecto.config.pojos.NewsHeaders;
import es.projecto.config.pojos.TwitterConfigs;
import es.projecto.email.EmailClient;
import es.projecto.facebook.conection.FacebookBDAClient;
import es.projecto.hmi.interfaces.HmiPresenter;
import es.projecto.hmi.utils.Constants;
import es.projecto.hmi.visualeelements.BomDiaAcademia;
import es.projecto.twitter.conection.TwitterMain;

/**
 * Classe que implementa o interface que habilita o GUI o acesso aos dados e
 * inicializa a aplicação
 * 
 * @author Elvino Monteiro
 *
 */
public class HMIPresenterImpl implements HmiPresenter {

	private TwitterMain maitwitterClient;
	private BomDiaAcademia window;
	private FacebookBDAClient fbclient;
	private EmailClient emailClient;

	public HMIPresenterImpl() {
		window = new BomDiaAcademia(this);
	}
	
	/**
	 * Mostra a janela para interacção do utilizador
	 */
	public void start() {
		window.frame.setVisible(true);
	}
	
	/**
	 * Parar a janela para interacção do utilizador
	 */
	public void stop() {
		window.frame.dispatchEvent(new WindowEvent(window.frame, WindowEvent.WINDOW_CLOSING));
	}

	/**
	 * Obtem uma lista de feeds do twitter que sejam publicados por contas
	 * associadas ao iscte
	 * 
	 * @return a lista obtida
	 */
	private List<NewsHeaders> getTwitterData() {
		ArrayList<NewsHeaders> result = new ArrayList<NewsHeaders>();
		TwitterConfigs twitterConfigs = ConfigHelper.getInstance().getConfigurations().gettwitterConfigs();
		maitwitterClient = new TwitterMain(twitterConfigs.getConsumerKey(), twitterConfigs.getConsumerSecret(),
				twitterConfigs.getAccessToken(), twitterConfigs.getAccessTokenSecret());
		try {
			maitwitterClient.getStatuses().stream().forEach(t -> {

				result.add(new NewsHeaders(t.getId(), 
						Constants.TWITTER_ID,
						null,
						t.getText(),
						t.getUser().getScreenName(), 
						t.getCreatedAt()));
			});
		} catch (Exception e) {
			System.err.println("twitter limit excedded");
		}
		result.sort((d1, d2) -> d2.getDate().compareTo(d1.getDate()));
		return result;
	}

	/**
	 * Obtem uma lista de feeds do facebook
	 * 
	 * @return a lista obtida
	 */
	private List<NewsHeaders> getFacebookData() {
		fbclient = new FacebookBDAClient(
				ConfigHelper.getInstance().getConfigurations().getfacebookConfigs().getAccessToken());
		List<NewsHeaders> result=fbclient.getUserTimelinePosts();
		result.sort((d1, d2) -> d2.getDate().compareTo(d1.getDate()));
		return result;

	}

	/**
	 * Obtem uma lista de feeds do email
	 * 
	 * @return a lista obtida
	 */
	private List<NewsHeaders> getEmailData() {
		EmailConfigs emailConfigs = ConfigHelper.getInstance().getConfigurations().getemailConfigs();
		emailClient = new EmailClient();
		List<NewsHeaders> result=new ArrayList<>();
				try {
					emailClient.connect(emailConfigs.getUser(),emailConfigs.getPassword());
					result = emailClient.getEmailMessages(null);
				} catch (MessagingException e) {
					JOptionPane.showMessageDialog(window.frame, new JLabel(e.getLocalizedMessage()), "Dados incorrectos", JOptionPane.WARNING_MESSAGE);
				}
				result.sort((d1, d2) -> d2.getDate().compareTo(d1.getDate()));
		return result;
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
		result.sort((d1, d2) -> d2.getDate().compareTo(d1.getDate()));
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

	}
	
	public BomDiaAcademia getWindow() {
		return this.window;
		
	}

	@Override
	public void sendMessage(String string,Object postId, int provider) {
	
		switch(provider) {
		case Constants.TWITTER_ID:
			maitwitterClient.interactRetwett((Long)postId);
			break;
		case Constants.FACEBOOK_ID:
			fbclient.sharePost((String) postId);
			break;
		case Constants.EMAIL_ID:
			if(postId instanceof NewsHeaders) {
				String to = ((NewsHeaders)postId).getPoster();
				String subject = ((NewsHeaders)postId).getShorttext();
			emailClient.sendMail(to, subject, string);
			}
			break;
			
			default:
		}
		
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
					HMIPresenterImpl presenter = new HMIPresenterImpl();
					presenter.start();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}





}
