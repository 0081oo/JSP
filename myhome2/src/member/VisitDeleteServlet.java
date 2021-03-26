package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class VisitDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VisitDeleteServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트가 전달한 파라미터 추출
		int id = Integer.parseInt(request.getParameter("id"));
		
		// 2. VisitDAO 를 생성
		VisitDAO visit = new VisitDAO();
		
		// 3. 생성된 VisitDAo에 삭제할 데이터를 구분할수 있는 값(primary key) 전달후 삭제
		visit.deleteData(id);
		visit.close();
		
		// 4. 삭제 완료후 localhost:8080/home2/visit 을 다시 요청하도록 리다이렉트 메시지전달
		response.sendRedirect("./visit"); 
	}

}
