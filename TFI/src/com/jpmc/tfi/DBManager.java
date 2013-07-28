package com.jpmc.tfi;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "tfi";

    private SQLiteDatabase db;
    
    //Create database tables
    private static final String DATABASE_CREATE1 ="CREATE TABLE IF NOT EXISTS student (sid INTEGER(6))";
    private static final String DATABASE_CREATE2 ="CREATE TABLE IF NOT EXISTS register (sid INTEGER(6), isPresent TINYINT(1))";

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
	public void onCreate(SQLiteDatabase db) 
	{
    	db.execSQL(DATABASE_CREATE1);
    	db.execSQL(DATABASE_CREATE2);
    	for(int i=1;i<=10;i++)
    	{
	    	String query="INSERT INTO student VALUES("+i+");";
	    	db.execSQL(query);
	    	query="INSERT INTO register VALUES("+i+",0);";
	    	db.execSQL(query);
    	}
	}
    
	public void onUpgrade(SQLiteDatabase db, int oldVersion, 
			  int newVersion) 
	{
		onCreate(db);
	}
    
    public void open() throws SQLException 
    {
        db=this.getWritableDatabase();
    }

    public void close() 
    {
        db.close();
    } 
    
    public Cursor getSID()
    {
    	String query="SELECT sid FROM student WHERE 1;";
    	Cursor c_sid=db.rawQuery(query, null);
    	return c_sid;
    }
    
    public void setAttendance(String sid,int isPresent)
    {
    	try{
    	String query="UPDATE register SET isPresent="+isPresent+" WHERE sid="+sid;
    	db.execSQL(query);

    	}
    	catch(Exception e)
    	{
    		System.out.println("aa"+e);
    	}
    }
    

}
