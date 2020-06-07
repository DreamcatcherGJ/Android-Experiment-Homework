package homework.taohuo.WZT;

import android.app.AlertDialog;
import android.bluetooth.le.AdvertiseData;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import homework.taohuo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PickAddress#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickAddress extends Fragment {
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Object Addaddress;
    private Object ModifyAddress;
    private Object DeleteAddress;

    public PickAddress() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickAddress.
     */
    // TODO: Rename and change types and number of parameters
    public static PickAddress newInstance(String param1, String param2) {
        PickAddress fragment = new PickAddress();
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
        return inflater.inflate(R.layout.fragment_pick_address, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        btn1 = (Button) getActivity().findViewById(R.id.wzt_bt1);
        btn2 = (Button) getActivity().findViewById(R.id.wzt_bt2);
        btn3 = (Button) getActivity().findViewById(R.id.wzt_bt3);
        btn4 = (Button) getActivity().findViewById(R.id.wzt_bt4);
        btn9 = (Button) getActivity().findViewById(R.id.wzt_bt9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Addaddress == null) {
                    Addaddress = new Addaddress();
                }
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, (Fragment) Addaddress).commitAllowingStateLoss();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ModifyAddress == null) {
                    ModifyAddress = new Addaddress();
                }
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, (Fragment) ModifyAddress).commitAllowingStateLoss();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DeleteAddress == null) {
                    DeleteAddress = new Addaddress();
                }
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, (Fragment) DeleteAddress).commitAllowingStateLoss();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ModifyAddress == null) {
                    ModifyAddress = new Addaddress();
                }
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, (Fragment) ModifyAddress).commitAllowingStateLoss();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DeleteAddress == null) {
                    DeleteAddress = new Addaddress();
                }
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, (Fragment) DeleteAddress).commitAllowingStateLoss();
            }
        });


    }
}