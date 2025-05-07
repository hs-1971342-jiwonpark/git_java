//커넥션 상수를 모아두기 위한 클래스로, abstract를 이용해서 인스턴스 생성을 방지해야 한다.


public abstract class ConnectionConst {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521/xe"; //자신의 db 정보 넣어야함.
	public static final String USERNAME = "jiwon"; //자기 db 정보들 넣기
	public static final String PASSWORD = "test1234"; //자기 db 정보들 넣기
}