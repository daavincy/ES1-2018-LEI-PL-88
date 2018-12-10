package es.projecto.hmi.visualeelements;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import es.projecto.hmi.interfaces.InteractionCallback;

public class EmailReplyDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2568633184547147944L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private InteractionCallback callback;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EmailReplyDialog dialog = new EmailReplyDialog("this is a test email", null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EmailReplyDialog(String to, InteractionCallback callback) {

		this.callback = callback;
		initialize(to);
	}

	/**
	 * 
	 */
	void initialize(String to) {
		setTitle("Enviar mesnsagem");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPanel.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		JLabel lblTo = new JLabel("to:");
		JTextArea taEmailMessage = new JTextArea();
		JPanel buttonPane = new JPanel();
		JButton okButton = new JButton("OK");
		JButton cancelButton = new JButton("Cancelar");
		
		flowLayout.setAlignment(FlowLayout.LEFT);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

		textField = new JTextField();
		textField.setEditable(false);
		textField.setText(to);
		textField.setMinimumSize(new Dimension(200, 20));
		textField.setPreferredSize(new Dimension(200, 20));
		textField.setColumns(49);
		taEmailMessage.setLineWrap(true);
		
		okButton.setActionCommand("OK");
		cancelButton.setActionCommand("Cancel");
		
		panel.add(lblTo);
		panel.add(textField);
		contentPanel.add(taEmailMessage, BorderLayout.CENTER);
		contentPanel.add(panel, BorderLayout.NORTH);
		buttonPane.add(okButton);
		buttonPane.add(cancelButton);
		getRootPane().setDefaultButton(okButton);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		//Setting the action listeners
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (callback != null)
					callback.interact(taEmailMessage.getText());
				dispose();
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
