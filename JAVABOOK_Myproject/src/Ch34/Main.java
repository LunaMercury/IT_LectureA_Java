package Ch34;

@CustomAnnotation(value = "HELLO WORLD", number = 5)
class simple{
	String v1;
	int v2;
	public simple() {	
		CustomAnnotation ref =this.getClass().getAnnotation(CustomAnnotation.class);
		System.out.println("value : "+ ref.value());
		System.out.println("value : "+ ref.number());
		this.v1 =ref.value();
		this.v2 =ref.number();
	}
	
	// toString
	@Override
	public String toString() {
		return "simple [v1=" + v1 + ", v2=" + v2 + "]";
	}
	
}

public class Main {

	public static void main(String[] args) {
		simple obj = new simple();
		System.out.println(obj);
	}
}