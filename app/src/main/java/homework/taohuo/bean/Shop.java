package homework.taohuo.bean;

public class Shop {
    private String title;//标题
    private int headImage;//图片
    private int detailImage;//详细信息
    private String price;//价格

    public Shop(String title, int headImage, int detailImage, String price) {
        this.title = title;
        this.headImage = headImage;
        this.detailImage = detailImage;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHeadImage() {
        return headImage;
    }

    public void setHeadImage(int headImage) {
        this.headImage = headImage;
    }

    public int getDetailImage() {
        return detailImage;
    }

    public void setDetailImage(int detailImage) {
        this.detailImage = detailImage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
