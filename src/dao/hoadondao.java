package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import bean.loaibean;

public class hoadondao {
	public int Them(long makh) throws Exception {
		//b1: Ket noi vao csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//b2: Tao cau lenh sql
		String sql= "INSERT INTO hoadon (makh,NgayMua,damua) VALUES (?,?,?)";
		//b3: tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setLong(1, makh);
		//Lay ngay gio hien tai
		Date n1 = new Date();
		SimpleDateFormat dd= new SimpleDateFormat("yyyy-MM-dd");
		//Doi ngay util sang chuoi theo dinh dang
		String tam = dd.format(n1);
		Date n2 = dd.parse(tam); // doi chuoi ra ngay util
		//doi ngay util sang ngay sql va dua vao tham so
		cmd.setDate(2, new java.sql.Date(n2.getTime()));
		cmd.setBoolean(3, false);
		int kq=cmd.executeUpdate(); // thuc hien cau lenh sql
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public long getMaxHD() throws Exception {
		//b1: Ket noi vao csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//b2: Tao cau lenh sql
		String sql= "select max(MaHoaDon) as maxhd from	hoadon";
		//b3: tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		long max=0;
		if(rs.next()) {
			//Lay ve gia tri cua cot dau tien trong rs
			max = rs.getLong(1);
		}
		//b6: Dong rs va ket noi
		rs.close();
		kn.cn.close();
		return max;
	}
}
