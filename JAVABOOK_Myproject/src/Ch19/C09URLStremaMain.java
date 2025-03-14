package Ch19;

import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class C09URLStremaMain {

	public static void main(String[] args) throws URISyntaxException, IOException {
		URL url = (new URI("https://n.news.naver.com/mnews/article/001/0015264907?rc=N&ntype=RANKING")).toURL(); // URI로 받고 그걸 URL로 변환
		InputStream in = url.openStream(); //inputstream으로 업스케일링

		// 보조 스트림 추가(Ch20에서 실행)
		BufferedInputStream bufferIn = new BufferedInputStream(in); // InputStream에 buffer기능을 추가
		Reader rin = new InputStreamReader(bufferIn); // byte -> char 변환
		Writer out = new FileWriter("C:\\IOTEST\\index.html");
//		OutputStream out = new FileOutputStream("C:\\IOTEST\\index.html");

		while (true) {
			int data = rin.read();//(char)rin을 int형으로 변환
			if (data == -1) {
				break;
			}
			System.out.print((char) data);
			out.write((char) data);
			out.flush();
		}
		rin.close();
		bufferIn.close();
		in.close();
		out.close();		
	}
}