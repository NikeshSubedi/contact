package com.example.nasa.contacts;

/**
 * Created by NASA on 2/26/2018.
 */

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * add the view activity_create_user
 * initiliaze the component of the view
 * get the user name and password confirmpassword from the view on create button click
 * check the password and confirm password is equal or not and username is not empty
 * if valid save the data username and password in the sharedpreferences
 * save the name in key "username"
 * save the password in key "password"
 * show the toast message after user is created
 */

public class CreateUserActivity extends AppCompatActivity {
    EditText et_username, et_password, et_confirmpassword;
    Button btn_create;
    String userName = "", password = "", confirmPassword = "";
    SharedPreferences preferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the view
        setContentView(R.layout.activity_newuser);
        // initialize the view
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_confirmpassword = findViewById(R.id.et_confirm_password);
        btn_create = findViewById(R.id.btn_create);

        // set the button click event in the create button and get the username , password and confirm password

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = et_username.getText().toString();
                password = et_password.getText().toString();
                confirmPassword = et_confirmpassword.getText().toString();
                boolean valid = true;
                if(TextUtils.isEmpty(userName)){
                    valid = false;
                    et_username.setError("Username is empty");
                }
                if(TextUtils.isEmpty(password)){
                    valid = false;
                    et_password.setError("Password is empty");
                }
                if(TextUtils.isEmpty(confirmPassword)){
                    valid = false;
                    et_confirmpassword.setError("Confirm password is empty");
                }
                if(!TextUtils.equals(password, confirmPassword)){
                    valid = false;
                    et_confirmpassword.setError("Password is not matched");
                }
                if(valid){
                    // save the data in the sharedPreferences
                    //Initializing the SharedPreferences
                  preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    // save the value in username and password key
                    saveValue("username", userName);
                    saveValue("password", password);
                    // show the message to user
                    Toast.makeText(getApplicationContext(), "New UserCreated", Toast.LENGTH_SHORT).show();

                }
            }
        });



    }
    public void saveValue(String key, String value) {
        preferences.edit().putString(key, value).commit();
    }
}
