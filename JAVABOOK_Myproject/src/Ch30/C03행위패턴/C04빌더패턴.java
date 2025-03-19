package Ch30.C03행위패턴;


class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String address;

    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.address = builder.address;
    }

    // Getters

    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private String address;

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}

public class C04빌더패턴 {
	public static void main(String[] args) {
		
		Person hong = new Person.Builder("Hong","GilDong")
				.setAge(30)
				.setAddress("대구")
				.build();
	}
}




