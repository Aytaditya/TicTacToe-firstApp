package com.aditya.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 0=0
    // X=1
    //blank=2
    int activePlayer=0;
    int [] gameState={2,2,2,2,2,2,2,2,2};
    int [][] winPos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,5,6}};
    boolean gameActive=true;

    public void playerTap(View view){
        ImageView img=(ImageView) view;
        int tappedImg=Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if(gameState[tappedImg]==2){
            gameState[tappedImg]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0){
                img.setImageResource(R.drawable.zero1);
                activePlayer=1;
                TextView status= findViewById(R.id.status);
                status.setText("Player X turn now-Continue");
            }
            else{
                img.setImageResource(R.drawable.cross);
                activePlayer=0;
                TextView status= findViewById(R.id.status);
                status.setText("Player O turn now-Continue");
            }
            img.animate().translationYBy(1000f).setDuration(300);

        }
        //checking if any player has won
        for(int []winPosition:winPos){
            if(gameState[winPosition[0]]==gameState[winPosition[1]] &&
                    gameState[winPosition[1]]==gameState[winPosition[2]] &&
                    gameState[winPosition[0]]!=2){
                //somebody has won state
                //now we will find out how won and show
                gameActive=false;
                String winnerStr;
                if(gameState[winPosition[0]]==0){

                     winnerStr="O has won the game";

                }
                else {
                    winnerStr = "X has won the game";
                }
                //updating status bar for winner
                TextView status= findViewById(R.id.status);
                status.setText(winnerStr);


            }
        }




    }
    public void gameReset(View view){
        gameActive=true;
        activePlayer=0;
        for(int j = 0;j<gameState.length;j++){
            gameState[j]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        TextView status=findViewById(R.id.status);
        status.setText("Player X turn now-Continue");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}