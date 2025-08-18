package javapractice.generic;

import java.util.function.Function;

class GenericBox<T>{
    T value;

    public GenericBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isPresent(){
        return value != null;
    }

    static <T> GenericBox<T> of(T value){
        return new GenericBox<>(value);
    }

    static <T> void swap(GenericBox<T> a,GenericBox<T> b){
        T Temp;
        Temp = b.getValue();
        b.setValue(a.getValue());
        a.setValue(Temp);
    }

    public <R> GenericBox<R> map(Function<? super T, ? extends R> mapper) {
        return new GenericBox<>(mapper.apply(value));
    }


}

public class Main {
    public static void main(String[] args) {
        GenericBox<Integer> box1 = new GenericBox<>(50);    // 생성자 초기화
        GenericBox<Integer> box2 = GenericBox.of(500);      // 메소드 초기화
        GenericBox<String> box3 = GenericBox.of("Summer");

        System.out.println(box1.isPresent());       // true
        System.out.println(box1.getValue());        // 50
        box1.setValue(100);
        System.out.println(box1.getValue());        // 100

        System.out.println(box2.getValue());        // 100
        GenericBox.swap(box1,box2);                 // box1의 100이 box2로, box2의 500이 box1로
        System.out.println("box 1: " + box1.getValue() + ", box 2: " + box2.getValue());

//        GenericBox.swap(box2,box3);       // 자료형 불일치 오류

        GenericBox<Double> doubox1 = box1.map(i -> i * 1.5);    // 500 * 1.5 값을 가지는 double 형태의 box 생성

        System.out.println(doubox1.getValue());     // 750.0
    }
}
