package es.projecto.hmi;

import javax.swing.JPanel;

import java.util.Arrays;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import es.projecto.hmi.pojos.BDAConfigs;
import es.projecto.hmi.pojos.NewsHeaders;

import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;

import javax.swing.Box;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class NewsDetails extends JPanel {

	public NewsDetails() {
		super();
		setBorder(new EmptyBorder(0, 5, 0, 5));
		setPreferredSize(new Dimension(300, 530));

		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDetalhes = new JLabel("Detalhes");
		lblDetalhes.setPreferredSize(new Dimension(50, 25));
		lblDetalhes.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetalhes.setBounds(0, 0, 300, 42);
		panel.add(lblDetalhes, BorderLayout.NORTH);
		
		JSeparator separator = new JSeparator();
		panel.add(separator, BorderLayout.CENTER);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(0, 10));
		panel.add(verticalStrut, BorderLayout.WEST);
		
		lblSource = new JLabel("New label");
		lblSource.setForeground(Color.BLACK);
		lblSource.setBackground(Color.WHITE);
		panel.add(lblSource, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton, BorderLayout.WEST);
		
		JButton btnNewButton_1 = new JButton("Interact");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(btnNewButton_1, BorderLayout.EAST);
		
		lblDate = new JLabel("lbl<date");
		lblDate.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(lblDate, BorderLayout.NORTH);
		lblContent = new JTextArea();
		lblContent.setLineWrap(true);
		lblContent.setEditable(false);
		add(lblContent, BorderLayout.CENTER);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6607733022346261687L;
	private JLabel lblSource;
	private JLabel lblDate;
	private JTextArea lblContent;


	public void setSource(String source) {
		lblSource.setText(source);
		
	}
	public JLabel getSource() {
		return lblSource;
	}
	public JLabel getDate() {
		return lblDate;
	}

	public void setText(String text) {
		lblContent.setText(text);
		
	}

	public void setDate(Date date) {

SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:MM");
lblDate.setText(df.format(date));
		
	}
}
