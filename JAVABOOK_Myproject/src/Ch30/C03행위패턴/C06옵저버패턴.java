package Ch30.C03행위패턴;
//옵저버 패턴 (Observer Pattern):
//이 패턴은 한 객체의 상태 변화를 관찰하는 다른 객체들에게 자동으로 알림을 전달하는 패턴입니다. 
//주체(Subject)와 관찰자(Observer)로 구성되며, 상태 변화가 발생하면 관찰자들에게 알림이 전달됩니다.

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update();
}

 class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    //상태변화시 옵저버에 알리는 작업이 포함
    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

class BinaryObserver implements Observer {
    private Subject subject;

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}

class OctalObserver implements Observer {
    private Subject subject;

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}

class HexaObserver implements Observer {
    private Subject subject;

    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()));
    }
}

public class C06옵저버패턴 {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexaObserver(subject);

        subject.setState(10);
        System.out.println();
        subject.setState(20);
    }
}
