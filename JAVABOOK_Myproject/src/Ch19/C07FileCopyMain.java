// 파일복사

package Ch19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class C07FileCopyMain {

	public static void main(String[] args) throws Exception {
		InputStream in1 = new FileInputStream("C:\\IOTEST\\사냥개.png");
		OutputStream out1 = new FileOutputStream("C:\\IOTEST\\사냥개-copy.png");

		// 01 버퍼미사용
		long sTime1 = System.currentTimeMillis();
		while (true) {
			int data = in1.read();
			if (data == -1) {
				break;
			}
			out1.write((byte) data);
			out1.flush();
		}
		long eTime1 = System.currentTimeMillis();

		System.out.println("소요시간 : " + (eTime1 - sTime1) + "ms");
		in1.close();
		out1.close();

		// 02 버퍼 사용		
		InputStream in2 = new FileInputStream("C:\\IOTEST\\testfile.exe");
		OutputStream out2 = new FileOutputStream("C:\\IOTEST\\testfile-copy.exe");
		
		byte[] buff = new byte[4096];
		long sTime2 = System.currentTimeMillis();
		while (true) {
			int data = in2.read(buff);
			if (data == -1) {
				break;
			}
			out2.write(buff, 0, data);
			out2.flush();
		}
		long eTime2 = System.currentTimeMillis();
		System.out.println("소요시간 : " + (eTime2 - sTime2) + "ms");
		in2.close();
		out2.close();

	}
}