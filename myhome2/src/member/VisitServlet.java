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
//			System.out.println(v.getContent());
//			System.out.println(v.getCreate_date());
//		} else {
//			System.out.println("조회 결과 없음");
//		}
		
//		if(result != null) {
//			for(int i = 0; i < result.size(); i++) {
//				System.out.print("Id : " + result.get(i).getId() + " | ");
//				System.out.print("Author : " + result.get(i).getAuthor() + " | ");
//				System.out.print("Content : " + result.get(i).getContent() + " | ");
//				System.out.println("Create Date : " + result.get(i).getCreate_date());
//			}
//		} else {
//			System.out.println("조회 결과 없음");
//		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 1. 클라이언트가 전달한 파라미터 추출	
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		
		// 2. 추출한 파라미터를 VisitVO 객체에 저장
		VisitVO data =  new VisitVO(author, content);
		
		// 3. VisitDAO를 생성후 2번에서 만든 VisitVO를 저장하기 위해 전달후 저장
		VisitDAO visit = new VisitDAO();
		visit.saveData(data);
		visit.close();
		
		// 4. 저장 완료후 localhost:8080/home2/visit 을 다시 요청하도록 클라이언트에 리다이렉트 메시지전달
		response.sendRedirect("./visit");
	}

}
