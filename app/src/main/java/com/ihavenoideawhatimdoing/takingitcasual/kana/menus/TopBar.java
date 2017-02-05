package com.ihavenoideawhatimdoing.takingitcasual.kana.menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ihavenoideawhatimdoing.takingitcasual.kana.KanaEdit;
import com.ihavenoideawhatimdoing.takingitcasual.kana.R;
import com.ihavenoideawhatimdoing.takingitcasual.kana.singleton.GlobalSingleton;

public class TopBar extends Fragment {

    private int Mode;
    GlobalSingleton g;

    public TopBar() {
        g = GlobalSingleton.getSingletonObject();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Mode = this.getArguments().getInt("Mode");

        final LinearLayout parentLL = new LinearLayout(getActivity());
        parentLL.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        parentLL.setOrientation(LinearLayout.VERTICAL);

        if(Mode >= g.TOPBAR_BASIC){

        }
        if(Mode >= g.TOPBAR_KANA){
            final LinearLayout buttonBar = new LinearLayout(getActivity());
            buttonBar.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            buttonBar.setOrientation(LinearLayout.HORIZONTAL);

            final Button button1 = new Button(getActivity());
            LinearLayout.LayoutParams button1_params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1.0f // layout_weight
            );
            button1.setLayoutParams(button1_params);
            button1.setId(R.id.hiraMode);
            button1.setText(R.string.HiraganaButton);
            button1.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switchKanaEdit(v);
                }
            });

            final Button button2 = new Button(getActivity());
            LinearLayout.LayoutParams button2_params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1.0f // layout_weight
            );
            button2.setLayoutParams(button2_params);
            button2.setId(R.id.kataMode);
            button2.setText(R.string.KatakanaButton);
            button2.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switchKanaEdit(v);
                }
            });

            buttonBar.addView(button1);
            buttonBar.addView(button2);
            parentLL.addView(buttonBar);
        }
        if(Mode >= g.TOPBAR_KANAEDIT){

        }

        return parentLL;
    }

    private void switchKanaEdit(View v){
        switch(v.getId()) {
            case R.id.hiraMode:
                g.set_kanaMode(g.MODE_HIRAGANA);
                break;
            case R.id.kataMode:
                g.set_kanaMode(g.MODE_KATAKANA);
                break;
        }
        startActivity(new Intent(getActivity(), KanaEdit.class));
        getActivity().overridePendingTransition(R.anim.enter_right, R.anim.exit_left);
    }

}
