package com.ihavenoideawhatimdoing.takingitcasual.kana.menus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ihavenoideawhatimdoing.takingitcasual.kana.R;
import com.ihavenoideawhatimdoing.takingitcasual.kana.singleton.GlobalSingleton;

public class FirstScreen extends android.support.v4.app.Fragment {

    GlobalSingleton g;

    public FirstScreen() {

    }

    public static FirstScreen newInstance() {
        FirstScreen fragment = new FirstScreen();
        // Bundle args = new Bundle();
        // args.putInt("Unused", Unused);
        // fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        g = GlobalSingleton.getSingletonObject();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final LinearLayout parentLL = new LinearLayout(getActivity());
        parentLL.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        parentLL.setOrientation(LinearLayout.VERTICAL);

        final Button editKanaButton = new Button(getActivity());
        LinearLayout.LayoutParams button1_params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        editKanaButton.setLayoutParams(button1_params);
        editKanaButton.setId(R.id.hiraMode);
        editKanaButton.setText(R.string.MenuButton_KanaEdit);
        editKanaButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchKanaEdit(v);
            }
        });

        parentLL.addView(editKanaButton);

        return parentLL;
    }

    private void switchKanaEdit(View view){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_right, R.anim.exit_left,
                R.anim.enter_left, R.anim.exit_right);
        KanaEdit ke = KanaEdit.newInstance();
        transaction.replace(R.id.mainScreen, ke);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
