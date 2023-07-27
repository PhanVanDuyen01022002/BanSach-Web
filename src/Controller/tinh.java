package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class tinh
 */
@WebServlet("/tinh")
public class tinh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tinh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Tao ra doi tuong out
		PrintWriter out = response.getWriter();
		//out.print("<html><body>alo</body></html>");
		//Tao ra doi tuong session
		HttpSession session = request.getSession();
		session.setAttribute("tam", "Xin chao");
		//Gui du lieu ve jsp
		request.setAttribute("a", (long)10);
		request.setAttribute("b", "haha");
		String[] ds= {"Hoa", "My", "Lien", "Tung"};
		request.setAttribute("ds", ds);
		//CHuyen tiep ve trang dangky.jsp
		RequestDispatcher rd= request.getRequestDispatcher("dangky.jsp");
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
