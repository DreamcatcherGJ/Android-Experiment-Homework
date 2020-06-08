package homework.taohuo.WL;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import homework.taohuo.GJ.BlankFragment;
import homework.taohuo.GJ.JumpActivity;
import homework.taohuo.GX.ListFragment;
import homework.taohuo.R;
import homework.taohuo.bean.Adress;
import homework.taohuo.bean.Shop;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderTabFragment extends Fragment {
    private View view;
    private List<String> number;

    public OrderTabFragment(List<String> number) {
        this.number = number;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.wl_order_tab, container, false);

        setTab();

        return view;
    }

    public void setTab()
    {
        OrderFragment orderFragment = new OrderFragment(number);
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.wl_tab, orderFragment, null)
                .addToBackStack(null)
                .commit();

        Button button1 = (Button)  view.findViewById(R.id.button3);
        Button button2 = (Button)  view.findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                List<String> number = new ArrayList<>();
                number.add("1");
                number.add("2");
                number.add("3");
                OrderFragment orderFragment = new OrderFragment(number);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.wl_tab, orderFragment, null)
                        .addToBackStack(null)
                        .commit();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                List<String> number = new ArrayList<>();
                number.add("4");
                number.add("5");
                number.add("6");
                OrderFragment orderFragment = new OrderFragment(number);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.wl_tab, orderFragment, null)
                        .addToBackStack(null)
                        .commit();
            }
        });

    }


}
