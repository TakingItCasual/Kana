package com.ihavenoideawhatimdoing.takingitcasual.kana;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
        transaction.replace(R.id.topBar, new TopBar()).commit();
    }

    public void switchKanaEdit(View v) {
        switch(v.getId()) {
            case R.id.hira:
                g.set_kanaMode(g.MODE_HIRAGANA);
                break;
            case R.id.kata:
                g.set_kanaMode(g.MODE_KATAKANA);
                break;
        }
        startActivity(new Intent(TopMenu.this, KanaEdit.class));
        overridePendingTransition(R.anim.enter_right, R.anim.exit_left);
    }
}
