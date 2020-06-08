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

        /***
         问题：
             1.id值唯一
             2.'0'不可作为id
             3.该Activity多人共同编辑存在开发冲突问题

         解决办法：
            1.分配id范围(范围如下)
             //葛健：1-10
             //谷杭豫：11-20
             //葛璇：21-30
             //何家乐：31-40
             //张虎：41-50
             //刘顺：51-60
             //王龙：61-70
             //汪真天：71-80
             //王锦：81-90
             //汤深杰：91-100

        ***/

        /*****界面跳转*****/
        //葛健：1-10


        //谷杭豫：11-20
        if (id == 11) {
            //商品ID
            String shop_id = getIntent().getStringExtra("shop_id");

            ShopDetailFragment shopDetailFragment = new ShopDetailFragment(shop_id);
            fragmentTransaction.add(R.id.fragment_container2, shopDetailFragment);
            fragmentTransaction.commit();
        }
        //葛璇：21-30
        if (id == 21) {
            //商品列表
            String number = getIntent().getStringExtra("number");
            Gson gson=new Gson();

            List<String> ListNumber = gson.fromJson(number,new TypeToken<List<String>>(){}.getType());
            ListFragment listFragment = new ListFragment(ListNumber);
            fragmentTransaction.add(R.id.fragment_container2, listFragment);
            fragmentTransaction.commit();
        }

        //何家乐：31-40

        //张虎：41-50

        //刘顺：51-60

        //王龙：61-70
        if (id == 61) {
            //我的订单
            String number = getIntent().getStringExtra("number");
            Gson gson=new Gson();
            List<String> ListNumber = gson.fromJson(number,new TypeToken<List<String>>(){}.getType());
            OrderTabFragment orderTabFragment = new OrderTabFragment(ListNumber);
            fragmentTransaction.replace(R.id.fragment_container2, orderTabFragment);
            fragmentTransaction.commit();
        }

        //汪真天：71-80
        if (id == 71) {
            //打开我的收货地址
            AdressFragment adressFragment =  new AdressFragment();
            fragmentTransaction.add(R.id.fragment_container2, adressFragment);
            fragmentTransaction.commit();
        }
        if (id == 72) {
            //修改我的收货地址
            ModifyAddress modifyAddress = new ModifyAddress();
            fragmentTransaction.add(R.id.fragment_container2, modifyAddress);
            fragmentTransaction.commit();
        }
        if (id == 73) {
            //修改成功
            ModifyAddress modifyAddress = new ModifyAddress();
            fragmentTransaction.add(R.id.fragment_container2, modifyAddress);
            fragmentTransaction.commit();
        }
        if (id == 74) {
            //返回”我的收货地址“界面
            AdressFragment adressFragment =  new AdressFragment();
            fragmentTransaction.add(R.id.fragment_container2, adressFragment);
            fragmentTransaction.commit();
        }

        //王锦：81-90

        //汤深杰：91-100

    }
}
