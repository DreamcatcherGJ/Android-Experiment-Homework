package homework.taohuo.GHY;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import homework.taohuo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopDetailFragment extends Fragment {

    public ShopDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.ghy_shop_detail, container, false);
    }
}
