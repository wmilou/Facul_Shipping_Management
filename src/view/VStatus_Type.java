package view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class VStatus_Type extends JPanel{
	/**
	 *  Serial Version Id
	 */
	private static final long serialVersionUID = 1L;

	public JTextField txtBusca;
	public JTextField txtDescription;

	public JLabel lblID;
	public JLabel lblnID;
	public JLabel lblDescription;
	public JLabel lblTableStatus;

	public JButton btnPesquisar;

	public VStatus_Type() {
		setLayout(null);
		
		txtBusca = new JTextField();
		txtBusca.setBounds(10, 40, 294, 20);
		add(txtBusca);
		txtBusca.setColumns(10);
		
		lblID = new JLabel("Id:");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblID.setBounds(20, 71, 36, 14);
		add(lblID);
	
		lblnID = new JLabel("NumID");
		lblnID.setBounds(53, 71, 46, 14);
		lblnID.setText("ID");
		add(lblnID);
		
		
		lblDescription = new JLabel("Description_Type");
		lblDescription.setBounds(10, 99, 120, 14);
		add(lblDescription);
				
        btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(314, 39, 110, 23);
		add(btnPesquisar);
		
		txtDescription = new JTextField();
		txtDescription.setBounds(140, 96, 284, 20);
		add(txtDescription);
		txtDescription.setColumns(10);
		
		lblTableStatus = new JLabel("Table: Status");
		lblTableStatus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblTableStatus.setBounds(171, 11, 133, 14);
		add(lblTableStatus);
		
		}
			

		
}
