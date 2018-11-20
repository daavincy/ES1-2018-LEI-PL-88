package es.projecto.hmi;

import java.awt.EventQueue;
import java.nio.channels.NotYetConnectedException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import es.projecto.hmi.pojos.BDAConfigs;
import es.projecto.hmi.pojos.NewsHeaders;
import es.projecto.hmi.utils.Constants;
import es.projecto.twitter.conection.TwitterMain;

public class HMIPresenterImpl implements HmiPresenter {
	

	private TwitterMain main;

	public HMIPresenterImpl() {
		main = new TwitterMain(BDAConfigs.twitter_consumerKey, BDAConfigs.twitter_consumerSecret, BDAConfigs.twitter_accessToken, BDAConfigs.twitter_accessTokenSecret);
	}


	private List<NewsHeaders> getTwitterData() {
		ArrayList<NewsHeaders> result = new ArrayList<NewsHeaders>();
		main.getStatuses().stream().forEach(t->{
			result.add(new NewsHeaders(t.getId(),Constants.TWITTER_ID , t.getUser().getScreenName(), t.getText().substring(0, 50),t.getText(), t.getCreatedAt()));
		});
		return result;
	}

	private  List<NewsHeaders> getFacebookData() {
		throw new NotYetConnectedException();
		// TODO Auto-generated method stub
	}

	@Override
	public List<NewsHeaders>  getNewsFeeds() {
		return getTwitterData();	
	}
	
	@Override
	public List<NewsHeaders>  getNewsFeeds(int provider) {
		switch(provider) {
		case Constants.TWITTER_ID:
			return getTwitterData();
		case Constants.FACEBOOK_ID:
		case Constants.EMAIL_ID:
		default:
			return new ArrayList<>();
		}
			
	}

	@Override
	public void closeConnections() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getConfigurations() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setConfigurations(BDAConfigs configs) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
	    try {
            // Set cross-platform Java L&F (also called "Metal")
        UIManager.setLookAndFeel(
        		"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
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
