package homework.taohuo.service;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

import homework.taohuo.bean.Adress;


public class RWUser
{
    private SharedPreferences Login, User;
    private SharedPreferences.Editor editor;

    public void RWUser(Context context)
    {
        SharedPreferences Login = context.getSharedPreferences("Login", Context.MODE_PRIVATE);
        System.out.println("Login:3");
        String Admin = Login.getString("user", "NoBody");
        System.out.println("Login:4");
        System.out.println("Login:Admin");


        User = context.getSharedPreferences(Admin, Context.MODE_PRIVATE);
        System.out.println("Admin:1");
        editor = User.edit();

        editor.putString("user", "Admin");
        System.out.println("Admin:2");
        editor.apply();
    }


    /***获得信息***/
    //购物车
    public List<String> GetCart()
    {
        List<String> number2 = new ArrayList<>();
        String data = User.getString("user", "defaultValue");
        System.out.println("Admin:3");
        System.out.println(data);
        number2.add(data);
        return number2;
    }
    //收藏
    public List<String> GetCollect(String user)
    {
        return null;
    }
    //订单
    public List<String> Getorder(String user)
    {
        return null;
    }
    //地址
    public List<Adress> GetAdress(String user)
    {
        return null;
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
    public List<String> Changeorder(String user)
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
    public List<String> Deleteorder(String user)
    {
        return null;
    }
    //地址
    public List<Adress> DeleteAdress(String user)
    {
        return null;
    }
}
