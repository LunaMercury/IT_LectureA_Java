package Ch08;

class TV {
	String maker;
	int productyear;
	int viewsize;

	public TV(String maker, int productyear, int viewsize) {
		super();
		this.maker = maker;
		this.productyear = productyear;
		this.viewsize = viewsize;
	}

	void show() {
		System.out.printf("%s에서 만든 %d년 %d인치", maker, productyear, viewsize).println();
	}


}	
public class C09_1TV {
	public static void main(String[] args) {
		TV myTV = new TV("LG", 2017, 32); // LG에서 만든 2017년 32인치
		myTV.show();
	}
}