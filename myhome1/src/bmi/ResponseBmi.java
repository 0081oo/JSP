package bmi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseBmi
 */
@WebServlet("/bmi/res")
public class ResponseBmi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseBmi() {
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
		String html ="";
		html += "<!DOCTYPE html>";
		html += "<html lang=\"ko\">";
		html += "<head>";
		html += "    <meta charset=\"UTF-8\">";
		html += "    <title>BMI</title>";
		html += "</head>";
		html += "<body>";
		html += "<h1>당신의 BMI 수치 입니다</h1>\n";
		double h = Double.parseDouble(request.getParameter("height"))/100;
		double w = Double.parseDouble(request.getParameter("weight"));
		int BMI = (int)(w / (h*h));
		
		String bmiRes = "";
		if(BMI < 20) bmiRes = "저체중";
		else if(BMI >= 20 && BMI <= 24) bmiRes = "정상";
		else if(BMI >= 25 && BMI <= 29) bmiRes = "과체중";
		else bmiRes = "비만";
		html += "당신의 키 : " + (h*100) + "cm<br>" + "당신의 몸무게 : " + w + "kg<br>" +
				"BMI 결과값 : " + BMI + "<br>";
		html += "당신은 " + bmiRes + " 입니다";

		html += "</body>";
		html += "</html>";
		out.println(html);
	}

}
