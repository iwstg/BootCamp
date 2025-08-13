package JavaPractice.CallBackFunc;
public class Main {
    public static void main(String[] args) {
        BankAccount bank1 = new BankAccount("123", "John", 5000);
        BankAccount bank2 = new BankAccount("456", "김철수", 10000);
        BankAccount bank3 = new BankAccount("789", "Alice", -5000); // -금액은 0원으로 처리됨

        bank1.getBalance();                 // 5000
        bank1.dsposit(-10000);      // 비정상 접근
        bank1.getBalance();                 // 5000
        bank1.dsposit(5000);        // +5000 입금
        bank1.getBalance();                 // 10000
        System.out.println();

        bank2.getBalance();                 // 10000
        bank2.withdraw(15000);      // 잔액 초과 출금x
        bank2.getBalance();                 // 10000
        bank2.withdraw(-5000);      // 비정상 접근
        bank2.getBalance();                 // 10000
        bank2.withdraw(5000);       // -5000 출금
        bank2.getBalance();                 // 5000
        System.out.println();

        bank1.getBalance();                 // 10000
        bank3.getBalance();                 // 0 생성자 비정상값 처리
        bank1.transferTo(bank1, 5000);  // 본인에게 송금 불가
        bank1.transferTo(bank3, 5000);  // bank1 에서 bank3 으로 5000원 송금
        bank1.getBalance();                 // 5000
        bank3.getBalance();                 // 5000
    }
}
