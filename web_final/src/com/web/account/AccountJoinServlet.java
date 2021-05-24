package com.web.account;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.account.db.AccountDAO;
import com.web.account.db.AccountVO;

@WebServlet("/account/join")
public class AccountJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AccountJoinServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/jsp/account/join.jsp";
		RequestDispatcher dp = request.getRequestDispatcher(path);
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// account/login 으로 리다이렉트
		String username = request.getParameter("username");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		
//		System.out.println("username : " + username);
//		System.out.println("nickname : " + nickname);
//		System.out.println("email : " + email);
//		System.out.println("password : " + password);
//		System.out.println("gender : " + gender);
//		System.out.println("age : " + age);
		
		AccountVO data = new AccountVO();
		data.setUsername(username);
		data.setNickname(nickname);
		data.setEmail(email);
		data.setPassword(password);
		data.setGender(gender);
		data.setAge(age);
		
		AccountDAO dao = new AccountDAO();
		boolean res = dao.join(data);
		dao.close();
		if(res) {
			// 가입 완료 -> 로그인 페이지로 이동 시켜줌
			response.sendRedirect(request.getContextPath() + "/account/login");
		} else {
			// 가입 실패
			request.setAttribute("error", "회원가입 실패");
			String path = "/WEB-INF/jsp/account/join.jsp";
			RequestDispatcher dp = request.getRequestDispatcher(path);
			dp.forward(request, response);
		}
		
	}

}
