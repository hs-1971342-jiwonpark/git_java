import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MariadbExample {

	private Scanner scanner = new Scanner(System.in);
	private Connection conn;

	public MariadbExample() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			final String DB_IP = "localhost";
			final String DB_PORT = "3306";
			final String DB_NAME = "study";
			final String DB_URL = 
					"jdbc:mariadb://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME;
			conn = DriverManager.getConnection(DB_URL,"testuser","test1234");
			System.out.println("마리아 db연결 성공");
			list();
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
	}

	public static void main(String[] args) {
		MariadbExample be = new MariadbExample();
	}

	public void list() {
		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println("---------------------------------------------------------------------");
		System.out.printf("%-12s%-16s%-16s%-12s%-12s\n", "studno", "name", "tel", "major", "professor");
		System.out.println("---------------------------------------------------------------------");

		try {
			String sql = "SELECT s.studno, s.name, s.tel, m.name AS major_name, p.name AS prof_name "
			           + "FROM student s "
			           + "LEFT JOIN professor p ON s.profno = p.no "
			           + "LEFT JOIN major m ON s.major1 = m.code";			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setSno(rs.getInt("studno"));
				student.setName(rs.getString("s.name"));
				student.setPhone(rs.getString("tel"));
				student.setMajor(rs.getString("major_name"));
				String prof = rs.getString("prof_name");
				student.setProfessor(prof == null ? "지도교수 없음" : prof);
				System.out.printf("%-12s%-12s%-16s%-12s%-12s\n", 
						student.getSno(), 
						student.getName(), 
						student.getPhone(),
						student.getMajor(),
						student.getProfessor());
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			exit();
		}

	}


	public void exit() {
		if(conn != null) {
			try {
				conn.close();
			}catch (Exception e) {

			}
		}
		System.out.println("** 게시판 종료 **");
		System.exit(0);
	}
}
