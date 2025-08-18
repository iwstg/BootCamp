package javastudy;

public class ArithmeticOperatorsExample {
    public static void main(String[] args) {
        int a = 15;
        int b = 4;

        float f1 = 7.5f;
        float f2 = 2.5f;

        double d1 = 10.0;
        double d2 = 3.0;

        System.out.println("++a = " + ++a); // 먼저 올라가 16이 출력
        System.out.println("a++ = " + a++); // 16이 출력되고나서 a = a + 1
        System.out.println("a = " + a); // 이후 a값은 17

        System.out.println("(f1 + f2) = " + (f1 + f2)); // 10.5
        System.out.println("(f1 - f2) = " + (f1 - f2)); // 5.0
        System.out.println("(f1 / f2) = " + (f1 / f2)); // 3.0
        System.out.println("(f1 * f2) = " + (f1 * f2)); // 18.75

        System.out.println("(d1 + d2) = " + (d1 + d2)); // 13.0
        System.out.println("(d1 - d2) = " + (d1 - d2)); // 7.0
        System.out.println("(d1 / d2) = " + (d1 / d2)); // 3.33333333..
        System.out.println("(d1 * d2) = " + (d1 * d2)); // 30.0

        System.out.println("a + b = " + (a + b)); // 19
        System.out.println("a - b = " + (a - b)); // 11
        System.out.println("a * b = " + (a * b)); // 60
        System.out.println("a / b = " + (a / b)); // 3
        System.out.println("a % b = " + (a % b)); // 3
    }
}