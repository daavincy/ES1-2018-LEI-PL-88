package es.projecto.hmi;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import es.projecto.hmi.controlers.ListElements;
import es.projecto.hmi.pojos.BDAConfigs;
import es.projecto.hmi.pojos.NewsHeaders;
import es.projecto.hmi.utils.Constants;

public class ListRender extends ListElements implements ListCellRenderer<NewsHeaders> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3164330303698775211L;

	@Override
	public Component getListCellRendererComponent(JList<? extends NewsHeaders> list, NewsHeaders value, int index,
			boolean isSelected, boolean cellHasFocus) {

		getLblLblcontent().setText(value.getSource());
		getLblPoster().setText(value.getText());
		getLblLbldate().setText(value.getDate().toString());
		
		switch (value.getProvider()) {
		case Constants.TWITTER_ID:
			getLblLogo().setIcon(BDAConfigs.getTwiterLogo(50, 50));
			break;
		default:
			getLblLogo().setIcon(BDAConfigs.getLogoImage(50, 50));
		}
		
//		setIcon((s.length() > 10) ? longIcon : shortIcon);
//		if (isSelected) {
//			setBackground(list.getSelectionBackground());
//			setForeground(list.getSelectionForeground());
//		} else {
//			setBackground(list.getBackground());
//			setForeground(list.getForeground());
//		}
//		setEnabled(list.isEnabled());
//		setFont(list.getFont());
		setOpaque(true);
		return this;
	}
}
