package member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visit")
public class VisitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VisitServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VisitDAO visit  = new VisitDAO();
//		VisitVO v = visit.getRecord(Integer.parseInt(request.getParameter("id"))); // 이 인자는 main.jsp에서 넘겨줌
		ArrayList<VisitVO> result = visit.getAll(); // 전체출력
		visit.close();
		
		request.setAttribute("result", result);
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/visit.jsp");
		dp.forward(request, response);
		
//		if(v != null) {
//			System.out.println(v.getId());
//			System.out.println(v.getAuthor());
//			System.out.println(v.getContext());
//			System.out.println(v.getCreate_date());
//		} else {
//			System.out.println("조회 결과 없음");
//		}
		
//		if(result != null) {
//			for(int i = 0; i < result.size(); i++) {
//				System.out.print("Id : " + result.get(i).getId() + " | ");
//				System.out.print("Author : " + result.get(i).getAuthor() + " | ");
//				System.out.print("Context : " + result.get(i).getContext() + " | ");
//				System.out.println("Create Date : " + result.get(i).getCreate_date());
//			}
//		} else {
//			System.out.println("조회 결과 없음");
//		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
