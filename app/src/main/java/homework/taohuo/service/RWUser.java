package homework.taohuo.service;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import homework.taohuo.bean.Adress;


public class RWUser extends AppCompatActivity
{
    private SharedPreferences Login, User;
    private SharedPreferences.Editor editor;
    private String data;
    private Gson gson=new Gson();
    private List<String> ListNumber = new ArrayList<>();
    private List<Adress> Adress = new ArrayList<>();

    public void RWUser(Context context)
    {
        Login = context.getSharedPreferences("Login", Context.MODE_PRIVATE);
        String Admin = Login.getString("user", "NoBody");

        User = context.getSharedPreferences(Admin, Context.MODE_PRIVATE);
        editor = User.edit();
    }


    /***获得信息***/
    //购物车
    public List<String> GetCart()
    {
        data = User.getString("cart", "defaultValue");
        if(data == "defaultValue"){
            return null;
        }else {
            ListNumber = gson.fromJson(data,new TypeToken<List<String>>(){}.getType());
            return ListNumber;
        }
    }
    //收藏
    public List<String> GetCollect()
    {
        data = User.getString("collect", "defaultValue");
        if(data == "defaultValue"){
            return null;
        }else {
            ListNumber = gson.fromJson(data,new TypeToken<List<String>>(){}.getType());
            return ListNumber;
        }
    }
    //全部订单
    public List<String> GetOrder1()
    {
        data = User.getString("order1", "defaultValue");
        if(data == "defaultValue"){
            return null;
        }else {
            ListNumber = gson.fromJson(data,new TypeToken<List<String>>(){}.getType());
            return ListNumber;
        }
    }
    //待支付订单
    public List<String> GetOrder2()
    {
        String data = User.getString("order2", "defaultValue");
        if(data == "defaultValue"){
            return null;
        }else {
            ListNumber = gson.fromJson(data,new TypeToken<List<String>>(){}.getType());
            return ListNumber;
        }
    }
    //地址
    public List<Adress> GetAddress()
    {
        String data = User.getString("address", "defaultValue");
        if(data == "defaultValue"){
            return null;
        }else {
            Adress = gson.fromJson(data,new TypeToken<List<Adress>>(){}.getType());
            return Adress;
        }
    }


    /***修改信息***/
    //购物车
    public void ChangeCart(String listNum)
    {
        editor.putString("cart", listNum);
        editor.apply();
    }
    //收藏
    public void ChangeCollect(String listNum)
    {
        editor.putString("collect", listNum);
        editor.apply();
    }
    //全部订单
    public void ChangeOrder1(String listNum)
    {
        editor.putString("order1", listNum);
        editor.apply();
    }
    //待支付订单
    public void ChangeOrder2(String listNum)
    {
        editor.putString("order2", listNum);
        editor.apply();
    }
    //地址
    public void ChangeAddress(String listNum)
    {
        editor.putString("address", listNum);
        editor.apply();
    }


    /***删除信息***/
    //购物车
    public void DeleteCart()
    {
        editor.remove("cart");
        editor.apply();
    }
    //收藏
    public void DeleteCollect()
    {
        editor.remove("collect");
        editor.apply();
    }
    //全部订单
    public void DeleteOrder1()
    {
        editor.remove("order1");
        editor.apply();
    }
    //待支付订单
    public void DeleteOrder2()
    {
        editor.remove("order2");
        editor.apply();
    }
    //地址
    public void DeleteAddress()
    {
        editor.remove("address");
        editor.apply();
    }
}
