package com.sai.files;

public class LibraryPayload {

    public static String addBookPayload(String aisle, String isbn){
        String addBook = "{\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"John foe\"\n" +
                "}";
        return addBook;
    }

}
