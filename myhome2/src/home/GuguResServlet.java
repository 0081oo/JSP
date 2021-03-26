package home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudan/res")
public class GuguResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GuguResServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("dan_num"));
		
		ArrayList<String> gugu_res = new ArrayList();
		for (int i = 1; i<=9; i++ ) {
			gugu_res.add(num + " x " + i + " = " + (i*num));
		}
		
		request.setAttribute("gugu_res", gugu_res);
		RequestDispatcher dp = request.getRequestDispatcher("../gugures.jsp"); // res까지 들어가야했으니까 한단계 위로
		dp.forward(request, response);
	}

}
