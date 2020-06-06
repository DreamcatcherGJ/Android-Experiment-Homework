package homework.taohuo.GX;

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
import homework.taohuo.R;
import homework.taohuo.bean.Shop;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment
{
    private RecyclerView ListOptionView;
    private List<Shop> data = new ArrayList<>();

    public ListFragment(List<Shop> data) {
        this.data = data;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.gx_list, container, false);

        ListOptionView = (RecyclerView) view.findViewById(R.id.list_option_view);
        ListOptionView.setLayoutManager(new LinearLayoutManager(getContext()));
        ListOptionView.setAdapter(new MyAdapter());
        return view;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

    //用于为RecyclerView提供数据的适配器类
    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder>
    {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.gx_list_option,parent,false);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder viewHolder, int position) {
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
