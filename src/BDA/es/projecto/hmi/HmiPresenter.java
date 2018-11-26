package es.projecto.hmi;

import java.util.List;

import es.projecto.hmi.pojos.BDAConfigs;
import es.projecto.hmi.pojos.NewsHeaders;

public interface HmiPresenter  {
	/**
	 * Obtem das fontes integradas as noticias relevantes
	 * @return a lista de noticias relevantes
	 */
	List<NewsHeaders> getNewsFeeds();
	/**
	 * Obtem, filtrado por fonte,nas noticias relevantes
	 * @return a lista de noticias relevantes
	 */
	List<NewsHeaders> getNewsFeeds(int provider);
	
	/**
	 * Fecha as ligações aos serviços
	 * 
	 */
	void closeConnections();
	
	/**
	 * Obtem as configurações para apresentar num ecrã especifico (Não implementado ainda)
	 */
	void getConfigurations();
	
	/**
	 * Salva as configurações que foram alteradas num ecrã especifico (Não implementado ainda)
	 */
	void setConfigurations(BDAConfigs configs);

}
