package com.example.abkire.project3;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
    ArrayList<CardView> cardViewsClicked = new ArrayList<CardView>();
    private boolean finished = false;
    private Button resetButton;
    private boolean first = true;


    @Override
    public void onResume()
    {
        getSupportActionBar().setBackgroundDrawable(
            new ColorDrawable(Integer.parseInt(DataHolder.getInstance().getData())));
        super.onResume();


        for(CardView c : cardViewsClicked)
        {

            c.setCardBackgroundColor(Integer.parseInt(DataHolder.getInstance().getData()));
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(first) {
            DataHolder.getInstance().setData("" + getResources().getColor(R.color.postclick));
            first = false;
        }
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Integer.parseInt(DataHolder.getInstance().getData())));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        resetButton = (Button) findViewById(R.id.reset_button);





        resetButton.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Reset Cards", Toast.LENGTH_LONG).show();
                for(CardView c : cardViewsClicked)
                {
                    c.setCardBackgroundColor(getResources().getColor(R.color.preclick));
                }
                viewIdList.clear();
                cardViewsClicked.clear();
                finished = false;


              }
            });

        }

    public void  setColors(View view){
        // Intent to start new activity

        Intent intent = new Intent(MainActivity.this, ChangeColorsActivity.class);
        MainActivity.this.startActivity(intent);
    }

    public void changeCardColor(View view) {
        String data = DataHolder.getInstance().getData();

        int viewid = view.getId();
        CardView card = view.findViewById(viewid);

        card.setCardBackgroundColor(Integer.parseInt(data));
        if (!viewIdList.contains(viewid)) {
            viewIdList.add(viewid);
            cardViewsClicked.add(card);
        }
        if(viewIdList.size() ==15 && !finished){
            Toast.makeText(getApplicationContext(), "You Win! ", Toast.LENGTH_LONG).show();
            MediaPlayer mp = MediaPlayer.create(this, R.raw.pop);
            mp.start();
            finished = true;
        }

    }

}
