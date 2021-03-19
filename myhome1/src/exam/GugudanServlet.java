package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GugudanServlet
 */
@WebServlet("/exam/gugudan")
public class GugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GugudanServlet() {
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
		
		PrintWriter out = response.getWriter();
		String html ="";
		html += "<!DOCTYPE html>";
		html += "<html lang=\"en\">";
		html += "<head>";
		html += "    <meta charset=\"UTF-8\">";
		html += "    <title>Document</title>";
		html += "</head>";
		html += "<body>";
		html += "<h1>구구단</h1>\n";
		html += "    <table border=\"1\">";
		html += "	<thead>";

		for(int i = 0; i < 9; i++){
			html += "<th>" + (i+1) + " 단" + "</th>";
		}

		html += "	</thead>";
		html += "        <tbody>";
		
		for(int i = 1; i <= 9; i++) {
			html += "<tr>";
			for(int j = 1; j <= 9; j++) {
				html += "                <td>" + j + " * " + i + " = " + i*j + "</td>";
			}
			html += "</tr>";
		}
	
		html += "        </tbody>";
		html += "    </table>";
		html += "<hr>";
		/* 구구단 테이블 따로 만들기 */
		html += "<h1>구구단</h1>";
		for(int i = 1; i <= 9; i++){
			html += "<div style='float:left; margin:5px;'>";
			html += "<br>";
			html += "<table border=\"1\">";
			html += "<thead>";
			html += "<th>" + i + " 단" + "</th>";
			html += "</thead>";
			html += "<tbody>";
			
			for(int j = 1; j <= 9; j++) {
				html += "<tr>";
				html += "<td>" + i + " * " + j + " = " + i*j + "</td>";
				html += "</tr>";
			}
			html += "</tbody>";
			html += "</table>";
			html += "</div>";
		}
		
		html += "</body>";
		html += "</html>";
		out.println(html);
	}

}
