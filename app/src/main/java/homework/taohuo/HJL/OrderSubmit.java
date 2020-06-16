package homework.taohuo.HJL;

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

import java.util.ArrayList;
import java.util.List;

import homework.taohuo.GJ.JumpActivity;
import homework.taohuo.GX.ListFragment;
import homework.taohuo.R;
import homework.taohuo.bean.Adress;
import homework.taohuo.bean.Shop;
import homework.taohuo.service.GetShopMes;
import homework.taohuo.service.RWUser;


public class OrderSubmit extends Fragment
{
    private RecyclerView ListOptionView;
    private List<String> ListNumber = new ArrayList<>();
    private List<Shop> data = new ArrayList<>();
    private List<Adress> data2 = new ArrayList<>();

    public OrderSubmit() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.hjl_order_submit, container, false);

        ListOptionView = (RecyclerView) view.findViewById(R.id.order_submit_option_view);
        ListOptionView.setLayoutManager(new LinearLayoutManager(getContext()));
        ListOptionView.setAdapter(new OrderSubmit.MyAdapter());

        RWUser User = new RWUser();
        User.RWUser(getActivity());
        ListNumber = User.GetCart();
        GetShopMes needmes = new GetShopMes();
        data = needmes.GetShopMes(ListNumber);
        data2 = User.GetAddress();

        TextView address_user = (TextView) view.findViewById(R.id.order_address_user);
        TextView address_detail = (TextView) view.findViewById(R.id.order_address_detail);
        Button change_address = (Button) view.findViewById(R.id.change_address);
        Button submit_button = (Button) view.findViewById(R.id.submit_button);

        Adress adress = data2.get(0);

        address_user.setText(adress.getName()+"  "+adress.getPhone());
        address_detail.setText(adress.getAdress());

        change_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), JumpActivity.class);
                intent.putExtra("id",32);
                startActivity(intent);
            }
        });
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), JumpActivity.class);
                intent.putExtra("id",33);
                startActivity(intent);
            }
        });

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
    private class MyAdapter extends RecyclerView.Adapter<OrderSubmit.MyViewHolder>
    {
        @Override
        public OrderSubmit.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.hjl_ordersubmit_option,parent,false);
            OrderSubmit.MyViewHolder viewHolder = new OrderSubmit.MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(OrderSubmit.MyViewHolder viewHolder, int position) {
            View v = viewHolder.itemView;
            ImageView viewHeadImage = (ImageView) v.findViewById(R.id.order_list_headimage);
            TextView viewTitle = (TextView) v.findViewById(R.id.order_list_title);

            Shop shop = data.get(position);

            viewHeadImage.setImageResource(shop.getHeadImage());
            viewTitle.setText(shop.getTitle());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}