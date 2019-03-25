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
        //change color primary theme to post click color
        getSupportActionBar().setBackgroundDrawable(
            new ColorDrawable(Integer.parseInt(DataHolder.getInstance().getData())));
        super.onResume();

        //Coming back from color picking activity update card colors of clicked cards we tracked
        for(CardView c : cardViewsClicked)
        {
            // gets colored we stored from other activity
            c.setCardBackgroundColor(Integer.parseInt(DataHolder.getInstance().getData()));
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //initialize our data holder object that is storing our color so it is not null default to post click color
        if(first) {
            DataHolder.getInstance().setData("" + getResources().getColor(R.color.postclick));
            first = false;
        }
        //change primary color to post click color
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Integer.parseInt(DataHolder.getInstance().getData())));
        //start activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //If a user clicks reset reset all cardview background colors to pre click color
        resetButton = (Button) findViewById(R.id.reset_button);

        resetButton.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Reset Cards", Toast.LENGTH_LONG).show();
                for(CardView c : cardViewsClicked)
                {
                    //Reset cards to pre click color to restart game
                    c.setCardBackgroundColor(getResources().getColor(R.color.preclick));
                }
                // clear tracking of clicked cards
                viewIdList.clear();
                cardViewsClicked.clear();
                //Reset game flag
                finished = false;


              }
            });

        }

    public void  setColors(View view){
        // Intent to start new activity

        Intent intent = new Intent(MainActivity.this, ChangeColorsActivity.class);
        MainActivity.this.startActivity(intent);
    }
    // A card is clicked on do what?
    public void changeCardColor(View view) {
        String data = DataHolder.getInstance().getData();

        int viewid = view.getId();
        CardView card = view.findViewById(viewid);
        //if the card hasn't been clicked this game change its color to post click color and add it to tracking
        card.setCardBackgroundColor(Integer.parseInt(data));
        if (!viewIdList.contains(viewid)) {
            viewIdList.add(viewid);
            cardViewsClicked.add(card);
        }
        //game over when 15 cards are prssed make a sound! and mark as already finished so we don't win until again until reset is pressed
        if(viewIdList.size() ==15 && !finished){
            Toast.makeText(getApplicationContext(), "You Win! ", Toast.LENGTH_LONG).show();
            //play pop!
            MediaPlayer mp = MediaPlayer.create(this, R.raw.pop);
            mp.start();
            finished = true;
        }

    }

}
