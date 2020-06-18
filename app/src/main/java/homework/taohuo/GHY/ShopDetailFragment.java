package homework.taohuo.GHY;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import homework.taohuo.HJL.OrderSubmit;
import homework.taohuo.R;
import homework.taohuo.service.GetShopMes;
import homework.taohuo.bean.Shop;
import homework.taohuo.service.RWUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopDetailFragment extends Fragment {
    private List<Shop> shopdata = new ArrayList<>();
    private List<String> number = new ArrayList<>();
    private Shop shop;
    private View v;
    private RWUser User;
    private String num;
    private LinearLayout myLinearLayout;

    public ShopDetailFragment(String num) {
        this.num = num;
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
        User = new RWUser();
        User.RWUser(getActivity());

        return v;
    }

    public void SetShopDetail() {
        TextView shop_name = (TextView) v.findViewById(R.id.shop_name);
        ImageView head_image = (ImageView) v.findViewById(R.id.head_image);
        TextView shop_title = (TextView) v.findViewById(R.id.shop_title);
        TextView shop_price = (TextView) v.findViewById(R.id.shop_price);
        ImageView detail_image = (ImageView) v.findViewById(R.id.detail_image);
        Button shop_buy = (Button) v.findViewById(R.id.shop_buy);
        Button shop_add = (Button) v.findViewById(R.id.shop_add);

        myLinearLayout = Objects.requireNonNull(getActivity()).findViewById(R.id.myLinearLayout);
        shop = shopdata.get(0);

        shop_name.setText(shop.getTitle());
        head_image.setImageResource(shop.getHeadImage());
        shop_title.setText(shop.getTitle());
        shop_price.setText(shop.getPrice());
        detail_image.setImageResource(shop.getDetailImage());

        shop_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> number = new ArrayList<>();
                number.add(shop.getId());
                OrderSubmit orderSubmit = new OrderSubmit(number, 0);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container2, orderSubmit)
                        .commit();
            }
        });

        shop_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = User.GetCart();
                number.add(num);
                Gson gson =new Gson();
                String numberStr = gson.toJson(number);
                User.ChangeCart(numberStr);
                getActivity().finish();
            }
        });
    }
}
