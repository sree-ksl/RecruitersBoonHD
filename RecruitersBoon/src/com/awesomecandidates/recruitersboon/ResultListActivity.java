package com.awesomecandidates.recruitersboon;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class ResultListActivity extends Activity{
	
	Button emailbtn;
	ListView resultsList;
    public String targetEmail;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		resultsList = (ListView) findViewById(R.id.listResults);
		
		DBHelper dbHelper = new DBHelper(this);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		
		//Get a cursor for the list of items
		Cursor listCursor = dbHelper.fetchListItems();
		startManagingCursor(listCursor);
		
		//set the custom list adapter
		//setListAdapter(new MyListAdapter(this, listCursor));
		
		resultsList = getListView();
		resultsList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				Cursor c = (Cursor)resultsList.getItemAtPosition(position);
				String val = c.getString(getColumnIndex(Database.RG_EMAIL));
				targetEmail = val;
			}

			private int getColumnIndex(String rgEmail) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		});
		
		
	}
	
	private ListView getListView() {
		// TODO Auto-generated method stub
		return null;
	}

	public void sendEmail()
	{
		Intent intent = new Intent(this,EmailActivity.class);
		intent.putExtra("email", targetEmail);
		
		startActivity(intent);
	}
	

}
