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

    public void Register(Context context,String user, String password){
        SharedPreferences ReUser = context.getSharedPreferences(user, Context.MODE_PRIVATE);
        SharedPreferences.Editor ReEditor = ReUser.edit();
        ReEditor.putString("user", user);
        ReEditor.putString("password", password);
        ReEditor.apply();
    }

    public boolean Login(Context context,String user, String password){
        SharedPreferences LoLogin = context.getSharedPreferences(user, Context.MODE_PRIVATE);
        String user2 = LoLogin.getString("user", "NoUser");
        String password2 = LoLogin.getString("password", "NoPassword");

        if (user.equals(user2) && password.equals(password2)){
            Login = context.getSharedPreferences("Login", Context.MODE_PRIVATE);
            SharedPreferences.Editor LoEditor =  Login.edit();
            LoEditor.putString("user", user);
            LoEditor.apply();
            return true;
        }else {
            return false;
        }
    }

    public void Quit(Context context){
        Login = context.getSharedPreferences("Login", Context.MODE_PRIVATE);
        SharedPreferences.Editor QuEditor =  Login.edit();
        QuEditor.remove("user");
        QuEditor.apply();
    }


    /***????????????***/
    //?????????
    public List<String> GetCart()
    {
        data = User.getString("cart", "defaultValue");
        if(data == "defaultValue"){
            return ListNumber;
        }else {
            ListNumber = gson.fromJson(data,new TypeToken<List<String>>(){}.getType());
            return ListNumber;
        }
    }
    //??????
    public List<String> GetCollect()
    {
        data = User.getString("collect", "defaultValue");
        if(data == "defaultValue"){
            return ListNumber;
        }else {
            ListNumber = gson.fromJson(data,new TypeToken<List<String>>(){}.getType());
            return ListNumber;
        }
    }
    //????????????
    public List<String> GetOrder1()
    {
        data = User.getString("order1", "defaultValue");
        if(data == "defaultValue"){
            return ListNumber;
        }else {
            ListNumber = gson.fromJson(data,new TypeToken<List<String>>(){}.getType());
            return ListNumber;
        }
    }
    //???????????????
    public List<String> GetOrder2()
    {
        String data = User.getString("order2", "defaultValue");
        if(data == "defaultValue"){
            return ListNumber;
        }else {
            ListNumber = gson.fromJson(data,new TypeToken<List<String>>(){}.getType());
            return ListNumber;
        }
    }
    //??????
    public List<Adress> GetAddress()
    {
        String data = User.getString("address", "defaultValue");
        if(data == "defaultValue"){
            return Adress;
        }else {
            Adress = gson.fromJson(data,new TypeToken<List<Adress>>(){}.getType());
            return Adress;
        }
    }


    /***????????????***/
    //?????????
    public void ChangeCart(String listNum)
    {
        editor.putString("cart", listNum);
        editor.apply();
    }
    //??????
    public void ChangeCollect(String listNum)
    {
        editor.putString("collect", listNum);
        editor.apply();
    }
    //????????????
    public void ChangeOrder1(String listNum)
    {
        editor.putString("order1", listNum);
        editor.apply();
    }
    //???????????????
    public void ChangeOrder2(String listNum)
    {
        editor.putString("order2", listNum);
        editor.apply();
    }
    //??????
    public void ChangeAddress(String listNum)
    {
        editor.putString("address", listNum);
        editor.apply();
    }


    /***????????????***/
    //?????????
    public void DeleteCart()
    {
        editor.remove("cart");
        editor.apply();
    }
    //??????
    public void DeleteCollect()
    {
        editor.remove("collect");
        editor.apply();
    }
    //????????????
    public void DeleteOrder1()
    {
        editor.remove("order1");
        editor.apply();
    }
    //???????????????
    public void DeleteOrder2()
    {
        editor.remove("order2");
        editor.apply();
    }
    //??????
    public void DeleteAddress()
    {
        editor.remove("address");
        editor.apply();
    }
}
