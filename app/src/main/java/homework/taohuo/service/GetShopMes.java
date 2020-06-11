package homework.taohuo.service;

import java.util.ArrayList;
import java.util.List;

import homework.taohuo.bean.Shop;
import homework.taohuo.bean.ShopMes;

public class GetShopMes {
    private List<Shop> needmes = new ArrayList<>();

    public List<Shop> GetShopMes(List<String> number)
    {
        ShopMes shopmes = new ShopMes();
        List<Shop> sm = shopmes.ShopMes();

        for (int i=0;i<number.size();i++)
        {
            int k = 0;
            k = Integer.parseInt(number.get(i))-1;
            needmes.add(new Shop(sm.get(k).getId(),sm.get(k).getTitle(),sm.get(k).getHeadImage(),sm.get(k).getDetailImage(),sm.get(k).getPrice()));
        }

        return needmes;

    }
}
