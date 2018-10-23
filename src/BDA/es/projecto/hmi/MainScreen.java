package es.projecto.hmi;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainScreen extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8038602851212296839L;
	
	private JFrame frame;
	private final String[] PROVIDERS =new String[] {"facebook","twitter"};;
	private DefaultListModel<String> list_model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScreen() {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel newsList =	getNewsList(PROVIDERS);
		JPanel base = new JPanel( new BorderLayout(2, 2));
		base.add(newsList, BorderLayout.WEST);
		
		setContentPane(base);
		repaint();
	}

	
	
	public JPanel getNewsList(String[] providers) {
		if(providers==null)return null;
		
	

//		base.setComponentOrientation(FlowLayout);
		
		list_model = new DefaultListModel<String>();
		JList<String> news_list = new JList<String>(list_model);
		news_list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list_model.addElement("bananas");
		list_model.addElement("teste");
		JScrollPane list_holder = new JScrollPane(news_list);
		list_holder.getSize().setSize(getWidth(), getHeight());
		
		JPanel base = new JPanel();
		base.add(new JLabel("banana_news"));
		base.add(list_holder);
		return base;
	}

}
