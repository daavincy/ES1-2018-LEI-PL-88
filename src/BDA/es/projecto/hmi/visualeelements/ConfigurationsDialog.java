package es.projecto.hmi.visualeelements;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.projecto.common.ConfigHelper;
import es.projecto.hmi.pojos.BDAConfigs;
import es.projecto.hmi.utils.Constants;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;

public class ConfigurationsDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1333379760548603953L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfigurationsDialog dialog = new ConfigurationsDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurationsDialog() {
		setBounds(100, 100, 574, 254);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		String[] twitterlabels = new String[]{"Consumer Key","Consumer Secret","Access Token","Access Token Secret"};
		
		String[] facebooklabels = new String[]{"Consumer Key","Consumer Secret","Access Token"};
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setSelectedIndex(-1);
		tabbedPane.addTab("twitter", BDAConfigs.getTwiterLogo(32, 32), new TwitterConfigPanel(Arrays.asList(twitterlabels)));
		tabbedPane.addTab("facebook", BDAConfigs.getFacebookImage(32, 32), new TwitterConfigPanel(Arrays.asList(facebooklabels)));
		tabbedPane.addTab("email", BDAConfigs.getEmailImage(32, 32), new JPanel());
		contentPanel.add(tabbedPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
