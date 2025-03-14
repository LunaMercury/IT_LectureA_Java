package Ch19;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.UUID;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class C10JsoupMain {

	public static void main(String[] args) throws IOException, URISyntaxException {
		// URL 연결
		Connection conn = Jsoup.connect("https://www.op.gg/champions"); // 크롤링 함수. conn과 사이트를 연결.

		Document document = conn.get(); // con을 document화
//		System.out.println(document);

		Elements elements = document.getElementsByTag("img"); // img파일의 정보만 elements에 저장
//		System.out.println(elements);

		for (Element el : elements) {

			try {

//				System.out.println(el);
				String img_URL = el.attr("src");
//				System.out.println(img_URL);
//
				URL url = (new URI(img_URL)).toURL();
				InputStream in = url.openStream();
				BufferedInputStream buffIn = new BufferedInputStream(in); // 버퍼공간 추가
				OutputStream out = null;

				if (img_URL.contains(".png")) {
					out = new FileOutputStream("C:\\IOTEST\\crolled_images\\" + UUID.randomUUID() + ".png"); // UUID~~~는 파일 이름 랜덤화
				} else if (img_URL.contains(".svg")) {
					out = new FileOutputStream("C:\\IOTEST\\crolled_images\\" + UUID.randomUUID() + ".svg");
				} else if (img_URL.contains(".webp")) {
					out = new FileOutputStream("C:\\IOTEST\\crolled_images\\" + UUID.randomUUID() + ".webp");
				} else {
					out = new FileOutputStream("C:\\IOTEST\\crolled_images\\" + UUID.randomUUID() + ".jpg");
				}

				while (true) {
					int data = buffIn.read();
					if (data == -1) {
						break;
					}
					out.write((byte) data);
					out.flush();
				}
				out.close();
				buffIn.close();
				in.close();
			} catch (Exception e) {				
			}

		}

	}

}
