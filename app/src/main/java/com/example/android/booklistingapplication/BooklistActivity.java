package com.example.android.booklistingapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class BooklistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booklist_activity);
        //Create a fake list of books.
        ArrayList<BookData> booklist = new ArrayList<>();
        booklist.add(new BookData("Life in a nutshell","Deep Roy","https://www.shutterstock.com/image-photo/book-732217162?src=2EQrpHqRT795M-WHCdsABA-1-4"));
        booklist.add(new BookData("How I got my ass kicked","Deep Roy","https://www.shutterstock.com/image-photo/book-732217162?src=2EQrpHqRT795M-WHCdsABA-1-4"));
        booklist.add(new BookData("How to apply minimal knowledge","Deep Roy","https://www.shutterstock.com/image-photo/book-732217162?src=2EQrpHqRT795M-WHCdsABA-1-4"));
        booklist.add(new BookData("How to be patient","Deep Roy","https://www.shutterstock.com/image-photo/book-732217162?src=2EQrpHqRT795M-WHCdsABA-1-4"));
        booklist.add(new BookData("How I became my own master","Deep Roy","https://www.shutterstock.com/image-photo/book-732217162?src=2EQrpHqRT795M-WHCdsABA-1-4"));
        booklist.add(new BookData("I don't give a fuck","Deep Roy, Rizwan","https://www.shutterstock.com/image-photo/book-732217162?src=2EQrpHqRT795M-WHCdsABA-1-4"));
        booklist.add(new BookData("You needed to be honest","Deep Roy,Dipanshu Prasad","https://www.shutterstock.com/image-photo/book-732217162?src=2EQrpHqRT795M-WHCdsABA-1-4"));
        booklist.add(new BookData("Listen to your inner voice","Deep Roy, Souvik Chatterjee","https://www.shutterstock.com/image-photo/book-732217162?src=2EQrpHqRT795M-WHCdsABA-1-4"));
        booklist.add(new BookData("C'mon I will help you","Deep Roy","https://www.shutterstock.com/image-photo/book-732217162?src=2EQrpHqRT795M-WHCdsABA-1-4"));
        booklist.add(new BookData("Had someone told me about that unworthy marks","Deep Roy","https://www.shutterstock.com/image-photo/book-732217162?src=2EQrpHqRT795M-WHCdsABA-1-4"));
        /**Find a reference to the {@link ListView} just created
         *
         */
        ListView bookDataListView = (ListView)findViewById(R.id.list_view);

        //Create a new adapter that takes the list of book data as input
        BookDataAdapter adapter = new BookDataAdapter(this, booklist);

        //Set the adapter on the {@link ListView}
        //so the list can be populated in the user interface
        bookDataListView.setAdapter(adapter);
    }
}
