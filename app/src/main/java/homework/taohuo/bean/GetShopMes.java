package homework.taohuo.bean;

import java.util.ArrayList;
import java.util.List;

public class GetShopMes {
    private List<Shop> needmes = new ArrayList<>();

    public List<Shop> GetShopMes(List<String> number)
    {
        ShopMes shopmes = new ShopMes();
        List<Shop> sm = shopmes.ShopMes();

        System.out.println("GetShopMes");
        for(int i = 0;i < number.size();i++){
            System.out.println(number.get(i));
        }

        for (int i=0;i<number.size();i++)
        {
            int k = 0;
            k = Integer.parseInt(number.get(i))-1;
            System.out.println("K:"+k);
            needmes.add(new Shop(sm.get(k).getId(),sm.get(k).getTitle(),sm.get(k).getHeadImage(),sm.get(k).getDetailImage(),sm.get(k).getPrice()));
        }

        return needmes;

    }
}
