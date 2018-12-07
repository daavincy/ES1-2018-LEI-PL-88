package es.projecto.hmi.interfaces;

import java.util.List;

import es.projecto.config.pojos.NewsHeaders;

public interface HmiPresenter  {
	/**
	 * Obtem das fontes integradas as noticias relevantes
	 * @return a lista de noticias relevantes
	 */
	List<NewsHeaders> getNewsFeeds();
	/**
	 * Obtem, filtrado por fonte,nas noticias relevantes
	 * @param provider usado para filtrar as noticias
	 * @return a lista de noticias relevantes
	 */
	List<NewsHeaders> getNewsFeeds(int provider);
	
	/**
	 * Fecha as ligações aos serviços
	 * 
	 */
	void closeConnections();

}
