package JDBC_Demo;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class BlobDemo01 {
	
	public static void main(String[] args) throws Exception {
		Connection conn = Ds_connector.My_Connector();
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String name = "zhoujing";
		
		String sql_1 = "SELECT * FROM userblob";
		pstmt = conn.prepareStatement(sql_1);
		rs=pstmt.executeQuery();
		rs.last();
		int num = rs.getRow()+1;
		
		String sql ="INSERT INTO userblob(num,name,photo) VALUES(?,?,?) ";
		pstmt = conn.prepareStatement(sql);
		File f = new File("f:"+File.separator+"1234.gif");
		FileInputStream input = new FileInputStream(f);
		
		
		pstmt.setInt(1,num);
		pstmt.setString(2,name);		
		pstmt.setBinaryStream(3, input,(long)f.length());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		
		
	}

}
