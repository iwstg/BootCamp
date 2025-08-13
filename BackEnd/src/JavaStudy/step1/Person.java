package JavaStudy.step1;

public class Person {
    static String region = "서울";

    // 정적 메서드는 정적 필드만 가지고올 수 있음. name age height 못가져옴
    static String whereLive(){
        return "%s에 거주합니다.".formatted(region);
    }

    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public Person() {
        name = "무명";
        age = 1;
    }

    String name;
    int age;
    int height;

    public void sayHello(){
        System.out.printf("안녕하세요 제 이름은 [ %s ] 이며 나이는[ %d ]입니다. 키는[ %d ]이구요%n", name, age, height);
    }

}
