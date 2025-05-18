package intro;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

import files.Payload;

import static io.restassured.RestAssured.*;

public class Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//to validate ADD place API is working as expected
		
		//setting base URL
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		//given is used to start the "Request". 
		//giving Query parameter in Endpoint Request
		given().log().all().queryParam("key", "qaclick123")
		
		//giving header in Endpoint Request
		.header("Content-Type", "application/json")
		
		//giving body in header Request
		.body(Payload.addPlace())
		
		//giving resources in Header Request
		.when().post("maps/api/place/add/json")
		
		//"then" is used to read the response
		//assertion is done to check status code in response is equal to 200
		.then().log().all().assertThat().statusCode(200)
		
		//equalTo function is used to assert scope of response is APP
		.body("scope",  equalTo("APP"))
		
		//header is again used when it is for a response
		//is used to assert server which the response is coming to is "Apache/2.4.52 (Ubuntu)"
		.header("server", "Apache/2.4.52 (Ubuntu)");

	}

}
