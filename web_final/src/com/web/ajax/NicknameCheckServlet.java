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

@WebServlet("/ajax/checker/nickname")
public class NicknameCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public NicknameCheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname = request.getParameter("nickname");
		AccountDAO dao = new AccountDAO();
		boolean res = dao.usedEmail(nickname);
		dao.close(); 
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
//		json-simple-1.1.1.jar 이용한 것
		JSONObject json = new JSONObject();
		json.put("result", res);
		out.println(json.toJSONString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
