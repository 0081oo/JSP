package exam;

import java.util.Random;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RandomServlet
 */
@WebServlet("/exam/random")
public class RandomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        Random rand = new Random();

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
		html += "<h1>랜덤 만들기</h1>\n";
        int rNum = rand.nextInt(100) + 1;
        
        /* String color = "#000000"; 만든후 if에서 color만 바꿔줘서 
         * 마지막에 <h2 style=\"color: " + color + "\">" + rNum + "</h2>"; 해주면 효율적
         *  */
        if(rNum >= 1 && rNum <= 20) html += "<h2 style='color:#F85615; font-size:40pt;'>"+ rNum +"</h2>";
        else if(rNum > 20 && rNum <= 40) html += "<h2 style='color:#F8156C; font-size:40pt;'>"+ rNum +"</h2>";
        else if(rNum > 40 && rNum <= 60) html += "<h2 style='color:#159DF8; font-size:40pt;'>"+ rNum +"</h2>";
        else if(rNum > 60 && rNum <= 80) html += "<h2 style='color:#4AF815; font-size:40pt;'>"+ rNum +"</h2>";
        else html += "<h2 style='color:#F8E115; font-size:40pt;'>"+ rNum +"</h2>";
		html += "</body>";
		html += "</html>";
		out.println(html);
		
	}

}
