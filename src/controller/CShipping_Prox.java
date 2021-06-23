package controller;

import model.MShipping;
import c_lib.ShippingjList;
import view.MainWindow;
import view.VShipping_Prox;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class CShipping_Prox {
	
	public void manage_Events(MainWindow main_window) {
	MShipping model_shipping = new MShipping();
	VShipping_Prox view_shipping = main_window.get_view_shipping_prox();
	ShippingjList ShippingNext = new ShippingjList();
	

	// Add Event to get Shipping by id
	view_shipping.btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					List<String> resultado = null;
					try {
						List<String> tmp_list = model_shipping.get_shipping_id_distance();
						double[] value = new double[tmp_list.size()];
						for (int i = 0; i < tmp_list.size(); ++i) { //iterate over the elements of the list
						    value[i] = Double.parseDouble(tmp_list.get(i)); //store each element as a double in the array
						}

						resultado = model_shipping.get_shipping_by_id(Integer.toString(ShippingNext.get_menor_valor(value)));
						System.out.println(Integer.toString(ShippingNext.get_menor_valor(value)));
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
						JOptionPane.showMessageDialog(view_shipping.btnPesquisar, "Nenhum proximo Item");

					}
				}
			
		});
	}

}
