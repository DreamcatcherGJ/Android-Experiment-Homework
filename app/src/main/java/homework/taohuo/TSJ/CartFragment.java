package homework.taohuo.TSJ;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import homework.taohuo.GJ.JumpActivity;
import homework.taohuo.GJ.MainFragment;
import homework.taohuo.R;
import homework.taohuo.bean.Shop;
import homework.taohuo.service.GetShopMes;
import homework.taohuo.service.RWUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {
    private RecyclerView ListOptionView;
    private Shop shop;
    private List<Shop> data = new ArrayList<>();
    private Gson gson=new Gson();
    private List<String> ListNumber = new ArrayList<>();
    private List<String> number = new ArrayList<>();
    private List<String> numberChange = new ArrayList<>();
    private CheckBox checkAllChoose;
    private TextView tvTotal;
    private CartFragment.MyAdapter shopAdapter;
    private double totalPrice=0;
    private RWUser User;
    private String numberStr;

    public CartFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tsj_cart, container, false);

        ListOptionView = (RecyclerView) view.findViewById(R.id.cart_option_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ListOptionView.setLayoutManager(layoutManager);
        shopAdapter=new CartFragment.MyAdapter();
        ListOptionView.setAdapter(shopAdapter);

        User = new RWUser();
        User.RWUser(getActivity());
        ListNumber = User.GetCart();
        GetShopMes needmes = new GetShopMes();
        data = needmes.GetShopMes(ListNumber);

        Button viewButton = (Button) view.findViewById(R.id.cart_button1);
        Button viewButton2 = (Button) view.findViewById(R.id.cart_button2);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberChange = User.GetCart();
                for (int h=0;h<number.size();h++)
                {
                    numberChange.remove(number.get(h));
                }
                Gson gson =new Gson();
                numberStr = gson.toJson(numberChange);
                User.ChangeCart(numberStr);

                MainFragment mainFragment = new MainFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, mainFragment)
                        .commit();
            }
        });

        viewButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson=new Gson();
                String listNum = gson.toJson(number);

                Intent intent = new Intent(getActivity(), JumpActivity.class);
                intent.putExtra("id",31);
                intent.putExtra("OrderNumber",listNum);
                startActivity(intent);

                MainFragment mainFragment = new MainFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, mainFragment)
                        .commit();
            }
        });

        //??????????????????
        tvTotal=(TextView)view.findViewById(R.id.textView13);

        checkAllChoose=view.findViewById(R.id.checkBox1);
        checkAllChoose.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                for(Shop shop:data)
                    shop.setbChoose(isChecked);
                if(shopAdapter!=null)
                    shopAdapter.notifyDataSetChanged();

                //??????
                Message message=msgHandler.obtainMessage();
                message.what=MSG_UPDATE_PRICE;
                msgHandler.sendMessage(message);
            }
        });


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

                    //????????????Activiyt
                    Intent intent = new Intent(getActivity(), JumpActivity.class);
                    intent.putExtra("id", 11);
                    intent.putExtra("shop_id", shop.getId());
                    startActivity(intent);

                }
            });
        }
    }

    //?????????RecyclerView???????????????????????????
    private class MyAdapter extends RecyclerView.Adapter<CartFragment.MyViewHolder> {
        @Override
        public CartFragment.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.tsj_cart_option, parent, false);
            CartFragment.MyViewHolder viewHolder = new CartFragment.MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(final CartFragment.MyViewHolder viewHolder, int position) {
            View v = viewHolder.itemView;
            ImageView viewHeadImage = (ImageView) v.findViewById(R.id.cart_headimage);
            TextView viewTitle = (TextView) v.findViewById(R.id.cart_title);
            TextView viewPrice = (TextView) v.findViewById(R.id.cart_price);
            final CheckBox cb=v.findViewById(R.id.checkBox2);


            shop = data.get(position);

            viewHeadImage.setImageResource(shop.getHeadImage());
            viewTitle.setText(shop.getTitle());
            viewPrice.setText(shop.getPrice());
            cb.setChecked(shop.isbChoose());

            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String price=data.get(viewHolder.getAdapterPosition()).getPrice();
                    price=price.substring(1);
                    if(cb.isChecked()){
                        totalPrice+=Double.parseDouble(price);
                        number.add(data.get(viewHolder.getAdapterPosition()).getId());
                    }else{
                        totalPrice-=Double.parseDouble(price);
                        for (int i = 0; i < number.size(); i++) {
                            if (data.get(viewHolder.getAdapterPosition()).getId().equals(number.get(i))) {
                                number.remove(i);
                                i--;
                            }
                        }
                    }

                    tvTotal.setText("???????????"+totalPrice);
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }


    private static final int MSG_UPDATE_PRICE=1;
    private Handler msgHandler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            List<String> zeroNumber = new ArrayList<>();
            number = zeroNumber;
            switch(msg.what){
                case MSG_UPDATE_PRICE:
                    //??????
                    double price=0;
                    for(Shop shop:data){
                        if(shop.isbChoose()){
                            String strP=shop.getPrice();
                            number.add(shop.getId());
                            strP=strP.substring(1);
                            price+=Double.parseDouble(strP);
                        }
                    }
                    totalPrice=price;
                    tvTotal.setText("???????????"+price);
                    break;
            }
        }
    };
}

