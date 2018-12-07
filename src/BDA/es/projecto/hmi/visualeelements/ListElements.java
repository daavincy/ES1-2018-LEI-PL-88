package es.projecto.hmi.visualeelements;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

/**
 * Classe criada com auxilio à representação de noticias em lista
 * @author Elvino Monteiro(THP)
 *
 */
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
	 * Cria o painel para mostrar cada linha de noticias
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
		lblSmallText.setVerticalTextPosition(SwingConstants.CENTER);
		lblSmallText.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblSmallText, "6, 2, left, center");
		
		lblDate = new JLabel("lblDate");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDate, "8, 2, default, center");

	}

	/**
	 * @return a etiqueta do logo para ser preenchida
	 */
	public JLabel getLblLogo() {
		return lblLogo;
	}

	/**
	 * @return a etiqueta da origem para ser preenchida
	 */
	public JLabel getLblPoster() {
		return lblPoster;
	}

	/**
	 * @return a etiqueta do assunto para ser preenchida
	 */
	public JLabel getLblSmallText() {
		return lblSmallText;
	}

	/**
	 * @return a etiqueta da data para ser preenchida
	 */
	public JLabel getLblLbldate() {
		return lblDate;
	}

}
