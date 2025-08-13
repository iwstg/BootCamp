package JavaStudy.Accessmodifier;

public class SmartPhone {

    /**
     * private 필드에 접근할때 getter setter를 이용핸다.
     */
    public String getCpu() { return cpu; }
    public void setCpu(String cpu) { this.cpu = cpu; }
 String model = "Galaxy";
    public String sdCard = "128";
    private String cpu  = "Snapdragon";
    protected String os = "Android";
    public void printInfo(){
        System.out.println(model);
        System.out.println(sdCard);
        System.out.println(cpu);
        System.out.println(os);
    }
}
