package samp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetGugu
 */
@WebServlet("/home/gugu")
public class GetGugu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetGugu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String html = "";
		html += "<h1>구구단을 출력합니다</h1>";
		int num = Integer.parseInt(request.getParameter("gugud"));
		
		html += "<div style='float:left; margin:5px;'>";
		html += "<br>";
		html += "<table border=\"1\">";
		html += "<thead>";
		html += "<th>" + num + " 단" + "</th>";
		html += "</thead>";
		html += "<tbody>";
		
		for(int i = 1; i <= 9; i++) {
			html += "<tr>";
			html += "<td>" + num + " * " + i + " = " + num*i + "</td>";
			html += "</tr>";
		}
		html += "</tbody>";
		html += "</table>";
		html += "</div>";
	
		
		html += "</body>";
		html += "</html>";
		out.println(html);
		
	}

}
