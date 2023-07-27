package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;
import bo.khachhangbo;

/**
 * Servlet implementation class dangnhapController
 */
@WebServlet("/dangnhapController")
public class dangnhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhapController() {
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
		   		String un = request.getParameter("txtun");
		   		String pass = request.getParameter("txtpass");
	   			khachhangbo khbo = new khachhangbo();
		   		if(un==null && pass==null) {
		   			RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
		   			rd.forward(request, response);
		   		} else {
		   			khachhangbean kh = khbo.ktdn(un, pass);
		   			if(kh!=null) {	//ok
		   				HttpSession session = request.getSession();	
		   				session.setAttribute("dn",kh);
		   				//Điều ướng sang SachController
//		   				RequestDispatcher rd = request.getRequestDispatcher("sachController");
//		   				rd.forward(request, response);
		   				response.sendRedirect("sachController");
		   			} else {	//ok
		   				request.setAttribute("kt", 1);
		   				RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
		   				rd.forward(request, response);
		   			}
		   		}
			} catch (Exception e) {
				// TODO: handle exception
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
