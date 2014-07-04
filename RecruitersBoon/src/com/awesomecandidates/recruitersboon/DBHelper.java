package com.awesomecandidates.recruitersboon;


import com.awesomecandidates.recruitersboon.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHelper extends SQLiteOpenHelper{

	public static final int DB_VERSION = 2;
	public static final String DB_NAME = "edata.db";
	public DBHelper(Context ctx) {
		super(ctx, DB_NAME , null , DB_VERSION);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		createTables(db);
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public void createTables(SQLiteDatabase database){
		String cd_table = "create table " + Database.CD_TABLE_NAME + " ( " +
	              Database.CD_ID + " integer primary key autoincrement, " +
				  Database.CD_EMAIL + "TEXT" +
	              Database.CD_NAME + "TEXT" +
	              Database.CD_BIO + "TEXT" +
				  Database.CD_TOPICS + "TEXT)" ;
	
	
	try{
		database.execSQL(cd_table);
	}catch(Exception ex){
		Log.d(Database.TAG, "Error in DBHelper.onCreate() : " + ex.getMessage());
	}
	
  }
	

}
