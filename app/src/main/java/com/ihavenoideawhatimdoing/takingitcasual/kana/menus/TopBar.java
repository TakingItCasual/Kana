package com.ihavenoideawhatimdoing.takingitcasual.kana.menus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.Space;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ihavenoideawhatimdoing.takingitcasual.kana.KanaEdit;
import com.ihavenoideawhatimdoing.takingitcasual.kana.R;
import com.ihavenoideawhatimdoing.takingitcasual.kana.singleton.GlobalSingleton;


public class TopBar extends Fragment {

    private static int TopBarMode;

    GlobalSingleton g;

    public TopBar() {

    }

    public static TopBar newInstance(int setTopBarMode) {
        TopBar fragment = new TopBar();
        Bundle args = new Bundle();
        args.putInt("Mode", setTopBarMode);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        g = GlobalSingleton.getSingletonObject();
        TopBarMode = g.TOPBAR_BASIC;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TopBarMode = this.getArguments().getInt("Mode");

        Context context = this.getContext();
        int buttonBarHeight = context.getResources().getDimensionPixelSize(R.dimen.TopBarHeight);

        final LinearLayout parentLL = new LinearLayout(getActivity());
        parentLL.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        parentLL.setOrientation(LinearLayout.VERTICAL);

        if(TopBarMode >= g.TOPBAR_BASIC){
            final LinearLayout buttonBar = new LinearLayout(getActivity());
            buttonBar.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    buttonBarHeight
            ));
            buttonBar.setOrientation(LinearLayout.HORIZONTAL);

            final AppCompatImageView backButton = new AppCompatImageView(getActivity());
            LinearLayout.LayoutParams button1_params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            );
            backButton.setLayoutParams(button1_params);

            int back_xml = context.getResources().getIdentifier("back_arrow", "drawable", context.getPackageName());

            backButton.setImageResource(back_xml);
            backButton.setColorFilter(ContextCompat.getColor(context, R.color.black));
            backButton.setScaleType(AppCompatImageView.ScaleType.CENTER_INSIDE);
            backButton.setAdjustViewBounds(true);

            backButton.setId(R.id.backButton);
            backButton.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO: make back button do something
                }
            });

            final Space emptySpace = new Space(getActivity());
            LinearLayout.LayoutParams space_params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1.0f // layout_weight
            );
            emptySpace.setLayoutParams(space_params);
            emptySpace.setId(R.id.emptySpace);

            final AppCompatImageView settingsButton = new AppCompatImageView(getActivity());
            LinearLayout.LayoutParams button2_params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            settingsButton.setLayoutParams(button2_params);

            int settings_xml = context.getResources().getIdentifier("settings_gear", "drawable", context.getPackageName());

            settingsButton.setImageResource(settings_xml);
            settingsButton.setColorFilter(ContextCompat.getColor(context, R.color.black));
            settingsButton.setScaleType(AppCompatImageView.ScaleType.CENTER_INSIDE);
            settingsButton.setAdjustViewBounds(true);

            settingsButton.setId(R.id.settingsButton);
            settingsButton.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO: make settings button do something
                }
            });

            buttonBar.addView(backButton);
            buttonBar.addView(emptySpace);
            buttonBar.addView(settingsButton);
            parentLL.addView(buttonBar);
        }
        if(TopBarMode >= g.TOPBAR_KANA){
            final CardView buttonBarWrapper = new CardView(getActivity());
            buttonBarWrapper.setLayoutParams(new CardView.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            buttonBarWrapper.setUseCompatPadding(true);
            buttonBarWrapper.setPreventCornerOverlap(false);
            buttonBarWrapper.setRadius(0);
            buttonBarWrapper.setPadding(0, 0, 0, 0);
            buttonBarWrapper.setCardElevation(context.getResources().getDimensionPixelSize(R.dimen.spacing_tiny));

            final LinearLayout buttonBar = new LinearLayout(getActivity());
            buttonBar.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    buttonBarHeight
            ));
            buttonBar.setOrientation(LinearLayout.HORIZONTAL);
            buttonBar.setBackgroundResource(R.drawable.linearlayout_shadow);

            final Button button1 = new Button(getActivity());
            LinearLayout.LayoutParams button1_params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1.0f // layout_weight
            );
            button1.setLayoutParams(button1_params);
            button1.setBackgroundResource(R.drawable.btn_grey_rect);
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
            button2.setBackgroundResource(R.drawable.btn_grey_rect);
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
            buttonBarWrapper.addView(buttonBar);
            parentLL.addView(buttonBarWrapper);
        }
        if(TopBarMode >= g.TOPBAR_KANAEDIT){

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
