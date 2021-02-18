package com.hahagua.android_learn_tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Red will go first
    boolean redFlag = true;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    ImageView img7;
    ImageView img8;
    ImageView img9;
    int[] placed = new int[9];
    int[] color = new int[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img1 = findViewById(R.id.red_button_1);
        ImageView img2 = findViewById(R.id.red_button_2);
        ImageView img3 = findViewById(R.id.red_button_3);
        ImageView img4 = findViewById(R.id.red_button_4);
        ImageView img5 = findViewById(R.id.red_button_5);
        ImageView img6 = findViewById(R.id.red_button_6);
        ImageView img7 = findViewById(R.id.red_button_7);
        ImageView img8 = findViewById(R.id.red_button_8);
        ImageView img9 = findViewById(R.id.red_button_9);
    }

    public void dropIn(View view) {
        Toast.makeText(getApplicationContext(), "Test string", Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Test string", Toast.LENGTH_SHORT).show();

        ImageView counter = (ImageView) view;
        String tag = String.valueOf(view.getTag());
        int imgId = Integer.parseInt(tag) - 1;
        if (placed[imgId] == 0) {
            if (redFlag) {
                counter.setImageResource(R.drawable.red);
                color[imgId] = 1;
                redFlag = !redFlag;
            } else {
                counter.setImageResource(R.drawable.yellow);
                color[imgId] = 2;
                redFlag = !redFlag;
            }
        }

        String winMsg = !redFlag ? "Red Win" : "Yellow Win";
        if (checkWin()) {
            Toast.makeText(getApplicationContext(), winMsg, Toast.LENGTH_SHORT).show();
        }
        placed[imgId] = 1;
    }

    private boolean checkWin() {
        return checkRow() || checkColumn() ||checkDiag();
    }

    private boolean checkRow() {
        for (int i = 0; i < 3; i++) {
            if (color[i * 3] != 0 && color[i * 3] == color[i * 3 + 1] && color[i * 3 + 1] == color[i * 3 + 2]) {
                return true;
            }
        }
        return false;
    }
    private boolean checkColumn() {
        for (int i = 0; i < 3; i++) {
            if (color[i] != 0 && color[i] == color[i + 3] && color[i + 3] == color[i + 6]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiag() {
        return (color[0] != 0 && color[0] == color[4] && color[4] == color[8]) || (color[2] != 0 && color[2] == color[4] && color[4] == color[6]);
    }

}