package boot.start;

import org.apache.el.parser.AstFalse;
import org.springframework.util.Assert;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class HashMapEx {
    public static void main(String[] args) {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("apple", 10);
        map.put("banana", 20);

        System.out.println("apple: " + map.get("apple"));
        System.out.println("banana: " + map.get("banana"));

        map.compute("apple", (key, value) -> value == null ? 1 : value + 1);
        System.out.println("apple re : " + map.get("apple"));


        ConcurrentMap<String, String> map2 = new ConcurrentHashMap<>();

        // putIfAbsent 값이 없다면 입력
        map2.putIfAbsent("name", "John");
        map2.putIfAbsent("name", "Mike");

        System.out.println("name: " + map2.get("name"));
        map2.replace("name", "John", "Doe");
        System.out.println("name: " + map2.get("name"));

        map2.remove("name", "Doe");
        System.out.println("name: " + map2.get("name"));
        map2.putIfAbsent("name", "Mike");
        System.out.println("name: " + map2.get("name"));


        Optional<String> emptyOptional = Optional.empty();
        System.out.println("emptyOptional isPresent?: " + emptyOptional.isPresent()); // isPresent 존재하면 true, 아니면 false
        String defaultValue = emptyOptional.orElse("Default"); // orElse 값 있으면 반환, 없으면 값을 입력
        System.out.println("defaultValue: " + defaultValue);

        Optional<String> optional = Optional.of("Hello");
        System.out.println("optional isPresent?: " + optional.isPresent());

        String value = optional.get();
        System.out.println("value: " + value);

        try{
            Optional.of(null);
        }catch (NullPointerException e){
            System.out.println("Null Pointer Exception Error");
        }

        Optional<String> optionalWithNull = Optional.empty();
        String result =  optionalWithNull.orElseGet(() -> "Generated");
        System.out.println("result: " + result);


    }
}
