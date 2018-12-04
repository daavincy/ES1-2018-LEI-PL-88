package es.projecto.hmi.visualeelements;

import java.awt.Component;
import java.text.SimpleDateFormat;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

import es.projecto.hmi.DetailsViewCallback;
import es.projecto.hmi.pojos.BDAConfigs;
import es.projecto.hmi.pojos.NewsHeaders;
import es.projecto.hmi.utils.Constants;

public class ListRender extends ListElements implements ListCellRenderer<NewsHeaders> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3164330303698775211L;

	private DetailsViewCallback callback;

	
	/**
	 * Cria uma nova linha atraves da extensão do layout {@link ListElements}
	 * @param callback é o objecto utilizado para efectuar acções no Interface gráfico
	 */
	public ListRender(DetailsViewCallback callback) {
		this.callback = callback;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.ListCellRenderer#getListCellRendererComponent(JList<? extends NewsHeaders> list, NewsHeaders value, int index, boolean isSelected, boolean cellHasFocus)
	 */
	@Override
	public Component getListCellRendererComponent(JList<? extends NewsHeaders> list, NewsHeaders value, int index,
			boolean isSelected, boolean cellHasFocus) {

		
		getLblLblcontent().setText(value.getText());
		getLblPoster().setText(value.getSource());
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-YYYY HH:mm");
		getLblLbldate().setText(df.format(value.getDate()));

		switch (value.getProvider()) {
		case Constants.TWITTER_ID:
			getLblLogo().setIcon(BDAConfigs.getTwiterLogo(50, 50));
			break;
		default:
			getLblLogo().setIcon(BDAConfigs.getLogoImage(50, 50));
		}

		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
			callback.openDetailsView(value);
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
//			callback.closeDetailsView();
		}

		setEnabled(list.isEnabled());
		setFont(list.getFont());
		setOpaque(true);
		return this;
	}
}