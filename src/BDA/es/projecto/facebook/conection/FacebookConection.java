package es.projecto.facebook.conection;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Header;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.Post;
import com.restfb.types.User;

import es.projecto.hmi.pojos.NewsHeaders;
import es.projecto.hmi.utils.Constants;

public class FacebookConection {
	
	private String accessToken; //="EAAElkZB1PPCABAJqd07ZAZB1gRA6zpJBnBXAvaTFw5qoa4zkdRK7m2SsApCVWhFvLdK4Y14jQcXGuCoJnizGDUCvDJHPzxfQXD0n7FVqdALG6K3XdPiow83TVJ1zb618TgLl78w34lC3Euuz7ZBuNfZCsDIFXOjujXzw6LySLLaHZAZC3REKQwL";

	private FacebookClient fbClient;
	
	
	/**
	 * FacebookConnector constructor
	 * @param accessToken
	 */
	public FacebookConection(String accessToken) {
		this.accessToken=accessToken;
		
		fbClient = new DefaultFacebookClient(accessToken);
		AccessToken extendedAccessToken4 = fbClient.obtainExtendedAccessToken("322792248523808","9fb34f027c272ab0d46b40df34ad0410");
		
		//Dados User
		User me2 = fbClient.fetchObject("me", User.class);
		System.out.println("Facebook:");
		System.out.println("Id: " + me2.getId());
		System.out.println("Name: " + me2.getName());
		
	}
	
	
	/**
	 * @return ArrayList with the filtered posts
	 */
	public ArrayList<NewsHeaders> getUserTimelinePosts() {
		
		//ArrayList<Post> fbOutput = new ArrayList<>();
		//Posts
		Connection<Post> result = fbClient.fetchConnection("me/feed",Post.class);
		System.out.println("\nPosts:");
		int counter5 = 0;
		int counterTotal = 0;
		
		ArrayList<NewsHeaders> header = new ArrayList<>();
		
		for (List<Post> page : result) {
			for (Post aPost : page) {
				// Filters only posts that contain the word "Inform"
				
				if (aPost.getMessage() != null && aPost.getMessage().contains("ISCTE")) {
					
					System.out.println("---- Post "+ counter5 + " ----");
					
					System.out.println("Id: "+"fb.com/"+aPost.getId());
					System.out.println("Message: "+aPost.getMessage());
					System.out.println("Created: "+aPost.getCreatedTime());
					
					counter5++;
					//fbOutput.add(aPost);
					
					header.add(new NewsHeaders(null, Constants.FACEBOOK_ID, aPost.getDescription() , aPost.getMessage(), aPost.getFrom().toString(), aPost.getCreatedTime()));
					
				}
				counterTotal++;
			}
		}
		return header;
	}

 
	public void getPostsIscte() {
	}
	
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		FacebookConection fc = new FacebookConection("EAAElkZB1PPCABAJqd07ZAZB1gRA6zpJBnBXAvaTFw5qoa4zkdRK7m2SsApCVWhFvLdK4Y14jQcXGuCoJnizGDUCvDJHPzxfQXD0n7FVqdALG6K3XdPiow83TVJ1zb618TgLl78w34lC3Euuz7ZBuNfZCsDIFXOjujXzw6LySLLaHZAZC3REKQwL");
		fc.getUserTimelinePosts();

	}

}
