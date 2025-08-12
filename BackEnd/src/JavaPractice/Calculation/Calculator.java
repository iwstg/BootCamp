package JavaPractice.Calculation;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opretor;
        double num1, num2;
        System.out.println("과제 - 3");
        do {
            System.out.print("연산자를 입력하세요 (+, -, *, /) : ");
            opretor = sc.nextLine();
            if (!opretor.equals("+")&&!opretor.equals("-")&&!opretor.equals("*")&&!opretor.equals("/")) {
                System.out.println("연산자를 잘못입력하셨습니다. 다시 입력해주세요");
            }

        }while(!opretor.matches("[+\\-*/]")); // + - * / 가 아닐때까지 반복
        System.out.print("연산할 두 수를 공백을 두고 입력하세요 (현재 "+opretor+" 연산 ): ");
        num1 = sc.nextDouble();
        num2 = sc.nextDouble();

        switch (opretor) {
            case "+":
                System.out.println(num1 + " + " + num2 + " = "+ (num1+num2));
                break;

            case "-":
                System.out.println(num1 + " - " + num2 + " = "+ (num1-num2));
                break;

            case "*":
                System.out.println(num1 + " * " + num2 + " = "+ (num1*num2));
                break;

            case "/":
                System.out.printf("%.2f / %.2f = %.2f", num1, num2, num1/num2);
                break;

            default:
                System.out.println("연산자를 잘못 입력하셨습니다.");
                break;
        }
    }
}
