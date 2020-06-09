package homework.taohuo.GHY;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.fragment.app.FragmentTransaction;
import homework.taohuo.LS.CategoryFragment;
import homework.taohuo.R;
import homework.taohuo.bean.GetShopMes;
import homework.taohuo.bean.Shop;
import homework.taohuo.category_fragment.CategoryFragment1;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopDetailFragment extends Fragment {
    private List<Shop> shopdata = new ArrayList<>();
    private View v;
    private LinearLayout myLinearLayout;

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

        myLinearLayout = Objects.requireNonNull(getActivity()).findViewById(R.id.myLinearLayout);
        Shop shop = shopdata.get(0);

        shop_name.setText(shop.getTitle());
        head_image.setImageResource(shop.getHeadImage());
        shop_title.setText(shop.getTitle());
        shop_price.setText(shop.getPrice());
        detail_image.setImageResource(shop.getDetailImage());
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        backListenter();
//    }
//
//    private void backListenter() {
//        v.setFocusableInTouchMode(true);
//        v.requestFocus();
//        v.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int i, KeyEvent keyEvent) {
//                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_BACK) {
//                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                    fragmentTransaction.replace(R.id.mFrameLayout, new CategoryFragment1()).commit();
//                    fragmentTransaction.remove(ShopDetailFragment.this);
//                    myLinearLayout.setVisibility(View.VISIBLE);
//                    return true;
//                }
//                return false;
//            }
//        });
//    }
}
