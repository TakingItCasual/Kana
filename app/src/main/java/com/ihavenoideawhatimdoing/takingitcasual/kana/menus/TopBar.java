package com.ihavenoideawhatimdoing.takingitcasual.kana.menus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.Space;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ihavenoideawhatimdoing.takingitcasual.kana.R;
import com.ihavenoideawhatimdoing.takingitcasual.kana.singleton.GlobalSingleton;


public class TopBar extends android.support.v4.app.Fragment {

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
        float dpDensity = context.getResources().getDisplayMetrics().density;

        final LinearLayout parentLL = new LinearLayout(getActivity());
        parentLL.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        parentLL.setOrientation(LinearLayout.VERTICAL);

        if(TopBarMode >= g.TOPBAR_BASIC){ // Back button, page description, options button
            final CardView buttonBarCard = new CardView(getActivity());
            buttonBarCard.setLayoutParams(new CardView.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            buttonBarCard.setUseCompatPadding(true);
            buttonBarCard.setPreventCornerOverlap(false);
            buttonBarCard.setRadius(0);
            buttonBarCard.setPadding(0, 0, 0, 0);
            buttonBarCard.setCardElevation(3.0f / dpDensity);

            final LinearLayout buttonBar = new LinearLayout(getActivity());
            buttonBar.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    buttonBarHeight
            ));
            buttonBar.setOrientation(LinearLayout.HORIZONTAL);
            buttonBar.setVerticalGravity(Gravity.CENTER);

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
                    getActivity().onBackPressed();
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
            buttonBarCard.addView(buttonBar);
            parentLL.addView(buttonBarCard);
        }
        if(TopBarMode >= g.TOPBAR_KANA){ // Hiragana and Katakana buttons
            final CardView buttonBarCard = new CardView(getActivity());
            buttonBarCard.setLayoutParams(new CardView.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            buttonBarCard.setUseCompatPadding(true);
            buttonBarCard.setPreventCornerOverlap(false);
            buttonBarCard.setRadius(0);
            buttonBarCard.setPadding(0, 0, 0, 0);
            buttonBarCard.setCardElevation(2.0f / dpDensity);

            final LinearLayout buttonBar = new LinearLayout(getActivity());
            buttonBar.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    buttonBarHeight
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
                    setKanaMode(g.MODE_HIRAGANA);
                    //switchKanaEdit(v);
                }
            });
            if(g.get_kanaMode() == g.MODE_HIRAGANA){
                button1.setBackgroundResource(R.drawable.btn_grey_rect_focus);
            }else{
                button1.setBackgroundResource(R.drawable.btn_grey_rect);
            }

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
                    setKanaMode(g.MODE_KATAKANA);
                    //switchKanaEdit(v);
                }
            });
            if(g.get_kanaMode() == g.MODE_KATAKANA){
                button2.setBackgroundResource(R.drawable.btn_grey_rect_focus);
            }else{
                button2.setBackgroundResource(R.drawable.btn_grey_rect);
            }

            buttonBar.addView(button1);
            buttonBar.addView(button2);
            buttonBarCard.addView(buttonBar);
            parentLL.addView(buttonBarCard);
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

    private void setKanaMode(int kanaMode){
        //KanaEdit keObj = (KanaEdit)getActivity().getSupportFragmentManager().findFragmentById(R.id.KanaEdit);
        //TODO: Get the KanaEdit fragment to update its kana when the kanaMode is switched
        if(kanaMode == g.MODE_HIRAGANA){
            g.set_kanaMode(g.MODE_HIRAGANA);
            getView().findViewById(R.id.hiraMode).setBackgroundResource(R.drawable.btn_grey_rect_focus);
            getView().findViewById(R.id.kataMode).setBackgroundResource(R.drawable.btn_grey_rect);
            //keObj.reloadKana();
        }else if(kanaMode == g.MODE_KATAKANA){
            g.set_kanaMode(g.MODE_KATAKANA);
            getView().findViewById(R.id.hiraMode).setBackgroundResource(R.drawable.btn_grey_rect);
            getView().findViewById(R.id.kataMode).setBackgroundResource(R.drawable.btn_grey_rect_focus);
            //keObj.reloadKana();
        }
    }

}
