import java.util.Arrays;

public class TwoDimArrayPracitce {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        int num = 5;
        modifyArray(numbers);
        modifyNum(num);
        System.out.println("num = " + num);
        System.out.println("Arrays.toString() = " + Arrays.toString(numbers));
    }

    public static void modifyArray(int[] arry){ arry[1] = 999; }
    public static void modifyNum(int num){ num = 3;}
}
