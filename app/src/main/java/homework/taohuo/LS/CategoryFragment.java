package homework.taohuo.LS;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import homework.taohuo.R;
import homework.taohuo.LS.category_fragment.CategoryFragment1;
import homework.taohuo.LS.category_fragment.CategoryFragment2;
import homework.taohuo.LS.category_fragment.CategoryFragment3;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements View.OnClickListener {
    private View mView;
    private Button button1, button2, button3;
    private Button btn1, btn2, btn3;
    private FrameLayout mFrameLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.ls_category, null);
        initFrameLayout();

        return mView;
    }

    private void initFrameLayout() {
        mFrameLayout = mView.findViewById(R.id.mFrameLayout);
        button1 = mView.findViewById(R.id.button1);
        button2 = mView.findViewById(R.id.button2);
        button3 = mView.findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        getFragmentManager().beginTransaction().replace(R.id.mFrameLayout, new CategoryFragment1()).commit();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // final User user ;
        btn1 = (Button) getActivity().findViewById(R.id.ls_btn1);
        btn2 = (Button) getActivity().findViewById(R.id.ls_btn2);
        btn3 = (Button) getActivity().findViewById(R.id.ls_btn3);
        //img1 =(ImageView) getActivity().findViewById(R.id.zh_img1);
        /*btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blankFragment == null) {
                    blankFragment = new BlankFragment();
                }
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, blankFragment).commitAllowingStateLoss();
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                getFragmentManager().beginTransaction().replace(R.id.mFrameLayout, new CategoryFragment1()).commit();
                break;
            case R.id.button2:
                getFragmentManager().beginTransaction().replace(R.id.mFrameLayout, new CategoryFragment2()).commit();
                break;
            case R.id.button3:
                getFragmentManager().beginTransaction().replace(R.id.mFrameLayout, new CategoryFragment3()).commit();
                break;
        }
    }
}
