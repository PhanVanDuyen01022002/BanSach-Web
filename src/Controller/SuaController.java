package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class SuaController
 */
@WebServlet("/SuaController")
public class SuaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String ms = request.getParameter("ms");
		String sl = request.getParameter("txtsl");
		//Luu Session ra bien
		giohangbo gh = (giohangbo)session.getAttribute("gh");
		//Sua lai so luong
		long soluong = Long.parseLong(sl);
		if(soluong>0)
			gh.Sua(ms, soluong);
		//Luu bien vao session
		session.setAttribute("gh", gh);
		//Quay ve trang htgio.jsp
		RequestDispatcher rd = request.getRequestDispatcher("htgioController");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
