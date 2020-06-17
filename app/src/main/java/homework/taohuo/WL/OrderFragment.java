package homework.taohuo.WL;

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

import java.util.ArrayList;
import java.util.List;

import homework.taohuo.GJ.JumpActivity;
import homework.taohuo.R;
import homework.taohuo.service.GetShopMes;
import homework.taohuo.bean.Shop;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {
    private RecyclerView ListOptionView;
    private Shop shop;
    private List<Shop> data = new ArrayList<>();

    public OrderFragment(List<String> number) {
        GetShopMes needmes = new GetShopMes();
        data = needmes.GetShopMes(number);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.wl_order, container, false);

        ListOptionView = (RecyclerView) view.findViewById(R.id.order_option_view);
        ListOptionView.setLayoutManager(new LinearLayoutManager(getContext()));
        ListOptionView.setAdapter(new OrderFragment.MyAdapter());

        return  view;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

    //用于为RecyclerView提供数据的适配器类
    private class MyAdapter extends RecyclerView.Adapter<OrderFragment.MyViewHolder>
    {
        @Override
        public OrderFragment.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.wl_order_option,parent,false);
            OrderFragment.MyViewHolder viewHolder = new OrderFragment.MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(OrderFragment.MyViewHolder viewHolder, int position) {
            View v = viewHolder.itemView;
            ImageView viewHeadImage = (ImageView) v.findViewById(R.id.order_headimage);
            TextView viewTitle = (TextView) v.findViewById(R.id.order_title);
            TextView viewPrice = (TextView) v.findViewById(R.id.order_price);
            Button viewButton = (Button) v.findViewById(R.id.order_button);

            viewButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), JumpActivity.class);
                    intent.putExtra("id",63);
                    //   intent.putExtra("number",adress.getID());
                    startActivity(intent);
                }
            });

            shop = data.get(position);

            viewHeadImage.setImageResource(shop.getHeadImage());
            viewTitle.setText(shop.getTitle());
            viewPrice.setText(shop.getPrice());

            viewButton.setOnClickListener(new View.OnClickListener() {
                String shopNumber = shop.getId();
                @Override
                public void onClick(View v) {
                    List<String> number = new ArrayList<>();
                    System.out.println("456:"+shop.getId());
                    number.add(shopNumber);
                    Gson gson=new Gson();
                    String listNum = gson.toJson(number);

                    Intent intent = new Intent(getActivity(), JumpActivity.class);
                    intent.putExtra("id",31);
                    intent.putExtra("OrderNumber",listNum);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}
