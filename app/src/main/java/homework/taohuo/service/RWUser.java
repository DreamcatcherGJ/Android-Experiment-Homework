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
        data = User.getString("user", "defaultValue");
        ListNumber = gson.fromJson(data,new TypeToken<List<String>>(){}.getType());
        return ListNumber;
    }
    //收藏
    public List<String> GetCollect()
    {
        data = User.getString("collect", "defaultValue");
        ListNumber = gson.fromJson(data,new TypeToken<List<String>>(){}.getType());
        return ListNumber;
    }
    //订单
    public List<String> GetOrder1()
    {
        data = User.getString("order1", "defaultValue");
        ListNumber = gson.fromJson(data,new TypeToken<List<String>>(){}.getType());
        return ListNumber;
    }
    public List<String> GetOrder2()
    {
        String data = User.getString("order2", "defaultValue");
        ListNumber = gson.fromJson(data,new TypeToken<List<String>>(){}.getType());
        return ListNumber;
    }
    //地址
    public List<Adress> GetAdress()
    {
        String data = User.getString("adress", "defaultValue");
        Adress = gson.fromJson(data,new TypeToken<List<Adress>>(){}.getType());
        return Adress;
    }


    /***修改信息***/
    //购物车
    public List<String> ChangeCart(String user)
    {
        return null;
    }
    //收藏
    public List<String> ChangeCollect(String user)
    {
        return null;
    }
    //订单
    public List<String> ChangeOrder(String user)
    {
        return null;
    }
    //地址
    public List<Adress> ChangeAdress(String user)
    {
        return null;
    }


    /***删除信息***/
    //购物车
    public List<String> DeleteCart(String user)
    {
        return null;
    }
    //收藏
    public List<String> DeleteCollect(String user)
    {
        return null;
    }
    //订单
    public List<String> DeleteOrder(String user)
    {
        return null;
    }
    //地址
    public List<Adress> DeleteAdress(String user)
    {
        return null;
    }
}
