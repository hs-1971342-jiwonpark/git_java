package ch19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlEx {

	public static void main(String[] args) {
		/**
		 * 웹 상의 주소(URL)로 요청 후 
		 * 응답받은 데이터(html, json, text ...)를 입력받아
		 * 콘솔에 출력
		 */
		URL url = null;
		BufferedReader br = null;
		
		try {
			url = new URL("https://www.work24.go.kr/cm/main.do");
			System.out.println(url.getHost()); // base 주소
			System.out.println(url.getPath()); // 앤드포인트
			System.out.println(url.getProtocol()); // 프로토콜
			System.out.println(url.getPort()); // 포트
			// 바이트 스트림 -> 텍스트 스트림 리더
			// 성능 향상을 위해 버퍼 스트림 사용 (input)
			br = new BufferedReader(new InputStreamReader(url.openStream())); 
			
			String readLine = "";
			
//			while((readLine = br.readLine()) != null) {
//				System.out.println(readLine);
//			}
			
			// deprecated
//			String text = "안녕하세요";
//			String text2 = URLEncoder.encode(text);
//			System.out.println(text2);
			
			String text = "안녕하세요";
			String text2 = URLEncoder.encode(text, "UTF-8"); // UTF-8로 인코딩
			System.out.println(text2);
			String text3 = URLDecoder.decode(text2, "UTF-8"); // UTF-8로 디코딩
			System.out.println(text3);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

}
	