package javastudy.objectex;

public class WrapperExample {
    public static void main(String[] args) {

        // 1. 기본 자료형 → Wrapper 클래스 오토박싱
        int primitiveInt = 10;
        Integer wrapperInt = primitiveInt;
        System.out.println("오토박싱된 Int = " + wrapperInt);

        // 2. Wrapper 클래스 → 기본 자료형 오토 언박싱
        Integer anotherWrapper = 20;
        int anotherWrapperInt = anotherWrapper;
        System.out.println("오토언박싱 = " + anotherWrapperInt);

        // 3. Wrapper 주요메서드
        String numberStr = "123";

        // 4. 문자 → 기본 자료형
        int parsedInt = Integer.parseInt(numberStr);
        System.out.println("문자열 -> int" + parsedInt);

        // 5. 문자 → Wrapper 자료형
        Integer valueOfInt = Integer.valueOf(numberStr);
        System.out.println("문자열 -> ");

        // 6. Wrapper → 다른 자료형
        double asDouble = valueOfInt.doubleValue();
        System.out.println("asDouble = " + asDouble);

        // 7. 상수
        System.out.println("인트 최대: " + Integer.MAX_VALUE);
        System.out.println("인트 최소: " + Integer.MIN_VALUE);

        // 8. 이퀄 비교
        Integer val1 = 10;
        Integer val2 = 10;
        System.out.println("값 비교" + val1.equals(val2));


    }
}
