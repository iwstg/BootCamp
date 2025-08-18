package javastudy.instanceEx;


final class FinalC{
    String tt;
}

/* 아래 오류 발생. final이 붙은 class는 상속 불가
class SubClass extends FinalC{

}
*/

abstract class Animal {
    String name;

    abstract void absTest();

    void sound(){
        System.out.println("동물소리");
    }
}

class Dog extends Animal {

    void bark(){
        System.out.println(name + " 멍멍");
    }

    @Override
    void absTest() {
        System.out.println("추상 클래스 메서드 구현 DOG");
    }

    @Override
    void sound() {
        System.out.println("멍멍이다~");
    }
}

class Cat extends Animal {

    void purr(){
        System.out.println(name + " 야옹");
    }

    @Override
    void absTest() {
        System.out.println("추상 클래스 메서드 구현 CAT");
    }

    @Override
    void sound() {
//        super.sound(); // 부모 sound 함수 실행
        System.out.println("야옹이다~");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog(); // 업 케스팅
        Animal myCat = new Cat(); // 형변환 필요없음.

        myDog.absTest();
        myCat.absTest();

        myDog.sound();
        myCat.sound();

        if(myDog instanceof Dog){
            System.out.println("myDog는 Dog 인스턴스");
//          myDog.bark() << Animal으로 타입을 만들경우 bark() 함수를 쓸 수 없음.
            Dog dog = (Dog) myDog; // 다운캐스팅
            dog.name="바둑이"; dog.bark();
        }

        if(myDog instanceof Animal){
            System.out.println("myDog는 Animal 상속받은 인스턴스");
        }

        if(myDog instanceof Cat){
            System.out.println("Cat??");
        }

        Cat dog3 = (Cat) myDog; // 오류. 다운캐스팅 할 수 없음 .
        dog3.purr();

    }
}
