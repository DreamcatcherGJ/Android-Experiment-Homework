package homework.taohuo.TSJ;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import homework.taohuo.GJ.JumpActivity;
import homework.taohuo.R;
import homework.taohuo.bean.Shop;
import homework.taohuo.service.GetShopMes;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends Fragment {

    private RecyclerView ListOptionView;
    private List<Shop> data = new ArrayList<>();
    private List<String> number = new ArrayList<>();
    private Shop shop;

    public HotFragment () {
        number.add("1");
        number.add("2");
        number.add("12");
        number.add("14");
        number.add("8");
        number.add("10");
        number.add("6");
        GetShopMes needmes = new GetShopMes();
        data = needmes.GetShopMes(number);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tsj_hot, container, false);

        ListOptionView = (RecyclerView) v.findViewById(R.id.hot1_option_view);
        ListOptionView.setLayoutManager(new LinearLayoutManager(getContext()));
        ListOptionView.setAdapter(new HotFragment.MyAdapter());

        return v;
    }
    private class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Shop shop = data.get(position);

                    //????????????Activiyt
                    Intent intent = new Intent(getActivity(), JumpActivity.class);
                    intent.putExtra("id",11);
                    intent.putExtra("shop_id",shop.getId());
                    startActivity(intent);
                }
            });
        }
    }

    //?????????RecyclerView???????????????????????????
    private class MyAdapter extends RecyclerView.Adapter<HotFragment.MyViewHolder>
    {
        @Override
        public HotFragment.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.tsj_hot_option,parent,false);
            HotFragment.MyViewHolder viewHolder = new HotFragment.MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(HotFragment.MyViewHolder viewHolder, int position) {
            View v = viewHolder.itemView;
            ImageView viewHeadImage = (ImageView) v.findViewById(R.id.hot_headimage);
            TextView viewTitle = (TextView) v.findViewById(R.id.hot_title);
            TextView viewPrice = (TextView) v.findViewById(R.id.hot_price);
            Button viewButton = (Button) v.findViewById(R.id.hot_button);

            shop = data.get(position);

            viewHeadImage.setImageResource(shop.getHeadImage());
            viewTitle.setText(shop.getTitle());
            viewPrice.setText(shop.getPrice());

            viewButton.setOnClickListener(new View.OnClickListener() {
                String shopNumber = shop.getId();
                @Override
                public void onClick(View v) {
                    List<String> number = new ArrayList<>();
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