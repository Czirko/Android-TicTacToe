package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[][] table;
    int round;
   LinearLayout tableLayout;
    Button btn;
    List<Button> btns;
    int scoreX;
    int scoreY;
    TextView tvScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableLayout=findViewById(R.id.llTable);
        btns=new ArrayList<>();
        btn=findViewById(R.id.a1);
        btns.add(btn);
        btn=findViewById(R.id.a2);
        btns.add(btn);
        btn=findViewById(R.id.a3);
        btns.add(btn);
        btn=findViewById(R.id.b1);
        btns.add(btn);
        btn=findViewById(R.id.b2);
        btns.add(btn);
        btn=findViewById(R.id.b3);
        btns.add(btn);
        btn=findViewById(R.id.c1);

        btns.add(btn);
        btn=findViewById(R.id.c2);
        btns.add(btn);
        btn=findViewById(R.id.c3);
        btns.add(btn);

        table=new String[3][3];
        scoreX=0;
        scoreY=0;
        newTable(table);







    }

    private void newTable(String[][] table) {
       for(int i =0;i<3;i++){
           for(int j =0;j<3;j++){
               table[i][j]="";
           }
       }
        for(Button b: btns){
            b.setText("");
        }
       round=1;
    }


    public void a1(View view) {
        if(table[0][0].equals("")){
            table[0][0]=nextPlayer();
            btn=findViewById(R.id.a1);
            btn.setText(nextPlayer());
            isWon(table);

        }



    }


    public void a2(View view) {
        if(table[0][1].equals("")){
            table[0][1]=nextPlayer();
            btn=findViewById(R.id.a2);
            btn.setText(nextPlayer());
            isWon(table);

        }
    }
    public void a3(View view) {
        if(table[0][2].equals("")){
            table[0][2]=nextPlayer();
            btn=findViewById(R.id.a3);
            btn.setText(nextPlayer());
            isWon(table);


        }
    }



    public void b1(View view) {
        if(table[1][0].equals("")){
            table[1][0]=nextPlayer();
            btn=findViewById(R.id.b1);
            btn.setText(nextPlayer());
            isWon(table);


        }
    }

    public void b2(View view) {
        if(table[1][1].equals("")) {
            table[1][1] = nextPlayer();
            btn = findViewById(R.id.b2);
            btn.setText(nextPlayer());
            isWon(table);
        }
    }

    public void b3(View view) {
        if(table[1][2].equals("")){
            table[1][2]=nextPlayer();
            btn=findViewById(R.id.b3);
            btn.setText(nextPlayer());
            isWon(table);

        }
    }

    public void c1(View view) {
        if(table[2][0].equals("")){
            table[2][0]=nextPlayer();
            btn=findViewById(R.id.c1);
            btn.setText(nextPlayer());
            isWon(table);

        }
    }

    public void c2(View view) {
        if(table[2][1].equals("")) {
            table[2][1] = nextPlayer();
            btn = findViewById(R.id.c2);
            btn.setText(nextPlayer());
            isWon(table);
        }
    }

    public void c3(View view) {
        if(table[2][2].equals("")){
            table[2][2]=nextPlayer();
            btn=findViewById(R.id.c3);
            btn.setText(nextPlayer());
            isWon(table);

        }

    }


    private void isWon(String[][] tabla){
        boolean nyert = false;

        for (int i = 0; i < 3; i++) {
            if (       tabla[i][0].equals("X") && tabla[i][1].equals("X") && tabla[i][2].equals("X")
                    || tabla[0][i].equals("X") && tabla[1][i].equals("X") && tabla[2][i].equals("X")
                    || tabla[0][0].equals("X") && tabla[1][1].equals("X") && tabla[2][2].equals("X")
                    || tabla[0][2].equals("X") && tabla[1][1].equals("X") && tabla[2][0].equals("X")

                    || tabla[i][0].equals("O") && tabla[i][1].equals("O") && tabla[i][2].equals("O")
                    || tabla[0][i].equals("O") && tabla[1][i].equals("O") && tabla[2][i].equals("O")
                    || tabla[0][0].equals("O") && tabla[1][1].equals("O") && tabla[2][2].equals("O")
                    || tabla[0][2].equals("O") && tabla[1][1].equals("O") && tabla[2][0].equals("O")) {
                nyert = true;

            }
        }
        if(nyert){

            String text="Congratulation "+nextPlayer()+" has won";
            if(nextPlayer().equals("X")){
                scoreX++;
                tvScore=findViewById(R.id.tvX);
                tvScore.setText(scoreX+"");
            }else{
                scoreY++;
                tvScore=findViewById(R.id.tvY);
                tvScore.setText(scoreY+"");
            }
            Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
            newTable(table);
        }
        round++;

    }
    private String nextPlayer() {
        if(round%2==1){
            return "X";
        }else{
           return "O";
        }
    }

    public void newGame(View view) {
        newTable(table);
        for(Button b: btns){
            b.setText("");
        }
        scoreY=0;
        tvScore=findViewById(R.id.tvY);
        tvScore.setText(scoreY+"");

        scoreX=0;
        tvScore=findViewById(R.id.tvX);
        tvScore.setText(scoreX+"");


    }
}
