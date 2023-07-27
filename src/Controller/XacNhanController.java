package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bean.khachhangbean;
import bo.ctbo;
import bo.giohangbo;
import bo.hoadonbo;

/**
 * Servlet implementation class XacNhanController
 */
@WebServlet("/XacNhanController")
public class XacNhanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XacNhanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			khachhangbean kh = (khachhangbean)session.getAttribute("dn");
			if(kh==null) {
				RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
				rd.forward(request, response);
			} else {
				giohangbo gh=(giohangbo)session.getAttribute("gh");
				if(gh!=null) { //co hang trong gio
					//Tao 1 hoa don
					hoadonbo hdbo=new hoadonbo();
					hdbo.Them(kh.getMakh());
					long mahd=hdbo.getMaxHD();
					//Duyet gio de luu vao cthoadon
					ctbo ct=new ctbo();
					for(giohangbean g:gh.ds) 
						ct.Them(g.getMasach(), g.getSoluongmua(), mahd);
					//xoa gio hang
					session.removeAttribute("gh");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
