package es.projecto.hmi.visualeelements;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

import es.projecto.config.pojos.BDAConfigs;
import es.projecto.config.pojos.NewsHeaders;
import es.projecto.hmi.interfaces.DetailsViewCallback;
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

//		        SETICON(BDACONFIGS.GETFACEBOOKIMAGE(50, 50));
//		        SYSTEM.OUT.PRINTLN(VALUE.GETSHORTTEXT());
//		        SETTEXT(VALUE.GETSHORTTEXT());
//		        SETFOREGROUND(COLOR.BLACK);
		 
		
		getLblSmallText().setText(value.getShorttext());
		getLblPoster().setText(value.getPoster());
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-YYYY HH:mm");
		getLblLbldate().setText(value.getDate()==null?df.format(new Date()):df.format(value.getDate()));

		switch (value.getProvider()) {
		case Constants.TWITTER_ID:
			getLblLogo().setIcon(BDAConfigs.getTwiterLogo(30, 30));
			break;
		case Constants.FACEBOOK_ID:
			getLblLogo().setIcon(BDAConfigs.getFacebookImage(30, 30));
			break;
		case Constants.EMAIL_ID:
			getLblLogo().setIcon(BDAConfigs.getEmailImage(30, 30));
			break;
		default:
			getLblLogo().setIcon(BDAConfigs.getLogoImage(30, 30));
		}

		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
			callback.openDetailsView(value);
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		setOpaque(true);
		return this;
	}
}
