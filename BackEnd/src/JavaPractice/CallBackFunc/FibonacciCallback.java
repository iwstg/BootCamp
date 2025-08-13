package JavaPractice.CallBackFunc;

/**
 * 2025-08-13
 * 과제 1. 재귀메소드로 피보나치 수열 구현해보기
 */
public class FibonacciCallback {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(Fibonacci(6));
    }

    public static int Fibonacci(int number){
        if (number == 0){
            return 0;
        }else if (number == 1 || number == 2){
            return 1;
        }
        return Fibonacci(number-1) + Fibonacci(number-2);
    }

    public static int factorial(int number) {
        if(number == 1)  return 1;

        return number * factorial(number-1);
    }
}
