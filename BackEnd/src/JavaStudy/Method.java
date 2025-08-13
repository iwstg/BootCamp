package JavaStudy;

public class Method {
    public static void main(String[] args) {
        greet("철수");
        greet("철수", 10);
        greet("철수", "오후 2시");

        // int같은 매개변수를 보낼경우 해당 값 자체가 날아가 원본의 값 변경 없음
        int num = 5;
        greet(num);
        System.out.println(num);

        // 배열을 매개변수로 받아올경우 참조되어 값을 변경하면 실제 값이 변경됨
        int[] numArr = { 1, 2, 3};
        greet(numArr);
        System.out.println(numArr[0]);

    }

    public static void greet(String name){
        System.out.println("hello " + name);
    }

    public static void greet(String name, int age){
        System.out.println("hello " + name + ". 나이: " + age);
    }

    public static void greet(String name, String time){
        System.out.println("hello " + name + ". " + time + "입니다.");
    }

    public static void greet(int number){
        number = 1;
        System.out.println("greet내부 "+number);
    }

    public static void greet(int[] array){
        array[0]= 10;
        System.out.println("greet내부 array[0] " +array[0]);
    }
}
