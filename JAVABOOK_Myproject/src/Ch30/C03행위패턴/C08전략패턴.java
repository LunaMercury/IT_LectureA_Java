package Ch30.C03행위패턴;
//전략 패턴 (Strategy Pattern):
//이 패턴은 실행 중에 알고리즘을 선택할 수 있도록 하는 패턴입니다. 알고리즘을 캡슐화하여 각각의 
//전략을 독립적으로 변경할 수 있으며, 클라이언트는 전략을 선택하여 사용합니다.
interface Strategy {
    int execute(int num1, int num2);
}

class AddStrategy implements Strategy {
    @Override
    public int execute(int num1, int num2) {
        return num1 + num2;
    }
}
class SubtractStrategy implements Strategy {
    @Override
    public int execute(int num1, int num2) {
        return num1 - num2;
    }
}

class MultiplyStrategy implements Strategy {
    @Override
    public int execute(int num1, int num2) {
        return num1 * num2;
    }
}

class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.execute(num1, num2);
    }
}

public class C08전략패턴 {
    public static void main(String[] args) {
        Context context = new Context(new AddStrategy());
        int result = context.executeStrategy(10, 5);
        System.out.println("Addition: " + result);

        context = new Context(new SubtractStrategy());
        result = context.executeStrategy(10, 5);
        System.out.println("Subtraction: " + result);

        context = new Context(new MultiplyStrategy());
        result = context.executeStrategy(10, 5);
        System.out.println("Multiplication: " + result);
    }
}

