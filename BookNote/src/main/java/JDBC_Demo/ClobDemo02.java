package JDBC_Demo;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;



public class ClobDemo02 {

	public static void main(String[] args) throws Exception {
		Connection conn = Ds_connector.My_Connector();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM userclob";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			String name = rs.getString(2);
			StringBuffer note = new StringBuffer();
			InputStream  input = rs.getAsciiStream(3);
			Scanner scan = new Scanner(input);
			scan.useDelimiter("\r\n");
			while(scan.hasNext()){
				note.append(scan.next()).append("\n");
			}
			scan.close();
			System.out.println(name+"内容:"+note);
			input.close();
		}
		pstmt.close();
		conn.close();
	}

}
