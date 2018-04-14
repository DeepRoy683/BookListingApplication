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
//    String fakeJson="{\"type\":\"FeatureCollection\",\"metadata\":{\"generated\":1462579131000,\"url\":\"http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/significant_month.geojson\",\"title\":\"USGS Significant Earthquakes, Past Month\",\"status\":200,\"api\":\"1.5.2\",\"count\":11},\"features\":[{\"type\":\"Feature\",\"properties\":{\"mag\":6.6,\"place\":\"Northern East Pacific Rise\",\"time\":1461893618940,\"updated\":1461946157040,\"tz\":-420,\"url\":\"http://earthquake.usgs.gov/earthquakes/eventpage/us10005cc4\",\"detail\":\"http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us10005cc4.geojson\",\"felt\":0,\"cdi\":1,\"mmi\":null,\"alert\":null,\"status\":\"reviewed\",\"tsunami\":1,\"sig\":670,\"net\":\"us\",\"code\":\"10005cc4\",\"ids\":\",pt16120050,at00o6dgc2,us10005cc4,gcmt20160429013338,\",\"sources\":\",pt,at,us,gcmt,\",\"types\":\",cap,dyfi,geoserve,impact-link,moment-tensor,nearby-cities,origin,phase-data,\",\"nst\":null,\"dmin\":8.803,\"rms\":0.94,\"gap\":62,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 6.6 - Northern East Pacific Rise\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-103.715,10.2705,10]},\"id\":\"us10005cc4\"},\n" +
//            "{\"type\":\"Feature\",\"properties\":{\"mag\":7,\"place\":\"1km SE of Norsup, Vanuatu\",\"time\":1461872004420,\"updated\":1461953651373,\"tz\":660,\"url\":\"http://earthquake.usgs.gov/earthquakes/eventpage/us10005c88\",\"detail\":\"http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us10005c88.geojson\",\"felt\":1,\"cdi\":6.8,\"mmi\":6.74,\"alert\":\"green\",\"status\":\"reviewed\",\"tsunami\":1,\"sig\":755,\"net\":\"us\",\"code\":\"10005c88\",\"ids\":\",pt16119051,at00o6cznp,us10005c88,gcmt20160428193324,\",\"sources\":\",pt,at,us,gcmt,\",\"types\":\",cap,dyfi,finite-fault,general-link,general-text,geoserve,impact-link,losspager,moment-tensor,nearby-cities,origin,phase-data,shakemap,tectonic-summary,trump-moment-tensor,\",\"nst\":null,\"dmin\":0.649,\"rms\":1.29,\"gap\":14,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 7.0 - 1km SE of Norsup, Vanuatu\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[167.3926,-16.0743,27.17]},\"id\":\"us10005c88\"},\n" +
//            "{\"type\":\"Feature\",\"properties\":{\"mag\":7.8,\"place\":\"27km SSE of Muisne, Ecuador\",\"time\":1460851117280,\"updated\":1462381916197,\"tz\":-300,\"url\":\"http://earthquake.usgs.gov/earthquakes/eventpage/us20005j32\",\"detail\":\"http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us20005j32.geojson\",\"felt\":183,\"cdi\":9.1,\"mmi\":8.1,\"alert\":\"orange\",\"status\":\"reviewed\",\"tsunami\":1,\"sig\":1167,\"net\":\"us\",\"code\":\"20005j32\",\"ids\":\",at00o5r3xd,us20005j32,pt16107050,gcmt20160416235837,\",\"sources\":\",at,us,pt,gcmt,\",\"types\":\",cap,dyfi,finite-fault,general-link,general-text,geoserve,impact-link,losspager,moment-tensor,nearby-cities,origin,phase-data,poster,shakemap,tectonic-summary,\",\"nst\":null,\"dmin\":2.139,\"rms\":1,\"gap\":41,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 7.8 - 27km SSE of Muisne, Ecuador\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-79.9398,0.3715,19.16]},\"id\":\"us20005j32\"},\n" +
//            "{\"type\":\"Feature\",\"properties\":{\"mag\":5.7,\"place\":\"2km NW of Ozu, Japan\",\"time\":1460738756630,\"updated\":1460760920000,\"tz\":540,\"url\":\"http://earthquake.usgs.gov/earthquakes/eventpage/us20005ija\",\"detail\":\"http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us20005ija.geojson\",\"felt\":1,\"cdi\":3.4,\"mmi\":6.77,\"alert\":\"yellow\",\"status\":\"reviewed\",\"tsunami\":0,\"sig\":650,\"net\":\"us\",\"code\":\"20005ija\",\"ids\":\",us20005ija,\",\"sources\":\",us,\",\"types\":\",cap,dyfi,geoserve,losspager,moment-tensor,nearby-cities,origin,phase-data,shakemap,tectonic-summary,\",\"nst\":null,\"dmin\":2.675,\"rms\":1.03,\"gap\":61,\"magType\":\"mb\",\"type\":\"earthquake\",\"title\":\"M 5.7 - 2km NW of Ozu, Japan\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[130.8463,32.8805,10]},\"id\":\"us20005ija\"},\n" +
//            "{\"type\":\"Feature\",\"properties\":{\"mag\":7,\"place\":\"1km WSW of Kumamoto-shi, Japan\",\"time\":1460737506260,\"updated\":1460997743154,\"tz\":540,\"url\":\"http://earthquake.usgs.gov/earthquakes/eventpage/us20005iis\",\"detail\":\"http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us20005iis.geojson\",\"felt\":57,\"cdi\":8.5,\"mmi\":9.33,\"alert\":\"red\",\"status\":\"reviewed\",\"tsunami\":1,\"sig\":2048,\"net\":\"us\",\"code\":\"20005iis\",\"ids\":\",at00o5oo9v,pt16106053,us20005iis,gcmt20160415162506,\",\"sources\":\",at,pt,us,gcmt,\",\"types\":\",cap,dyfi,finite-fault,general-link,general-text,geoserve,impact-link,losspager,moment-tensor,nearby-cities,origin,phase-data,poster,scitech-link,shakemap,tectonic-summary,\",\"nst\":null,\"dmin\":0.364,\"rms\":1.12,\"gap\":39,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 7.0 - 1km WSW of Kumamoto-shi, Japan\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[130.7259,32.782,10]},\"id\":\"us20005iis\"},\n" +
//            "{\"type\":\"Feature\",\"properties\":{\"mag\":6.4,\"place\":\"95km NW of Port-Olry, Vanuatu\",\"time\":1460670627630,\"updated\":1460695768036,\"tz\":660,\"url\":\"http://earthquake.usgs.gov/earthquakes/eventpage/us20005i6p\",\"detail\":\"http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us20005i6p.geojson\",\"felt\":1,\"cdi\":6.1,\"mmi\":6.39,\"alert\":\"green\",\"status\":\"reviewed\",\"tsunami\":1,\"sig\":631,\"net\":\"us\",\"code\":\"20005i6p\",\"ids\":\",pt16105055,at00o5n8ns,us20005i6p,gcmt20160414215026,\",\"sources\":\",pt,at,us,gcmt,\",\"types\":\",cap,dyfi,geoserve,impact-link,impact-text,losspager,moment-tensor,nearby-cities,origin,phase-data,shakemap,tectonic-summary,\",\"nst\":null,\"dmin\":1.233,\"rms\":1.09,\"gap\":23,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 6.4 - 95km NW of Port-Olry, Vanuatu\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[166.3518,-14.5225,16]},\"id\":\"us20005i6p\"},\n" +
//            "{\"type\":\"Feature\",\"properties\":{\"mag\":6,\"place\":\"6km E of Uto, Japan\",\"time\":1460646226920,\"updated\":1460731124540,\"tz\":540,\"url\":\"http://earthquake.usgs.gov/earthquakes/eventpage/us20005i1a\",\"detail\":\"http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us20005i1a.geojson\",\"felt\":7,\"cdi\":4.8,\"mmi\":7.68,\"alert\":\"yellow\",\"status\":\"reviewed\",\"tsunami\":0,\"sig\":653,\"net\":\"us\",\"code\":\"20005i1a\",\"ids\":\",us20005i1a,gcmt20160414150347,\",\"sources\":\",us,gcmt,\",\"types\":\",cap,dyfi,geoserve,impact-text,losspager,moment-tensor,nearby-cities,origin,phase-data,shakemap,tectonic-summary,\",\"nst\":null,\"dmin\":0.447,\"rms\":0.87,\"gap\":32,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 6.0 - 6km E of Uto, Japan\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[130.732,32.6934,5.96]},\"id\":\"us20005i1a\"},\n" +
//            "{\"type\":\"Feature\",\"properties\":{\"mag\":6.2,\"place\":\"7km SW of Ueki, Japan\",\"time\":1460636796430,\"updated\":1460989611601,\"tz\":540,\"url\":\"http://earthquake.usgs.gov/earthquakes/eventpage/us20005hzn\",\"detail\":\"http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us20005hzn.geojson\",\"felt\":28,\"cdi\":7.9,\"mmi\":8.39,\"alert\":\"red\",\"status\":\"reviewed\",\"tsunami\":0,\"sig\":2022,\"net\":\"us\",\"code\":\"20005hzn\",\"ids\":\",us20005hzn,gcmt20160414122636,\",\"sources\":\",us,gcmt,\",\"types\":\",cap,dyfi,general-link,general-text,geoserve,losspager,moment-tensor,nearby-cities,origin,phase-data,poster,shakemap,tectonic-summary,\",\"nst\":null,\"dmin\":0.342,\"rms\":1.23,\"gap\":17,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 6.2 - 7km SW of Ueki, Japan\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[130.6345,32.8494,10]},\"id\":\"us20005hzn\"},\n" +
//            "{\"type\":\"Feature\",\"properties\":{\"mag\":6.9,\"place\":\"74km SE of Mawlaik, Burma\",\"time\":1460555717870,\"updated\":1460651201046,\"tz\":390,\"url\":\"http://earthquake.usgs.gov/earthquakes/eventpage/us20005hqz\",\"detail\":\"http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us20005hqz.geojson\",\"felt\":286,\"cdi\":5.9,\"mmi\":5.9,\"alert\":\"yellow\",\"status\":\"reviewed\",\"tsunami\":0,\"sig\":901,\"net\":\"us\",\"code\":\"20005hqz\",\"ids\":\",us20005hqz,gcmt20160413135517,\",\"sources\":\",us,gcmt,\",\"types\":\",cap,dyfi,general-text,geoserve,losspager,moment-tensor,nearby-cities,origin,phase-data,shakemap,tectonic-summary,\",\"nst\":null,\"dmin\":3.684,\"rms\":1.17,\"gap\":23,\"magType\":\"mwb\",\"type\":\"earthquake\",\"title\":\"M 6.9 - 74km SE of Mawlaik, Burma\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[94.8995,23.1329,134.76]},\"id\":\"us20005hqz\"},\n" +
//            "{\"type\":\"Feature\",\"properties\":{\"mag\":6.6,\"place\":\"42km WSW of Ashkasham, Afghanistan\",\"time\":1460284138660,\"updated\":1461326799686,\"tz\":270,\"url\":\"http://earthquake.usgs.gov/earthquakes/eventpage/us20005gsg\",\"detail\":\"http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us20005gsg.geojson\",\"felt\":117,\"cdi\":5.8,\"mmi\":4.41,\"alert\":\"green\",\"status\":\"reviewed\",\"tsunami\":0,\"sig\":738,\"net\":\"us\",\"code\":\"20005gsg\",\"ids\":\",us20005gsg,gcmt20160410102858,\",\"sources\":\",us,gcmt,\",\"types\":\",cap,dyfi,geoserve,impact-text,losspager,moment-tensor,nearby-cities,origin,phase-data,shakemap,tectonic-summary,\",\"nst\":null,\"dmin\":0.792,\"rms\":1.03,\"gap\":17,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 6.6 - 42km WSW of Ashkasham, Afghanistan\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[71.1357,36.4709,211.59]},\"id\":\"us20005gsg\"},\n" +
//            "{\"type\":\"Feature\",\"properties\":{\"mag\":6.7,\"place\":\"106km W of Sola, Vanuatu\",\"time\":1459999973790,\"updated\":1460152502000,\"tz\":660,\"url\":\"http://earthquake.usgs.gov/earthquakes/eventpage/us20005fzn\",\"detail\":\"http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us20005fzn.geojson\",\"felt\":2,\"cdi\":6.6,\"mmi\":5.17,\"alert\":\"green\",\"status\":\"reviewed\",\"tsunami\":1,\"sig\":692,\"net\":\"us\",\"code\":\"20005fzn\",\"ids\":\",at00o58v6w,us20005fzn,pt16098051,gcmt20160407033253,\",\"sources\":\",at,us,pt,gcmt,\",\"types\":\",cap,dyfi,geoserve,impact-link,losspager,moment-tensor,nearby-cities,origin,phase-data,shakemap,tectonic-summary,\",\"nst\":null,\"dmin\":6.775,\"rms\":0.93,\"gap\":25,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 6.7 - 106km W of Sola, Vanuatu\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[166.5711,-13.9942,26.79]},\"id\":\"us20005fzn\"}],\"bbox\":[-103.715,-16.0743,5.96,167.3926,36.4709,211.59]"
}