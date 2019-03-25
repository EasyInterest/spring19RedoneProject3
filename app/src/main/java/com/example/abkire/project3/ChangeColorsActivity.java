package com.example.abkire.project3;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import yuku.ambilwarna.AmbilWarnaDialog;

public class ChangeColorsActivity extends AppCompatActivity {

    Button postClickBtn;
    int postClickBtnColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_colors);

        // get the intent that started this activity and extract data
        Intent intent = getIntent();

        postClickBtn = (Button)findViewById(R.id.postClickBtn);
        postClickBtnColor = ContextCompat.getColor(ChangeColorsActivity.this, R.color.postclick);

        postClickBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                openColorPicker();
            }
        });
    }

    private void openColorPicker() {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, postClickBtnColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                // do nothing.
            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                String mycol = ""+color;

                postClickBtnColor = color;
                postClickBtn.setBackgroundColor(postClickBtnColor);
                String cols = ""+postClickBtnColor;
                DataHolder.getInstance().setData(cols);
            }
        });


        colorPicker.show();
    }
}
