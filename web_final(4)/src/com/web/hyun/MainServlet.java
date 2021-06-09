package com.web.hyun;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.hyun.account.db.AccountDAO;
import com.web.hyun.account.db.AccountVO;

@WebServlet("")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 마이바티스 테스트 용으로 작성된 코드 - 시작
		// 로그인한 사용자 계정 정보를 마이바티스로 조회하기.
		HttpSession session = request.getSession();
		
		if(session.getAttribute("logined") != null) {
			if(((AccountVO)session.getAttribute("account")).getId() > 0) {
				AccountDAO dao = new AccountDAO();
				AccountVO data = new AccountVO();
				data.setId(((AccountVO)session.getAttribute("account")).getId());
				data = dao.select(data);
				System.out.println("로그인 계정 : " + data.getNickname());
			}
		}
		// 마이바티스 테스트 용으로 작성된 코드 - 끝
		
		String path = "/WEB-INF/jsp/main.jsp";
		RequestDispatcher dp = request.getRequestDispatcher(path);
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
