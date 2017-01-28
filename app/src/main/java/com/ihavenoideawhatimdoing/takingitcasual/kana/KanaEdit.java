package com.ihavenoideawhatimdoing.takingitcasual.kana;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;

import static android.R.attr.button;

public class KanaEdit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kana_edit);

        GlobalSingleton g = GlobalSingleton.getSingletonObject();

        TextView topText = (TextView)findViewById(R.id.topText);
        topText.setText(g.get_testvar());

        final TableLayout tableLayout = (TableLayout) findViewById(R.id.activity_kana_edit);

        for (int i = 0; i < 5; i++) {
            final TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

            for (int i2 = 0; i2 < 5; i2++) {
                final AppCompatImageButton button = new AppCompatImageButton(this);

                Context context = button.getContext();
                int id = context.getResources().getIdentifier("a0"+Hiragana.IndexToHex(5*i+i2), "drawable", context.getPackageName());

                button.setImageResource(id);
                button.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                button.setColorFilter(ContextCompat.getColor(context,R.color.colorBlack));
                button.setScaleType(AppCompatImageButton.ScaleType.FIT_XY);
/*                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final TableRow parent = (TableRow) v.getParent();
                        tableLayout.removeView(parent);
                    }
                });*/

                tableRow.addView(button);
            }
            tableLayout.addView(tableRow);
        }
    }

    public void switchTopMenu(View view) {
        startActivity(new Intent(KanaEdit.this, TopMenu.class));
        overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
    }
}
