package com.sai.course;

/*
{
"dashboard": {
"purchaseAmount": 910,
"website": "rahulshettyacademy.com"
},
"courses": [
{
"title": "Selenium Python",
"price": 50,
"copies": 6
},
{
"title": "Cypress",
"price": 40,
"copies": 4
},
{
"title": "RPA",
"price": 45,
"copies": 10
}
]
}

1. Print No of courses returned by API
2. Print Purchase Amount
3. Print Title of the first course
4. Print All course titles and their respective Prices
5. Print no of copies sold by RPA Course
6. Verify if Sum of all Course prices matches with Purchase Amount
 */

import com.sai.files.CoursePayload;
import com.sai.files.UtilityMethods;
import io.restassured.path.json.JsonPath;

public class ValidateCourse {

    public static void main(String[] args) {

        JsonPath course = UtilityMethods.convertToJson(CoursePayload.coursePayload());

        //Print No of courses returned by API
        int count = course.getInt("courses.size()");
        System.out.println("Printing the number of courses in the course API = " + count);

        //Print Purchase Amount
        int totalAmount = course.getInt("dashboard.purchaseAmount");
        System.out.println("Total amount is " + totalAmount);

        //Print Title of the first course
        String firstCourseTitle = course.getString("courses[0].title");
        System.out.println("Print the title of First Course " + firstCourseTitle);

        //Print All course titles and their respective Prices
        for (int i=0; i<count; i++){
            String courseTitle = course.getString("courses["+i+"].title");
            int coursePrice = course.getInt("courses["+i+"].price");
            System.out.println("The price for the course " + courseTitle + " is " + coursePrice);
        }

        //Print no of copies sold by RPA Course
        for (int i=0; i<count; i++){
            String courseTitle = course.getString("courses["+i+"].title");
            if(courseTitle.equalsIgnoreCase("RPA")){
                int totalCopies = course.getInt("courses["+i+"].copies");
                System.out.println("The total number of RPA copies sold are " + totalCopies);
                break;
            }
        }

        //Verify if Sum of all Course prices matches with Purchase Amount
        int purchaseAmount = 0;
        for (int i=0; i<count; i++){
           int coursePrice = course.getInt("courses["+i+"].price") * course.getInt("courses["+i+"].copies");
           purchaseAmount += coursePrice;
        }

        if(purchaseAmount == totalAmount)
            System.out.println("The purchase amount matches with all sum of course prices" + "Purchase price = " + purchaseAmount + " Total Price " + totalAmount);
        else
            System.out.println("The purchase amount is not matched with all sum of course prices");

    }

}
