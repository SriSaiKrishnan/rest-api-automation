package com.sai.maps;

import com.sai.files.MapPayload;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AddPlace {

        @Test
        public static void addPlace() {

            RestAssured.baseURI = "https://rahulshettyacademy.com";

            //AddPlace
            given()
                    .log()
                    .all()
                    .relaxedHTTPSValidation()
                    .queryParam("key", "qaclick123")
                    .header("Content-Type", "application/json")
                    .body(MapPayload.addPlacePayload())
                    .when()
                    .post("/maps/api/place/add/json")
                    .then()
                    .log()
                    .all()
                    .assertThat()
                    .statusCode(200)
                    .body("scope", equalTo("APP"))
                    .header("Server", "Apache/2.4.52 (Ubuntu)");
        }

        @Test
        public static void addPlaceViaJson() throws IOException {
            RestAssured.baseURI = "https://rahulshettyacademy.com";

            //AddPlace via JSON file
            String path = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+ "/src/test/java/com/sai/files/AddPlacePayload.json")));
            given()
                    .log()
                    .all()
                    .relaxedHTTPSValidation()
                    .queryParam("key", "qaclick123")
                    .header("Content-Type", "application/json")
                    .body(path)
                    .when()
                    .post("/maps/api/place/add/json")
                    .then()
                    .log()
                    .all()
                    .assertThat()
                    .statusCode(200)
                    .body("scope", equalTo("APP"))
                    .header("Server", "Apache/2.4.52 (Ubuntu)");
        }

}
