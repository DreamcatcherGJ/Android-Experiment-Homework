package homework.taohuo.bean;

public class Adress {
    private String ID;//地址ID
    private String name;//姓名
    private String phone;//手机号
    private String adress;//地址

    public Adress(String ID, String name, String phone, String adress) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.adress = adress;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
