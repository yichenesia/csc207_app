package com.example.game2.endgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.GameListActivity;
import com.example.game.R;
import com.example.game.SwitchActivityInterface;
import com.example.game3.Activities.InstructionActivity;

import java.util.Objects;

/**
 * The activity that runs after Game 2 is over.
 **/
public class Game2PassActivity extends AppCompatActivity implements SwitchActivityInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2_pass);

        //Get score
        String score = Objects.requireNonNull(
                Objects.requireNonNull(getIntent().getExtras()).get("score")).toString();

        TextView displayScore = findViewById(R.id.displayScore);
        TextView displayLives = findViewById(R.id.lives);

        //Display the lives left
        displayLives.setText(String.format("Lives left: " + getIntent().getIntExtra("lives", 3)));

        //Display number of artifacts collected
        TextView displayArt = findViewById(R.id.artifacts);
        displayArt.setText(String.format("Artifacts: " + getIntent().getIntExtra("artifacts", 0)));

        //Display score
        displayScore.setText(String.format("Score = %s", score));
    }

    /**
     * Returns to the main menu or starts Game 3.
     *
     * @param view - the view of the display area.
     **/
    @Override
    public void nextActivity(View view) {
        int tag = view.getId();

        Intent intent;

        switch (tag) {
            case R.id.mainMenu:
                intent = new Intent(Game2PassActivity.this, GameListActivity.class);

                startActivity(intent);

                break;
            case R.id.nextGame:
                intent = new Intent(Game2PassActivity.this, InstructionActivity.class);

                startActivity(intent);

                break;
            default:
                break;
        }
    }
}
