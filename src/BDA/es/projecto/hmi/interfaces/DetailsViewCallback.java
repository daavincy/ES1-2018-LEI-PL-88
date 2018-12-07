package es.projecto.hmi.interfaces;

import es.projecto.config.pojos.NewsHeaders;


/**
 * Callback utilizado para quando se seleciona um item da jlist abrir a janela com os detalhes
 * 
 * @author Elvino Monteiro(THP)
 *
 */
public interface DetailsViewCallback {

	/**
	 * Abre uma vista com os detalhes do {@link NewsHeaders} item selecionado
	 * @param item com os valores para preencher o painel de detalhes
	 */
		void openDetailsView(NewsHeaders item);
	
}
