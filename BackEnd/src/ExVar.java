public class ExVar {
    public static void main(String[] args) {
        final int MAX_VALUE = 100;

        int num = 5;  // 정수형 변수 선언 및 초기화
        double price = 19.99;  // 실수형 변수 선언 및 초기화
        char grade = 'A';  // 문자형 변수 선언 및 초기화
        boolean isPassed = true;  // 불린형 변수 선언 및 초기화
        String name = "John";  // 문자열 변수 선언 및 초기화

        num = 10;  // 변경가능 int num
//        MAX_VALUE = 5; // 변경 불가능 final 선언

        // 변수 값을 출력
        System.out.println("Number: " + num);
        System.out.println("Price: " + price);
        System.out.println("Grade: " + grade);
        System.out.println("Passed: " + isPassed);
        System.out.println("Name: " + name);
    }
}
