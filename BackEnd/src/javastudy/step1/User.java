package javastudy.step1;

public class User {
    private static int userCnt = 0; // static임
    public int insUserCnt = 0; // 일반 자료형임
    private String name;

    public User(String name) {
        this.name = name;
        userCnt++;
        this.insUserCnt++;
    }

    public static  int  getUserCnt(){
        return userCnt;
    }

    public int getInsUserCnt(){
        return insUserCnt;
    }
}
