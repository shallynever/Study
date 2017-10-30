package JDBC_Demo;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class ClobDemo03 {

	public static void main(String[] args) throws Exception {
		Connection conn = Ds_connector.My_Connector();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM userclob";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			String name = rs.getString(2);
			Clob c = rs.getClob(3);
			String note = c.getSubString(1, (int)c.length());
			System.out.println(name+"::"+note);
			c.truncate(50);
			System.out.println(c.getSubString(1, (int)c.length()));

		}
		pstmt.close();
		conn.close();

	}

}
