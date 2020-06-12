package homework.taohuo.TSJ;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import homework.taohuo.GJ.JumpActivity;
import homework.taohuo.GJ.MainFragment;
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
    private ViewPager mViewPager;
    private RadioGroup mTabRadioGroup;

    /*public HotFragment(List<String> number) {
        GetShopMes needmes = new GetShopMes();
        data = needmes.GetShopMes(number);
    }
    */
    public HotFragment(){
        number.add("13");
        number.add("2");
        number.add("3");
        number.add("4");
        number.add("5");
        number.add("6");
        number.add("7");
        number.add("8");
        number.add("9");
        number.add("10");
        number.add("11");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        mViewPager = v.findViewById(R.id.fragment_vp);
        mTabRadioGroup = v.findViewById(R.id.tabs_rg);

        for (int i = 0;i < number.size(); i++) {
            System.out.println(number.get(i));
        }
        ListFragment listFragment = new ListFragment(number);
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

                    //跳转到新Activiyt
                    Intent intent = new Intent(getActivity(), JumpActivity.class);
                    intent.putExtra("id",91);
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
            View view = inflater.inflate(R.layout.tsj_hot_option,parent,false);
            HotFragment.MyViewHolder viewHolder = new HotFragment.MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(HotFragment.MyViewHolder viewHolder, int position) {
            View v = viewHolder.itemView;
            ImageView viewHeadImage = (ImageView) v.findViewById(R.id.hot_headimage);
            TextView viewTitle = (TextView) v.findViewById(R.id.hot_title);
            TextView viewPrice = (TextView) v.findViewById(R.id.cart_price);

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