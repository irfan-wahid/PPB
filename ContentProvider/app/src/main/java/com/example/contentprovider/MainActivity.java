package com.example.contentprovider;

import android.app.Activity;
import android.os.Bundle;
import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri allContacts = Uri.parse("content://contacts/people");
        Cursor c = getContentResolver().query(allContacts, null, null, null, null);
        String[] columns = new String[] {
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts._ID};
        int[] views = new int[] {R.id.contactName, R.id.contactID};
        SimpleCursorAdapter adapter =
                new SimpleCursorAdapter(this, R.layout.activity_main, c, columns, views);
        this.setListAdapter(adapter);
    }
}