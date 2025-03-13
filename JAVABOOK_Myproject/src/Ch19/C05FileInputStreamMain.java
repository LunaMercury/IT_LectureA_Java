// 소요시간 비교

package Ch19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.BindException;

public class C05FileInputStreamMain {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		InputStream fin = new FileInputStream("C:\\IOTEST\\data.xlsx");
		StringBuffer stringBuffer = new StringBuffer();

		// fin.read()로 확인
		long sTime1 = System.currentTimeMillis();
		while (true) {
			int data = fin.read();
			if (data == -1) {
				break;
			}
//			System.out.print((char) data);
		}
		long eTime1 = System.currentTimeMillis();
		System.out.println("fin.read()의 소요시간 : " + (eTime1 - sTime1) + "ms");

		// read([])로 확인
		byte[] buf = new byte[1024];
		long sTime2 = System.currentTimeMillis();
		// fin.read()로 확인
		while (true) {
			int data = fin.read(buf);
			if (data == -1) {
				break;
			}
//			System.out.print((char) data);
		}
		long eTime2 = System.currentTimeMillis();
		System.out.println("read([])의 소요시간 : " + (eTime2 - sTime2) + "ms");

	}
}