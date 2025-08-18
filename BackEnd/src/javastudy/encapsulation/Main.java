package javastudy.encapsulation;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        /* person 안의 내용이 public인 상태면 아래 코드가 정상 동작함.

        person.name="이름ㅁㅁㅁ";
        person.age= -10;

        System.out.println(person.name + person.age); */

        person.setName("홍길동");
        person.setAge(30);

        System.out.println(person.getName() + person.getAge());

    }
}
