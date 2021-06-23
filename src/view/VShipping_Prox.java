package view;

import model.MStatus_Type;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;

public class VShipping_Prox extends JPanel{

	/**
	 * serailVersion
	 */
	private static final long serialVersionUID = 1L;
	public JTextField txtEntrega;
	public JTextField txtDate;
	public JTextField txtDistance;
	public JTextField lblCustomerName;
	public JTextField lblCustomerId;

	public JLabel lblID;
	public JLabel lblnID;
	public JLabel lblEntrega;
	public JLabel lblDate;
	public JLabel lblStatusid;
	public JLabel lblCustomerid;
	public JLabel lblDistance;
	public JLabel lblTableShipping;

	public JButton btnPesquisar;

	@SuppressWarnings("rawtypes")
	public JComboBox comboBox ;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public VShipping_Prox() throws ClassNotFoundException, SQLException {
		setLayout(null);
		
		lblID = new JLabel("Id:");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblID.setBounds(10, 72, 36, 14);
		add(lblID);
	
		lblnID = new JLabel("NumID");
		lblnID.setBounds(103, 72, 46, 15);
		lblnID.setText("ID");
		add(lblnID);
		
		lblEntrega = new JLabel("Entrega");
		lblEntrega.setBounds(10, 99, 89, 14);
		add(lblEntrega);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(103, 124, 215, 20);
		add(txtDate);
		
		lblDate = new JLabel("Date");
		lblDate.setBounds(10, 127, 46, 14);
		add(lblDate);
		
		lblStatusid = new JLabel("Status");
		lblStatusid.setBounds(10, 158, 89, 17);
		add(lblStatusid);
		
		lblCustomerid = new JLabel("Customer : ");
		lblCustomerid.setBounds(10, 187, 89, 14);
		add(lblCustomerid);
		
		lblDistance = new JLabel("Distance");
		lblDistance.setBounds(10, 212, 72, 14);
		add(lblDistance);
		
		txtDistance = new JTextField();
		txtDistance.setColumns(10);
		txtDistance.setBounds(103, 210, 215, 20);
		add(txtDistance);
				
		btnPesquisar = new JButton("Recarregar");
		
		
		btnPesquisar.setBounds(10, 30, 308, 23);
		add(btnPesquisar);
		
		txtEntrega = new JTextField();
		txtEntrega.setBounds(103, 96, 215, 20);
		add(txtEntrega);
		txtEntrega.setColumns(10);
		
		lblTableShipping = new JLabel("Table: Shipping Next");
		lblTableShipping.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblTableShipping.setBounds(343, 14, 133, 14);
		add(lblTableShipping);
		
		
		
		MStatus_Type status_type = new MStatus_Type();
		List<String> tmpList1 = status_type.get_shipping_status_type();
		String [] JComboBoxData = tmpList1.toArray(new String[0]);

		comboBox = new JComboBox(JComboBoxData);
		comboBox.setBounds(103, 156, 215, 24);
		add(comboBox);
		
		lblCustomerName = new JTextField("Name Customer");
		lblCustomerName.setBounds(169, 187, 142, 15);
		add(lblCustomerName);
		
		lblCustomerId = new JTextField("Id");
		lblCustomerId.setBounds(103, 187, 54, 15);
		add(lblCustomerId);

		}
}
