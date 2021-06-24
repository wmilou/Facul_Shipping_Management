package model;

/* Nomes Alunos
 *  Vinicius Oliveira          RA: 72507
 *  Wedlsey Milouchine         RA: 73183
 *  Carolina Rodrigues         RA: 68097
 *  Eduardo Oliveira Batista   RA: 73026
 *  Genildo Santos             RA: 77846
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class connection {
    protected String driver = "com.mysql.cj.jdbc.Driver";  
    private String address; 
    private String port;
    private String database;

    private String user;
    private String password;

    public connection (String address, String port, String database, String user, String password) {
    	this.address = (address == null) ? "172.17.0.2" : address;
    	this.port = (port == null) ? "3306" : port;
    	this.database = (database == null) ? "Shipping_Management" : database;
    	this.user = (user == null) ? "root" : user;
    	this.password = (password == null) ? "Mdacs1321@" : password;
    }

    public connection () {
    	this.address = "172.17.0.2";
    	this.port = "3306";
    	this.database = "Shipping_Management";
    	this.user = "root";
    	this.password = "Mdacs1321@";
    }

    public Connection get_Connection() throws ClassNotFoundException{
        Class.forName(driver);
        Connection con = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://"+address+":"+port+"/"+database, 
					user, 
					password
			);
		}catch (SQLException e) {
			System.out.println(e);
		}
		return con;
    }
    
    public List<String> exec_Query(String query) throws ClassNotFoundException, SQLException {
    	Connection connection = this.get_Connection();
    	Statement statement = connection.createStatement();
    	ResultSet result = statement.executeQuery(query);

    	List<String> values = new ArrayList<String>();
    	int  colNum = result.getMetaData().getColumnCount();
			while (result.next()) {
				for (int i = 1; i<=colNum; i++) {
					System.out.println(result.getString(i)+ " ");
					values.add(result.getString(i));
				}
				System.out.println();
			}

    	statement.close();
    	connection.close();

		return values;
    }

    public boolean exec_Update(String query) throws ClassNotFoundException, SQLException {
    	Connection connection = this.get_Connection();
    	Statement statement = connection.createStatement();
    	int result_int = statement.executeUpdate(query);
    	statement.close();
    	connection.close();

		boolean result = (result_int == 1)? true : false;
		return result;
    }
}
