package es.projecto.hmi.visualeelements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import es.projecto.hmi.interfaces.InteractionCallback;

public class NewsDetails extends JPanel {
	private InteractionCallback callback;

	public NewsDetails() {
		super();
		setBorder(new EmptyBorder(0, 5, 0, 5));
		setPreferredSize(new Dimension(391, 530));
		setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("1dlu"), ColumnSpec.decode("max(200dlu;min):grow"),
						ColumnSpec.decode("1dlu"), },
				new RowSpec[] { RowSpec.decode("28px"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("20px"),
						FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("max(400px;min):grow"),
						FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("27dlu"), }));

		JPanel panel = new JPanel();
		panel.setBorder(null);
		add(panel, "2, 1, fill, top");
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblDetalhes = new JLabel("Detalhes");
		lblDetalhes.setBorder(null);
		lblDetalhes.setPreferredSize(new Dimension(50, 25));
		lblDetalhes.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetalhes.setBounds(0, 0, 300, 42);
		panel.add(lblDetalhes, BorderLayout.NORTH);

		JSeparator separator = new JSeparator();
		panel.add(separator, BorderLayout.CENTER);

		lblSource = new JLabel("New label");
		add(lblSource, "2, 3");
		lblSource.setForeground(Color.BLACK);
		lblSource.setBackground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "2, 5, fill, fill");

		lblContent = new JTextArea();
		lblContent.setLineWrap(true);
		lblContent.setEditable(false);
		scrollPane.setViewportView(lblContent);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		add(panel_1, "2, 7, fill, bottom");
		panel_1.setLayout(new BorderLayout(0, 0));

		JButton btnInteract = new JButton("Interact");
		btnInteract.setHorizontalAlignment(SwingConstants.RIGHT);
		btnInteract.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				callback.interact("");
				
			}
		});
		panel_1.add(btnInteract, BorderLayout.EAST);

		lblDate = new JLabel("lbl<date");
		lblDate.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(lblDate, BorderLayout.WEST);
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
		if (source == null || source.contains("...")) {
			lblDate.setText("");
			return;
		}

		lblSource.setText(source);

	}

	public JLabel getSource() {
		return lblSource;
	}

	public JLabel getDate() {
		return lblDate;
	}

	public void setText(String text) {
		if (text == null) {
			lblDate.setText("NA");
			return;
		}
		lblContent.setText(text);

	}

	public void setDate(Date date) {
		if (date == null) {
			lblDate.setText("NA");
			return;
		}
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:MM");
		lblDate.setText(df.format(date));

	}

	public InteractionCallback getCallback() {
		return callback;
	}

	public void setCallback(InteractionCallback callback) {
		this.callback = callback;
	}
}
