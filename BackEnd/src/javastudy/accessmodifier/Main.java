package javastudy.accessmodifier;

public class Main {
    public static void main(String[] args) {
        SmartPhone phone = new SmartPhone();

        System.out.println(phone.model);
        System.out.println(phone.sdCard);
        // System.out.println(phone.cpu); // private라 안됨
        System.out.println(phone.os);

        phone.printInfo(); // 클래스 내부의 private는 내부 함수로 접근가능
    }
}
