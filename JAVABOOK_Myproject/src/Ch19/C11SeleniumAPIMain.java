// 사람행동과 유사한 크롤링 봇

package Ch19;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.UUID;

import org.jsoup.select.Evaluator.Id;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//크롬서버.jar 다운로드 경로(셀레니움 공식 홈페이지)
//https://www.selenium.dev/downloads/

//크롬드라이브 다운로드 경로
//https://googlechromelabs.github.io/chrome-for-testing/#stable

public class C11SeleniumAPIMain {

	private static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 데이터베이스 관리를 위한 ID 지정
	private static final String WEB_DRIVER_PATH = "src/Drivers/chromedriver.exe"; // 위와 유사

	public static void main(String[] args) throws IOException {

		// 브라우저 옵션
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless"); 		// 백그라운드에서 실행. 이게 있으면 화면이 안뜨고 백그라운드에서만 실행된다.
//		options.addArguments("--no-sandbox"); 		// 리눅스 환경에서 sendbox 사용여부

		// 브라우저 동작
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.naver.com");

		// 특정 위치 요소 선택(키워드 입력하기)
		WebElement searchEl = driver.findElement(By.id("query"));

		// 키워드 입력
		searchEl.sendKeys("asus 노트북");
		// 엔터키 전달
		searchEl.sendKeys(Keys.RETURN);

		// 노트북 검색 이후 쇼핑 버튼 클릭
		WebElement shoppingBtnEl = driver.findElement(By.cssSelector("#lnb .tab:first-child"));
		// 새창열기 제거
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('target')", shoppingBtnEl);

		shoppingBtnEl.click();

//		네이버포털 -> '노트북'검색 -> 쇼핑 클릭-> MSI 노트북(엔터)
//				WebElement itemsHeaderEl =  driver.findElement(By.cssSelector("._searchInput_search_text_3CUDs"));
//				itemsHeaderEl.sendKeys("MSI 노트북");
//				itemsHeaderEl.sendKeys(Keys.RETURN);

		// 네이버포털 -> 'MSI노트북'검색 -> 쇼핑 클릭-> msi게이밍노트북 클릭
		WebElement optionchooseEl = driver.findElement(By.partialLinkText("asus게이밍노트북"));
		optionchooseEl.click();

//		//네이버포털 -> 'MSI노트북'검색 -> 쇼핑 클릭-> msi게이밍노트북 -> 리뷰 많은순 클릭
		List<WebElement> Els = driver.findElements(By.cssSelector(".subFilter_sort__lhuHl"));
//		System.out.println(Els);
		Els.forEach(el -> {
			if (el.getText().contains("리뷰 많은순"))
				el.click();
		});

		// 영역내 모든 정보 긁어오기 basicList_list_basis__uNBZx
		List<WebElement> El2s = driver.findElements(By.cssSelector(".basicList_list_basis__uNBZx"));
//		System.out.println(El2s);

//		//파일로 저장
		Writer out = new FileWriter("C:\\IOTEST\\Selenium_test\\" + UUID.randomUUID() + ".html");

		// HTML 기본 구조 작성
		StringBuilder htmlContent = new StringBuilder();
		htmlContent.append("<!DOCTYPE html>\n");
		htmlContent.append("<html lang=\"ko\">\n");
		htmlContent.append("<head>\n");
		htmlContent.append("<meta charset=\"UTF-8\">\n");
		htmlContent.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
		htmlContent.append("<title>네이버 쇼핑 검색 결과</title>\n");

		// css link 빼내오기
		List<WebElement> cssLinks = driver.findElements(By.tagName("link"));
		for (WebElement link : cssLinks) {
			String rel = link.getAttribute("rel");
			if (rel.equals("stylesheet")) {
				String href = link.getAttribute("href");
				System.out.println("CSS 링크 : " + href);
				htmlContent.append("<link rel=\"stylesheet\" href=\"").append(href).append("\">\n");

			}
		}
		htmlContent.append("</head>\n");
		htmlContent.append("<body>\n");

		// 본문내용
		for (WebElement el : El2s) {
			String elHTML = el.getAttribute("outerHTML");
			htmlContent.append(elHTML).append("\n");

		}
		htmlContent.append("</body>\n");
		htmlContent.append("</html>");

		// 파일에 저장
		out.write(htmlContent.toString());

		out.flush();
		out.close();

	}

}
