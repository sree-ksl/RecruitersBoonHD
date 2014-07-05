package com.awesomecandidates.recruitersboon;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHelper extends SQLiteOpenHelper{

	private SQLiteDatabase mDb;
	
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
		
		String jb_table = "create table " + Database.JB_TABLE_NAME + " ( " +
	              Database.JB_ID + "integer primary key autoincrement, " +
				  Database.JB_CATEGORY + "TEXT)" ;
		
		String rg_table = "create table " + Database.RG_TABLE_NAME + " ( " +
		          Database.RG_ID + "integer primary key autoincrement, " +
				  Database.RG_UNAME + "TEXT" +
		          Database.RG_EMAIL + "TEXT" +
				  Database.RG_PWD + "TEXT)" ;
	
	
	try{
		database.execSQL(cd_table);
		database.execSQL(jb_table);
		database.execSQL(rg_table);
	}catch(Exception ex){
		Log.d(Database.TAG, "Error in DBHelper.onCreate() : " + ex.getMessage());
	}
	
  }
	public Cursor fetchListItems() {
		Cursor cursor = 
	            mDb.query(Database.RG_TABLE_NAME, new String[] 
	                      {Database.RG_ID, Database.RG_UNAME, Database.RG_EMAIL, Database.RG_PWD}, 
	                      null, null, null, null, null);

	        if (cursor != null) {
	            cursor.moveToFirst();
	        }
	        return cursor;		
	}

	

}
