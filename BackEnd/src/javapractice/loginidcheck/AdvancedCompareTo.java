package javapractice.loginidcheck;

import java.util.Arrays;

/**
 *  2025-08-11
 * (Advanced) 여러 개의 단어를 사전 순서대로 정렬하는 프로그램을 만들어 봅시다.
 * 이때, 단어 비교에는 compareTo() 메소드를 활용합니다. (현재 이미 정렬이 되어있어서 임의로 변경함)
 * 단어 : apple, banana, cherry
 */

public class AdvancedCompareTo {
    public static void main(String[] args) {
        /**
         *  기본적으로 CompareTo() 매소드의 경우 동일 여부뿐만 아니라
         * 대소비교(어떤 문자열이 사전순으로 더 우선인지)도 할 수 있습니다.
         * 공식 문서에는 비교 기준이 lexicographic ordering(사전순서)라고 나와있습니다.
         *
         * "String A".CompareTo("String B") 의 경우에서,
         * "String A"가 "String B"보다 더 크면 음수, 같으면 0, 작으면 양수가 나옵니다.
         * 따라서, 제시된 단어의 순서가 뒤죽박죽이어도  apple, banana, cherry 대로 출력돼야 합니다.
         */
        String[] compareLeng = { "banana", "apple", "cherry"};
        String temp = "";
//        Arrays.stream(compareLeng).sorted().forEach(System.out::println);

        for (int i = 0; i < compareLeng.length - 1; i++) {
            for (int k = 0; k < compareLeng.length - 1 - i; k++) {
                if (compareLeng[k].compareTo(compareLeng[k + 1]) > 0) {
                    temp = compareLeng[k];
                    compareLeng[k] = compareLeng[k + 1];
                    compareLeng[k + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(compareLeng));

    }
}
