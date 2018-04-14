package com.example.android.booklistingapplication;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QueryUtils {
    /**Sample JSON response for booksapi query*/
    private static final String SAMPLE_JSON_RESPONSE ="{\"items\":" +
            "[{\"volumeInfo\":" +
            "{\"title\":" +
            "\"The Language of Flowers\"," +
            "\"authors\":" +
            "[\"Vanessa Diffenbaugh\"]," +
            "\"imageLinks\":" +
            "{\"smallThumbnail\":" +
            "\"http://books.google.com/books/content?id=DxT6vQ0Ul4YC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\"," +
            "\"thumbnail\":" +
            "\"http://books.google.com/books/content?id=DxT6vQ0Ul4YC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"}}}]}";
    /**Create a private constructor because no one should ever create a {@link QueryUtils} object.
     * This class is only meant to hold static variables and methods,which can be accessed
     * directly from the class name QueryUtils(and an instance of QueryUtils is not needed).
     */
    private QueryUtils(){

    }
    /**Return a list of {@link BookData} objects that has been built up from
     * parsing a JSON response.
     */
    public static ArrayList<BookData> extractBookData(){
        //Create an empty ArrayList that we can start adding book data to
        ArrayList<BookData> bookData = new ArrayList<>();

        //Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        //is formatted, a JSONException object will be thrown.
        //Catch the exception so the app doesn;t crash, and print the error message to the logs.
        try {
            JSONObject root = new JSONObject(SAMPLE_JSON_RESPONSE);
            JSONArray bookDataArray = root.getJSONArray("items");
            String title="";
            JSONArray authorsArray;
            String authors="";
            String imageUrl="";
            for(int i =0;i <bookDataArray.length(); i++){
                authors="";
                imageUrl="";
                //getting the title of the book
                title = bookDataArray.getJSONObject(i).getJSONObject("volumeInfo").getString("title");
                //getting the authors
                authorsArray = bookDataArray.getJSONObject(i).getJSONObject("volumeInfo").getJSONArray("authors");
                for(int j =0; j<authorsArray.length(); j++){
                    authors += authorsArray.getString(i);
                }
                //getting the imageUrl
                imageUrl = bookDataArray.getJSONObject(i).getJSONObject("volumeInfo").getJSONObject("imageLinks").getString("thumbnail");


                bookData.add(new BookData(title,authors,imageUrl));
            }

        }
        catch (JSONException e){
            //If an error is thrown when executing any of the above statements in the "try" block,
            //catch the exception here, so the app doesn't crash. Print a log message
            //with the message from the exception.
            Log.e("QueryUtils","Problem parsing the bookData JSON results",e);
        }
        //return the list of books
        return bookData;
    }
}
