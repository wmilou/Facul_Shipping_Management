package controller;

import model.MShipping;
import view.MainWindow;
import view.VShipping;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.HeadlessException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CShipping {
	
	public void manage_Events(MainWindow main_window) {
	MShipping model_shipping = new MShipping();
	VShipping view_shipping = main_window.get_view_shipping();
	
	// Add Event to click on list and load item 
	view_shipping.Llist.addListSelectionListener(new ListSelectionListener() {

        @Override
        public void valueChanged(ListSelectionEvent arg0) {
            if (!arg0.getValueIsAdjusting()) {
            	System.out.println(view_shipping.Llist.getSelectedIndex());
				List<String> resultado = null;
				try {
					resultado = model_shipping.get_shipping_by_id(Integer.toString(view_shipping.Llist.getSelectedIndex()+1));
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (resultado != null) {
					view_shipping.lblnID.setText (resultado.get(0));
					view_shipping.txtEntrega.setText(resultado.get(1));
					view_shipping.txtDate.setText(resultado.get(2));
					view_shipping.comboBox.setSelectedIndex(Integer.parseInt(resultado.get(3))-1);
					view_shipping.lblCustomerId.setText(resultado.get(4));
					view_shipping.txtDistance.setText(resultado.get(5));
					view_shipping.lblCustomerName.setText(resultado.get(6));
		
				}
            }
        }
    });

	// Add Event to get Shipping by id
	view_shipping.btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (view_shipping.txtBusca.getText().length() > 0) {
					List<String> resultado = null;
					try {
						resultado = model_shipping.get_shipping_by_id(view_shipping.txtBusca.getText().trim());
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (resultado != null) {
						view_shipping.lblnID.setText (resultado.get(0));
						view_shipping.txtEntrega.setText(resultado.get(1));
						view_shipping.txtDate.setText(resultado.get(2));
						view_shipping.comboBox.setSelectedIndex(Integer.parseInt(resultado.get(3))-1);
						view_shipping.lblCustomerId.setText(resultado.get(4));
						view_shipping.txtDistance.setText(resultado.get(5));
						view_shipping.lblCustomerName.setText(resultado.get(6));
			
					}else {
						JOptionPane.showMessageDialog(view_shipping.btnPesquisar, "Nenhum item inicia com " + 

						view_shipping.txtBusca.getText()+" em sua agenda!");
						view_shipping.txtEntrega.setText("");
					}
				} else {
					JOptionPane.showMessageDialog(view_shipping.btnPesquisar, "Informe o ID a ser buscado.");
					view_shipping.txtEntrega.setText("");
				}
			
			}
		});
		
		// Add Event to Delete Shipping
		view_shipping.btnExcluir.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				
				int confirma = JOptionPane.showConfirmDialog(view_shipping.btnExcluir, "Deseja realmente" + 
				"excluir o registro " + view_shipping.txtEntrega.getText()+"?");
				
				if (confirma==JOptionPane.YES_OPTION) {
					try {
						if(model_shipping.delete_shipping(view_shipping.lblnID.getText())) {
							JOptionPane.showMessageDialog(view_shipping.btnExcluir, "Exclu�do com sucesso!");
							view_shipping.txtEntrega.setText("");
						}else {
							JOptionPane.showMessageDialog(view_shipping.btnExcluir, "Problemas ao excluir");
						}
					} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if (confirma==JOptionPane.NO_OPTION || confirma==JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(view_shipping.btnExcluir, "Registro n�o exclu�do");
				}
			}
		});
			
		// add Event to add new Shipping
		view_shipping.btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				String nome = view_shipping.txtEntrega.getText();
				boolean resultado = false;
				try {
					resultado = model_shipping.add_shipping(view_shipping.txtEntrega.getText(), Integer.toString(view_shipping.comboBox.getSelectedIndex()+1), view_shipping.lblCustomerId.getText(), view_shipping.txtDistance.getText());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (resultado == true) {
					JOptionPane.showMessageDialog(view_shipping.btnCadastrar, "O registro do contato " + nome + " foi salvo com sucesso!");
				}else {
					JOptionPane.showMessageDialog(view_shipping.btnCadastrar, "Ocorreram problemas ao salvar o registro");
				}
			}
		});
		
		// add Event to edit Shipping
		view_shipping.btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirma = JOptionPane.showConfirmDialog(view_shipping.btnEditar, "Deseja editar " + " o registro " + view_shipping.txtEntrega.getText() + "?");
				
				if (confirma==JOptionPane.YES_OPTION) {
					try {
						if (model_shipping.edit_shipping(view_shipping.lblnID.getText(), view_shipping.txtEntrega.getText(), Integer.toString(view_shipping.comboBox.getSelectedIndex()+1), view_shipping.lblCustomerId.getText(), view_shipping.txtDistance.getText())) {
							JOptionPane.showMessageDialog(view_shipping.btnEditar, "Registro editado com sucesso!");
						}else {
							JOptionPane.showMessageDialog(view_shipping.btnEditar, "Problemas ao editar o registro");
						}
					} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if (confirma==JOptionPane.NO_OPTION || confirma==JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(view_shipping.btnEditar, "Registro não editado");
				}
			}
		});
	}

}
