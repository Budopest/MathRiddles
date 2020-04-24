package com.funProjects.mathriddles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LevelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        final ArrayList<Level> levels = new ArrayList<Level>();
        LevelsSQLiteHandler db = new LevelsSQLiteHandler(this);
        Cursor data = db.getAllData();
        int index = 0;
        while(data.moveToNext()){
            try{
            levels.add(new Level(data.getInt(1),data.getInt(2),data.getString(3),data.getString(4),data.getInt(5)));
            Log.v(this.toString(),"data : "+data.getInt(0) + "   " + data.getInt(1) + "   " +
                    data.getInt(2) + "   " + data.getString(3) + "   " + data.getString(4)
                     + data.getInt(5));
            }
            catch (Exception e){
                Log.e("Database Exception",e.toString());
            }
        }
        if(!levels.isEmpty()){
        LevelsAdapter levelsAdabter = new LevelsAdapter(this,levels);
        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.levelsList);
        listView.setAdapter(levelsAdabter);
            final Context context = this;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView levelNumber = (TextView) findViewById(R.id.levelNumberText);
                Toast toast = Toast.makeText(context,levelNumber.getText()+context.toString(),Toast.LENGTH_SHORT);
                toast.show();
                Intent Level = new Intent(context,LevelActivity.class);
                Level.putExtra("LEVELNUMBER",levels.get(position).getLevelNumber());
                context.startActivity(Level);
            }
        });
        }


    }
}

