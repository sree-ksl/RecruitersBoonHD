package com.awesomecandidates.recruitersboon;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class Database {
	
	public static final String TAG = "Email Data";
	public static final String CD_TABLE_NAME = "user_data";
	public static final String CD_ID = "_ID";
	public static final String CD_EMAIL = "email_id";
	public static final String CD_NAME = "user_name";
	public static final String CD_TOPICS = "topic_s";
	public static final String CD_BIO = "bio_data";
	
	public static String getDatabasePath(Context context) {
		DBHelper dbhelper = new DBHelper(context);
		SQLiteDatabase db = dbhelper.getReadableDatabase();
		String path = db.getPath();
		db.close();
		dbhelper.close();
		return path;
	}

}
