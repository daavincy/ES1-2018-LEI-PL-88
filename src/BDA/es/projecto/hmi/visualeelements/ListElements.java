package es.projecto.hmi.visualeelements;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

public class ListElements extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 855210785169801153L;
	private JLabel lblLogo;
	private JLabel lblPoster;
	private JLabel lblSmallText;
	private JLabel lblDate;


	/**
	 * Create the panel.
	 */
	public ListElements() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("60px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("190px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("70dlu"),
				FormSpecs.UNRELATED_GAP_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("3px"),
				RowSpec.decode("40px"),
				RowSpec.decode("3px"),}));
		
		lblLogo = new JLabel("");
		add(lblLogo, "2, 2, center, center");
		
		lblPoster = new JLabel("lblPoster");
		lblPoster.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPoster, "4, 2, left, center");
		
		lblSmallText = new JLabel("lblSmallText");
		lblSmallText.setHorizontalTextPosition(SwingConstants.LEFT);
		lblSmallText.setVerticalTextPosition(SwingConstants.TOP);
		lblSmallText.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblSmallText, "6, 2, left, default");
		
		lblDate = new JLabel("lblDate");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDate, "8, 2, default, center");

	}

	/**
	 * @return the lblLogo
	 */
	public JLabel getLblLogo() {
		return lblLogo;
	}

	/**
	 * @return the lblPoster
	 */
	public JLabel getLblPoster() {
		return lblPoster;
	}

	/**
	 * @return the lblLblcontent
	 */
	public JLabel getLblSmallText() {
		return lblSmallText;
	}

	/**
	 * @return the lblLbldate
	 */
	public JLabel getLblLbldate() {
		return lblDate;
	}

}
