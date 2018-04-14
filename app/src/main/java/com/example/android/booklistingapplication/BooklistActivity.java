package com.example.android.booklistingapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class BooklistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booklist_activity);
        //get the list of books from the {@link QueryUtils}
        ArrayList<BookData> booklist = QueryUtils.extractBookData();
         /**Find a reference to the {@link ListView} just created
         *
         */
         for (BookData l:booklist)
             Log.i("BooklistActivity","TEST: "+l);
        ListView bookDataListView = (ListView)findViewById(R.id.list_view);

        //Create a new adapter that takes the list of book data as input
        BookDataAdapter adapter = new BookDataAdapter(this, booklist);

        //Set the adapter on the {@link ListView}
        //so the list can be populated in the user interface
        bookDataListView.setAdapter(adapter);
    }
}
