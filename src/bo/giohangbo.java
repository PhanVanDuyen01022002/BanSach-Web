package bo;

import java.util.ArrayList;

import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds= new ArrayList<giohangbean>();
	public void ThemHang(String masach,String tensach,long gia, long soluongmua) {
		//Kiem tra xem hang da co trong ds chua
		//neu co thi tang so luong
		for(giohangbean h: ds) 
			if(h.getMasach().equals(masach)) {
				h.setSoluongmua(h.getSoluongmua()+soluongmua);
				return;
			}
		giohangbean h= new giohangbean(masach, tensach, gia, soluongmua);
		ds.add(h); //Them hang vao gio
	}
	//Xoa hang ra khoi ds
	public void XoaHang(String masach) {
		for(giohangbean h: ds)
			if(h.getMasach().equals(masach)) {
				ds.remove(h);
				return;
			}
	}
	//Sua lai so luong
	public void Sua(String masach, long soluongmoi) {
		int n=ds.size();  //Lay so sach trong ds
		for(int i=0;i<n;i++) {
			giohangbean h=ds.get(i); //Lay sach thu i
			if(h.getMasach().equals(masach)) {
				h.setSoluongmua(soluongmoi);  //Sua so luong
				ds.set(i, h);  //Luu lai vao ds
				return;
			}
		}
	}
	//Tinh tong tien
	public long Tong() {
		long s=0;
		for(giohangbean h: ds) {
			s=s+h.getThanhtien();
		}
		return s;
	}
}
