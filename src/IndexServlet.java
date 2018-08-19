
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String secondName = request.getParameter("secondName");
		String email = request.getParameter("email");
		String buttonName = request.getParameter("buttonName");
		PrintWriter out = response.getWriter();
		if ("Show".equals(buttonName)) {
			response.sendRedirect(request.getContextPath() + "/showbase.jsp");
		} else {
			try {
				Connection con = ru.unlimit.DBService.getConnection();
				ru.unlimit.DBService.post(con, firstName, secondName, email);
				con.close();
				out.println("<H3>Success</H3>");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				out.println("<br>");
				out.println("<a href=\"/TestTaskMicrofocus/index.html\">Page back</a>");
			}
		}
	}
}
