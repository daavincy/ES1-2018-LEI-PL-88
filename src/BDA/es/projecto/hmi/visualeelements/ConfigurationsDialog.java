package es.projecto.hmi.visualeelements;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import es.projecto.config.ConfigCallback;
import es.projecto.config.ConfigHelper;
import es.projecto.config.pojos.BDAConfigs;
import es.projecto.config.pojos.Configurations;


/**
 * Dialogo para a alteração e introdução de configurações
 * 
 * @author Elvino Monteiro(THP)
 *
 */
public class ConfigurationsDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1333379760548603953L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * metodo standalone para editar as configurações
	 */
	public static void main(String[] args) {
		try {
			ConfigurationsDialog dialog = new ConfigurationsDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {

		}
	}

	/**
	 * Cria o dialogo com base nos objectos das configurações
	 */
	public ConfigurationsDialog() {
		setBounds(100, 100, 574, 254);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		final Configurations configs;

		configs = ConfigHelper.getInstance().getConfigurations();

		JTabbedPane tabbedPane = getTabbedPane(configs);

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

	/**
	 * Cria o layout tabulado para as configurações
	 * @param configs para gerar o layout
	 * @return o layout para alterar as configurações
	 */
	JTabbedPane getTabbedPane(final Configurations configs) {
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
						}
						
					}

					@Override
					public void removeConfigValue(String string, String text) {
						try {
							configs.gettwitterConfigs().setFieldValue(string, text);
						} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
								| SecurityException e) {

						}
						
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

						}

					}

					@Override
					public void removeConfigValue(String string, String text) {
						try {
							configs.getfacebookConfigs().setFieldValue(string, text);
						} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
								| SecurityException e) {

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

						}

					}

					@Override
					public void removeConfigValue(String string, String text) {
						try {
							configs.getemailConfigs().setFieldValue(string, text);
						} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
								| SecurityException e) {

						}
						
					}

				}));
		return tabbedPane;
	}
}
