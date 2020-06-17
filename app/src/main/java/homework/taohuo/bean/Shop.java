package homework.taohuo.bean;

public class Shop {
    private String id;//商品编号
    private String title;//标题
    private int headImage;//图片
    private int detailImage;//详细信息
    private String price;//价格
    private boolean bChoose;

    public Shop(String id, String title, int headImage, int detailImage, String price,boolean bChoose) {
        this.id = id;
        this.title = title;
        this.headImage = headImage;
        this.detailImage = detailImage;
        this.price = price;
        this.bChoose=bChoose;
    }

    public Shop(String id, String title, int headImage, int detailImage, String price) {
        this.id = id;
        this.title = title;
        this.headImage = headImage;
        this.detailImage = detailImage;
        this.price = price;
        this.bChoose=false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean isbChoose() {
        return bChoose;
    }

    public void setbChoose(boolean bChoose) {
        this.bChoose = bChoose;
    }
}
