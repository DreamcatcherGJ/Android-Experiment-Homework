package homework.taohuo.GHY;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import homework.taohuo.R;
import homework.taohuo.bean.GetShopMes;
import homework.taohuo.bean.Shop;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopDetailFragment extends Fragment {
    private List<Shop> shopdata = new ArrayList<>();
    private View v;

    public ShopDetailFragment(String num) {
        List<String> number = new ArrayList<>();
        GetShopMes needmes = new GetShopMes();
        number.add(num);

        shopdata = needmes.GetShopMes(number);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.ghy_shop_detail, container, false);

        SetShopDetail();

        return v;
    }

    public void SetShopDetail() {
        TextView shop_name = (TextView) v.findViewById(R.id.shop_name);
        ImageView head_image = (ImageView) v.findViewById(R.id.head_image);
        TextView shop_title = (TextView) v.findViewById(R.id.shop_title);
        TextView shop_price = (TextView) v.findViewById(R.id.shop_price);
        ImageView detail_image = (ImageView) v.findViewById(R.id.detail_image);

        Shop shop = shopdata.get(0);

        shop_name.setText(shop.getTitle());
        head_image.setImageResource(shop.getHeadImage());
        shop_title.setText(shop.getTitle());
        shop_price.setText(shop.getPrice());
        detail_image.setImageResource(shop.getDetailImage());
    }
}
