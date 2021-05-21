package com.web.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.web.account.db.AccountDAO;

@WebServlet("/ajax/checker/email")
public class EmailCheckerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EmailCheckerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		AccountDAO dao = new AccountDAO();
		boolean res = dao.usedEmail(email);
		dao.close(); // 꼭 넣어줘야함! 안그러면 계속 시도 실행하면 데이터베이스 풀이 꽉차서 안될것임!
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
//		아래 주석친 줄들을 대신해서 이렇게 세 줄로 적을 수 있음 json-simple-1.1.1.jar 이용한 것
		JSONObject json = new JSONObject();
		json.put("result", res);
		out.println(json.toJSONString());
		
//		String json = "";
//		json += "{";
//		json += "	\"result\":" +(res == true ? "true" : "false");
//		json += "}";
//		out.println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
