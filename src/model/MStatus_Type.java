package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MStatus_Type {

	public List<String> get_shipping_status_type() throws ClassNotFoundException, SQLException{
		List<String> result = new ArrayList<String>();

		connection con = new connection();
	    result = con.exec_Query("SELECT Description_Type FROM Shipping_Status;");
		return result;
	}
	
	public List<String> get_shipping_status_type_by_id(String Id) throws ClassNotFoundException, SQLException{ 
		List<String> result = new ArrayList<String>();
		String query = "SELECT * FROM Shipping_Management.Shipping_Status WHERE Id LIKE '" + Id + "'";
	
		connection con = new connection();
		result = con.exec_Query(query);
		return result;
	}
	
}
