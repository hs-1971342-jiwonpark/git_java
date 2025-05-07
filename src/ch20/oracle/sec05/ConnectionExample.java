package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionExample {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"testuser",
					"test1234"
					);
			System.out.println("연결 성공");		
			String sql = "INSERT INTO users (userid, username, userpassword, userage, useremail) VALUES (?, ?, ?, ?, ?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "summer");
			pstmt.setString(2, "한여름");
			pstmt.setString(3, "12345");
			pstmt.setInt(4, 25);
			pstmt.setString(5, "summer@mycompany.com");
			
			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행 수: "+ rows);
			pstmt.close();
			
				
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
					System.out.println("연결 끊기");
				} catch (SQLException e) {
					
				}
			}
		}

	}
	

}
