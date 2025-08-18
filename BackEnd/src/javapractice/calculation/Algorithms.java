package javapractice.calculation;

import java.util.ArrayList;
import java.util.Scanner;

public class Algorithms {
    public static void main(String[] args) {
        /**
         * 1 부터 N까지의 짞수 합과 홀수 합 구현하기 (반복문 사용
         * Advenced - Scanner 사용
         */
        System.out.println("과제 - 1");
        Scanner sc = new Scanner(System.in);
        System.out.print("1부터 N 까지의 짝수합과 홀수합을 계산합니다. N : ");
        int N = sc.nextInt();
        int odd = 0 , even = 0;
        for (int i = 1; i <=  N; i++) {
            if(i%2==0) even += i;
            else odd += i;
        }
        System.out.println("1부터 "+N+"까지의 홀수 합 = " + odd);
        System.out.println("1부터 "+N+"까지의 짝수 합 = " + even);



        /**
         * 여러 숫자의 합과 평균 구하기 (가변인자 사용)
         * Advenced - Scanner 사용
         */
        System.out.println("과제 - 2 ");
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("숫자가 아닌 값이 입력될 경우 종료합니다.");
        while(true){
            System.out.print("숫자들을 입력해주세요. : ");
            if(!sc.hasNextInt()) break;
            list.add(sc.nextInt());
        }
        sc.close();
        SumAndAverage(list.stream().mapToInt(i->i).toArray()); // Java 8 스트림 mapToInt 사용 (ArrayList -> int[ ] 변환)

    }
    public static void SumAndAverage(int... numbers){
        int sum = 0;
        double avg = 0;
        for(int nums : numbers){
            sum += nums;
        }
        avg = (double)sum/numbers.length;


        System.out.printf("{ 합 : %d, 평균 : %.2f }", sum, avg);

    }
}
