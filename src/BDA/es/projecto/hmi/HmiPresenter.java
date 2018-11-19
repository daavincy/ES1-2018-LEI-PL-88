package es.projecto.hmi;

import java.util.List;

import es.projecto.hmi.pojos.BDAConfigs;
import es.projecto.hmi.pojos.NewsHeaders;

public interface HmiPresenter {
	List<NewsHeaders> getNewsFeeds();
	List<NewsHeaders> getNewsFeeds(int provider);
	void closeConnections();
	void getConfigurations();
	void setConfigurations(BDAConfigs configs);

}
