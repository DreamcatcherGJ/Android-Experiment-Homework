package homework.taohuo.GJ;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import homework.taohuo.R;
import homework.taohuo.service.RWUser;

public class LoginFragment extends Fragment {
    private String LoUser, LoPassword;
    private EditText ETUser, ETPassword;
    private Button BTLogin, BTRegister;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.gj_login, container, false);

        ETUser = (EditText) view.findViewById(R.id.lo_user);
        ETPassword = (EditText) view.findViewById(R.id.lo_password);
        BTLogin = (Button) view.findViewById(R.id.lo_bt_login);
        BTRegister = (Button) view.findViewById(R.id.lo_bt_register);

        BTLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoUser = ETUser.getText().toString();
                LoPassword = ETPassword.getText().toString();

                RWUser User = new RWUser();
                boolean result = User.Login(getActivity(), LoUser, LoPassword);
                if (result){
                    MainFragment fragment = new MainFragment();
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, fragment)
                            .commit();
                }
                else { }
            }
        });
        BTRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterFragment registerFragment = new RegisterFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, registerFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}