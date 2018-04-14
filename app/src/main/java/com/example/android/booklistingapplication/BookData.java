package com.example.android.booklistingapplication;
/**
A {@link BookData} object contains information about a single book
 */
public class BookData {
    //title of the book
    private String mBookTitle;
    //Name of the author of the book
    private String mAuthorOfTheBook;
    //image url of the book
    private String mImageUrl;
    /**Constructs a new {@link BookData} object
        @param BookTitle is the title of the book
        @param AuthorOfTheBook is the author of the book
        @param ImageUrl is the image address of the book
     */
    public BookData(String BookTitle, String AuthorOfTheBook, String ImageUrl){
        mBookTitle = BookTitle;
        mAuthorOfTheBook = AuthorOfTheBook;
        mImageUrl = ImageUrl;
    }
    /**returns the tile of the book
     */
    public String getBookTitle() {
        return mBookTitle;
    }
    /**returns the author of the book
     *
     */
    public String getAuthorOfTheBook() {
        return mAuthorOfTheBook;
    }
    /**returns the image url of the book
     *
     */
    public String getImageUrl() {
        return mImageUrl;
    }

    public String toString(){
        return mBookTitle+" "+mAuthorOfTheBook+" "+mImageUrl;
    }
}
