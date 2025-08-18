package javastudy.genericex;

class Box<T>{
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

// Bounded Generic ( Number로 자료형을 숫자로 제한함 )
class Calculator<T extends Number>{

    public double add(T num1, T num2){
        return num1.doubleValue() + num2.doubleValue();
    }
}

public class GenericDemo {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.setItem(11);
        int value = intBox.getItem();
        System.out.println(value);

        Box<String> StringBox = new Box<>();
        StringBox.setItem("ss");
        String text = StringBox.getItem();
        System.out.println(text);

        Calculator<Integer> intCal = new Calculator<>();
        System.out.println(intCal.add(1,2));

        Calculator<Double> douCal = new Calculator<>();
        System.out.println(douCal.add(1.1,2.2));

        /*
        Calculator<String> strCal = new Calculator<>();
        System.out.println(strCal.add("1","2"));

        오류 발생:
        java: type argument java.lang.String is not within bounds of type-variable T
         */
    }
}
