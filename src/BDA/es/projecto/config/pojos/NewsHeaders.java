package es.projecto.config.pojos;

import java.util.Date;

import es.projecto.hmi.utils.Constants;

public class NewsHeaders {
	private long id;
	private int provider;
	private String shorttext;
	private String text;
	private String poster;
	private Date date;
	private String id2;
	


/**
 * Construtor para receber as noticias.
 * @param id {@link Long} identificador unico da mensagem
 * @param provider uma das constates da class {@link Constants} {@code FACEBOOK_ID, TWITTER_ID ou EMAIL_ID}
 * @param shorttext titulo curto ou sujeito da mensagem
 * @param text corpo da mensagem
 * @param poster remetente da mensagem
 * @param date data de recepção da mensagem
 */
	public NewsHeaders(Long id, int provider, String shorttext, String text, String poster, Date date) {
		super();
		this.id = id==null?0L:id;
		this.provider = provider;
		this.shorttext = shorttext!=null?shorttext:text.length()<=40?text:text.substring(0, 37)+"...";;
		this.text = text;
		this.poster = poster;
		this.date = date==null?new Date():date;
	}

	/**
	 * Construtor para receber as noticias.
	 * @param id2 {@link String} identificador unico da mensagem
	 * @param provider uma das constantes da class {@link Constants} {@code FACEBOOK_ID, TWITTER_ID ou EMAIL_ID}
	 * @param shorttext titulo curto ou sujeito da mensagem
	 * @param text corpo da mensagem
	 * @param poster remetente da mensagem
	 * @param date data de recepção da mensagem
	 */

public NewsHeaders(String id2, int provider, String shorttext, String text, String poster, Date date) {
	this.id2 = id2;
	this.id=0L;
	this.provider = provider;
	this.shorttext = shorttext!=null?shorttext:text.length()<=40?text:text.substring(0, 37)+"...";
	this.text = text;
	this.poster = poster;
	this.date = date;
}


/**
 * @return the id
 */
public long getId() {
	return id;
}


/**
 * @return the provider
 */
public int getProvider() {
	return provider;
}


/**
 * @return the shorttext
 */
public String getShorttext() {
	return shorttext;
}


/**
 * @return the text
 */
public String getText() {
	return text;
}


/**
 * @return the poster
 */
public String getPoster() {
	return poster;
}


/**
 * @return the date
 */
public Date getDate() {
	return date;
}
	
/**
 * Special id used when the id cannot be of {@link Long} type...
 * @return the id2
 */
public String getId2() {
	return id2;
}


/**
 * @param id2 the id2 to set
 */
public void setId2(String id2) {
	this.id2 = id2;
}


	

}
