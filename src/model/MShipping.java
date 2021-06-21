package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MShipping {

	public List<String> get_shipping() throws ClassNotFoundException, SQLException{
		List<String> result = new ArrayList<String>();

		connection con = new connection();
	    result = con.exec_Query("SELECT * FROM Shipping;");
		return result;
	}

	public List<String> get_shipping_by_id(String Id) throws ClassNotFoundException, SQLException{
		List<String> result = new ArrayList<String>();

		connection con = new connection();
	    result = con.exec_Query("SELECT *, (SELECT Customer.Customer_Name FROM Customer WHERE Id = Shipping.Customer_Id) as Customer FROM Shipping WHERE Id = "+ Id +";");
		return result;
	}

	public List<String> get_shipping_list_formated() throws ClassNotFoundException, SQLException {
		List<String> result = new ArrayList<String>();

		connection con = new connection();
	    result = con.exec_Query("SELECT Shipping.Shipping_Description,\n"
				+ "       Shipping.Date_Time,\n"
				+ "       (SELECT Shipping_Status.Description_Type FROM Shipping_Status WHERE Id = Shipping.Shipping_Status_Id) as `Status`,\n"
				+ "       (SELECT Customer.Customer_Name FROM Customer WHERE Id = Shipping.Customer_Id) as Customer,\n"
				+ "       Shipping.Distance\n"
				+ "       FROM Shipping;");
		return result;
	}

	public List<String> get_shipping_list_formated_for_JList() throws ClassNotFoundException, SQLException {
		List<String> tmpresult = new ArrayList<String>();
		List<String> result = new ArrayList<String>();

		connection con = new connection();
	    tmpresult = con.exec_Query("SELECT Id, (SELECT Customer.Customer_Name FROM Customer WHERE Id = Shipping.Customer_Id) as Customer,\n" 
				+ "       (SELECT Shipping_Status.Description_Type FROM Shipping_Status WHERE Id = Shipping.Shipping_Status_Id) as `Status`,\n"
	    		+ "       Shipping.Distance\n"
				+ "       FROM Shipping;");
	    
	    int count = -1;
	    String tmpline = "";
	    while (count < tmpresult.size()-1) {
	    	tmpline = "";
	    	count++;
	    	tmpline += "ID: " + tmpresult.get(count) + " | ";
	    	count++;
	    	tmpline += "Customer : " + tmpresult.get(count) + " | ";
	    	count++;
	    	tmpline += "Status : " + tmpresult.get(count);
	    	count++;
	    	result.add(tmpline);
	    }  
		return result;
	}
	
	public boolean edit_shipping(String Id, String Description, String Status_Id, String Customer_Id, String Distance) throws ClassNotFoundException, SQLException {
		boolean result = false;
		
		connection con = new connection();
	    result = con.exec_Update("UPDATE Shipping_Management.Shipping SET Shipping_Description = '" + Description + "', Shipping_Status_Id = '"+ Status_Id +"', Customer_Id = '"+ Customer_Id +"', Distance = '"+ Distance +"' WHERE Id = '" + Id + "'");
		return result;
	}

	public boolean add_shipping(String Description, String Status_Id, String Customer_Id, String Distance) throws ClassNotFoundException, SQLException {
		boolean result = false;
		
		connection con = new connection();
	    result = con.exec_Update("INSERT INTO Shipping(Shipping_Description, Shipping_Status_Id, Customer_Id, Distance) VALUES ('"+ Description +"', "+ Status_Id +", "+ Customer_Id +", "+ Distance +" )");
		return result;
	}
	
	public boolean delete_shipping(String Id) throws ClassNotFoundException, SQLException {
		
		boolean result = false;
		
		connection con = new connection();
	    result = con.exec_Update("DELETE FROM Shipping WHERE Id = '" + Id + "'");
		return result;
	}
}
