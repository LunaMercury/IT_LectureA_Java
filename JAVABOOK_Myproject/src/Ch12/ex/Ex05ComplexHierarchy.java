package Ch12.ex;

// Exercise 5: Complex Hierarchy with Multiple Interfaces
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Bird implements Flyable {
    public void fly() {
        System.out.println("새가 날아갑니다");
    }
}

class Duck extends Bird implements Swimmable {
    public void fly() {
        System.out.println("오리가 날아갑니다");
    }
    
    public void swim() {
        System.out.println("오리가 수영합니다");
    }
    
    void quack() {
        System.out.println("오리가 꽥꽥거립니다");
    }
}

public class Ex05ComplexHierarchy {
    public static void main(String[] args) {
        System.out.println("=== 연습문제 5: 복합 계층구조 ===");
        // 문제: 다음 단계를 수행하는 코드를 작성하세요
        // 1. Duck 인스턴스를 생성하세요
        // 2. 생성한 인스턴스를 Bird, Flyable, Swimmable 타입으로 각각 업캐스팅해보세요
        // 3. 각 타입으로 업캐스팅된 참조로 사용 가능한 메서드들을 호출해보세요
        // 4. 각 타입에서 다시 Duck으로 다운캐스팅하여 quack() 메서드를 호출해보세요
        
        // 답안 예시


        
      
    }
} 