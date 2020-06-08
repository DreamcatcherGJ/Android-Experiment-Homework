package homework.taohuo.ZH;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import homework.taohuo.GJ.JumpActivity;
import homework.taohuo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {
    private Button btn1,btn2,btn3,btn4;
    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.zh_mine, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // final User user ;
        btn1 = (Button) getActivity().findViewById(R.id.zh_btn6);
        btn2 = (Button) getActivity().findViewById(R.id.zh_btn7);
        btn3 = (Button) getActivity().findViewById(R.id.zh_btn8);
        btn4 = (Button) getActivity().findViewById(R.id.zh_btn9);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> number = new ArrayList<>();
                number.add("1");
                number.add("2");
                number.add("3");

                Gson gson=new Gson();
                String listNum = gson.toJson(number);
                Intent intent = new Intent(getActivity(), JumpActivity.class);
                intent.putExtra("id",10);
                intent.putExtra("number",listNum);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), JumpActivity.class);
                intent.putExtra("id",3);
                startActivity(intent);
            }
        });
    }
}
