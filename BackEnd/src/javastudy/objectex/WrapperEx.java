package javastudy.objectex;

public class WrapperEx {
    public static void main(String[] args) {

        int num = 5;
        Integer wrapperInt = Integer.valueOf(num);

        int unboxedInt = wrapperInt.intValue();

        System.out.println("wrappeInt = " + wrapperInt);
        System.out.println("unboxedInt = " + unboxedInt);

        /**
         * Java에서 박싱 / 언박싱은 오토로 됨. 아래 코드는 위 코드와 똑같이 동작함
         */

        Integer autowrapperInt = num;
        int autounboxedInt = autowrapperInt;
        System.out.println("autowrapperInt = " + autowrapperInt);
        System.out.println("autounboxedInt = " + autounboxedInt);
    }
}
