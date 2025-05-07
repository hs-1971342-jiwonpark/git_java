package ch19.sec03.exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.0.23", 50002);
			System.out.println("[클라이언트] 연결 성공");
			
			String sendMessage = "\n0:23 ━━❚━━━━━━ 3:09\r\n"
					+ " ⇆ ⠀⠀⠀⠀⠀◃ ❚❚ ▹ ⠀⠀⠀⠀ ↻\r\n"
					+ "";
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(sendMessage);
			dos.flush();
			System.out.println("[클라이언트] 데이터 보냄: "+ sendMessage);
			socket.close();
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String receiveMessage = dis.readUTF();
			System.out.println("[클라이언트] 데이터 받음: "+ receiveMessage);
			
			System.out.println("[클라이언트] 연결 끊음");
		} catch (UnknownHostException e) {
			// IP 표기 방법이 잘못되었을 경우
		} catch (IOException e) {
			// 해당 포트의 서버에 연결할 수 없는 경우
		}
	}

}
