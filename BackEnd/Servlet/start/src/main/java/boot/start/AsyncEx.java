package boot.start;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncEx {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("비동기 작업 시작");

        CompletableFuture<String> future1 = performTest("작업1", 5000);
        CompletableFuture<String> future2 = performTest("작업2", 1000);

        System.out.println("작업 수행중... ");
        String result1 = future1.get();
        String result2 = future2.get();

        System.out.println(result1);
        System.out.println(result2);

        System.out.println("비동기 작업 완료");
    }

    private static CompletableFuture<String> performTest(String testName, int delay){
        return CompletableFuture.supplyAsync(() -> {
            try{
                Thread.sleep(delay);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            return testName + "결과 반환";
        });
    }
}
