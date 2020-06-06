package homework.taohuo.bean;

import java.util.ArrayList;
import java.util.List;
import homework.taohuo.bean.Shop;

import homework.taohuo.R;

public class ShopMes {
    private List<Shop> data = new ArrayList<>();

    public void ShopMes()
    {
        //张虎
        data.add(new Shop("HUAWEI WATCH GT2",
                R.mipmap.zh_shop1,R.mipmap.wl_shop1_detail,"￥"));
        data.add(new Shop("小米手表Color",
                R.mipmap.zh_shop2,R.mipmap.wl_shop2_detail,"￥"));

        //王龙
        data.add(new Shop("华为旗下荣耀手环5",
                R.mipmap.wl_shop1,R.mipmap.wl_shop1_detail,"￥149"));
        data.add(new Shop("小米移动电源3",
                R.mipmap.wl_shop2,R.mipmap.wl_shop2_detail,"￥109"));

        //刘顺
        data.add(new Shop("遨游A6防爆智能手机",
                R.mipmap.ls_shop1,R.mipmap.ls_shop1_detail,"￥3998"));
        data.add(new Shop("i9黑苹果主机",
                R.mipmap.ls_shop2,R.mipmap.ls_shop2_detail,"￥10700"));

        //谷杭豫
        data.add(new Shop("Apple/苹果 iPhone11 Pro",
                R.mipmap.ghy_shop1,R.mipmap.ghy_shop1_detail,"￥9999"));
        data.add(new Shop("华为荣耀MagicBook Pro 16.1英寸",
                R.mipmap.ghy_shop2,R.mipmap.ghy_shop2_detail,"￥5699"));

        //葛健
        data.add(new Shop("巧乐兹3种口味冰淇淋",
                R.mipmap.gj_shop1,R.mipmap.gj_shop1_detail,"￥129"));
        data.add(new Shop("甜甜乐星球杯大杯1000g",
                R.mipmap.gj_shop2,R.mipmap.gj_shop2_detail,"￥22"));

        //葛璇
        data.add(new Shop("德食120个鹌鹑卤蛋",
                R.mipmap.gx_shop1,R.mipmap.gx_shop1_detail,"￥29"));
        data.add(new Shop("4斤多口味瓜子",
                R.mipmap.gx_shop2,R.mipmap.gx_shop2_detail,"￥29"));

        //何家乐
        data.add(new Shop("王子香浓巧克力味曲奇",
                R.mipmap.hjl_shop1,R.mipmap.hjl_shop1_detail,"￥34"));
        data.add(new Shop("统一小当家干脆面整箱48袋",
                R.mipmap.hjl_shop2,R.mipmap.hjl_shop2_detail,"￥22"));


    }
}
