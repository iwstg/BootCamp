package JavaStudy;

public class SumMethodExample {
    public static void main(String[] args) {
        System.out.println(sum(1, 2, 3));     // 결과: 6
        System.out.println(sum(10, 20, 30));  // 결과: 60
        System.out.println(sum(5));           // 결과: 5 (매개변수가 하나일 때도 동작)
        System.out.println(sum());            // 결과: 0 (매개변수가 없을 때도 동작)
    }

    public static int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;  // 모든 숫자를 더함
        }
        return total;
    }
}
