package es.projecto.facebook.conection;

import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.Post;
import com.restfb.types.User;

public class FacebookConection {
	
	private static String accessToken="EAAElkZB1PPCABAJqd07ZAZB1gRA6zpJBnBXAvaTFw5qoa4zkdRK7m2SsApCVWhFvLdK4Y14jQcXGuCoJnizGDUCvDJHPzxfQXD0n7FVqdALG6K3XdPiow83TVJ1zb618TgLl78w34lC3Euuz7ZBuNfZCsDIFXOjujXzw6LySLLaHZAZC3REKQwL";


	public FacebookConection() {
	}
	
public void getUserTimelinePosts() {
		
		FacebookClient fbClient = new DefaultFacebookClient(accessToken);
		AccessToken extendedAccessToken4 = fbClient.obtainExtendedAccessToken("322792248523808","9fb34f027c272ab0d46b40df34ad0410");
		
		//Dados User
		User me2 = fbClient.fetchObject("me", User.class);
		System.out.println("Facebook:");
		System.out.println("Id: " + me2.getId());
		System.out.println("Name: " + me2.getName());
		
		//Posts
		Connection<Post> result = fbClient.fetchConnection("me/feed",Post.class);
		System.out.println("\nPosts:");
		int counter5 = 0;
		int counterTotal = 0;
		for (List<Post> page : result) {
			for (Post aPost : page) {
				// Filters only posts that contain the word "Inform"
				if (aPost.getMessage() != null && aPost.getMessage().contains("ISCTE")) {
					
					System.out.println("---- Post "+ counter5 + " ----");
					System.out.println("Id: "+"fb.com/"+aPost.getId());
					System.out.println("Message: "+aPost.getMessage());
					System.out.println("Created: "+aPost.getCreatedTime());
					counter5++;
				}
				counterTotal++;
			}
		}
		
	}

	public static void main(String[] args) {
		
		FacebookConection fc = new FacebookConection();
		fc.getUserTimelinePosts();

	}

}