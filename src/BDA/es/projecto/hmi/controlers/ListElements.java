package es.projecto.hmi.controlers;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class ListElements extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 855210785169801153L;
	private JLabel lblLogo;
	private JLabel lblPoster;
	private JLabel lblLblcontent;
	private JLabel lblLbldate;
	private JSeparator separator;

	/**
	 * Create the panel.
	 */
	public ListElements() {
		setLayout(new BorderLayout(0,0));
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("60px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("min:grow"),
				ColumnSpec.decode("70dlu"),},
			new RowSpec[] {
				RowSpec.decode("3px"),
				RowSpec.decode("40px"),
				RowSpec.decode("3px"),}));
		
		lblLogo = new JLabel("");
		add(lblLogo, "1, 2, left, fill");
		
		lblPoster = new JLabel("New label");
		lblPoster.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPoster, "2, 2, fill, fill");
		
		lblLblcontent = new JLabel("lblContent");
		lblLblcontent.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblLblcontent, "3, 2");
		
		lblLbldate = new JLabel("lblDate");
		lblLbldate.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblLbldate, "4, 2");

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
	public JLabel getLblLblcontent() {
		return lblLblcontent;
	}

	/**
	 * @return the lblLbldate
	 */
	public JLabel getLblLbldate() {
		return lblLbldate;
	}

}
