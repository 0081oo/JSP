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
 * Servlet implementation class LottoServlet
 */
@WebServlet("/exam/lotto")
public class LottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LottoServlet() {
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
		html += "<h1>로또생성기</h1>\n";
		
        int[] arr = new int[6];
        for(int i = 0; i< 6; i++){
            arr[i] = rand.nextInt(45) + 1;
            for(int j = 0; j < i; j++){
                if(arr[i] == arr[j]){
                    i--; break;
                }
            }
        }
        
        /* if문 없이 범위마다 색상부여하기 */
        String color[] = {"#F85615", "#F8156C", "#159DF8", "#4AF815", "#F8E115"};

        for(int i = 0; i< 6; i++){
            html += "<span style='font-size:40pt; font-weight:bold;color:" 
            		+ color[(arr[i]-1)/10] + ";'>" + arr[i] + "  " + "</span>";
        }
        
		html += "</body>";
		html += "</html>";
		out.println(html);
		
	}

}
