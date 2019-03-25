package com.example.abkire.project3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> viewIdList = new ArrayList<Integer>();
    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetButton = (Button) findViewById(R.id.reset_button);


        resetButton.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {

                resetCards();


              }
            });

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
            MediaPlayer mp = MediaPlayer.create(this, R.raw.pop);
            mp.start();
        }

    }
    public void resetCards()
    {
        Toast.makeText(getApplicationContext(), "Reset Cards", Toast.LENGTH_LONG).show();

    }
}
