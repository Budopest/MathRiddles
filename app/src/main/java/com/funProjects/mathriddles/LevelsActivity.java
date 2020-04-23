package com.funProjects.mathriddles;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class LevelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        ArrayList<Level> levels = new ArrayList<Level>();
        LevelsSQLiteHandler db = new LevelsSQLiteHandler(this);


        Cursor data = db.getAllData();
        int index = 0;
        while(data.moveToNext()){
            try{
            levels.add(new Level(data.getInt(1),data.getString(2),data.getString(3),data.getInt(4)));
            }
            catch (Exception e){
                Log.e("Database Exception",e.toString());
            }


        }
        LevelsAdapter levelsAdabter = new LevelsAdapter(this,levels);
        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.levelsList);
        listView.setAdapter(levelsAdabter);


    }
}

