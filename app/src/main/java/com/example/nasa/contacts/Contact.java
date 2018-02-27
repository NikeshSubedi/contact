package com.example.nasa.contacts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NASA on 2/25/2018.
 */

public class Contact {
    public String name, phone;
    public String id;
    public Contact(){}

    public Contact(String id, String name, String phone){
        this.name = name;
        this.id = id;
        this.phone = phone;
    }
    public Contact(String name, String phone){
        this.name = name;
        this.phone = phone;
    }


}
