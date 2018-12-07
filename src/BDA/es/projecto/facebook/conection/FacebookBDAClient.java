package es.projecto.facebook.conection;

import java.util.ArrayList;
import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;
import com.restfb.types.Post;

import es.projecto.config.pojos.NewsHeaders;
import es.projecto.hmi.utils.Constants;

public class FacebookBDAClient {
	
	
	private FacebookClient fbClient;
	private ArrayList<Post> posts;
	
	/**
	 * FacebookConnector constructor
	 * @param accessToken
	 */
	public FacebookBDAClient(String accessToken ) {
		fbClient = new DefaultFacebookClient(accessToken, Version.LATEST);
	}
	
	/**
	 * @return ArrayList with the filtered posts
	 */
	public ArrayList<NewsHeaders> getUserTimelinePosts() {

		Connection<Post> result = fbClient.fetchConnection("me/feed",Post.class);
		ArrayList<NewsHeaders> headers = new ArrayList<>();
		
		for (List<Post> page : result) {
			for (Post aPost : page) {
				
				if (aPost.getMessage() != null && aPost.getMessage().contains("ISCTE")) {	
					posts.add(aPost);
					headers.add(new NewsHeaders(aPost.getId(), Constants.FACEBOOK_ID, aPost.getDescription(), aPost.getMessage(), aPost.getFrom()!=null?aPost.getFrom().getName():"De Mim", aPost.getCreatedTime()));				
				}
			}
		}
		return headers;
	}

	/**
	 * Atraves do parametro partilha determinado post
	 * 
	 * @param postID
	 */
	public void sharePost(String postID){
		for(Post aPost: posts) {
			if(aPost.getId().equals(postID)) {
				fbClient.publish("me/feed", FacebookType.class, Parameter.with("link", aPost.getLink()));
			}
		}
	}
	
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		FacebookBDAClient fc = new FacebookBDAClient("EAAElkZB1PPCABAJqd07ZAZB1gRA6zpJBnBXAvaTFw5qoa4zkdRK7m2SsApCVWhFvLdK4Y14jQcXGuCoJnizGDUCvDJHPzxfQXD0n7FVqdALG6K3XdPiow83TVJ1zb618TgLl78w34lC3Euuz7ZBuNfZCsDIFXOjujXzw6LySLLaHZAZC3REKQwL");
		fc.getUserTimelinePosts();

	}

}
