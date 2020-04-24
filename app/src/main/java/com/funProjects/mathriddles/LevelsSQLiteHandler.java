package com.funProjects.mathriddles;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class LevelsSQLiteHandler extends SQLiteOpenHelper {

    private final static String databaseName = "MathRiddles";
    private final static int databaseVersion = 1;
    private final static String levelsTableName = "levels";
    private final static String levelID = "level_id";
    private final static String levelNumber = "level_number";
    private final static String levelResourceID = "level_resource_ID";
    private final static String levelHint =   "level_hint";
    private final static String levelSolution = "level_solution";
    private final static String levelStatus = "level_status";

    private String createTableQuery = "CREATE TABLE " + levelsTableName +
            "(" +levelID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            levelNumber + " INTEGER UNIQUE," +
            levelResourceID + " INTEGER," +
            levelSolution + " TEXT NOT NULL," +
            levelHint + " TEXT,"+
            levelStatus + " INTEGER," +
            "CHECK("+levelStatus+" IN(0,1)));";

    public LevelsSQLiteHandler(Context context){
        super(context,databaseName,null,databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(createTableQuery);
        this.insert(db,1,R.drawable.level_1,"23","*2+x",0);
        this.insert(db,2,R.drawable.level_1,"23","*2+x",0);
        this.insert(db,3,R.drawable.level_1,"23","*2+x",0);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insert(SQLiteDatabase db,int number,int resource,String solution,String hint,int status){
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues  values = new ContentValues();
        values.put(levelNumber,number);
        values.put(levelResourceID,resource);
        values.put(levelSolution,solution);
        values.put(levelHint,hint);
        values.put(levelStatus,status);
        long result  = db.insert(levelsTableName,null,values);
        Log.v("levels sql insert :",String.valueOf(result));
        return result != -1;
    }
    public boolean updateStatus(int id,int status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(levelStatus,status);
        long result = db.update(levelsTableName,values,""+levelNumber+" =?",new String[]{String.valueOf(id)});
        Log.v("levels sql update:",String.valueOf(result));

        return result !=-1;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+levelsTableName,null);
        return res;
    }
    public Cursor getLevelData(int key) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ levelsTableName +" WHERE "+ levelNumber +" = " + key,null);
        return res;
    }
    public Integer deleteData (int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(levelsTableName, ""+levelID + " =?",new String[] {String.valueOf(id)});
    }


}
