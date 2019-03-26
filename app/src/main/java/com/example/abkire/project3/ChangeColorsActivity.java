package com.example.abkire.project3;

import android.content.Intent;
import android.graphics.Color;
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
    Button preClickBtn;
    int preClickBtnColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Integer.parseInt(DataHolder.getInstance().getData())));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_colors);

        // get the intent that started this activity and extract data
        Intent intent = getIntent();

        postClickBtn = (Button)findViewById(R.id.postClickBtn);
        postClickBtnColor = Integer.parseInt(DataHolder.getInstance().getData());
        postClickBtn.setBackgroundColor(postClickBtnColor);
        postClickBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                openColorPicker();
            }
        });

        preClickBtn = (Button)findViewById(R.id.preClickBtn);
        preClickBtnColor = Integer.parseInt(DataHolder2.getInstance().getData());
        preClickBtn.setBackgroundColor(preClickBtnColor);
        preClickBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                openColorPicker2();
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
    private void openColorPicker2() {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, preClickBtnColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                // do nothing.
            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                String mycol = ""+color;

                preClickBtnColor = color;
                preClickBtn.setBackgroundColor(preClickBtnColor);
                String cols = ""+preClickBtnColor;
                DataHolder2.getInstance().setData(cols);
            }
        });


        colorPicker.show();
    }
}
