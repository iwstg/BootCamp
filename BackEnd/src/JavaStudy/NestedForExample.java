package JavaStudy;

public class NestedForExample {
    public static void main(String[] args) {
        // 중첩 for
//        for ( int dan = 2; dan <= 9; dan++) {
//            System.out.println("--"+dan+"  단--");
//            for ( int i = 1; i <= 9; i++ ) {
//                System.out.println(dan + " X " + i + " = " + dan * i);
//            }
//            System.out.println();
//        }

        // do-while
//        int i = 6;
//        do {
//            System.out.println(i);
//            i++;
//        }while(i<5);

        // while 버전
        int i = 1;
        while( i<= 5){
            System.out.print(i + " ");
            i++;
        }
        System.out.println();

        // for 버전
        for(int k=1; k<=5; k++){
            System.out.print(k + " ");
        }
        System.out.println();

        // do-while 버전
        int j = 1;
        do{
            System.out.print(j + " ");
            j++;
        }while(j<= 5);
    }
}
