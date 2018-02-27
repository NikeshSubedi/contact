package com.example.nasa.contacts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by NASA on 2/23/2018.
 */

/**
 * target : get the values of username and password
 * validate the credintials
 * if success open the contactlista page
 */

/**
 * steps : initialize the views
 * set the onclick event listener in the login and signup button
 * when login button is clicked then
 * get the values from username and password
 * check values are null or empty
 * if values are not null and not empty then
 * check the equility of the username and password
 * if username and password is equal then
 * open the contactlist page
 */

public class loginActivity extends AppCompatActivity {
    EditText et_username, et_password;
    Button btn_login, btn_signup;
    String username = "", password= "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // initialize the view
        // we need edittext(username, password)
        // button (login and signup)
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_signup = findViewById(R.id.btn_signup);

        // set the onclick event listener in the login button
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // when button is clicked here
                // get the values from username and password edittext view
                username = et_username.getText().toString();
                password = et_password.getText().toString();
                // check the values are null or empty (simply we called it as form validation)
               boolean success = true;
                if(TextUtils.isEmpty(username)){
                    et_username.setError("Username is empty");
                    success = false;
                }
                if(TextUtils.isEmpty(password)){
                    et_password.setError("Password is empty");
                    success = false;
                }
                if(success){
                    // check the username and password
                    // get the username and password from saved value
                    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    String userName = pref.getString("username", "");
                    String pass = pref.getString("password", "");
                    if(TextUtils.equals(username, userName) && TextUtils.equals(password, pass)){
                        // creditials matched
                        // open the contactlist page
                        Intent intent=new Intent(loginActivity.this,ContactListActivity.class);
                        intent.putExtra("uname",username);
                        startActivity(intent);




                    }else{
                        Toast.makeText(getApplicationContext(), "Username and password not matched", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        // set the onclick event listener in the signup button
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {startActivity(new Intent(loginActivity.this, CreateUserActivity.class));
            }
        });
    }
}
