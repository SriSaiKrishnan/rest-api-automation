package com.sai.files;

public class MapPayload {

    public static String addPlacePayload(){

        String requestBody = "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Sai Krishnan Automation Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n";

        return requestBody;

    }

    public static String updatePlacePayload(String place_id, String newAddress){

        String requestBody = "{\n" +
                "\"place_id\":\""+place_id+"\",\n" +
                "\"address\":\""+newAddress+"\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}";

        System.out.println(requestBody);

        return requestBody;

    }

}
