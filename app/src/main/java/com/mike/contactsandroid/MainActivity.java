package com.mike.contactsandroid;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {

    ListView list;
    EditText text1;
    EditText text2;
    Button addButton;

    ArrayAdapter<String> theContacts;
    public final static String EXTRA_MESSAGE = "com.mike.contact_view.";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        text1 = (EditText) findViewById(R.id.name);
        text2 = (EditText) findViewById(R.id.phone);
        addButton = (Button) findViewById(R.id.addButton);

        theContacts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        list.setAdapter(theContacts);
        addButton.setOnClickListener(this);

        list.setOnItemLongClickListener(this);

        list.setOnItemClickListener(this);
    }



    @Override
    public void onClick(View v) {
        String nameField = text1.getText().toString();
        String phoneNumber = text2.getText().toString();
        if (!nameField.isEmpty() && !phoneNumber.isEmpty() && v == addButton) {
            String contact = nameField + "       " + "(" +  phoneNumber + ")";
            theContacts.add(contact);
            text1.setText("");
            text2.setText("");
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String theContact = theContacts.getItem(position);
        theContacts.remove(theContact);
        return true;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ContactViewer(view, position);
    }
    public void ContactViewer(View view, int position){
        Intent intent = new Intent(this, ContactView.class);
        String contact = theContacts.getItem(position).toString();
        intent.putExtra(EXTRA_MESSAGE, contact);
        startActivity(intent);
    }
}
