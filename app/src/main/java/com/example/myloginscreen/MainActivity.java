package com.example.myloginscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MainCallbacks {

    FragmentLogin fragmentLogin = new FragmentLogin();
    FragmentRegister fragmentRegister = new FragmentRegister();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(fragmentLogin);
    }

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();
    }

    @Override
    public void onMsgFromFragToMain(String sender, String strValue) {
        if(sender.equals("register")){
            loadFragment(fragmentRegister);
        }
        if(sender.equals("login")){
            loadFragment(fragmentLogin);
        }
    }
}