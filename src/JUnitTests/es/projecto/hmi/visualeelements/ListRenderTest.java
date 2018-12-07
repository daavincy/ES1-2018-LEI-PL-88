package es.projecto.hmi.visualeelements;


import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import org.junit.jupiter.api.Test;

import es.projecto.config.pojos.NewsHeaders;
import es.projecto.hmi.interfaces.DetailsViewCallback;

public class ListRenderTest {

	@Test
	public void testGetListCellRendererComponent() throws Exception {
		ListRender testobj = new ListRender(new DetailsViewCallback() {
			
			@Override
			public void openDetailsView(NewsHeaders item) {
				
			}
		});
		NewsHeaders element = new NewsHeaders(1L, 0, "shorttext", "text", "poster", new Date());
		JList<NewsHeaders> jl = new JList<>(new DefaultListModel<>());
		((DefaultListModel<NewsHeaders>)jl.getModel()).addElement(element);
		
		testobj.getListCellRendererComponent(jl, new NewsHeaders(1L, 0, "shorttext", "text", "poster", new Date()), 1, true, true);
		
	}

}
