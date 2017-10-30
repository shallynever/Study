package JDBC_Demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo {

	public static void main(String[] args) throws Exception {
		Connection conn = Ds_connector.My_Connector();//����Ds_connector���е�My_Connector()����������Connetion����
		
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
		File f = new File("f:"+File.separator+"test.txt");//����һ��File����
		InputStream input = new FileInputStream(f);//ע���ļ��ı����ʽ
		pstmt.setInt(1, num);
		pstmt.setString(2, name);
		pstmt.setAsciiStream(3, input,(int)f.length());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

}
