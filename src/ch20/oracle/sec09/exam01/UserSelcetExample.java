package ch20.oracle.sec09.exam01;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSelcetExample {

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
			
			String sql = "SELECT bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata FROM boards WHERE bwriter=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"winter");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board b = new Board();
				b.setBno(rs.getInt("bno"));
				b.setBtitle(rs.getString("btitle"));
				b.setBcontent(rs.getString("bcontent"));
				b.setBwrite(rs.getString("bwriter"));
				b.setBdate(rs.getDate("bdate"));
				b.setBfileName(rs.getString("bfilename"));
				b.setBfiledata(rs.getBlob("bfiledata"));
				System.out.println(b);
				
				
				Blob blob = b.getBfiledata();
				if(blob != null) {
					InputStream is = blob.getBinaryStream();
					OutputStream os = new FileOutputStream("D:/Temp/" + b.getBfileName());
					is.transferTo(os);
					os.flush();
					os.close();
					is.close();
				}
			}
			rs.close();
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
