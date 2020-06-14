package homework.taohuo.TSJ;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import homework.taohuo.GJ.JumpActivity;
import homework.taohuo.R;
import homework.taohuo.bean.Shop;
import homework.taohuo.service.GetShopMes;
import homework.taohuo.service.RWUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {
    private RecyclerView ListOptionView;
    private List<Shop> data = new ArrayList<>();
    private Gson gson=new Gson();
    private List<String> ListNumber = new ArrayList<>();

    public CartFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tsj_cart, container, false);

        ListOptionView = (RecyclerView) view.findViewById(R.id.cart_option_view);
        ListOptionView.setLayoutManager(new LinearLayoutManager(getContext()));
        ListOptionView.setAdapter(new CartFragment.MyAdapter());

        RWUser User = new RWUser();
        User.RWUser(getActivity());
        ListNumber = User.GetCart();

        GetShopMes needmes = new GetShopMes();
        data = needmes.GetShopMes(ListNumber);

        return view;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Shop shop = data.get(position);

                    //跳转到新Activiyt
                    Intent intent = new Intent(getActivity(), JumpActivity.class);
                    intent.putExtra("id", 11);
                    intent.putExtra("shop_id", shop.getId());
                    startActivity(intent);

                }
            });
        }
    }

    //用于为RecyclerView提供数据的适配器类
    private class MyAdapter extends RecyclerView.Adapter<CartFragment.MyViewHolder> {
        @Override
        public CartFragment.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.tsj_cart_option, parent, false);
            CartFragment.MyViewHolder viewHolder = new CartFragment.MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(CartFragment.MyViewHolder viewHolder, int position) {
            View v = viewHolder.itemView;
            ImageView viewHeadImage = (ImageView) v.findViewById(R.id.cart_headimage);
            TextView viewTitle = (TextView) v.findViewById(R.id.cart_title);
            TextView viewPrice = (TextView) v.findViewById(R.id.cart_price);
            Button viewButton = (Button) v.findViewById(R.id.cart_button1);
            Button viewButton2 = (Button) v.findViewById(R.id.cart_button2);

            Shop shop = data.get(position);

            viewHeadImage.setImageResource(shop.getHeadImage());
            viewTitle.setText(shop.getTitle());
            viewPrice.setText(shop.getPrice());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}

