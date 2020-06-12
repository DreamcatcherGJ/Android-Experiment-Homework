package homework.taohuo.TSJ;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    public HotFragment(List<String> number) {
        GetShopMes needmes = new GetShopMes();
        data = needmes.GetShopMes(number);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.gx_list, container, false);

        ListOptionView = (RecyclerView) view.findViewById(R.id.list_option_view);
        ListOptionView.setLayoutManager(new LinearLayoutManager(getContext()));
        ListOptionView.setAdapter(new HotFragment.MyAdapter());
        return view;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Shop shop = data.get(position);

                    //跳转到新Activiyt
                    Intent intent = new Intent(getActivity(), JumpActivity.class);
                    intent.putExtra("id",11);
                    intent.putExtra("shop_id",shop.getId());
                    startActivity(intent);
                }
            });
        }
    }

    //用于为RecyclerView提供数据的适配器类
    private class MyAdapter extends RecyclerView.Adapter<HotFragment.MyViewHolder>
    {
        @Override
        public HotFragment.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.gx_list_option,parent,false);
            HotFragment.MyViewHolder viewHolder = new HotFragment.MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(HotFragment.MyViewHolder viewHolder, int position) {
            View v = viewHolder.itemView;
            ImageView viewHeadImage = (ImageView) v.findViewById(R.id.list_headimage);
            TextView viewTitle = (TextView) v.findViewById(R.id.list_title);
            TextView viewPrice = (TextView) v.findViewById(R.id.list_price);

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