package ch19.sec03.exam01;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExamole {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.0.183", 50001);
			System.out.println("[클라이언트] 연결 성공");
			socket.close();
			System.out.println("[클라이언트] 연결 끊음");
		} catch (UnknownHostException e) {
			// IP 표기 방법이 잘못되었을 경우
		} catch (IOException e) {
			// 해당 포트의 서버에 연결할 수 없는 경우
		}
	}

}
