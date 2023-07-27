package bo;

import java.util.ArrayList;

import bean.sachbean;
import dao.sachdao;

public class sachbo {
	sachdao sdao=new sachdao();
	ArrayList<sachbean> ds;
	//Viet ham getsach: lay ve all sach
	public ArrayList<sachbean> getsach() throws Exception {
		ds=sdao.getsach();
		return ds;
	}
	//Viet ham timMa(String maloai): tra ve all sach cua loai co ma: maloai
	public ArrayList<sachbean> TimMa(String maloai) throws Exception {
		ArrayList<sachbean> tam = new ArrayList<sachbean>();
		for(sachbean s:ds) 
			if(s.getMaloai().equals(maloai)) 
				tam.add(s);
		return tam;
	}
	//Viet ham tim(String key): tra ve all sach co ten sach hoac tac gia giong nhu key
	public ArrayList<sachbean> Tim(String key) throws Exception {
		ArrayList<sachbean> tam = new ArrayList<sachbean>();
		for(sachbean s:ds) 
			if(s.getTensach().toLowerCase().contains(key.toLowerCase()) || s.getTacgia().toLowerCase().contains(key.toLowerCase())) 
				tam.add(s);
		return tam;
	}
}
