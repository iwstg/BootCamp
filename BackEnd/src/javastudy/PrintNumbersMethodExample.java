package javastudy;

public class PrintNumbersMethodExample {
    public static void printNumbers(String message, int... numbers) {
        System.out.println(message);
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printAverage(String message, double... numbers) {
        System.out.println(message);

        double sum = 0;
        for (double score : numbers) {
            sum += score;
        }
        double average = sum / numbers.length;

        System.out.println(message + " 평균 점수: " + average);
        System.out.printf("%s 평균점수: %.2f %n", message, average);
    }

    public static void main(String[] args) {
        printNumbers("숫자 목록:", 1, 2, 3, 4);  // 출력: 숫자 목록: 1 2 3 4
        printNumbers("한 개의 숫자:", 7);        // 출력: 한 개의 숫자: 7
        printNumbers("숫자가 없습니다.");         // 출력: 숫자가 없습니다.

        printAverage("");
    }

}
