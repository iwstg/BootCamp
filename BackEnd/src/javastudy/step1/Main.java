package javastudy.step1;
import javastudy.accessmodifier.SmartPhone;

public class Main {
    public static void main(String[] args) {
        /**
         * Person은 Class. 이 클래스로 만든 person1은 인스턴스
         * Class는 메모리를 차지하지 않음. 인스턴스는 메모리를 차지함.
         * 정적 필드는 static 으로 선언해서 클래스 자체에 소속되게됨 (인스턴스에서 접근 x)
         */
        System.out.println(Person.region); // 클래스 자체에서 접근 가능한 값
        System.out.println(Person.whereLive());
        Person person1 = new Person();
        person1.sayHello(); // 값을 받기 전 결과값
        System.out.println(person1.region); // 오류 (초보를 위해 자동으로 Person.region으로 컴파일해줌.)
        System.out.println(person1.whereLive()); // 오류 (그래서 해당 결과값이 정상적으로 나오는것처럼 보임)

        person1.name= "홍길동";
        person1.age= 30;
        person1.height= 160;
        person1.sayHello();

        // 생성자 오버로딩
        Person person2 = new Person("김철수", 10, 100);
        person2.sayHello();


        int sum = MathUtils.add(5, 3);
        int product = MathUtils.multiply(6,3);
        System.out.printf("합: %d 곱: %d%n",sum,product);

        User user1 = new User("사람1");
        User user2 = new User("사람2");
        User user3 = new User("사람3");
        System.out.println(User.getUserCnt()); // 3 (생성된 모든 인스턴스의 총합)
        System.out.println(user1.getInsUserCnt()); // 1 (인스턴스 내에서 초기화된 값+1)
        System.out.println(user2.getInsUserCnt()); // 1
        System.out.println(user3.getInsUserCnt()); // 1

        SmartPhone phone = new SmartPhone();
        //System.out.println(phone.model); // public이 아니라 안됨
        System.out.println(phone.sdCard); // public이라 가능
        // System.out.println(phone.cpu); // private라 안됨
        //System.out.println(phone.os);
    }
}
