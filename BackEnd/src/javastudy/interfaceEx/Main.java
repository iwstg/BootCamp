package javastudy.interfaceEx;

abstract class Animal {
    abstract void sound();
    void sleep(){
        System.out.println("동물이 잠을 잡니다");
    }
}

interface Moveable {
    void move();
}

class Dog extends Animal implements Moveable {
    @Override
    void sound() {
        System.out.println("멍멍");
    }

    @Override
    void sleep() {
        super.sleep();
    }

    @Override
    public void move() {
        System.out.println("뛰기");
    }
}

class Bird extends Animal implements Moveable {
    @Override
    void sound() {
        System.out.println("짹짹");
    }

    @Override
    void sleep() {
        super.sleep();
    }

    @Override
    public void move() {
        System.out.println("날기");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Bird bird = new Bird();

        dog.sound();
        dog.sleep();
        dog.move();

        bird.sound();
        bird.sleep();
        bird.move();


    }
}
