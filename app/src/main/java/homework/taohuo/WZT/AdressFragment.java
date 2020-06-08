package homework.taohuo.WZT;

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

/**
 * A simple {@link Fragment} subclass.
 */
public class AdressFragment extends Fragment {
    private RecyclerView ListOptionView;
    private List<Adress> data = new ArrayList<>();

    public AdressFragment() {
        data.add(new Adress("1","汪真天","123456","黄山学院"));
        data.add(new Adress("2","汪真天","123456","黄山学院"));
        data.add(new Adress("3","汪真天","123456","黄山学院"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.wzt_adress, container, false);

        ListOptionView = (RecyclerView) view.findViewById(R.id.adress_option_view);
        ListOptionView.setLayoutManager(new LinearLayoutManager(getContext()));
        ListOptionView.setAdapter(new AdressFragment.MyAdapter());

        return view;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

    //用于为RecyclerView提供数据的适配器类
    private class MyAdapter extends RecyclerView.Adapter<AdressFragment.MyViewHolder>
    {
        @Override
        public AdressFragment.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.wzt_adress_option,parent,false);
            AdressFragment.MyViewHolder viewHolder = new AdressFragment.MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(AdressFragment.MyViewHolder viewHolder, final int position) {
            View v = viewHolder.itemView;
            TextView viewUser = (TextView) v.findViewById(R.id.adress_user);
            TextView viewDetail = (TextView) v.findViewById(R.id.adress_detail);
            Button BTchange = (Button) v.findViewById(R.id.adress_change);
            Button BTdetele = (Button) v.findViewById(R.id.adress_detele);

            final Adress adress = data.get(position);

            viewUser.setText(adress.getName()+"  "+adress.getPhone());
            viewDetail.setText(adress.getAdress());
            BTchange.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), JumpActivity.class);
                    intent.putExtra("id",4);
                    intent.putExtra("number",adress.getID());
                    startActivity(intent);
                }
            });
            BTdetele.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}
