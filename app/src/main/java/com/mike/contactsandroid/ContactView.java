package com.mike.contactsandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by michaelplott on 9/28/16.
 */
public class ContactView extends AppCompatActivity{

    ListView list2;
    ArrayAdapter theContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_view);
        Intent intent = getIntent();
        String contact = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        list2 = (ListView) findViewById(R.id.list);
        theContact = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        list2.setAdapter(theContact);
    }
}
