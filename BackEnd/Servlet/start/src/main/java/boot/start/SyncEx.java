package boot.start;

import java.sql.SQLOutput;

public class SyncEx {

    public static void main(String[] args) {
        System.out.println("동기 작업 시작");
        String result = performSync();
        System.out.println("동기 작업 완료");
        System.out.println("동기 작업 결과 확인: " + result);
    }

    private static String performSync(){
        try{
            Thread.sleep(2000);
            System.out.println("작업중....");
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        return "동기 작업 결과";
    }
}
