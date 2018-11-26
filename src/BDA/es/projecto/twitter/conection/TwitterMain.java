	package es.projecto.twitter.conection;

import java.util.ArrayList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public final class TwitterMain  {
	
	private ArrayList<Status> statuses;
	
	private Twitter twitter;
	
	 
	/**
	 * TwitterMain constructor
	 * @param consumerKey
	 * @param consumerSecret
	 * @param accessToken
	 * @param accessTokenSecret
	 */
	public TwitterMain(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {

		  try {
	        	ConfigurationBuilder cb = new ConfigurationBuilder();
	        	cb.setDebugEnabled(true)
	        	  .setOAuthConsumerKey(consumerKey) //"WwkVm3nKOV5OF7b1iSkLqPE6w"
	        	  .setOAuthConsumerSecret(consumerSecret) //"DPKF4GyPbtgB3tO5RdnyOW2Ad03vq1V0fYZxorvTlakj8IjuAF"
	        	  .setOAuthAccessToken(accessToken) //"1052230420182519808-rDk4irssdofqNhmefXYpfjdwBicl3x"
	        	  .setOAuthAccessTokenSecret(accessTokenSecret); //hXjYJYu2mGqh21IoxIDxZqupBAr8KW8abeLFBX8oU7MM9"
	        	TwitterFactory tf = new TwitterFactory(cb.build());
	        	twitter = tf.getInstance();        		
		
		  } catch (Exception e) {
			  System.out.println(e.getMessage());
			// TODO: handle exception
		}
	}
	
	
	/**
	 * Metodo Devolve um Arraylist, filtrado por ISCTE, com os status do nome do user e respetivo texto do twitt
	 * 
	 * @return ArrayList with the filtered statuses
	 * 
	 * 
	 */
	public ArrayList<Status> getStatuses() {
		
		ArrayList<Status> aux = new ArrayList<Status>();
		
		try {
			
			statuses = (ArrayList<Status>) twitter.getHomeTimeline();
			 System.out.println("------------------------\n Showing home timeline \n------------------------");
			 
	    		int counter=0;
	    		int counterTotal = 0;
	            for (Status status : statuses) {
					// Filters only tweets from user "ISCTE"
					if (status.getUser().getName() != null && status.getUser().getName().contains("ISCTE")) {
						System.out.println(status.getUser().getName() + ":" + status.getText());
						counter++;
						aux.add(status);
					}
					counterTotal++;
	            }
	          
	    		System.out.println("-------------\nN� of Results: " + counter+"/"+counterTotal);
	    		
	    		System.out.println(aux);
	    		return aux;
	    		
			
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}





	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {

		// http://twitter4j.org/en/code-examples.html
		// https://www.youtube.com/watch?v=uYPmkzMpnxw~
		
		
		TwitterMain m = new TwitterMain("WwkVm3nKOV5OF7b1iSkLqPE6w","DPKF4GyPbtgB3tO5RdnyOW2Ad03vq1V0fYZxorvTlakj8IjuAF", 
				"1052230420182519808-rDk4irssdofqNhmefXYpfjdwBicl3x", "hXjYJYu2mGqh21IoxIDxZqupBAr8KW8abeLFBX8oU7MM9");
		m.getStatuses();
		

     }
}
    
