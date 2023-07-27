package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.khachhangbean;
import bean.loaibean;

public class khachhangdao {
	public khachhangbean ktdn(String tendn, String pass) throws Exception{
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql="select * from khachhang where tendn=? and pass=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tendn);
		cmd.setString(2, pass);
		ResultSet rs = cmd.executeQuery();
		khachhangbean kh=null;
		if(rs.next()) {
			long makh = rs.getLong("makh");
			String hoten = rs.getString("hoten");
			String diachi = rs.getString("diachi");
			String sodt = rs.getString("sodt");
			String email = rs.getString("email");
			kh = new khachhangbean(makh, hoten, diachi, sodt, email, tendn, pass);
		}
		return kh;
	}
}
