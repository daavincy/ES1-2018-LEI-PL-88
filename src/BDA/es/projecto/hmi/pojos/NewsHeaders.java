package es.projecto.hmi.pojos;

import java.util.Date;

import es.projecto.hmi.utils.Constants;

public class NewsHeaders {
	private long id;
	private int provider;
	private String shorttext;
	private String text;
	private String source;
	private Date date;
	

/**
 * Construtor para receber as noticias.
 * @param id {@link Long} identificador unico da mensagem
 * @param provider uma das constates da class {@link Constants} {@code FACEBOOK_ID, TWITTER_ID ou EMAIL_ID}
 * @param shorttext titulo curto ou sujeito da mensagem
 * @param text corpo da mensagem
 * @param source remetente da mensagem
 * @param date data de recepção da mensagem
 */
	public NewsHeaders(Long id, int provider, String shorttext, String text, String source, Date date) {
		super();
		this.id = id==null?0L:id;
		this.provider = provider;
		this.shorttext = shorttext;
		this.text = text;
		this.source = source;
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
 * @return the source
 */
public String getSource() {
	return source;
}


/**
 * @return the date
 */
public Date getDate() {
	return date;
}
	
	
	

}
