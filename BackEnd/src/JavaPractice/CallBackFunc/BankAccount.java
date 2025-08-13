package JavaPractice.CallBackFunc;
/**
 * 2025-08-13
 * 과제 2. BankAccount 클래스 만들기 (캡슐화. 검증)
 */
public class BankAccount {
    private String accountNumber;
    private String owner;
    private int balance;

    public BankAccount(String accountNumber, String owner, int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = (balance >= 0 ? balance : 0); // 생성자 초기 잔액 비정상접근 0 으로 처리
    }

    public void dsposit(int amount) {
        if(amount >= 0) {
            balance += amount;
//            System.out.printf("%s님의 계좌에 [ %d ] 원이 입금되었습니다.%n",owner, amount);
        }else{
            System.out.printf("정상적인 금액이 아닙니다.%n");
        }
    }

    public void withdraw(int amount) {
        if(amount < 0) {
            System.out.printf("정상적인 금액이 아닙니다.%n");
        }else if(amount > balance) {
            System.out.printf("잔액이 부족합니다.%n");
        }else{
            balance -= amount;
//            System.out.printf("%s님의 계좌에 [ %d ] 원이 출금되었습니다.%n",owner, amount);
        }
    }

    public void getBalance() {
        System.out.println(owner+"님의 현재 남은 잔액: "+ balance);
    }

    /**
     * (Advenced) tranksferTo 를 사용해 BankAccount 끼리 이체 기능 추가
     */

    public void transferTo(BankAccount to, int amount) {
        if(amount < 0) {
            System.out.printf("정상적인 금액이 아닙니다.%n");
        }else if(amount > balance) {
            System.out.printf("잔액이 부족합니다.%n");
        }else if(accountNumber.equals(to.accountNumber)){
            System.out.println("본인에게 송금할 수 없습니다.");
        }else {
            withdraw(amount);
            to.dsposit(amount);
            System.out.printf("[ %d ] 원을 %s 님의 계좌로 입금했습니다.%n",amount, to.owner);
        }
    }
}
