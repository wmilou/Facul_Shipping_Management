package controller;
import view.VStatus_Type;
import view.MainWindow;
import model.MStatus_Type;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class CStatus_Type {
	
	public void manage_Events(MainWindow main_window) {
		MStatus_Type model_status_type = new MStatus_Type();
		VStatus_Type view_status_type = main_window.get_view_status_type();

		// Add event to get Status by Id
		view_status_type.btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (view_status_type.txtBusca.getText().length() > 0) {
					List<String> resultado = null;
					try {
						resultado = model_status_type.get_shipping_status_type_by_id(view_status_type.txtBusca.getText().trim());
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (resultado != null) {
						view_status_type.lblnID.setText (resultado.get(0));
						view_status_type.txtDescription.setText(resultado.get(1));
					}else {
						JOptionPane.showMessageDialog(view_status_type.btnPesquisar, "Nenhum com esse ID");

					}
				} else {
					JOptionPane.showMessageDialog(view_status_type.btnPesquisar, "Informe o ID a ser buscado.");
				}
			}
		});
	}

}
