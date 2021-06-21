package controller;
import view.MainWindow;

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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
