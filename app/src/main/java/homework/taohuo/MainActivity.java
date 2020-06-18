package homework.taohuo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

import homework.taohuo.GJ.LoginFragment;
import homework.taohuo.GJ.MainFragment;
import homework.taohuo.bean.Adress;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetAdmin();

        SharedPreferences Login = getSharedPreferences("Login", Context.MODE_PRIVATE);
        String Admin = Login.getString("user", "NoBody");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MainFragment fragment = new MainFragment();
        LoginFragment loginFragment = new LoginFragment();

        if (Admin.equals("NoBody")){
            fragmentTransaction.replace(R.id.fragment_container, loginFragment);
            fragmentTransaction.commit();
        }else {
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }
    }


    public void SetAdmin(){
        //初始值-用户信息
        SharedPreferences User = getSharedPreferences("admin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = User.edit();
        Gson gson=new Gson();
        String user = "admin";
        String password = "123456";
        List<String> number3 = new ArrayList<>();
        List<String> number4 = new ArrayList<>();
        List<String> number5 = new ArrayList<>();
        List<String> number6 = new ArrayList<>();
        List<Adress> address = new ArrayList<>();
        number3.add("1");
        number3.add("2");
        number3.add("3");
        number4.add("4");
        number4.add("5");
        number4.add("6");
        number5.add("7");
        number5.add("8");
        number6.add("9");
        number6.add("10");
        address.add(new Adress("user1","123456","黄山学院"));
        address.add(new Adress("user2","123456","黄山学院"));
        address.add(new Adress("user3","123456","黄山学院"));

        String listNum3 = gson.toJson(number3);
        String listNum4 = gson.toJson(number4);
        String listNum5 = gson.toJson(number5);
        String listNum6 = gson.toJson(number6);
        String listNum7 = gson.toJson(address);

        editor2.putString("user", user);
        editor2.putString("password", password);
        editor2.putString("cart", listNum3);
        editor2.putString("collect", listNum4);
        editor2.putString("order1", listNum5);
        editor2.putString("order2", listNum6);
        editor2.putString("address", listNum7);
        editor2.apply();
    }
}
