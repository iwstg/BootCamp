package JavaPractice.LoginIDCheck;

/**
 * 2025-08-11
 *  과제 2. 웹사이트나 앱에서 로그인할 때, 보통 아이디는 대소문자를 구분하지 않습니다.
 * 예를 들어 저장된 아이디가 “Admin”이라면 “admin”, “ADMIN”, “AdMiN” 모두 같은 아이디로 인식해야 합니다. 이를 구현해 보세요!
 * <요구사항>
 * 아이디값 두개를 비교한다.
 * 대소문자 구분 없이 비교해야 한다.
 * 아이디가 일치하면 “로그인 성공!“을, 그렇지 않으면 “아이디가 일치하지 않습니다.“를 출력한다.
 */

public class AdminLoginCheck {
    public static void main(String[] args) {
        String DBID = "Admin"; // 로그인 성공 기준 ID toLowerCase() 매소드로 소문자 화 시켜 비교할 예쩡
        String[] InputID = {"ADMIN" , "Admin", "ADmIn", "AdMIN", "admins", "AADD"}; // 입력될 ID 배열

        System.out.println("로그인ID\t- 결과\n--------------------");
        for(String ID : InputID){
            System.out.println(ID + (
                    DBID.toLowerCase().equals(ID.toLowerCase()) ?
                            "\t- 로그인 성공!" : "\t- 아이디가 일치하지 않습니다.")
            );
        }
    }
}
