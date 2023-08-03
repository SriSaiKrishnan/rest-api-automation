package com.sai.files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class AddGetDeleteBook {

    @Test(dataProvider = "addBookData")
    public void verifyAddBook(String aisle, String isbn){

        RestAssured.baseURI = "http://216.10.245.166";

        String addBookResponse = given()
                .header("Content-Type" , "application/json")
                .body(LibraryPayload.addBookPayload(aisle,isbn))
                .when()
                .post("/Library/Addbook.php")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response()
                .asString();

        JsonPath abbBookJson = UtilityMethods.convertToJson(addBookResponse);

        String bookId = abbBookJson.get("ID");
        System.out.println(bookId);

    }

    @DataProvider(name = "addBookData")
    public Object[][] getData(){
        return new Object[][] {{"111", "aaa"},{"222", "bbb"},{"333", "ccc"}};
    }

}
