package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ketnoidao {
	public Connection cn;
	public void ketnoi() throws Exception{
		//B1: xac dinh hqtcsdl
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.print("Da xac dinh duoc heqtcsdl");
		String url="jdbc:sqlserver://DESKTOP-IMFUST7:1433;databaseName=QlSach;user=sa;password=123";
		cn=DriverManager.getConnection(url);
		System.out.print("-Da ket noi");
	}
}
