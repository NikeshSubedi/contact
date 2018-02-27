package com.example.nasa.contacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by NASA on 2/26/2018.
 */

/**
 * set the addcontact view
 * initialize the view
 * validate the form
 * if valid save the username and phone in the database
 */
public class AddContactActivity extends AppCompatActivity{
    EditText et_name, et_phone;
    Button btn_save;
    String name = "", phone = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the view
        setContentView(R.layout.activity_add_contact);
        // initialize the view

        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        btn_save = findViewById(R.id.btn_save);

        // validate the form when save button is clicked

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // validate the form
                boolean valid = true;
                phone = et_phone.getText().toString();
                name = et_name.getText().toString();

                if(TextUtils.isEmpty(phone)){
                    valid = false;
                    et_phone.setError("Phone is empty");
                }
                if(TextUtils.isEmpty(name)){
                    valid = false;
                    et_name.setError("Name cannot be empty");
                }
                // if valid we save the data in the sqlite database
                // initialize the sqlite database
                if(valid) {
                    DataBaseHandler dh = new DataBaseHandler(getApplicationContext());
                    // save the contact
                    Contact contact = new Contact(name, phone);
                    dh.saveContact(contact);
                    Toast.makeText(getApplicationContext(), "Contact added successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
