package ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/board")
public class AjaxTempListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxTempListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		
		// 전달 받은 데이터에 대한 처리 로직 구현 시작
		
		// 전달 받은 데이터에 대한 처리 로직 구현 끝
		
		// 처리 결과를 JSON 형식으로 클라이언트에 전
		response.setContentType("application/json");
		ServletOutputStream out = response.getOutputStream();
		out.print("{\"res\" : \"complete\"}");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
