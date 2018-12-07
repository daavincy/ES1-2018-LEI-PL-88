package es.projecto.hmi.visualeelements;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import es.projecto.config.ConfigCallback;

public class ConfigPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6583760258303213159L;
	
	/**
	 * @param list
	 * @param configCallback 
	 */
	public ConfigPanel(List<String[]> list, ConfigCallback configCallback) {
		
		
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
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.UNRELATED_GAP_ROWSPEC,}));
		
		
	int pos[]=new int[] {2};
	if(list!=null)
		 list.forEach(t->{
				JLabel lblKey = new JLabel(t[0]);
				add(lblKey, "2, " + pos[0] + ", right, default");
				
				JTextField tfvalue;
				tfvalue = new JTextField();
				tfvalue.setText(t[1]);
				add(tfvalue, "4, " + pos[0] + ", fill, default");
				tfvalue.setColumns(10);
				pos[0]+=2;
				
				tfvalue.getDocument().addDocumentListener(new DocumentListener() {
					
					@Override
					public void removeUpdate(DocumentEvent e) {
						configCallback.removeConfigValue(t[0], tfvalue.getText());
						System.out.println("Updated -> " + tfvalue.getText());
					}
					
					@Override
					public void insertUpdate(DocumentEvent e) {
						configCallback.updateConfigValue(t[0], tfvalue.getText());
						System.out.println("Updated -> " + tfvalue.getText());
						
						
					}
					
					@Override
					public void changedUpdate(DocumentEvent e) {
						configCallback.updateConfigValue(t[0], tfvalue.getText());
						System.out.println("Updated -> " + tfvalue.getText());
						
					}
				});
		 });;
	}
	
	

	RowSpec[] calcRowSpecs(int size) {
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
	
}