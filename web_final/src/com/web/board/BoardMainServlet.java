package com.web.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.board.db.BoardDAO;
import com.web.board.db.BoardTypeVO;
import com.web.board.db.BoardVO;

@WebServlet("/board")
public class BoardMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BoardMainServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		
		ArrayList<BoardTypeVO> boardtypes = new ArrayList<BoardTypeVO>();
		ArrayList<BoardVO> boardlist = new ArrayList<BoardVO>();
		
		BoardDAO dao = new BoardDAO();
		boardtypes = (ArrayList<BoardTypeVO>) dao.getBoardTypes();
		if(type != null) {
			boardlist = (ArrayList)dao.selectList(type);
		} else {
			boardlist = (ArrayList)dao.selectList();
		}
		
		dao.close();
		
		request.setAttribute("boardtypes", boardtypes);
		request.setAttribute("boardlist", boardlist);
		
		String path = "/WEB-INF/jsp/board/main.jsp";
		RequestDispatcher dp = request.getRequestDispatcher(path);
		dp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
