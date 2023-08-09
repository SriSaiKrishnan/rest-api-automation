package com.sai.files;

public class JiraPayload {

    public static String createSession(){
        String session = "{\n" +
                "    \"username\": \"krishnansai99\",\n" +
                "    \"password\": \"ALLthebest@123\"\n" +
                "}";
        return session;
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
