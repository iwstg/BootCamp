package JavaStudy;

public class ArrayExample {
    public static void main(String[] args) {
        // 1차원 배열
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("First element: " + numbers[0]);
        System.out.println("Array length: " + numbers.length);

        // 2차원 배열
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Matrix[1][2]: " + matrix[1][2]);

        // 3차원 배열
        char[][][] trpChrAry = {
                {{'자', '축'}, {'인', '묘'}},
                {{'진', '사'}, {'오', '미'}},
                {{'신', '유'}, {'술', '해'}},
        };
        System.out.println(trpChrAry[1][1][1]);
    }
}