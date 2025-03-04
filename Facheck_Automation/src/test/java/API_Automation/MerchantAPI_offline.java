package API_Automation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class MerchantAPI_offline {
    @Test
    public void offLinePayment() {
        // Step 1: First API - POST request to submit userId, Aadhar/Pan number
        String userId = "3";  // Example userId
        String source = "GSAPS8742F";  // Example Aadhar/Pan number

        // Request body for the first API (submit userId and Aadhar/Pan number)
        String requestBody = "{ \"userId\": \"" + userId + "\", \"source\": \"" + source + "\" }";

        // "{
        // userId:"+userID+",
        // source:"+sourcce+"
        // }";

        // Make the POST request to the first API endpoint
        Response response1 = RestAssured.given()
                .baseUri("https://dev-api.facheck.biz") // Replace with your base URI
                .basePath("/ekyc/demo") // Replace with your API endpoint path
                .contentType("application/json")
                .body(requestBody)
                .post();
        System.out.println("Posted Successfully");

        // Step 2: Validate the first API response and extract the encoded response
        response1.then().statusCode(200); // Check for 200 status code, indicating success

        // Assuming the response contains an 'encodedResponse' field that is Base64 encoded
        // Extract the encoded 'data' field from the response
        String encodedData = response1.jsonPath().getString("data");


        // Print the decoded data (for debugging purposes)
        System.out.println("encoded Data from First API: " + encodedData);





        // Step 3: Second API - POST request using decoded data and Livekey/Application-ID in the headers
        String secondRequestBody = "{ \"encrypted_data\": \"" + encodedData + "\" }";  // Modify based on what second API expects

        // Make the POST request to the second API with decoded value in the body and Livekey/Application-ID in headers
        Response response2 = RestAssured.given()
                .baseUri("https://dev-api.facheck.biz") // Replace with your base URI
                .basePath("facheck-authentication/pan") // Replace with your second API endpoint path
                .header("x-parse-rest-api-key", "LIVE_5HG13CLJJ2VEPNKKBU5GN1RWF4K")  // Add Livekey in the header
                .header("x-parse-application-id", "postpaid_ekyc")  // Add Application-ID in the header
                .contentType("application/json")
                .body(secondRequestBody)  // Body for the second API
                .post();

        // Step 4: Validate the second API response
        response2.then().statusCode(200); // Ensure the second API request is successful (status 200)

        // Print the response from the second API
        System.out.println("Response from Second API: " + response2.getBody().asString());

    }
}