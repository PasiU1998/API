package dbcon;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	
	//DB Connection Method	
			public static Connection connection() {
				
				Connection con = null ;
						
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							
							//DB Connection
							con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/firealarmmonitosystem", "root" , "pasindupasi1998");
						}
						catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						return con;
			}
			
			
	
	
}
