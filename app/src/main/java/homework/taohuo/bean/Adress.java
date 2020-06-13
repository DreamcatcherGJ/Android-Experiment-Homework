package homework.taohuo.bean;

public class Adress {
    private String name;//姓名
    private String phone;//手机号
    private String adress;//地址

    public Adress(String name, String phone, String adress) {
        this.name = name;
        this.phone = phone;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
