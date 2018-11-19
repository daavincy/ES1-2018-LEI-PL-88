package es.projecto.hmi.pojos;

import java.util.Date;

public class NewsHeaders {
	private long id;
	private int provider;
	private String text;
	private String source;
	private Date date;
	
	public NewsHeaders(long id, int provider, String text, String source, Date date) {
		super();
		this.id = id;
		this.provider = provider;
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

	public Date getDate() {
		return date;
	}
	
	

}
