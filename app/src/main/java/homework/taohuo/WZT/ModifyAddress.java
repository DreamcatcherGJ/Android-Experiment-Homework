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

import java.util.List;
import homework.taohuo.bean.Adress;
import homework.taohuo.GJ.JumpActivity;
import homework.taohuo.R;
import homework.taohuo.service.RWUser;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ModifyAddress#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ModifyAddress extends Fragment {
    private  List<Adress> address;
    private View view;
    private EditText r_address,r_name,r_phone;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public ModifyAddress() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ModifyAddress.
     */
    // TODO: Rename and change types and number of parameters
    public static ModifyAddress newInstance(String param1, String param2) {
        ModifyAddress fragment = new ModifyAddress();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.wzt_modify_address, container, false);

       RWUser User = new RWUser();
        User.RWUser(getActivity());
        address = User.GetAddress();
//        r_address=(EditText) view.findViewById(R.id.changeadress);//
//        r_name=(EditText) view.findViewById(R.id.changename);//
//        r_phone=(EditText) view.findViewById(R.id.changenumber);//
//        Gson gson =new Gson();
//        String s_address=gson.toJson(r_address);
//        String s_name=gson.toJson(r_name);
//        String s_phone=gson.toJson(r_phone);
       // User.ChangeAddress(s_address+"     "+s_name+"      "+s_phone);
        //User.ChangeAddress("123333333333");

        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button set = (Button) view.findViewById(R.id.changeok);
        Button returnme= (Button) view.findViewById(R.id.changecancel);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent intent = new Intent(getActivity(), JumpActivity.class);
                intent.putExtra("id",71);
                startActivity(intent);
            }
        });






/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



        returnme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), JumpActivity.class);
                intent.putExtra("id",71);
                startActivity(intent);
            }
        });




    }

}