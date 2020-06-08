package homework.taohuo.GJ;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import homework.taohuo.GHY.ShopDetailFragment;
import homework.taohuo.GX.ListFragment;
import homework.taohuo.R;
import homework.taohuo.bean.Shop;

public class JumpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int id = 0;
        setContentView(R.layout.activity_jump);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        JumpFragment fragment = new JumpFragment();
        fragmentTransaction.add(R.id.fragment_container2, fragment);
        fragmentTransaction.commit();

        id = getIntent().getIntExtra("id", 0);
        String numbers = getIntent().getStringExtra("num");
        System.out.println("123:"+numbers);
        //Gson gson=new Gson();
        //List<String> lis = gson.fromJson(number,new TypeToken<List<Shop>>(){}.getType());
        //for (int i=0;i<lis.size();i++){
        //    System.out.println("lis:"+lis.get(i));
        //}

        if (id == 1) {
            List<String> number = new ArrayList<>();
            number.add("9");
            number.add("10");
            number.add("11");
            number.add("12");
            number.add("13");
            number.add("14");
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_jump,new ListFragment(number))
                    .addToBackStack(null)
                    .commit();
        }
        if (id == 2) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_jump,new ShopDetailFragment(numbers))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
