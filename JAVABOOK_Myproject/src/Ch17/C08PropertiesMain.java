// 파일위치 불러오기
// 파일 내 자료 가져오기

package Ch17;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class C08PropertiesMain {

	public static void main(String[] args) throws IOException {

		// 자바 설치 위치 확인(?)
		String classPath = System.getProperty("java.class.path");
		System.out.println("classPath : " + classPath);
		// 작업 경로 확인
		String dirPath = System.getProperty("user.dir");
		System.out.println("dirPath : " + dirPath);
		// 패키지명 확인
		String packagePath = C08PropertiesMain.class.getPackageName();
		System.out.println("packagePath : " + packagePath);
		// 파일의 최종 위치. 이 경우에는 application.properties 의 위치를 찾음
		String filePath = dirPath + File.separator + "src" + File.separator + packagePath + File.separator
				+ "application.properties";
		FileInputStream fin = new FileInputStream(filePath);

		//
		Properties properties = new Properties();
		properties.load(fin);
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		System.out.printf("%s %s %s \n", url, username, password);
	}
}