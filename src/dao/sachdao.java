package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;
import bean.sachbean;

public class sachdao {
	public ArrayList<sachbean> getsach() throws Exception {
		ArrayList<sachbean> ds = new ArrayList<sachbean>();
		//b1: Ket noi vao csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//b2: Tao cau lenh sql
		String sql= "select*from sach";
		//b3: tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		//b5: Duyet rs de luu vao ds
		while (rs.next()) {
			String masach=rs.getString("masach");
			String tensach=rs.getString("tensach");
			String tacgia=rs.getString("tacgia");
			long gia=rs.getLong("gia");
			long soluong=rs.getLong("soluong");
			String anh=rs.getString("anh");
			String maloai=rs.getString("maloai");
			ds.add(new sachbean( masach, tensach, tacgia, gia, soluong,anh,maloai));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
}
