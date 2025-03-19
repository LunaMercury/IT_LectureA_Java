package Ch30.C01생성패턴;


class Singleton {
    private static Singleton instance;

    private Singleton() {
        // private 생성자
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
public class C01싱글톤패턴 {
	public static void main(String[] args) {
		
	}
}
