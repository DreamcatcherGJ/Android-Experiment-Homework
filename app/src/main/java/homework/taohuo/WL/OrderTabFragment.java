package homework.taohuo.WL;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.List;
import homework.taohuo.R;
import homework.taohuo.service.RWUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderTabFragment extends Fragment {
    private View view;
    private List<String> number1, number2;

    public OrderTabFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.wl_order_tab, container, false);

        RWUser User = new RWUser();
        User.RWUser(getActivity());
        number1 = User.GetOrder1();
        number2 = User.GetOrder2();

        setTab();

        return view;
    }

    public void setTab()
    {
        OrderFragment orderFragment = new OrderFragment(number1);
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
                OrderFragment orderFragment = new OrderFragment(number1);
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
                OrderFragment orderFragment = new OrderFragment(number2);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.wl_tab, orderFragment, null)
                        .addToBackStack(null)
                        .commit();
            }
        });

    }


}
