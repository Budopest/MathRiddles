package com.funProjects.mathriddles;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class LevelActivity extends AppCompatActivity {

    private int levelNumber=-1;
    Level level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)  levelNumber = bundle.getInt("LEVELNUMBER");
        Log.v("LEVEL NUMBER : ", String.valueOf(levelNumber));
        if(levelNumber!= -1){
        LevelsSQLiteHandler db = new LevelsSQLiteHandler(this);
        Cursor cursor = db.getLevelData(levelNumber);
        while (cursor.moveToNext()){
            Log.v(this.toString(), "Level Number = " + cursor.getInt(1) + "level stats : " + cursor.getInt(5)  );
            level = new Level(cursor.getInt(1),cursor.getInt(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5));
        }
        }
     ImageView quizImage = (ImageView) findViewById(R.id.levelImage);
     quizImage.setImageResource(level.getLevelResource());
    }

}
