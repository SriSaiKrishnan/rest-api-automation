package com.sai.files;

import org.json.simple.JSONObject;

public class JiraPayload {

    public static String createSession(){
        String credentials = "{\n" +
                "    \"username\": \"krishnansai99\",\n" +
                "    \"password\": \"ALLthebest@123\"\n" +
                "}";
        return credentials;
    }

    public static String addComment(){
        String comment = "{\n" +
                "    \"body\": \"Hi i have added the comment via rest api automation\",\n" +
                "    \"visibility\": {\n" +
                "        \"type\": \"role\",\n" +
                "        \"value\": \"Administrators\"\n" +
                "    }\n" +
                "}\n";
        return comment;
    }

}
