package ch20.oracle.sec05;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardWithFileInsertExample {

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
			
			String sql = "DELETE from boards WHERE bwriter=?";
			

			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "winter");
			
			int rows = pstmt.executeUpdate();
			System.out.println("수정된 행 수: "+ rows);
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
