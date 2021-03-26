package member;

import java.sql.*;

// DAO = Data Access Object
// db접속과 관련된 메소드 정의
public class MemberDAO {
	
	private Connection conn = null;
	private Statement stat = null;
	
	public MemberDAO() {
		this.connect();
	}
	
	public MemberVO getRecord(String userid) {
		// SQL 질의 작성
		String sql = "SELECT * FROM member_t WHERE userid = '" + userid + "'";
		
		// SQL 구문 작업용 개체 생성
		MemberVO m = null;
		try {
			// SQL 질의문 실행
			ResultSet res = this.stat.executeQuery(sql);
			
			if(res.next()) {
				m = new MemberVO(res.getString("userid"),res.getString("password"),
						res.getString("email"),res.getDate("joindate"));
			}

			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("SQL Query Execute 완료");
	
		return m;
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