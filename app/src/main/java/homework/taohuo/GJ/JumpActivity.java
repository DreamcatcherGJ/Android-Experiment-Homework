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
import homework.taohuo.LS.CategoryFragment;
import homework.taohuo.R;
import homework.taohuo.WL.OrderTabFragment;
import homework.taohuo.WZT.AdressFragment;
import homework.taohuo.WZT.CreateAddress;
import homework.taohuo.WZT.DeleteAddress;
import homework.taohuo.WZT.ModifyAddress;
import homework.taohuo.ZH.MineFragment;

public class JumpActivity extends AppCompatActivity
{
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

         注：
             点击 “界面A的按钮1” 跳转 “界面B”
             这个跳转由写界面B的来写跳转。写界面A的要提前把按钮监听事件写好。

         ***/

        /*****界面跳转*****/
        //葛健：1-10


        //谷杭豫：11-20
        if (id == 11) {
            //商品详情
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
        if (id == 31) {
            int AddressNumber = getIntent().getIntExtra("AddressNumber", 0);
            String OrderNumber = getIntent().getStringExtra("OrderNumber");
            Gson gson=new Gson();
            List<String> ListNumber = gson.fromJson(OrderNumber,new TypeToken<List<String>>(){}.getType());

            OrderSubmit orderSubmit = new OrderSubmit(ListNumber, AddressNumber);
            fragmentTransaction.add(R.id.fragment_container2, orderSubmit);
            fragmentTransaction.commit();
        }

        if (id == 32) {
            String OrderNumber = getIntent().getStringExtra("OrderNumber");
            Gson gson=new Gson();
            List<String> ListNumber = gson.fromJson(OrderNumber,new TypeToken<List<String>>(){}.getType());
            OrderAddress orderAddress = new OrderAddress(ListNumber);
            fragmentTransaction.add(R.id.fragment_container2, orderAddress);
            fragmentTransaction.commit();
        }

        if (id == 33) {
            OrderSucceed orderSucceed = new OrderSucceed();
            fragmentTransaction.add(R.id.fragment_container2, orderSucceed);
            fragmentTransaction.commit();
        }

//        if (id == 34) {
//            OrderAddress orderAddress = new OrderAddress();
//            fragmentTransaction.add(R.id.fragment_container2, orderAddress);
//            fragmentTransaction.commit();
//        }

        //张虎：41-50

        //刘顺：51-60
        if (id == 51) {
            //商品ID
            String shop_id = getIntent().getStringExtra("shop_id");

            ShopDetailFragment shopDetailFragment = new ShopDetailFragment(shop_id);
            fragmentTransaction.add(R.id.fragment_container2, shopDetailFragment);
            fragmentTransaction.commit();
        }

        //王龙：61-70
        if (id == 61) {
            //我的订单
            OrderTabFragment orderTabFragment = new OrderTabFragment();
            fragmentTransaction.replace(R.id.fragment_container2, orderTabFragment);
            fragmentTransaction.commit();
        }
        if (id == 62) {
            //“我的”界面
            MineFragment mineFragment = new MineFragment();
            fragmentTransaction.replace(R.id.fragment_container2, mineFragment);
            fragmentTransaction.commit();
        }
        if (id == 63) {
            //返回商品
            CategoryFragment categoryFragment = new CategoryFragment();
            fragmentTransaction.replace(R.id.fragment_container2, categoryFragment);
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
            int number = getIntent().getIntExtra("Number",-1);

            ModifyAddress modifyAddress = new ModifyAddress(number);
            fragmentTransaction.add(R.id.fragment_container2, modifyAddress);
            fragmentTransaction.commit();
        }

        if (id == 73) {
            //进入删除界面
            int number = getIntent().getIntExtra("Number",-1);

            DeleteAddress deleteAddress =  new DeleteAddress(number);
            fragmentTransaction.add(R.id.fragment_container2, deleteAddress);
            fragmentTransaction.commit();
        }
        if (id == 74) {
            //进入新增界面
            int number = getIntent().getIntExtra("Number",-1);

            CreateAddress createAddress =new CreateAddress(number);
            fragmentTransaction.add(R.id.fragment_container2, createAddress);
            fragmentTransaction.commit();
        }


        //王锦：81-90

        //汤深杰：91-100

    }
}
