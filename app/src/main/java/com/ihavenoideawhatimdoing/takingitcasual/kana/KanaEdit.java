package com.ihavenoideawhatimdoing.takingitcasual.kana;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.Space;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;

import com.ihavenoideawhatimdoing.takingitcasual.kana.singleton.GlobalSingleton;

public class KanaEdit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kana_edit);

        GlobalSingleton g = GlobalSingleton.getSingletonObject();

        TextView topText = (TextView)findViewById(R.id.topText);
        topText.setText(g.get_testvar());

        final TableLayout tableLayout = (TableLayout) findViewById(R.id.activity_kana_edit);

        for (int i = 0; i < 16; i++) {
            final TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

            for (int i2 = 0; i2 < 5; i2++) {
                if (!g.IndexToSound(5 * i + i2).isEmpty()){
                    final LinearLayout button = new LinearLayout(this);
                    TableRow.LayoutParams params = new TableRow.LayoutParams(
                            TableRow.LayoutParams.WRAP_CONTENT,
                            TableRow.LayoutParams.WRAP_CONTENT
                    );
                    Context context = button.getContext();
                    final int margin = context.getResources().getDimensionPixelSize(R.dimen.spacing_tiny);
                    params.setMargins(margin, margin, margin, margin);
                    button.setLayoutParams(params);

                    button.setOrientation(LinearLayout.VERTICAL);
                    button.setBackgroundResource(R.drawable.btn_kana);
                    button.setClickable(true);
                    button.setFocusable(true);
                    button.setPadding(margin, margin, margin, margin);

                    final AppCompatImageView buttonImage = new AppCompatImageView(this);
                    buttonImage.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    ));

                    context = buttonImage.getContext();
                    int id = context.getResources().getIdentifier("a0" + g.IndexToHex(5 * i + i2), "drawable", context.getPackageName());

                    buttonImage.setImageResource(id);
                    buttonImage.setColorFilter(ContextCompat.getColor(context, R.color.black));
                    buttonImage.setScaleType(AppCompatImageView.ScaleType.CENTER_INSIDE);
                    buttonImage.setAdjustViewBounds(true);
    /*                button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            final TableRow parent = (TableRow) v.getParent();
                            tableLayout.removeView(parent);
                        }
                    });*/

                    final TextView buttonText = new TextView(this);
                    buttonText.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    ));
                    buttonText.setGravity(Gravity.CENTER_HORIZONTAL);
                    buttonText.setText(g.IndexToSound(5 * i + i2));
                    buttonText.setTypeface(null, Typeface.BOLD);

                    button.addView(buttonImage);
                    button.addView(buttonText);
                    tableRow.addView(button);
                }else{
                    final Space emptySpace = new Space(this);
                    tableRow.addView(emptySpace);
                }
            }
            tableLayout.addView(tableRow);
        }
    }

    public void switchTopMenu(View view) {
        startActivity(new Intent(KanaEdit.this, TopMenu.class));
        overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
    }
}
