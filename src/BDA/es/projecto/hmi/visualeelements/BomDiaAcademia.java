package es.projecto.hmi.visualeelements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import es.projecto.config.pojos.BDAConfigs;
import es.projecto.config.pojos.NewsHeaders;
import es.projecto.hmi.interfaces.DetailsViewCallback;
import es.projecto.hmi.interfaces.HmiPresenter;
import es.projecto.hmi.utils.Constants;

/**
 * Classe responsavel pelo desenho da Janela
 * 
 * @author Elvino Monteiro
 *
 */
public class BomDiaAcademia {

	public JFrame frame;

	private HmiPresenter presenter;

	/**
	 * Cria o ecrã inicial da aplicação
	 * 
	 * @param hmiPresenter é usado para obter os dados
	 */
	public BomDiaAcademia(HmiPresenter hmiPresenter) {
		this.presenter = hmiPresenter;
		initialize();
	}

	/**
	 * Cra o layout da aplicação
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBounds(new Rectangle(18, 17, 0, 0));
		frame.setBounds(100, 100, 1025, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// definition of panels
		JPanel pnlMenuHolder = new JPanel();
		JPanel pnlMenu = new JPanel();
		JPanel pnlMenuDevider = new JPanel();
		JPanel pnlFrameDivider = new JPanel();
		JPanel pnlNewsSelect = new JPanel();
		JPanel pnlNewsList = new JPanel();
		JPanel pnlDetails = new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		NewsDetails detailsView;

		// Attribution of layouts
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		pnlMenu.setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("10px"), ColumnSpec.decode("60px"), ColumnSpec.decode("10px"), },
				new RowSpec[] { RowSpec.decode("10px"), RowSpec.decode("70px"), RowSpec.decode("10px"), }));
		pnlMenuHolder.setLayout(new BorderLayout(0, 0));
		pnlNewsSelect.setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec.decode("79px"), },
				new RowSpec[] { RowSpec.decode("25px"), RowSpec.decode("70px"), RowSpec.decode("6px"),
						RowSpec.decode("92px"), RowSpec.decode("92px"), RowSpec.decode("92px"), RowSpec.decode("92px"),
						RowSpec.decode("92px"), }));
		pnlNewsList.setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec.decode("default:grow"), },
				new RowSpec[] { RowSpec.decode("25px"), RowSpec.decode("fill:default:grow"), }));
		pnlDetails.setLayout(new BorderLayout(0, 0));

		// Creating the objects
		JButton btnMenu = new JButton();
		btnMenu.setForeground(Color.CYAN);
		JLabel lblLogo = new JLabel("");
		JLabel lblBomDiaAcademia = new JLabel("Bom Dia Academia");
		JButton btnAll = new JButton("All");
		JButton btnFacebook = new JButton("Facebook");
		JButton btnTwitter = new JButton("Twitter");
		JButton btnEmail = new JButton("Email");
		JList<NewsHeaders> newsList = new JList<NewsHeaders>(new DefaultListModel<NewsHeaders>());
		newsList.setVisibleRowCount(4);
		newsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JLabel lblNews = new JLabel("News");
		detailsView = new NewsDetails();

		// Setting element properties
		btnMenu.setMargin(new Insets(5, 10, 5, 10));
		btnMenu.setPreferredSize(new Dimension(60, 70));
		btnMenu.setIcon(BDAConfigs.getMenuImage(50, 50));
		lblLogo.setPreferredSize(new Dimension(89, 76));
		lblLogo.setIcon(BDAConfigs.getLogoImage(89, 76));
		lblBomDiaAcademia.setHorizontalAlignment(SwingConstants.CENTER);
		lblBomDiaAcademia.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNews.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNews.setHorizontalAlignment(SwingConstants.CENTER);
		pnlDetails.setPreferredSize(new Dimension(0, 0));
		newsList.setCellRenderer(new ListRender(new DetailsViewCallback() {

			@Override
			public void openDetailsView(NewsHeaders item) {

				pnlDetails.setPreferredSize(new Dimension(300, pnlNewsSelect.getHeight()));
				detailsView.setSize(new Dimension(300, pnlNewsSelect.getHeight()));
				detailsView.setSource(item.getPoster());
				detailsView.setText(item.getText());
				detailsView.setDate(item.getDate());
				newsList.revalidate();
				pnlDetails.revalidate();
			}

		}));
		scrollPane.setViewportView(newsList);

		// Adding elements to the panels
		pnlMenu.add(btnMenu, "2, 2, fill, fill");
		pnlMenuHolder.add(pnlMenu, BorderLayout.WEST);
		pnlMenuHolder.add(lblLogo, BorderLayout.EAST);
		pnlMenuHolder.add(lblBomDiaAcademia, BorderLayout.CENTER);
		pnlMenuHolder.add(pnlMenuDevider, BorderLayout.SOUTH);
		pnlNewsSelect.add(btnAll, "1, 2, fill, fill");
		pnlNewsSelect.add(btnTwitter, "1, 4, fill, fill");
		pnlNewsSelect.add(btnFacebook, "1, 5, fill, fill");
		pnlNewsSelect.add(btnEmail, "1, 6, fill, fill");
		pnlNewsList.add(lblNews, "1, 1");
		pnlNewsList.add(scrollPane, "1, 2, fill, fill");
		pnlDetails.add(detailsView, BorderLayout.NORTH);

		frame.getContentPane().add(pnlMenuHolder, BorderLayout.NORTH);
		frame.getContentPane().add(pnlFrameDivider, BorderLayout.SOUTH);
		frame.getContentPane().add(pnlNewsSelect, BorderLayout.WEST);
		frame.getContentPane().add(pnlNewsList, BorderLayout.CENTER);
		frame.getContentPane().add(pnlDetails, BorderLayout.EAST);
	
		// Attributing listeners
		btnTwitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateNewsList(newsList, Constants.TWITTER_ID);
			}
		});

		btnFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateNewsList(newsList, Constants.FACEBOOK_ID);
			}
		});

		btnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateNewsList(newsList, Constants.EMAIL_ID);
			}
		});
		
		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateNewsList(newsList);
			}
		});
		
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationsDialog dialog = new ConfigurationsDialog();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});

	}

	/**
	 * Preenche a lista com as noticias obtidas dos serviços integrados
	 * 
	 * @param newsList lista de noticias para se colocado na jlist do GUI
	 */
	protected void populateNewsList(JList<NewsHeaders> newsList) {	
		List<NewsHeaders> list = presenter.getNewsFeeds();
		DefaultListModel<NewsHeaders> model = (DefaultListModel<NewsHeaders>) newsList.getModel();
		model.removeAllElements();
		list.forEach(t -> model.addElement(t));

	}
	
	/**
	 * Preenche a lista com as noticias obtidas do serviço passado como argumento
	 * 
	 * @param newsList lista de noticias para se colocado na jlist do GUI
	 * @param provider id do provider, constante estatica da classe {@link Constants}
	 *
	 */
	protected void populateNewsList(JList<NewsHeaders> newsList, int provider) {
		List<NewsHeaders> list = presenter.getNewsFeeds(provider);
		DefaultListModel<NewsHeaders> model = (DefaultListModel<NewsHeaders>) newsList.getModel();
		model.removeAllElements();
		list.forEach(t -> model.addElement(t));
		frame.repaint();
	}

}
