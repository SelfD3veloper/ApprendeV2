package com.cbedoy.apprende;

import java.util.HashMap;

import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cbedoy.apprende.bussiness.MasterController;
import com.cbedoy.apprende.interfaces.IAsyncServiceDelegate;
import com.cbedoy.apprende.interfaces.IContextDetection;
import com.cbedoy.apprende.interfaces.viewdelegates.ILoginViewDelegate;
import com.cbedoy.apprende.keysets.ServiceKeySet;
import com.cbedoy.apprende.keysets.UserKeySet;
import com.cbedoy.apprende.services.AppInstanceProvider;

public class LoginView extends Activity implements ILoginViewDelegate{

	private MasterController masterController;
	private EditText username;
	private EditText password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_view);

		((TextView) findViewById(R.id.version_name)).setTypeface(AppInstanceProvider.lightFont);
		((Button) 	findViewById(R.id.login_action)).setTypeface(AppInstanceProvider.lightFont);
		((EditText) findViewById(R.id.username_field)).setTypeface(AppInstanceProvider.lightFont);
		((EditText) findViewById(R.id.password_field)).setTypeface(AppInstanceProvider.lightFont);
		this.username = (EditText)findViewById(R.id.username_field);
		this.password = (EditText)findViewById(R.id.password_field);
		
		this.username.setText("cbedoy");
		this.password.setText("nomeacuerdo");
		
		View.OnClickListener loginAction = new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				requestLogin();
			}
		};
		
		findViewById(R.id.login_action).setOnClickListener(loginAction);
	}
	
	private void requestLogin(){
		HashMap<Object, Object> information = new HashMap<Object, Object>();
		information.put(UserKeySet.USERNAME, this.username.getText().toString());
		information.put(UserKeySet.PASSWORD, this.password.getText().toString());
		masterController = AppInstanceProvider.getInstance().instanceServiceLogin(this, information, ServiceKeySet.GET_USER_INFO);
		masterController.getAnsycTask().execute();
		
	}

	@Override
	public void reloadData(JSONObject jsonObject) {
		Intent intent = new Intent(this, ProfileView.class);
		startActivity(intent);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.login_menu, menu);
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.action_registration:
	            Intent intent = new Intent(this, RegistrationView.class);
	            startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
}