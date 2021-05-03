package account.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") == null ) {
			String path = "/WEB-INF/jsp/account/login.jsp";
			RequestDispatcher dp = request.getRequestDispatcher(path);
			dp.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// username: user
		// password: user
		// 위의 정보로 접속하면 로그인 성공하게 구현
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// 세션 생성
		HttpSession session = request.getSession();
		
		// login 세션 유무 확인
		if(session.getAttribute("login") == null) {
			// 기존에 로그인을 한 세션 정보가 없음 -> 로그인 안 한 상태. 아이디/패스워드 검사
			if (username.equals("user")) {
				if(password.equals("user")) {
					session.setAttribute("login", true);
					session.setMaxInactiveInterval(60*60*24*5);
					response.sendRedirect(request.getContextPath()); // 로그인 했으니 메인페이지로 돌려보냄
				} else { // pw 불일치시
					String path = "/WEB-INF/jsp/account/login.jsp";
					request.setAttribute("login_error", "패스워드 틀렸습니다");
					RequestDispatcher dp = request.getRequestDispatcher(path);
					dp.forward(request, response);
				}
			} else { // 계정 불일치시
				String path = "/WEB-INF/jsp/account/login.jsp";
				request.setAttribute("login_error", "아이디가 존재하지 않습니다");
				RequestDispatcher dp = request.getRequestDispatcher(path);
				dp.forward(request, response);
			}
		} else {
			// 기존에 로그인을 한 세션 정보가 있음 -> 이미 로그인을 한 상태. 메인 페이지로 돌려보냄
			//session.setMaxInactiveInterval(60*60*24*5); // 세션 시간 재설정
			response.sendRedirect(request.getContextPath());
		}
	}

}
