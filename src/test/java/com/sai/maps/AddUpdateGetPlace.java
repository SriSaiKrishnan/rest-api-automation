package com.sai.maps;

import com.sai.files.MapPayload;
import com.sai.files.UtilityMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AddUpdateGetPlace {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        // Add Place
        String addPlace = given()
                .log()
                .all()
                .relaxedHTTPSValidation()
                .queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(MapPayload.addPlacePayload())
                .when()
                .post("/maps/api/place/add/json")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.52 (Ubuntu)")
                .extract()
                .response()
                .asString();

        JsonPath addPlaceResponse = UtilityMethods.convertToJson(addPlace);

        String place_id = addPlaceResponse.getString("place_id");
        String newAddress = "21 South west Area, India";;

        //Update place
        given()
                .log()
                .all()
                .relaxedHTTPSValidation()
                .queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(MapPayload.updatePlacePayload(place_id, newAddress))
                .when()
                .put("/maps/api/place/update/json")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .body("msg",equalTo("Address successfully updated"));

        //Get place
        String getPlace = given()
                .log()
                .all()
                .relaxedHTTPSValidation()
                .queryParam("key","qaclick123")
                .queryParam("place_id",place_id)
                .header("Content-Type","application/json")
                .when()
                .get("maps/api/place/get/json")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .body("address",equalTo(newAddress))
                .extract()
                .asString();

        JsonPath getPlaceResponse = UtilityMethods.convertToJson(getPlace);

        String actualAddress = getPlaceResponse.getString("address");

        Assert.assertEquals(actualAddress,newAddress);

    }

}
