package com.web.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.account.db.AccountDAO;
import com.web.account.db.AccountVO;

@WebServlet("/")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MainServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// mybatis 테스트하려고 작성한 코드 - 시작
		// 로그인한 사용자 게정 정보를 마이바티스로 조회하기
		HttpSession session = request.getSession();
		if((boolean)session.getAttribute("logined")) {
			if(((AccountVO)session.getAttribute("account")).getId() > 0) {
				AccountDAO dao = new AccountDAO();
				AccountVO data = dao.select();
				System.out.println("로그인 계정 : " + data.getNickname());
			}
		}
		// mybatis 테스트하려고 작성한 코드 - 끝
		
		String path = "/WEB-INF/jsp/main.jsp";
		RequestDispatcher dp = request.getRequestDispatcher(path);
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
