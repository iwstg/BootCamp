package javastudy.instanceEx;

public class ScopeExample {
    private String instanceVariable = "인스턴스 변수";

    public void methodScope(){
        String methodVariable = "메서드 변수";

        if(true){
            String blockVariable = "블록 변수";
            System.out.println(blockVariable);
            System.out.println(instanceVariable);
            System.out.println(methodVariable);
        }

//        System.out.println(blockVariable); 오류
        System.out.println(instanceVariable);
        System.out.println(methodVariable);
    }

    public static void main(String[] args) {
        ScopeExample example = new ScopeExample();
        example.methodScope();

        String mainVriable = "메인 변수";
        System.out.println(mainVriable);

//        System.out.println(instanceVariable); 오류 (직접 접근 불가)
        System.out.println(example.instanceVariable);
    }
}
