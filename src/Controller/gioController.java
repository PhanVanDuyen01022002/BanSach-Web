package Controller;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class gioController
 */
@WebServlet("/gioController")
public class gioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gioController() {
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
			//Lay ve ms, ts, gia
			String masach = request.getParameter("ms");
			String tensach = request.getParameter("ts");
			String giatemp = request.getParameter("gia");
			//Neu khong phai chay lan dau thi:
			if(masach!=null && tensach!=null && giatemp!=null){
				HttpSession session = request.getSession();
				//Doi gia tu chuoi ra so
				long gia = Long.parseLong(giatemp);
				giohangbo gh = null;
				//Neu chua tao session("gh") thi tao ra
				if(session.getAttribute("gh")==null){
					gh = new giohangbo();
					session.setAttribute("gh", gh);
				}
				gh = (giohangbo)session.getAttribute("gh");//Luu session ra bien 
				gh.ThemHang(masach, tensach, gia, 1); //Goi ham them
				//Luu bien vao lai session
				session.setAttribute("gh", gh);
				session.setAttribute("sl", gh.ds.size());
				//Dieu huong qua tra de hien thi gio hang
				//response.sendRedirect("htgio.jsp");
				response.sendRedirect("htgioController");
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("htgio.jsp");
				rd.forward(request, response);
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
