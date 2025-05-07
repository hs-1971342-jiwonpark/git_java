package ch20.oracle.sec05;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardUpdateExample2 {

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
			
			String sql = "INSERT INTO boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) VALUES (SEQ_BNO.NEXTVAL, ?, ?, ?,SYSDATE ,?,?)";
			

			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno"});
			
			pstmt.setString(1, "눈 오는 날");
			pstmt.setString(2, "함박눈이 내려요");
			pstmt.setString(3, "winter");
			pstmt.setString(4, "snow.jpg");
			pstmt.setBlob(5, new FileInputStream("D:\\temp\\snow.jpg"));
			
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
