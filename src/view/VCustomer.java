package view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

//@TODO Move methods for model, on this class only View components and events
public class VCustomer extends JPanel {

	/**
	 *  Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Window Creation
	 */
	public JTextField txtBusca;
	public JTextField txtNome;

	public JButton btnPesquisar;
	public JButton btnCadastrar;
	public JButton btnEditar;
	public JButton btnExcluir;

	public JLabel lblcontato;
	public JLabel lblID;
	public JLabel lblnID;
	public JLabel lblNome;

	public VCustomer() {
		setLayout(null);

		lblcontato = new JLabel("Table: Customer");
		lblcontato.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblcontato.setBounds(171, 15, 133, 14);
		add(lblcontato);
		
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
		
		txtNome = new JTextField();
		txtNome.setBounds(66, 96, 358, 20);
		add(txtNome);
		txtNome.setColumns(10);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 99, 46, 14);
		add(lblNome);
				
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(314, 39, 110, 23);
		add(btnPesquisar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(10, 227, 89, 30);
		add(btnCadastrar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(335, 227, 89, 30);
		add(btnEditar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(175, 227, 89, 30);
		add(btnExcluir);
		
		
	}
}