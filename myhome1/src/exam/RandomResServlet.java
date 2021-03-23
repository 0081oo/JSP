package exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RandomResServlet
 */
@WebServlet("/exam/random/res")
public class RandomResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomResServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");
		
		String mn = request.getParameter("mn");
		String mx = request.getParameter("mx");
		String rn = request.getParameter("rn");
		
		
		PrintWriter out = response.getWriter();
		
		String html = "";
		html += "<!DOCTYPE html>";
		html += "<html lang=\"en\">";
		html += "<head>";
		html += "    <meta charset=\"UTF-8\">";
		html += "    <title>Document</title>";
		html += "</head>";
		html += "<body>";
		html += "<h1>랜덤 만들기</h1>\n";
       
        html += "<h2 style='color:#F8E119; font-size:40pt;'>"+ rn +"</h2>";
		html += "</body>";
		html += "</html>";
		out.println(html);
	}

}
