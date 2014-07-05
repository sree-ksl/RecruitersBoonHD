package com.awesomecandidates.recruitersboon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends Activity implements OnClickListener{

	Button buttonSend;
	EditText textTo;
	EditText textSubject;
	EditText textMessage;
	public String toId = "";
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email);
	
		buttonSend = (Button) findViewById(R.id.buttonSend);
		textTo = (EditText) findViewById(R.id.editTextTo);
		textSubject = (EditText) findViewById(R.id.editTextSubject);
		textMessage = (EditText) findViewById(R.id.editTextMessage);
 
		//Intent i = getIntent();
		//final String toId = i.getStringExtra(("email"));
	    Bundle extras = getIntent().getExtras();
	    if(extras != null){
	    	toId = extras.getString("email");
	    }
	    buttonSend.setOnClickListener(this);
	}
		
// 
//			@Override
//			public void onClick(View v) {
// 
//			  String to = textTo.setText(toId);
//			  String subject = textSubject.getText().toString();
//			  String message = textMessage.getText().toString();
// 
//			  Intent email = new Intent(Intent.ACTION_SEND);
//			  email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
//			  //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
//			  //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
//			  email.putExtra(Intent.EXTRA_SUBJECT, subject);
//			  email.putExtra(Intent.EXTRA_TEXT, message);
// 
//			  //need this to prompts email client only
//			  email.setType("message/rfc822");
// 
//			  startActivity(Intent.createChooser(email, "Choose an Email client :"));
// 
//			}
//		});
//	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		  textTo.setText(toId);
		  String subject = textSubject.getText().toString();
		  String message = textMessage.getText().toString();

		  Intent email = new Intent(Intent.ACTION_SEND);
		  email.putExtra(Intent.EXTRA_EMAIL, new String[]{ toId});
		  //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
		  //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
		  email.putExtra(Intent.EXTRA_SUBJECT, subject);
		  email.putExtra(Intent.EXTRA_TEXT, message);

		  //need this to prompts email client only
		  email.setType("message/rfc822");

		  startActivity(Intent.createChooser(email, "Choose an Email client :"));

	}

}
