package javastudy.inheritance;

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    void sound(){
        System.out.println("동물소리");
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    void bark(){
        System.out.println(name + " 멍멍");
    }

    @Override
    void sound() {
        System.out.println("멍멍이다~");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("바둑이");
        Animal dogs = new Dog("바둑이");
        System.out.println(dog instanceof Animal ? "Animal의 인스턴스임." : "Animal의 인스턴스가 아님.");
//        dog.name = "바둑이";
        dog.bark();
        dog.sound();    // 동물소리가 아닌 override 된 멍멍이다 로 나옴
    }
}
