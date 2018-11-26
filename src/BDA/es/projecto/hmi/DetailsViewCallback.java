package es.projecto.hmi;

import es.projecto.hmi.pojos.NewsHeaders;

public interface DetailsViewCallback {

		void openDetailsView(NewsHeaders item);

		void closeDetailsView();
	
}
