package com.ihavenoideawhatimdoing.takingitcasual.kana;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ihavenoideawhatimdoing.takingitcasual.kana.menus.FirstScreen;
import com.ihavenoideawhatimdoing.takingitcasual.kana.singleton.GlobalSingleton;
import com.ihavenoideawhatimdoing.takingitcasual.kana.menus.TopBar;

public class TopMenu extends AppCompatActivity {

    GlobalSingleton g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_menu);

        g = GlobalSingleton.getSingletonObject();
        g.set_testvar(g.SoundToHex("ko"));

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        TopBar tb = TopBar.newInstance(g.TOPBAR_KANA);
        transaction.replace(R.id.topBar, tb);
        FirstScreen fs = FirstScreen.newInstance();
        transaction.replace(R.id.firstScreen, fs);
        transaction.commit();
    }

}