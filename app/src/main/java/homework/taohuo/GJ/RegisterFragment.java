package homework.taohuo.GJ;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import homework.taohuo.R;
import homework.taohuo.service.RWUser;


public class RegisterFragment extends Fragment {
    private String ReUser, RePassword;
    private EditText ETUser, ETPassword;
    private TextView TVWarn;
    private Button BTRegister, BTServer;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.gj_register, container, false);

        ETUser = (EditText) view.findViewById(R.id.re_user);
        ETPassword = (EditText) view.findViewById(R.id.re_password);
        TVWarn = (TextView) view.findViewById(R.id.re_warning) ;
        BTRegister = (Button) view.findViewById(R.id.re_bt_register);
        BTServer = (Button) view.findViewById(R.id.re_bt_server);

        BTRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReUser = ETUser.getText().toString();
                RePassword = ETPassword.getText().toString();

                RWUser User = new RWUser();
                User.Register(getActivity(), ReUser, RePassword);
                LoginFragment loginFragment = new LoginFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, loginFragment)
                        .commit();
            }
        });
        BTServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}