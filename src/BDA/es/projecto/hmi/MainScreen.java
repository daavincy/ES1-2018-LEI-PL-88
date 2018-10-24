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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.NotYetConnectedException;
import java.rmi.UnexpectedException;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import es.projecto.twitter.conection.TwitterMain;

public class MainScreen extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8038602851212296839L;
	
	private static String consumerKey="WwkVm3nKOV5OF7b1iSkLqPE6w";
	private static String consumerSecret="DPKF4GyPbtgB3tO5RdnyOW2Ad03vq1V0fYZxorvTlakj8IjuAF";
	private static String accessToken="1052230420182519808-rDk4irssdofqNhmefXYpfjdwBicl3x";
	private static String accessTokenSecret="hXjYJYu2mGqh21IoxIDxZqupBAr8KW8abeLFBX8oU7MM9";
	
	private JFrame frame;
	private final String[] PROVIDERS =new String[] {"twitter"};

	private JPanel newsList;;

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

		setBounds(100, 100, 1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		newsList = new JPanel();
		JPanel base = new JPanel( new BorderLayout(2, 2));
		JButton all = new JButton("Todos");
		all.addActionListener(e -> {
			((JButton) e.getSource()).disable();
			base.remove(newsList);
			try {
			
				newsList = getNewsList(PROVIDERS);
		
			} catch (Exception e1) {
				newsList=new JPanel();
			}
			base.add(newsList, BorderLayout.CENTER);
			setContentPane(base);
			((JButton) e.getSource()).enable();
			repaint();
		});
		
		JButton twitter = new JButton("Twitter");
		twitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((JButton) e.getSource()).disable();
				base.remove(newsList);
				try {
					newsList = getNewsList(new String[]{"twitter"});

				} catch (Exception e1) {
					newsList = new JPanel();
				}
				base.add(newsList, BorderLayout.CENTER);
				setContentPane(base);
				((JButton) e.getSource()).enable();
				repaint();
			}
		});
		JButton facebook = new JButton("Facebook");
		facebook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((JButton) e.getSource()).disable();
				base.remove(newsList);
				try {
					newsList = getNewsList(new String[]{"facebook"});
				} catch (Exception e1) {
					newsList = new JPanel();
				}
				base.add(newsList, BorderLayout.CENTER);
				setContentPane(base);
				((JButton) e.getSource()).enable();
				repaint();
			}
		});
		
		GridLayout gridlayout = new GridLayout(0, 1, 10, 10);
		JPanel left = new JPanel(gridlayout);
		left.add(all);
		left.add(twitter);
		left.add(facebook);
		
		base.add(left, BorderLayout.WEST);
		
		setContentPane(base);
		repaint();
	}

	
	/**
	 * Metodo para gerar a lista que vai mostrar as publicaçoes as noticias
	 * 
	 * @param providers
	 * @return {@link JPanel} the panel that contains the list of news
	 * @throws UnexpectedException se o provider não tiver sido identificado
	 */
	public JPanel getNewsList(String[] providers) throws UnexpectedException, NotYetConnectedException {
		if(providers==null)return null;
		DefaultListModel<String> list_model = new DefaultListModel<String>();
		for(String provider: providers) {
			switch (provider) {
			case "facebook":
				getFacebookData(list_model);
				break;
			case "twitter":
				getTwitterData(list_model);
				break;
			default:
				throw new UnexpectedException(provider);
			}
			
		}

//		base.setComponentOrientation(FlowLayout);

		

		
		JList<String> news_list = new JList<String>(list_model);
		news_list.setLayoutOrientation(JList.VERTICAL_WRAP);
	

		JScrollPane list_holder = new JScrollPane(news_list);
		
		
		list_holder.getSize().setSize(getWidth(), getHeight());
		

		
		JPanel base = new JPanel();

		base.add(list_holder);
		return base;
	}

	private void getTwitterData(DefaultListModel<String> list_model) {
		TwitterMain main = new TwitterMain(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		main.getStatuses().stream().forEach(t->{
			
			list_model.addElement(  "twitter |" + t.getSource() +"|" + t.getText());
			
		});
	}

	private void getFacebookData(DefaultListModel<String> list_model) {
		throw new NotYetConnectedException();
		// TODO Auto-generated method stub
	}

}
