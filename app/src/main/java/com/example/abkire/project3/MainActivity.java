package com.example.abkire.project3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> viewIdList = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void  setColors(View view){
        // Intent to start new activity
        Intent intent = new Intent(MainActivity.this, ChangeColorsActivity.class);
        MainActivity.this.startActivity(intent);
    }

    public void changeCardColor(View view) {
        int viewid = view.getId();
        CardView card = view.findViewById(viewid);
        card.setCardBackgroundColor(getResources().getColor(R.color.postclick));
        if (!viewIdList.contains(viewid)) {
            viewIdList.add(viewid);
        }
        if(viewIdList.size() ==15){
            Toast.makeText(getApplicationContext(), "You Win! ", Toast.LENGTH_LONG).show();
        }

    }
}
