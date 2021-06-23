package controller;
import view.MainWindow;
import c_lib.ShippingjList;

import java.awt.EventQueue;

public class Shipping_Management {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow main_window = new MainWindow();
					main_window.setVisible(true);
					
					
					// Set Events with Controllers
					CCustomer customer_events = new CCustomer();
					customer_events.manage_Events(main_window);
					
					CStatus_Type shipping_status_type_events = new CStatus_Type();
					shipping_status_type_events.manage_Events(main_window);

					CShipping shipping_events = new CShipping();
					shipping_events.manage_Events(main_window);
					
					ShippingjList lista_menos = new ShippingjList();
					double[] value = {1.0, 4.5, 2, 6.7} ;
					System.out.println(lista_menos.get_menor_valor(value));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
