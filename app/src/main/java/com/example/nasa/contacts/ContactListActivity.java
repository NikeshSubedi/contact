package com.example.nasa.contacts;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * create the dummy json data of contactlist
 * create the model for dummy json
 * add the listview in the view
 * initialize the listview
 * create the adapter
 * set the adapter in the list
 * assign click listener in the item of the listview
 * call in the given number
 *
 */

public class ContactListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        // get the values passed here
        if(getIntent().hasExtra("uname")){
            String username=getIntent().getStringExtra("uname");
            setTitle("welcome "+ username);
        }
        // create the dummy json
//        String data = "[\n" +
//                "\t{\n" +
//                "\t\t\"name\":\"Yubaraj POudel\",\n" +
//                "\t\t\"phone\":\"9842583634\"\n" +
//                "\t},\n" +
//                "\t{\n" +
//                "\t\t\"name\":\"Yubaraj POudel\",\n" +
//                "\t\t\"phone\":\"9842583634\"\n" +
//                "\t},\n" +
//                "\t{\n" +
//                "\t\t\"name\":\"Yubaraj POudel\",\n" +
//                "\t\t\"phone\":\"9842583634\"\n" +
//                "\t},\n" +
//                "\t{\n" +
//                "\t\t\"name\":\"Yubaraj POudel\",\n" +
//                "\t\t\"phone\":\"9842583634\"\n" +
//                "\t},\n" +
//                "\t{\n" +
//                "\t\t\"name\":\"Yubaraj POudel\",\n" +
//                "\t\t\"phone\":\"9842583634\"\n" +
//                "\t}\n" +
//                "]";


        findViewById(R.id.btn_add_contact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddContactActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        // get the data from the database
        DataBaseHandler dh = new DataBaseHandler(getApplicationContext());
        List<Contact> contactList = dh.getAllContact();

        // initialize the listview from the view
        ListView lv_contact = findViewById(R.id.lv_contact);
        //create the adapter
        // to create the adapter we need datasource here datasource data
        // view to populate the data
        // in array adapter this, view, dat.asource
        lv_contact.setAdapter(new ArrayAdapter<Contact>(this, R.layout.row_contact_list, contactList){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                // if view is null convert the layout ie xml into view
                if(convertView == null){
                    convertView = getLayoutInflater().inflate(R.layout.row_contact_list, null);
                }
                // get the views inside the row_contact_list
                TextView tv_initial = convertView.findViewById(R.id.tv_initial);
                TextView tv_fullname = convertView.findViewById(R.id.tv_fullname);
                // set the value
                tv_initial.setText(getItem(position).name.toCharArray()[0]+"");
                tv_fullname.setText(getItem(position).name);

                return convertView;
            }
        });
    }
}
