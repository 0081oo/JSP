package com.web.hyun.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.web.hyun.board.db.BoardMybatis;

@WebServlet("/ajax/board/recommend")
public class BoardRecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardRecommendServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String code = request.getParameter("code");
		int count = 0;
		
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		
		HashMap<String, Boolean> board_rec_map = (HashMap)session.getAttribute("boardRec");
		if(board_rec_map == null) {
			board_rec_map = new HashMap<String, Boolean>();
		}
		
		if(board_rec_map.get(id) == null) {
			BoardMybatis dao = new BoardMybatis();
			switch(code) {
				case "g":
					dao.good(Integer.parseInt(id));
					dao.commit();
					count = dao.goodCount(Integer.parseInt(id));
					board_rec_map.put(id, true);
					break;
				case "b":
					dao.bad(Integer.parseInt(id));
					dao.commit();
					count = dao.badCount(Integer.parseInt(id));
					board_rec_map.put(id, true);
					break;
			}
			session.setAttribute("boardRec", board_rec_map);
			dao.close();
			
			json.put("res", "success");
			json.put("code", code);
			json.put("count", count);
		} else {
			json.put("res", "fail");
			json.put("message", "추천/비추천은 한 번만 할 수 있습니다.");
		}
		
		out.println(json.toJSONString());
	}

}
