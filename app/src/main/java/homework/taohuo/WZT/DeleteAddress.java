package homework.taohuo.WZT;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import homework.taohuo.GJ.JumpActivity;
import homework.taohuo.R;
import homework.taohuo.WL.OrderFragment;
import homework.taohuo.bean.Adress;
import homework.taohuo.service.RWUser;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DeleteAddress#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeleteAddress extends Fragment {
    private  List<Adress> olddelete = new ArrayList<>();
    private  List<Adress> newdelete = new ArrayList<>();
    private int id;
    private RWUser User;
    private String newaddressStr;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View view;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DeleteAddress(int id) {
        // Required empty public constructor
        this.id =  id;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeleteAddress.
     */
    // TODO: Rename and change types and number of parameters
    public static DeleteAddress newInstance(String param1, String param2) {
        DeleteAddress fragment = new DeleteAddress(-1);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.wzt_delete_address, container, false);

        User = new RWUser();
        User.RWUser(getActivity());
        olddelete = User.GetAddress();



        for (int i=0;i<olddelete.size();i++)
        {
            if(id == i)
            {
                // olddelete.add(new Adress("","",""));
            }else {
                newdelete.add(new Adress(olddelete.get(i).getName(),olddelete.get(i).getPhone(),olddelete.get(i).getAdress()));
            }
        }

        Gson gson =new Gson();
        newaddressStr = gson.toJson(newdelete);

        return view;
    }
    @Override


    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button Delete = (Button) view.findViewById(R.id.button1);
        Button returnmine= (Button) view.findViewById(R.id.button2);

        returnmine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdressFragment adressFragment =  new AdressFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container2, adressFragment)
                        .commit();
//                Intent intent = new Intent(getActivity(), JumpActivity.class);
//                intent.putExtra("id",71);
//                startActivity(intent);
            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.ChangeAddress(newaddressStr);
                AdressFragment adressFragment =  new AdressFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container2, adressFragment)
                        .commit();
//                Intent intent = new Intent(getActivity(), JumpActivity.class);
//                intent.putExtra("id",71);
//                startActivity(intent);
            }
        });

    }
}
