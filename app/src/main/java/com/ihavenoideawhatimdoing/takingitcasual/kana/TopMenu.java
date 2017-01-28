package com.ihavenoideawhatimdoing.takingitcasual.kana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TopMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_menu);

        GlobalSingleton g = GlobalSingleton.getSingletonObject();
        g.set_testvar(Hiragana.SoundToHex("ko"));
    }

    public void switchKanaEdit(View view) {
        startActivity(new Intent(TopMenu.this, KanaEdit.class));
        overridePendingTransition(R.anim.enter_right, R.anim.exit_left);
    }
}
