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

import org.apache.catalina.connector.Request;

import bo.giohangbo;

/**
 * Servlet implementation class XoaController
 */
@WebServlet("/XoaController")
public class XoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			if(request.getParameter("x")!=null) {
				String ms = request.getParameter("ms");
				giohangbo gh = (giohangbo)session.getAttribute("gh");
				gh.XoaHang(ms);
				//Luu bien vao session
				session.setAttribute("gh", gh);
				//Quay ve trang htgio.jsp
				RequestDispatcher rd = request.getRequestDispatcher("htgioController");
				rd.forward(request, response);
			} else if(request.getParameter("masachList")!=null) {
				String masachList = request.getParameter("masachList");

		        // Kiểm tra nếu masachList không rỗng và không null
		        if (masachList != null && !masachList.isEmpty()) {
		            String[] masachArray = masachList.split(",");

		            // Thực hiện việc xóa các masach đã được chọn ở đây
		            giohangbo gh = (giohangbo)session.getAttribute("gh");
		            if (gh != null) {
		                for (String masach : masachArray) {
		                    gh.XoaHang(masach);
		                }
		            }
		            //Luu bien vao session
					session.setAttribute("gh", gh);
					//Quay ve trang htgio.jsp
					RequestDispatcher rd = request.getRequestDispatcher("htgioController");
					rd.forward(request, response);
		        }
			} else if(request.getParameter("xh")!=null) {
				session.removeAttribute("gh");
				RequestDispatcher rd = request.getRequestDispatcher("htgioController");
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
