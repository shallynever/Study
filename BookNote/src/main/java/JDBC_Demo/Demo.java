package JDBC_Demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo {

	public static void main(String[] args) throws Exception {
		Connection conn = Ds_connector.My_Connector();//调用Ds_connector类中的My_Connector()方法，返回Connetion对象
		
		PreparedStatement pstmt = null;
		String name = "zhoujing";
		ResultSet rs = null;
		
		String sql_1 = "SELECT * FROM userclob";
		pstmt = conn.prepareStatement(sql_1);
		rs=pstmt.executeQuery();
		rs.last();
		int num = rs.getRow()+1;
		
		String sql = "INSERT INTO userclob(num,name,note)VALUES(?,?,?)";
		pstmt = conn.prepareStatement(sql);
		File f = new File("f:"+File.separator+"test.txt");//声明一个File对象
		InputStream input = new FileInputStream(f);//注意文件的编码格式
		pstmt.setInt(1, num);
		pstmt.setString(2, name);
		pstmt.setAsciiStream(3, input,(int)f.length());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

}
