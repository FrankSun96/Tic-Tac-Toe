package com.example.a001.tit_tat_toe;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Boolean flagX = true;
    private Boolean gameOver = false;
    private int[] textViewID = new int[] { R.id.button1,R.id.button2, R.id.button3,
            R.id.button4,R.id.button5, R.id.button6,R.id.button7,R.id.button8,R.id.button9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected  void onResume(){
        super.onResume();
    }

    protected  void onPause(){
        super.onPause();;
    }

    public void onShareClick(View view){
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_SUBJECT, "share#");
        share.putExtra(Intent.EXTRA_TEXT, "tic-tac-toe is so fun! come and play with me!");
        share.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(Intent.createChooser(share,getTitle()));

    }

    public void onChessClick(View view) {
        if(!gameOver) {
            Button chess = (Button) view;
            if (chess.getText().toString().equals("")) {
                if (flagX) {
                    chess.setText("X");
                    chess.setTextColor(Color.RED);
                    flagX = false;
                } else {
                    chess.setText("O");
                    chess.setTextColor(Color.BLUE);
                    flagX = true;
                }
            }
            check();
        }
    }
    public void onNewClick(View view){
        flagX = true;
        gameOver = false;
        Button button[][] = new Button[3][3];
        int count = 0;
        //遍历每一个button
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                button[i][j] = (Button)findViewById(textViewID[count++]);
                button[i][j].setText("");
            }
        }
    }
    public void check(){
        Button button[][] = new Button[3][3];
        int count = 0;
        int selected = 0;
        //遍历每一个button
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                button[i][j] = (Button)findViewById(textViewID[count++]);
                if(!(button[i][j].getText().equals(""))){
                    selected++;
                }
            }
        }
        //检查横三行
        if((button[0][0].getText() == button[0][1].getText()) && (button[0][0].getText() == button[0][2].getText())
                && (button[0][0].getText().equals("O"))){
            hugWin();
        }else if((button[0][0].getText() == button[0][1].getText()) && (button[0][0].getText() == button[0][2].getText())
                && (button[0][0].getText().equals("X"))){
            kissWin();
        }else if((button[1][0].getText() == button[1][1].getText()) && (button[1][0].getText() == button[1][2].getText())
                && (button[1][0].getText().equals("X"))){
            kissWin();
        }else if((button[1][0].getText() == button[1][1].getText()) && (button[1][0].getText() == button[1][2].getText())
                && (button[1][0].getText().equals("O"))){
            hugWin();
        }else if((button[2][0].getText() == button[2][1].getText()) && (button[2][0].getText() == button[2][2].getText())
                && (button[2][0].getText().equals("X"))){
            kissWin();
        }else if((button[2][0].getText() == button[2][1].getText()) && (button[2][0].getText() == button[2][2].getText())
                && (button[2][0].getText().equals("O"))){
            hugWin();
        }
        //检查竖三行
        else if((button[0][0].getText() == button[1][0].getText()) && (button[0][0].getText() == button[2][0].getText())
                && (button[0][0].getText().equals("O"))){
            hugWin();
        }else if((button[0][0].getText() == button[1][0].getText()) && (button[0][0].getText() == button[2][0].getText())
                && (button[0][0].getText().equals("X"))){
            kissWin();
        }else if((button[0][1].getText() == button[1][1].getText()) && (button[0][1].getText() == button[2][1].getText())
                && (button[0][1].getText().equals("X"))){
            kissWin();
        }else if((button[0][1].getText() == button[1][1].getText()) && (button[0][1].getText() == button[2][1].getText())
                && (button[0][1].getText().equals("O"))){
            hugWin();
        }else if((button[0][2].getText() == button[1][2].getText()) && (button[0][2].getText() == button[2][2].getText())
                && (button[0][2].getText().equals("X"))){
            kissWin();
        }else if((button[0][2].getText() == button[1][2].getText()) && (button[0][2].getText() == button[2][2].getText())
                && (button[0][2].getText().equals("O"))){
            hugWin();
        }
        //检查对角
        else if((button[0][0].getText() == button[1][1].getText()) && (button[0][0].getText() == button[2][2].getText())
                && (button[0][0].getText().equals("O"))){
            hugWin();
        }else if((button[0][0].getText() == button[1][1].getText()) && (button[0][0].getText() == button[2][2].getText())
                && (button[0][0].getText().equals("X"))){
            kissWin();
        }else if((button[0][2].getText() == button[1][1].getText()) && (button[0][2].getText() == button[2][0].getText())
                && (button[0][2].getText().equals("O"))){
            hugWin();
        }else if((button[0][2].getText() == button[1][1].getText()) && (button[0][2].getText() == button[2][0].getText())
                && (button[0][2].getText().equals("X"))){
            kissWin();
        }else if(selected == 9){
            tie();
        }

    }
    public void hugWin(){
        Toast.makeText(MainActivity.this, "Hug Wins",
                Toast.LENGTH_LONG).show();
        gameOver = !gameOver;
    }
    public void kissWin(){
        Toast.makeText(MainActivity.this, "Kiss Wins",
                Toast.LENGTH_LONG).show();
        gameOver = !gameOver;
    }
    public void tie(){
        Toast.makeText(MainActivity.this, "Tie",
                Toast.LENGTH_LONG).show();
        gameOver = !gameOver;
    }


}
