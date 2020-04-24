package com.funProjects.mathriddles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class LevelActivity extends AppCompatActivity {

    private int levelNumber=-1;
    LevelsSQLiteHandler db;
    Level level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)  levelNumber = bundle.getInt("LEVELNUMBER");
        Log.v("LEVEL NUMBER : ", String.valueOf(levelNumber));
        if(levelNumber!= -1){
            db = new LevelsSQLiteHandler(this);
        Cursor cursor = db.getLevelData(levelNumber);
        while (cursor.moveToNext()){
            Log.v(this.toString(), "Level Number = " + cursor.getInt(1) + "level stats : " + cursor.getInt(5)  );
            level = new Level(cursor.getInt(1),cursor.getInt(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5));
        }
        }
     ImageView quizImage = (ImageView) findViewById(R.id.levelImage);
     quizImage.setImageResource(level.getLevelResource());
        Button enterbutton = (Button) findViewById(R.id.enterbutton);
        final Context context = this;
        final Toast toast;
        enterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    EditText answer = (EditText) findViewById(R.id.answertext);
                    if(parseInt(answer.getText().toString()) == parseInt(level.getSolution())){
                        Toast.makeText(context,"Correct Answer",Toast.LENGTH_SHORT).show();
                        db.updateStatus(level.getLevelNumber(),1);
                    }
                    else
                        Toast.makeText(context,"Wrong Answer",Toast.LENGTH_SHORT).show();
                        answer.setText("");
                }
                catch (NumberFormatException E) {
                    Log.e(this.toString(),E.getStackTrace().toString());}

            }
        });
    }

}
