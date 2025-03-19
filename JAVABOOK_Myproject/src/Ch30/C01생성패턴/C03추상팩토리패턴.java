package Ch30.C01생성패턴;

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("원을 그립니다.");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("사각형을 그립니다.");
    }
}

interface AbstractFactory {
    Shape createShape();
}

class CircleFactory implements AbstractFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}

class RectangleFactory implements AbstractFactory {
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}
public class C03추상팩토리패턴 {
    public static void main(String[] args) {
        AbstractFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw(); // 원을 그립니다.

        AbstractFactory rectangleFactory = new RectangleFactory();
        Shape rectangle = rectangleFactory.createShape();
        rectangle.draw(); // 사각형을 그립니다.
    }
}



