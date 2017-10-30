package JDBC_Demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Ds_connector {	
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/javastudy";
	public static final String DBUSER = "root";
	public static final String DBPASS = "19891127";	
	public static Connection My_Connector() throws Exception {		
		Connection conn = null;	
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);	
		return conn;
	}		
}
