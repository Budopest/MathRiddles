package com.funProjects.mathriddles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context mainAct = this;
        Button levelsButton = (Button) findViewById(R.id.levelsButton);
        /* Move to Levels Activity*/
        levelsButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent levelsAct = new Intent(mainAct,LevelsActivity.class);
                        startActivity(levelsAct);
                    }
                }
        );
        Button exitButton = (Button) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                //System.exit(1);
            }
        });



    }
}
