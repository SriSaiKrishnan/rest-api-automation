package com.sai.maps;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		AddPlace addPlace = new AddPlace();
		addPlace.setAccuracy(50);
		addPlace.setAddress("29, side layout, cohen 09");
		addPlace.setLanguage("French-IN");
		addPlace.setName("Frontline house");
		addPlace.setPhoneNumber("(+91) 983 893 3937");
		addPlace.setWebsite("http://google.com");
		
		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		
		addPlace.setLocation(location);
		
		List<String> types = new ArrayList<>();
		types.add("shoe park");
		types.add("shop");
		
		addPlace.setTypes(types);
		
		Response response = given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(addPlace)
		.when()
		.post("/maps/api/place/add/json")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.extract()
		.response();
		
		String responseString = response.toString();
		
		System.out.println(responseString);

		
	}

}
