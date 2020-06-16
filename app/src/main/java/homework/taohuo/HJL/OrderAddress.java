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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import homework.taohuo.GJ.JumpActivity;
import homework.taohuo.R;
import homework.taohuo.WZT.AdressFragment;
import homework.taohuo.bean.Adress;
import homework.taohuo.bean.Shop;
import homework.taohuo.service.RWUser;


public class OrderAddress extends Fragment
{
    private RecyclerView ListOptionView;
    private List<Adress> data = new ArrayList<>();

    public OrderAddress() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.hjl_order_address, container, false);

        ListOptionView = (RecyclerView) view.findViewById(R.id.order_address_option_view);
        ListOptionView.setLayoutManager(new LinearLayoutManager(getContext()));
        ListOptionView.setAdapter(new OrderAddress.MyAdapter());

        RWUser User = new RWUser();
        User.RWUser(getActivity());
        data = User.GetAddress();

        return view;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    //跳转到新Activiyt
//                    Intent intent = new Intent(getActivity(), JumpActivity.class);
//                    intent.putExtra("id",11);
//                    startActivity(intent);

                }
            });
        }
    }

    //用于为RecyclerView提供数据的适配器类
    private class MyAdapter extends RecyclerView.Adapter<OrderAddress.MyViewHolder>
    {
        @Override
        public OrderAddress.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.hjl_orderaddress_option,parent,false);
            OrderAddress.MyViewHolder viewHolder = new OrderAddress.MyViewHolder(view);
            return viewHolder;
        }



        @Override
        public void onBindViewHolder(OrderAddress.MyViewHolder viewHolder, final int position) {
            View v = viewHolder.itemView;
            TextView user = (TextView) v.findViewById(R.id.order_address_user2);
            TextView detail = (TextView) v.findViewById(R.id.order_address_detail2);

            Adress adress = data.get(position);

            user.setText(adress.getName()+"  "+adress.getPhone());
            detail.setText(adress.getAdress());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

}