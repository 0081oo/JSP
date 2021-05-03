package test_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/a")
public class TestAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public TestAServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestAServlet doGet() Start");
		String name = request.getParameter("name");
		System.out.println(name);
		
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/jsp/test/index.jsp");
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestAServlet doPost()");
		String name = request.getParameter("name");
		System.out.println(name);
		
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/jsp/test/index.jsp");
		dp.forward(request, response);
	}

}
