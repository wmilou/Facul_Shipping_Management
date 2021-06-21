package controller;
import view.VCustomer;
import view.MainWindow;
import model.MCustomer;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.HeadlessException;


public class CCustomer{
	
	public void manage_Events(MainWindow main_window) {
		MCustomer model_customer = new MCustomer();
		VCustomer view_customer = main_window.get_view_customer();

		// Add All Events on this Controller
		
		// Add Event to Search on Customer by Name
		view_customer.btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (view_customer.txtBusca.getText().length() > 0) {
					List<String> resultado = null;
					try {
						resultado = model_customer.get_customers_by_name(view_customer.txtBusca.getText().trim());
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (resultado != null) {
						view_customer.lblnID.setText (resultado.get(0));
						view_customer.txtNome.setText(resultado.get(1));
			
					}else {
						JOptionPane.showMessageDialog(view_customer.btnPesquisar, "Nenhum nome inicia com " + 
						view_customer.txtBusca.getText()+" em sua agenda!");
						
					}
				} else {
					JOptionPane.showMessageDialog(view_customer.btnPesquisar, "Informe o in�cio do nome a ser buscado.");
					
				}
			}
		});

		// Add Events to Add User
		view_customer.btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed (ActionEvent e) {
					String nome = view_customer.txtNome.getText();
					
					boolean resultado = false;
					try {
						resultado = model_customer.add_customer(nome);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					System.out.println("Resultado: "+ resultado);
					if (resultado == true) {
						JOptionPane.showMessageDialog(view_customer.btnCadastrar, "O registro do contato " + nome + " foi salvo com sucesso!");
					}else {
						JOptionPane.showMessageDialog(view_customer.btnCadastrar, "Ocorreram problemas ao salvar o registro");
					}
				}
			});
		
		// Add Event to Edit Customer
		view_customer.btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirma = JOptionPane.showConfirmDialog(view_customer.btnEditar, "Deseja editar " + " o registro " + view_customer.txtNome.getText() + "?");
				
				if (confirma==JOptionPane.YES_OPTION) {
					try {
						if (model_customer.set_customer_name(Integer.parseInt(view_customer.lblnID.getText()),view_customer.txtNome.getText())) {
							JOptionPane.showMessageDialog(view_customer.btnEditar, "Registro editado com sucesso!");
										
						}else {
							JOptionPane.showMessageDialog(view_customer.btnEditar, "Problemas ao editar o registro");
						}
					} catch (NumberFormatException | HeadlessException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if (confirma==JOptionPane.NO_OPTION || confirma==JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(view_customer.btnEditar, "Registro n�o editado");
				}
			}
		});
		
		//Add Event to Delete Customer
		view_customer.btnExcluir.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				
				int confirma = JOptionPane.showConfirmDialog(view_customer.btnExcluir, "Deseja realmente" + 
				"excluir o registro " + view_customer.txtNome.getText()+"?");
				
				if (confirma==JOptionPane.YES_OPTION) {
					try {
						if(model_customer.delete_customer(Integer.parseInt(view_customer.lblnID.getText()))) {
							JOptionPane.showMessageDialog(view_customer.btnExcluir, "Exclu�do com sucesso!");
						}else {
							JOptionPane.showMessageDialog(view_customer.btnExcluir, "Problemas ao excluir");
						}
					} catch (NumberFormatException | HeadlessException | ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}else if (confirma==JOptionPane.NO_OPTION || confirma==JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(view_customer.btnExcluir, "Registro n�o exclu�do");
				}
			}
		});
		
		
	}


}
