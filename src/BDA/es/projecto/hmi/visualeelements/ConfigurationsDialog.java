package es.projecto.hmi.visualeelements;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import es.projecto.config.ConfigCallback;
import es.projecto.config.ConfigHelper;
import es.projecto.config.pojos.BDAConfigs;
import es.projecto.config.pojos.Configurations;
import es.projecto.hmi.utils.Constants;

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

		String[] twitterlabels = new String[] { "Consumer Key", "Consumer Secret", "Access Token",
				"Access Token Secret" };
		String[] facebooklabels = new String[] { "Access Token", "Client ID", "App ID" };
		String[] emaillabels = new String[] { "User", "Password" };
		final Configurations configs;

			configs = ConfigHelper.getInstance().getConfigurations();


		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setSelectedIndex(-1);
		tabbedPane.addTab("twitter", BDAConfigs.getTwiterLogo(32, 32),
				new ConfigPanel(configs.gettwitterConfigs().getValuesAsList(), new ConfigCallback() {

					@Override
					public void updateConfigValue(String propertyname, String propertyvalue) {
						try {
							configs.gettwitterConfigs().setFieldValue(propertyname, propertyvalue);
						} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
								| SecurityException e) {
							
							e.printStackTrace();
						}
System.err.println(configs);
					}

				}));
		tabbedPane.addTab("facebook", BDAConfigs.getFacebookImage(32, 32),
				new ConfigPanel(configs.getfacebookConfigs().getValuesAsList(), new ConfigCallback() {

					@Override
					public void updateConfigValue(String propertyname, String propertyvalue) {
						try {
							configs.getfacebookConfigs().setFieldValue(propertyname, propertyvalue);
						} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
								| SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}));
		tabbedPane.addTab("email", BDAConfigs.getEmailImage(32, 32),
				new ConfigPanel(configs.getemailConfigs().getValuesAsList(), new ConfigCallback() {

					@Override
					public void updateConfigValue(String propertyname, String propertyvalue) {
						try {
							configs.getemailConfigs().setFieldValue(propertyname, propertyvalue);
						} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
								| SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}));
		
		contentPanel.add(tabbedPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");

				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ConfigHelper.getInstance().saveConfigurations(configs);
						dispose();
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					
				}
			});
			}
		}
	}
}
