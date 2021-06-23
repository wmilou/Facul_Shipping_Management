package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MCustomer {

	public List<String> get_customers() throws ClassNotFoundException, SQLException{
		List<String> result = new ArrayList<String>();

		connection con = new connection();
		result = con.exec_Query("SELECT * FROM Customer;");
		return result;
	}
	
	public List<String> get_customers_by_name(String Customer_Name) throws ClassNotFoundException, SQLException{
		List<String> result = new ArrayList<String>();

		connection con = new connection();
		result = con.exec_Query("SELECT * FROM Shipping_Management.Customer WHERE Customer_Name LIKE '" + Customer_Name + "'");
		return result;
	}

	public boolean set_customer_name(int Id,String Customer_Name) throws ClassNotFoundException {
		String query = "UPDATE Shipping_Management.Customer SET Customer_Name = '" + Customer_Name +"'WHERE Id = '" + Id + "'";
			
		boolean result = false;
		try{
			connection con = new connection();
			result = con.exec_Update(query);
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		return result;
	}
	
	public boolean delete_customer(int Id) throws ClassNotFoundException {
		String query = "DELETE FROM Customer WHERE Id = '" + Id + "'";
			
		boolean result = false;
		try {
			connection con = new connection();
			result = con.exec_Update(query);
		}catch (SQLException e) {
			System.out.println(e);
		}

		return result;
	}
	
	public boolean add_customer(String Name_Customer) throws ClassNotFoundException {
		String query = "INSERT INTO `Shipping_Management`.`Customer` (`Customer_Name`) VALUES" + 
						"('"+ Name_Customer +"')";
			
		boolean result = false;
		try {
			connection con = new connection();
			result = con.exec_Update(query);
		}catch (SQLException e) {
			System.out.println(e);
		}

		return result;
	}

}