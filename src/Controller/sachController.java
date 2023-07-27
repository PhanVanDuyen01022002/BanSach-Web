package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;
import bean.loaibean;
import bean.sachbean;
import bo.khachhangbo;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class sachController
 */
@WebServlet("/sachController")
public class sachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			sachbo sbo = new sachbo();
			ArrayList<sachbean> ds=sbo.getsach();
			//lay du lieu tu trang htsach.jsp
			String ml=request.getParameter("ml"); //get ma loai
			String key=request.getParameter("txttim"); // get value of input
			if(ml!=null) 
				ds=sbo.TimMa(ml);
			else
				if(key!=null) 
					ds=sbo.Tim(key);
			loaibo lbo=new loaibo();
			ArrayList<loaibean> dsloai=lbo.getloai();
			//Chuyen ve htsach.jsp: ds va dsloai
			request.setAttribute("dssach", ds);
			request.setAttribute("dsloai", dsloai);
			RequestDispatcher rd = request.getRequestDispatcher("htsach.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
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
