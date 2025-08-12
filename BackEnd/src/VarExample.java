public class VarExample {
    public static void main(String[] args) {
        var num = 10;
        var text = "dd";
        var decimal = "3.24";

        System.out.println("num = " + num);
        System.out.println("text = " + text);
        System.out.println("decimal = " + decimal);

        var numbers = new int[]{1,2,3};
        for (var n : numbers) {
            System.out.print(n+" ");
        }

//        var arr = {1, 2, 3};  // var는 무슨 자료형인지 알려줘야함
    }
}
