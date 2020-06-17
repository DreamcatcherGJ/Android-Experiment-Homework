package homework.taohuo.HJL;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
import homework.taohuo.GJ.MainFragment;
import homework.taohuo.GX.ListFragment;
import homework.taohuo.R;
import homework.taohuo.WL.OrderFragment;
import homework.taohuo.bean.Adress;
import homework.taohuo.bean.Shop;
import homework.taohuo.service.GetShopMes;
import homework.taohuo.service.RWUser;


public class OrderSubmit extends Fragment
{
    private RecyclerView ListOptionView;
    int address = 0;
    private List<Shop> data = new ArrayList<>();
    private List<Adress> data2 = new ArrayList<>();
    private List<String> number = new ArrayList<>();

    public OrderSubmit(List<String> number, int address) {
        this.number = number;
        GetShopMes needmes = new GetShopMes();
        data = needmes.GetShopMes(number);
        this.address = address;
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
        data2 = User.GetAddress();

        TextView address_user = (TextView) view.findViewById(R.id.order_address_user);
        TextView address_detail = (TextView) view.findViewById(R.id.order_address_detail);
        Button change_address = (Button) view.findViewById(R.id.change_address);
        Button submit_button = (Button) view.findViewById(R.id.submit_button);

        Adress adress = data2.get(address);

        address_user.setText(adress.getName()+"  "+adress.getPhone());
        address_detail.setText(adress.getAdress());

        change_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderAddress orderAddress = new OrderAddress(number);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container2, orderAddress)
                        .commit();
            }
        });
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderSucceed orderSucceed = new OrderSucceed();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container2, orderSucceed)
                        .commit();
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