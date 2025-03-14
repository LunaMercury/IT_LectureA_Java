// OPENWEATHER MAP API 를 이용해서 날씨 정보 받아옵니다 
//(https://openweathermap.org/api/one-call-3)

package Ch19;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class C13Ex {

	public static void main(String[] args) throws IOException, InterruptedException {

		// url 형식
		// =https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API
		// key}
		// key}";
		String lat = "35.8658";
		String lon = "128.5937";
		String myAPIkey = "eeb24c2ff7258fcf9a81e91fe210a2a7"; // 저장하지 않는 것이 좋다.

		String url = "https://api.openweathermap.org/data/2.5/weather?" + "lat=" + lat + "&lon=" + lon + "&appid="
				+ myAPIkey;

		// Http Request 객체 생성
		HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

		// Http Request(요청)
		HttpClient httpClient = HttpClient.newHttpClient();

		// htto response(응답)
		HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString()); // 이 데이터가 기준

//		System.out.println(response.body());

		// Json 데이터 가공 및 추출
		ObjectMapper objectMapper = new ObjectMapper();

		JsonNode jsonNode = objectMapper.readTree(response.body());
		JsonNode weather = jsonNode.get("weather").get(0).get("main");

		System.out.println("Json 출력 : " + weather);

		// Class로 가공
		Data.Root weatherEl = objectMapper.readValue(response.body(), Data.Root.class);
		System.out.println("Class로 출력 : " + weatherEl.weather.get(0).main);

	}

	public static class Data {

		public static class Clouds {
			public int all;

			Clouds() {
			};

			public Clouds(int all) {
				super();
				this.all = all;
			}

			@Override
			public String toString() {
				return "Clouds [all=" + all + "]";
			}

		}

		public static class Coord {
			public double lon;
			public double lat;

			public Coord() {
			}

			public Coord(double lon, double lat) {
				super();
				this.lon = lon;
				this.lat = lat;
			}

			public double getLon() {
				return lon;
			}

			public void setLon(double lon) {
				this.lon = lon;
			}

			public double getLat() {
				return lat;
			}

			public void setLat(double lat) {
				this.lat = lat;
			}

		}

		public static class Main {
			public double temp;
			public double feels_like;
			public double temp_min;
			public double temp_max;
			public int pressure;
			public int humidity;
			public int sea_level;
			public int grnd_level;

			@Override
			public String toString() {
				return "Main [temp=" + temp + ", feels_like=" + feels_like + ", temp_min=" + temp_min + ", temp_max="
						+ temp_max + ", pressure=" + pressure + ", humidity=" + humidity + ", sea_level=" + sea_level
						+ ", grnd_level=" + grnd_level + "]";
			}

			public Main() {
			}

			public Main(double temp, double feels_like, double temp_min, double temp_max, int pressure, int humidity,
					int sea_level, int grnd_level) {
				super();
				this.temp = temp;
				this.feels_like = feels_like;
				this.temp_min = temp_min;
				this.temp_max = temp_max;
				this.pressure = pressure;
				this.humidity = humidity;
				this.sea_level = sea_level;
				this.grnd_level = grnd_level;
			}

		}

		public static class Root {
			public Coord coord;
			public ArrayList<Weather> weather;
			public String base;
			public Main main;
			public int visibility;
			public Wind wind;
			public Clouds clouds;
			public int dt;
			public Sys sys;
			public int timezone;
			public int id;
			public String name;
			public int cod;

			@Override
			public String toString() {
				return "Root [coord=" + coord + ", weather=" + weather + ", base=" + base + ", main=" + main
						+ ", visibility=" + visibility + ", wind=" + wind + ", clouds=" + clouds + ", dt=" + dt
						+ ", sys=" + sys + ", timezone=" + timezone + ", id=" + id + ", name=" + name + ", cod=" + cod
						+ "]";
			}

			public Root() {
			}

			public Root(Coord coord, ArrayList<Weather> weather, String base, Main main, int visibility, Wind wind,
					Clouds clouds, int dt, Sys sys, int timezone, int id, String name, int cod) {
				super();
				this.coord = coord;
				this.weather = weather;
				this.base = base;
				this.main = main;
				this.visibility = visibility;
				this.wind = wind;
				this.clouds = clouds;
				this.dt = dt;
				this.sys = sys;
				this.timezone = timezone;
				this.id = id;
				this.name = name;
				this.cod = cod;
			}

		}

		public static class Sys {
			public String country;
			public int sunrise;
			public int sunset;

			@Override
			public String toString() {
				return "Sys [country=" + country + ", sunrise=" + sunrise + ", sunset=" + sunset + "]";
			}

			public Sys() {
			}

			public Sys(String country, int sunrise, int sunset) {
				super();
				this.country = country;
				this.sunrise = sunrise;
				this.sunset = sunset;
			}

		}

		public static class Weather {
			public int id;
			public String main;
			public String description;
			public String icon;

			@Override
			public String toString() {
				return "Weather [id=" + id + ", main=" + main + ", description=" + description + ", icon=" + icon + "]";
			}

			public Weather() {
			}

			public Weather(int id, String main, String description, String icon) {
				super();
				this.id = id;
				this.main = main;
				this.description = description;
				this.icon = icon;
			}

		}

		public static class Wind {
			public double speed;
			public int deg;
			public double gust;

			@Override
			public String toString() {
				return "Wind [speed=" + speed + ", deg=" + deg + ", gust=" + gust + "]";
			}

			public Wind() {
			}

			public Wind(double speed, int deg, double gust) {
				super();
				this.speed = speed;
				this.deg = deg;
				this.gust = gust;
			}

		}

	}
}