package com.awesomecandidates.recruitersboon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText editUsername, editEmailid , editPassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editUsername = (EditText)findViewById(R.id.editUname);
		editEmailid = (EditText)findViewById(R.id.editEmail);
		editPassword = (EditText)findViewById(R.id.editPwd);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void registerAccount(){
		Intent intent = new Intent(this, JobActivity.class);
		startActivity(intent);
	}

}
