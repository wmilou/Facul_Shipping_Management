package controller;

/* Nomes Alunos
 *  Vinicius Oliveira          RA: 72507
 *  Wedlsey Milouchine         RA: 73183
 *  Carolina Rodrigues         RA: 68097
 *  Eduardo Oliveira Batista   RA: 73026
 *  Genildo Santos             RA: 77846
 */

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
					
					CShipping_Prox shipping_prox_events = new CShipping_Prox();
					shipping_prox_events.manage_Events(main_window);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
