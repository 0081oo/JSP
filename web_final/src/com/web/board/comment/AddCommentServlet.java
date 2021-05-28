package com.web.board.comment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.account.db.AccountVO;
import com.web.board.comment.db.CommentDAO;
import com.web.board.comment.db.CommentVO;

@WebServlet("/ajax/comment/add")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddCommentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AccountVO account = (AccountVO)session.getAttribute("account");
		String bid =request.getParameter("bid");
		String comment = request.getParameter("comment");
		
		CommentVO data = new CommentVO();
		data.setBid(bid);
		data.setContents(comment);
		data.setAid(account.getId());
		
		
		CommentDAO dao = new CommentDAO();
//		if(dao.insert(data)) {
//			// 저장 성공
//		} else {
//			// 저장 실패
//		}
//		dao.close();
	}

}
