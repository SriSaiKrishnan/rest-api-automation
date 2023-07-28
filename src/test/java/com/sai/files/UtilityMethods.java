package com.sai.files;

import io.restassured.path.json.JsonPath;

public class UtilityMethods {

    public static JsonPath convertToJson(String response){
        JsonPath convertToJson = new JsonPath(response);
        return convertToJson;
    }

}
