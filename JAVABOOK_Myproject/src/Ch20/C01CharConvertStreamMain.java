// test.txt에 글 쓰기
// test.txt에 무슨 글 있는지 읽어오긴

package Ch20;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class C01CharConvertStreamMain {

	public static void main(String[] args) throws Exception {
		String str = "문자 변환 스트림 사용";

		// 데이터 입력
		OutputStream out = new FileOutputStream("c:\\IOTEST\\test.txt");
		OutputStreamWriter wout = new OutputStreamWriter(out);
		BufferedWriter bout = new BufferedWriter(wout);
		bout.write(str);
		bout.flush();
		bout.close();

		// 데이터 읽기
		InputStream in = new FileInputStream("c:\\IOTEST\\test.txt");
		BufferedInputStream bin = new BufferedInputStream(in);
		InputStreamReader rin = new InputStreamReader(bin);
		while (true) {
			int data = rin.read();
			if (data == -1)
				break;
			System.out.print((char) data);
		}
	}
}