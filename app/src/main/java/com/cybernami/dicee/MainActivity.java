package com.cybernami.dicee;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    final int[] DICE_FACES = {
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button rollButton = findViewById(R.id.button_roll);
        final ImageView leftDice = findViewById(R.id.image_dice_left);
        final ImageView rightDice = findViewById(R.id.image_dice_right);

        rollDiceAndUpdate(leftDice, rightDice);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDiceAndUpdate(leftDice, rightDice);
            }
        });
    }

    private void rollDiceAndUpdate(ImageView leftDice, ImageView rightDice) {
        final Random rng = new Random();
        int leftIdx = rng.nextInt(6);
        int rightIdx = rng.nextInt(6);

        leftDice.setImageResource(DICE_FACES[leftIdx]);
        rightDice.setImageResource(DICE_FACES[rightIdx]);

        Log.d("Dicee", String.format("Dice roll %s %s", ++leftIdx, ++rightIdx));
    }
}
