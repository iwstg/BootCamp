package javastudy.genericex;

/**
 * 제네릭 클래스에서 클래스 이름 뒤 < > 같은 타입 파라미터가 있는 경우
 * static을 파라미터로 받을 수 없으며, 기본 자료형도 받을 수 없다.
 * int를 사용하려면 Integer을 사용해야 함. 기본 자료형은 Wrapper 사용
 * 컴파일 시 타입이 체크됨으로 타입 안정성이 보장됨
 */
public class Pair<K, V> {
    private final K key;
    private final V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}