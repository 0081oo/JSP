package bmi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bmicalc
 */
@WebServlet("/bmi/calc")
public class Bmicalc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bmicalc() {
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
		html += "<html lang=\"ko\">";
		html += "<head>";
		html += "    <meta charset=\"UTF-8\">";
		html += "    <title>BMI</title>";
		html += "</head>";
		html += "<body>";
		html += "<h1>키와 체중을 입력하세요</h1>\n";
		html += "<form action=\"./res\" method=\"get\">";
		html += "키(cm)  : \n"
				+ "<input type=\"text\" name=\"height\"><br>\n"
				+ "체중(kg) : \n"
				+ "<input type=\"text\" name=\"weight\">\n"
				+ "<br><button type =\"submit\">입력</button>";
		html += "</form>";
        
		html += "</body>";
		html += "</html>";
		out.println(html);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			
	}

}
