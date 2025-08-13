package JavaStudy;

public class LogicalEx {
    public static void main(String[] args) {
        boolean isRaining = true;
        boolean hasUmbrella = true;

        if( isRaining && hasUmbrella ) {
            System.out.println("비가오는데 우산이 있음 -> 나가도 됨");
        }else if( isRaining && !hasUmbrella ) {
            System.out.println("비가오는데 우산이 없음 -> 나가면 안됨");
        }else {
            System.out.println("비가 안옴 -> 나가도 됨");
        }

//        3항 연산자
        System.out.println(
            isRaining?
                hasUmbrella? "비가오는데 우산이 있음 -> 나가도 됨"
                    : "비가오는데 우산이 없음 -> 나가면 안됨"
            :
                "비가 안옴 -> 나가도 됨"
        );
    }
}