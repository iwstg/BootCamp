package javastudy.genericex;

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> p = new Pair<>("age", 20);
        System.out.println("{ key: " + p.getKey() + ", value: " + p.getValue() + " }");
    }
}
