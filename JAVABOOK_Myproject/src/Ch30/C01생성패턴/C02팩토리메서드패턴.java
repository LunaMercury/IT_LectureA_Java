package Ch30.C01생성패턴;

//여기 설명 주석 추가해줘   
//팩토리 메서드 패턴은 객체 생성을 서브클래스에서 결정하도록 하는 디자인 패턴입니다. 
//이 패턴은 객체 생성 로직을 분리하고 서브클래스에서 구체적인 구현을 결정하도록 합니다.

/* 팩토리 메서드 패턴의 실제 활용 예시:
 * 
 * 1. UI 컴포넌트 생성
 *    - 운영체제별 다른 버튼, 윈도우 생성 (Windows/Mac/Linux)
 *    - 프레임워크별 다른 위젯 생성 (Android/iOS)
 * 
 * 2. 데이터베이스 연결
 *    - 다양한 DBMS 연결 객체 생성 (MySQL/Oracle/PostgreSQL)
 *    - ORM 프레임워크의 DB 드라이버 생성
 * 
 * 3. 파일 처리
 *    - 다양한 파일 형식 파서 생성 (XML/JSON/CSV)
 *    - 문서 변환기 생성 (PDF/Word/Excel)
 * 
 * 4. 네트워크 통신
 *    - 프로토콜별 커넥션 객체 생성 (HTTP/FTP/SMTP)
 *    - 소켓 통신 객체 생성 (TCP/UDP)
 * 
 * 5. 게임 개발
 *    - 레벨별 적 캐릭터 생성
 *    - 게임 아이템/무기 생성
 */



//팩토리메서드 패턴
//- 객체생성은 서브클래스에서 하도록 

abstract class Animal {
    public abstract void sound();
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("야옹");
    }
}

//팩토리 Interface,상속관계의 모든 Factoray객체를 받음 
interface AnimalFactory 
{
    Animal createAnimal();	//추상메서드
}

class DogFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}



public class C02팩토리메서드패턴 {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();
        dog.sound(); // 멍멍

        AnimalFactory catFactory = new CatFactory();
        Animal cat = catFactory.createAnimal();
        cat.sound(); // 야옹
    }
}


