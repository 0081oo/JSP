package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 맨 처음 이대로 실행하면 c.getName()안되니까 NullPointException 발생한다 해결방법 찾아야함
		// 그래서 34줄에 c.getName() != null 추가해줌
		
		// 클라이언트가 전송한 쿠키 정보를 획득
		Cookie[] cookies = request.getCookies();
		
		// login.jsp 페이지에서 사용할 아이디 초기값을 미리 생성
		request.setAttribute("username", "");
		
		// 클라이언트가 전송한 쿠키 정보중 로그인 아이디 쿠키 정보가 있는지 검사
		for(Cookie c: cookies) {
			if(c.getName() != null && c.getName().equals("username")) {
				// 로그인 아이디 쿠키 정보를 login.jsp 페이지에서 사용할 아이디 초기값으로 설정
				request.setAttribute("username", c.getValue());
				break;
			}
		}
		
		RequestDispatcher dp = request.getRequestDispatcher("/WEB-INF/member/login.jsp");
		dp.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 기억하기가 체크되어 있으면 아이디 값을 저장한 쿠키 생성
		
		// 클라이언트가 입력한 데이터 획득
		String remember = request.getParameter("remember");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		
		Cookie[] cookies = request.getCookies();
		if(remember != null) {
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
		} else { // 기억하기 체크박스가 해제되어 있는 경우 기존 아이디 정보를 저장한 쿠키 만료시간을 0으로 변경
			for(Cookie c: cookies) {
				if(c.getName().equals("username")) {
					c.setMaxAge(0);
					response.addCookie(c);
					break;
				}
			}
		}
		
		response.sendRedirect(request.getContextPath());
	}

}
