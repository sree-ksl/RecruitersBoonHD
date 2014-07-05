package com.awesomecandidates.recruitersboon;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class JobActivity extends Activity{

	DBHelper dbHelper;
	EditText jobType;
	Spinner jobCateg;
	Cursor cursor;
	ListView listResults;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		jobType = (EditText)findViewById(R.id.editType);
		jobCateg = (Spinner)findViewById(R.id.selectJob);
		listResults = (ListView)findViewById(R.id.listResults);
		
		Intent intent = new Intent(JobActivity.this, ResultListActivity.class);
		intent.putExtra("jobType", jobType.getText().toString());
		startActivity(intent);
		
		try{
			dbHelper = new DBHelper(this);
			SQLiteDatabase db = dbHelper.getReadableDatabase();
			cursor = db.query(Database.CD_TABLE_NAME, null, null, null, null, null, Database.CD_ID);
			startManagingCursor(cursor);
			String from [] = {Database.CD_EMAIL, Database.CD_NAME, Database.CD_BIO, Database.CD_TOPICS};
			int to [] = {R.id.editEmail, R.id.editUname};
			
			SimpleCursorAdapter ca = new SimpleCursorAdapter(this, R.layout.activity_result, cursor, from, to);
			listResults.setAdapter(ca);
			
		}catch(Exception ex){
			Log.d(Database.TAG, ex.getMessage());
			Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
		}
	}
	
	
	
	

}
