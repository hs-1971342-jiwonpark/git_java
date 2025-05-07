package ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {

	public static void main(String[] args) throws Exception {
		String origimalFileName = "D:/Temp/google.png";
		String targetFileName = "D:/Temp/google2.png";
		
		InputStream is = new FileInputStream(origimalFileName);
		OutputStream os = new FileOutputStream(targetFileName);
		
		byte[] data = new byte[1024];
		while(true) {
			int num = is.read(data);
			if(num == -1) break;
			os.write(data,0,num);
		}
		
		os.flush();
		os.close();
		is.close();
		
		System.out.println("복사 완료");
	}

}
