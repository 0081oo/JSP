package member;

import java.sql.*;
import java.util.ArrayList;

public class VisitDAO {
	private Connection conn = null;
	private Statement stat = null;
	
	public VisitDAO() {
		this.connect();
	}
	
	public int saveData(VisitVO data) {
		int result = 0;
		String sql = "";
		sql += "INSERT INTO visit_t(id, author, content, create_date)";
		sql += "VALUES (visit_seq.NEXTVAL, '" + data.getAuthor() + "' , '" + data.getContent()+ "' , SYSDATE)";
		
		try {
			// 저장이 됐는지 안됐는지 확인하기 위한 목적
			result = this.stat.executeUpdate(sql); // 삭제처리 완료되면 1반환
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// id가 일치하는 하나의 레코드만 가져온다
	public VisitVO getRecord(int id) {
		// SQL 질의 작성
		String sql = "SELECT * FROM visit_t WHERE id = '" + id + "'";
		
		// SQL 구문 작업용 개체 생성
		VisitVO v = null;
		try {
			// SQL 질의문 실행
			ResultSet res = this.stat.executeQuery(sql);
			
			if(res.next()) {
				v = new VisitVO(res.getInt("id"),res.getString("author"),
						res.getString("content"),res.getDate("create_date"));
			}

			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("SQL Query Execute 완료");
	
		return v;
	}
	
	// 모든 레코드 가져온다
	public ArrayList getAll() {
		ArrayList<VisitVO> records = new ArrayList(); 
		
		// SQL 질의 작성
		String sql = "SELECT * FROM visit_t";
		
		// SQL 구문 작업용 개체 생성
		VisitVO v = null;
		try {
			// SQL 질의문 실행
			ResultSet res = this.stat.executeQuery(sql);
			
			while(res.next()) {
				v = new VisitVO(res.getInt("id"),res.getString("author"),
						res.getString("content"),res.getDate("create_date"));
				records.add(v);
			}

			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return records;
	}
	
	public int deleteData(int id) {
		int result = 0; // 저장이 됐는지 안됐는지 확인하기 위한 목적
		String sql = "";
		sql += "DELETE FROM visit_t";
		sql += " WHERE id = " + id; // WHERE 앞 띄어쓰기 필수
		
		try {
			result = this.stat.executeUpdate(sql); // 삭제 완료되면 1 반환
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// prepareStatement? 다시 공부
	public int updateData(VisitVO data) {
		int result = 0;
		String sql = "";
		sql += "UPDATE visit_t";
//		sql += "SET content = ?, author=? WHERE id=?";
		sql += "SET content = " + data.getContent() + "WHERE id=" + data.getId();
		
		try {
			result = this.stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private void connect() {
		try {
			// JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC DRIVER 로딩 완료");
			
			// 접속정보
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "web_admin";
			String password = "web_admin";
			
			// DB 접속객체 생성, 접속시도
			this.conn = DriverManager.getConnection(url, user, password);
			System.out.println("Oracle DB 접속 완료");
			
			this.stat = this.conn.createStatement();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() {
		// 모든 JDBC 관련 생성 객체 정보 close
		try {
			this.stat.close();
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
