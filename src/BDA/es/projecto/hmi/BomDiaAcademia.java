package es.projecto.hmi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import es.projecto.hmi.pojos.BDAConfigs;
import es.projecto.hmi.pojos.NewsHeaders;
import es.projecto.hmi.utils.Constants;

public class BomDiaAcademia {

	JFrame frame;
	private JList<NewsHeaders> newsList;
	private HmiPresenter presenter;

	/**
	 * Create the application.
	 * @param hmiPresenterImpl 
	 */
	public BomDiaAcademia(HmiPresenter hmiPresenterImpl) {
		this.presenter = hmiPresenterImpl;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBounds(new Rectangle(18, 17, 0, 0));
		frame.setBounds(100, 100, 1025, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlMenuHolder = new JPanel();
		frame.getContentPane().add(pnlMenuHolder, BorderLayout.NORTH);
		pnlMenuHolder.setLayout(new BorderLayout(0, 0));

		JPanel pnlMenu = new JPanel();
		pnlMenuHolder.add(pnlMenu, BorderLayout.WEST);
		pnlMenu.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("10px"),
				ColumnSpec.decode("60px"),
				ColumnSpec.decode("10px"),},
			new RowSpec[] {
				RowSpec.decode("10px"),
				RowSpec.decode("70px"),
				RowSpec.decode("10px"),}));
		
		JButton btnMenu = new JButton();
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMenu.setMargin(new Insets(5, 10, 5, 10));
		btnMenu.setPreferredSize(new Dimension(60, 70));

			btnMenu.setIcon(BDAConfigs.getMenuImage(50, 50));

		pnlMenu.add(btnMenu,"2, 2, fill, fill");
		
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setPreferredSize(new Dimension(89, 76));

			lblLogo.setIcon(BDAConfigs.getLogoImage(89, 76));

		pnlMenuHolder.add(lblLogo, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		pnlMenuHolder.add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblBomDiaAcademia = new JLabel("Bom Dia Academia");
		lblBomDiaAcademia.setHorizontalAlignment(SwingConstants.CENTER);
		lblBomDiaAcademia.setHorizontalTextPosition(SwingConstants.CENTER);
		pnlMenuHolder.add(lblBomDiaAcademia, BorderLayout.CENTER);
		
		JPanel divider = new JPanel();
		frame.getContentPane().add(divider, BorderLayout.SOUTH);
		
		JPanel pnlNewsSelect = new JPanel();
		frame.getContentPane().add(pnlNewsSelect, BorderLayout.WEST);
		pnlNewsSelect.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("79px"),},
			new RowSpec[] {
				RowSpec.decode("25px"),
				RowSpec.decode("70px"),
				RowSpec.decode("6px"),
				RowSpec.decode("92px"),
				RowSpec.decode("92px"),
				RowSpec.decode("92px"),
				RowSpec.decode("92px"),
				RowSpec.decode("92px"),}));
		
		JButton btnAll = new JButton("All");
		pnlNewsSelect.add(btnAll, "1, 2, fill, fill");
		
		JButton btnFacebook = new JButton("Facebook");
		btnFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnTwitter = new JButton("Twitter");
		btnTwitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<NewsHeaders> list = presenter.getNewsFeeds(Constants.TWITTER_ID);
			DefaultListModel<NewsHeaders> model = (DefaultListModel<NewsHeaders>) newsList.getModel();
			list.forEach(t->model.addElement(t));
				
				
			}
		});
		pnlNewsSelect.add(btnTwitter, "1, 4, fill, fill");
		pnlNewsSelect.add(btnFacebook, "1, 5, fill, fill");
		
		JButton btnEmail = new JButton("Email");
		pnlNewsSelect.add(btnEmail, "1, 6, fill, fill");
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("25px"),
				RowSpec.decode("fill:default:grow"),}));
		
		JLabel lblNews = new JLabel("News");
		lblNews.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNews.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNews, "1, 1");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, "1, 2, fill, fill");
		
		newsList = new JList<NewsHeaders>(new DefaultListModel<NewsHeaders>());
		newsList.setCellRenderer(new ListRender());
		scrollPane.setViewportView(newsList);
		
		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4, BorderLayout.EAST);
		panel_4.setLayout(new FormLayout(new ColumnSpec[] {},
			new RowSpec[] {}));

	}

}
