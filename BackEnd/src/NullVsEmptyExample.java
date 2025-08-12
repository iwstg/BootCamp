public class NullVsEmptyExample {
    public static void main(String[] args) {
        String nullStr = null;
        String emptyStr = "";

        System.out.println("emptyStr = " + emptyStr);
        System.out.println("nullStr = " + nullStr);

        // System.out.println(nullStr.length()); // 오류 NullPointerException 나옴
        System.out.println(emptyStr.length());

        if(nullStr != null && !nullStr.isEmpty()) {
            System.out.println("값이 비어있지 않음");
        }

    }
}
