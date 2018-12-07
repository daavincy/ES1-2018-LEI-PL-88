package es.projecto.hmi.visualeelements;

import static org.junit.Assert.assertNotEquals;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import org.junit.jupiter.api.Test;

import es.projecto.config.pojos.NewsHeaders;
import es.projecto.hmi.HMIPresenterImpl;
import es.projecto.hmi.utils.Constants;

public class BomDiaAcademiaTest {
 @Test
 public void testJlistPopulationForFacebook() {
	 HMIPresenterImpl presenter = new HMIPresenterImpl();
	 presenter.start();
	 JList<NewsHeaders> jl = new JList<>(new DefaultListModel<>());
	 presenter.getWindow().frame.add(jl);
	 presenter.getWindow().populateNewsList(jl, Constants.FACEBOOK_ID);
	 assertNotEquals(0, jl.getModel().getSize());
 }
 
 @Test
 public void testJlistPopulationForTwitter() {
	 HMIPresenterImpl presenter = new HMIPresenterImpl();
	 presenter.start();
	 JList<NewsHeaders> jl = new JList<>(new DefaultListModel<>());
	 presenter.getWindow().frame.add(jl);
	 presenter.getWindow().populateNewsList(jl, Constants.TWITTER_ID);
	 assertNotEquals(0, jl.getModel().getSize());
 }
 
 @Test
 public void testJlistPopulationForEmail() {
	 HMIPresenterImpl presenter = new HMIPresenterImpl();
	 presenter.start();
	 JList<NewsHeaders> jl = new JList<>(new DefaultListModel<>());
	 presenter.getWindow().frame.add(jl);
	 presenter.getWindow().populateNewsList(jl, Constants.EMAIL_ID);
	 assertNotEquals(0, jl.getModel().getSize());
 }
 
}
