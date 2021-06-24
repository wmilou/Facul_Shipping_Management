package view;

/* Nomes Alunos
 *  Vinicius Oliveira     RA: 72507
 *  Wedlsey Milouchine    RA: 73183
 */

import java.awt.BorderLayout;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame{
	/**
	 * 
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	
	//Views Objects
	public VCustomer view_customer;
	public VStatus_Type view_status_type;
	public VShipping view_shipping;
	public VShipping_Prox view_shipping_prox;


	private JPanel contentPane;
	// Create Main Window with TabbedPanes
	public MainWindow() throws ClassNotFoundException, SQLException {
		setTitle("shipping_management");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		view_customer = new VCustomer();
		tabbedPane.addTab("Manager User", view_customer);
		view_status_type = new VStatus_Type();
		tabbedPane.addTab("Manager Status", view_status_type);
		view_shipping = new VShipping();
		tabbedPane.addTab("Manager Shipping", view_shipping);
		view_shipping_prox = new VShipping_Prox();
		tabbedPane.addTab("Next Shipping", view_shipping_prox);
		
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	public VCustomer get_view_customer () {
		return this.view_customer;
	}

	public VStatus_Type get_view_status_type () {
		return this.view_status_type;
	}

	public VShipping get_view_shipping () {
		return this.view_shipping;
	}

	public VShipping_Prox get_view_shipping_prox () {
		return this.view_shipping_prox;
	}

}

