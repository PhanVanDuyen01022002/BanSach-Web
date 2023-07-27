package dao;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ctdao {
	public int Them(String MaSach, long SoLuongMua, Long MaHoaDon) throws Exception {
		//b1: Ket noi vao csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//b2: Tao cau lenh sql
		String sql= "INSERT INTO ChiTietHoaDon(MaSach,SoLuongMua,MaHoaDon,DaMua) VALUES (?,?,?,?)";
		//b3: tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, MaSach);
		cmd.setLong(2, SoLuongMua);
		cmd.setLong(3, MaHoaDon);
		cmd.setBoolean(4, false);
		int kq=cmd.executeUpdate(); // thuc hien cau lenh sql
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
