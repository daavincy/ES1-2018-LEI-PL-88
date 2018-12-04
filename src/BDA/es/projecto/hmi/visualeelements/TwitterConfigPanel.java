package es.projecto.hmi.visualeelements;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;

public class TwitterConfigPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6583760258303213159L;
	
	/**
	 * @param headers
	 */
	public TwitterConfigPanel(List<String> headers) {
		
		
//		RowSpec[] rowspecs = calcRowSpecs(headers.size());
//		
//		
//		FormLayout layout = new FormLayout(new ColumnSpec[] {
//			FormSpecs.UNRELATED_GAP_COLSPEC,
//			ColumnSpec.decode("max(72dlu;default)"),
//			FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
//			ColumnSpec.decode("max(207dlu;default):grow"),},
//				rowspecs);
		
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(72dlu;default)"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("max(207dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.UNRELATED_GAP_ROWSPEC,}));
		
		
	int pos[]=new int[] {2};
		 headers.forEach(t->{
				JLabel lblConsumerKey = new JLabel(t);
				add(lblConsumerKey, "2, " + pos[0] + ", right, default");
				
				tfConsumerKey = new JTextField();
				add(tfConsumerKey, "4, " + pos[0] + ", fill, default");
				tfConsumerKey.setColumns(10);
				pos[0]+=2;
		 });;
	}
	
	

	private RowSpec[] calcRowSpecs(int size) {
		RowSpec[] output = new RowSpec[(size*2)+2];
		output[0] = FormSpecs.UNRELATED_GAP_ROWSPEC;
		int j = 1;
		for (int i =0; i< size;i++) {
			output[j] = FormSpecs.PREF_ROWSPEC;
			j++;
			output[j] = FormSpecs.RELATED_GAP_ROWSPEC;
			j++;
			
		}
		output[j] = FormSpecs.UNRELATED_GAP_ROWSPEC;
		return output;
	}
	




	private JTextField tfConsumerKey;
	private JTextField tfConsumerSecret;
	private JTextField tfAccessToken;
	private JTextField tfAccessTokenSecret;

	/**
	 * Create the panel.
	 */
	public TwitterConfigPanel() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(72dlu;default)"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("max(207dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.UNRELATED_GAP_ROWSPEC,}));
		
		JLabel lblConsumerKey = new JLabel("Consumer Key");
		add(lblConsumerKey, "2, 2, right, default");
		
		tfConsumerKey = new JTextField();
		add(tfConsumerKey, "4, 2, fill, default");
		tfConsumerKey.setColumns(10);
		
		JLabel lblConsumerSecret = new JLabel("Consumer Secret");
		add(lblConsumerSecret, "2, 4, right, default");
		
		tfConsumerSecret = new JTextField();
		add(tfConsumerSecret, "4, 4, fill, default");
		tfConsumerSecret.setColumns(10);
		
		JLabel lblAccessToken = new JLabel("Access Token");
		add(lblAccessToken, "2, 6, right, default");
		
		tfAccessToken = new JTextField();
		add(tfAccessToken, "4, 6, fill, default");
		tfAccessToken.setColumns(10);
		
		JLabel lblAccessTokenSecret = new JLabel("Access Token Secret");
		add(lblAccessTokenSecret, "2, 8, right, default");
		
		tfAccessTokenSecret = new JTextField();
		add(tfAccessTokenSecret, "4, 8, fill, default");
		tfAccessTokenSecret.setColumns(10);

	}
}
