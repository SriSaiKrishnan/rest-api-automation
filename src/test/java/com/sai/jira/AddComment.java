package com.sai.jira;

import com.sai.files.JiraPayload;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class AddComment {

    @Test
    public static void addComment(){

        RestAssured.baseURI = "http://localhost:8080";

        SessionFilter session = new SessionFilter();

        //Create session
     given()
                .header("Content-Type" , "application/json")
                .body(JiraPayload.createSession())
                .log()
                .all()
                .filter(session)
                .when()
                .post("/rest/auth/1/session")
                .then()
                .log()
                .all()
                .extract()
                .response()
                .asString();

//        given()
//                .queryParam("key","10001")
//                .header("Content-Type" , "application/json")
//                .body(JiraPayload.addComment())
//                .log()
//                .all()
//                .filter(session)
//                .when()
//                .post("/api/2/issue/{key}/comment")
//                .then()
//                .log()
//                .all();


    }

}
