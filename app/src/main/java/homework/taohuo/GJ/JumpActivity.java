package homework.taohuo.GJ;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import homework.taohuo.GHY.ShopDetailFragment;
import homework.taohuo.GX.ListFragment;
import homework.taohuo.R;
import homework.taohuo.WL.OrderTabFragment;
import homework.taohuo.WZT.AdressFragment;
import homework.taohuo.WZT.ModifyAddress;

public class JumpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //界面跳转需求
        int id = getIntent().getIntExtra("id", 0);

        //界面跳转
        if (id == 1) {
            //1.商品列表
            String number = getIntent().getStringExtra("number");
            Gson gson=new Gson();
            List<String> ListNumber = gson.fromJson(number,new TypeToken<List<String>>(){}.getType());
            ListFragment listFragment = new ListFragment(ListNumber);
            fragmentTransaction.add(R.id.fragment_container2, listFragment);
            fragmentTransaction.commit();
        }
        if (id == 2) {
            //2.商品ID
            String shop_id = getIntent().getStringExtra("shop_id");

            ShopDetailFragment shopDetailFragment = new ShopDetailFragment(shop_id);
            fragmentTransaction.add(R.id.fragment_container2, shopDetailFragment);
            fragmentTransaction.commit();
        }
        if (id == 3) {
            AdressFragment adressFragment =  new AdressFragment();
            fragmentTransaction.add(R.id.fragment_container2, adressFragment);
            fragmentTransaction.commit();
        }
        if (id == 4) {
            String number = getIntent().getStringExtra("number");
            Gson gson=new Gson();
            List<String> ListNumber = gson.fromJson(number,new TypeToken<List<String>>(){}.getType());
            OrderTabFragment orderTabFragment = new OrderTabFragment(ListNumber);
            fragmentTransaction.replace(R.id.fragment_container2, orderTabFragment);
            fragmentTransaction.commit();
        }
    }
}
