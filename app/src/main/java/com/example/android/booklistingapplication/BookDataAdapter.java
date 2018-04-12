package com.example.android.booklistingapplication;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * An {@link BookDataAdapter} knows how to create list item layout for each Book
 * in the data source (a list of {@link BookData} objects).
 *
 * These list item layout will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class BookDataAdapter extends ArrayAdapter<BookData> {
/**
 * Constructs a new {@link BookDataAdapter}.
 *
 * @param context of the app
 * @param bookdata is the list of books, which is the data source of the adapter
 *
 */
public BookDataAdapter(Context context, List<BookData> bookdata){
    super(context, 0, bookdata);
}

    /**
     * Returns the a list item view that displays information about the book data at
     * the given position in the list of book data.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
    //Check if there is an existing list item view (called convertView) that we can reuse,
    //otherwise, if convertView is null, then inflate a new list item layout.
    View listItemView = convertView;
    if(listItemView == null){
        listItemView = LayoutInflater.from(getContext()).inflate(
                R.layout.list_item, parent, false);

    }

    //Find the book at the given position at the list of books in the list
        BookData currentBook = getItem(position);
    //Find the TextView with view ID author_text_view
        TextView authorOfTheBook = (TextView)listItemView.findViewById(R.id.author_text_view);
        authorOfTheBook.setText(currentBook.getAuthorOfTheBook());
    //Find the TextView with view ID title_text_view
        TextView titleOfTheBook = (TextView)listItemView.findViewById(R.id.title_text_view);
        titleOfTheBook.setText(currentBook.getBookTitle());
    //Find the TextView with view ID image_of_book
        ImageView imageUrl = (ImageView)listItemView.findViewById(R.id.image_of_book);
        imageUrl.setImageResource(R.drawable.dummy_book_image);
    //Return the list item view that is now showing the appropriate data
        return listItemView;
    }

}
