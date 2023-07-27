package bo;

import dao.ctdao;

public class ctbo {
	ctdao ct= new ctdao();
	public int Them(String MaSach, long SoLuongMua, Long MaHoaDon) throws Exception {
		return ct.Them(MaSach, SoLuongMua, MaHoaDon);
	}
}
