package intro;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import files.Payload;

import static io.restassured.RestAssured.*;

public class Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//to validate ADD place API is working as expected
		//------------------------------POST---------------------------------------- 
		
		//setting base URL
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		//given is used to start the "Request". 
		//giving Query parameter in Endpoint Request
		String response= given().log().all().queryParam("key", "qaclick123")
		
		//giving header in Endpoint Request
		.header("Content-Type", "application/json")
		
		//giving body in header Request
		.body(Payload.addPlace())
		
		//giving resources in Header Request
		.when().post("maps/api/place/add/json")   //this 'when' is where we decide whether the request is POST or PUT or GET or DELETE
		
		//"then" is used to read the response
		//assertion is done to check status code in response is equal to 200
		.then().log().all().assertThat().statusCode(200)
		
		//equalTo function is used to assert scope of response is APP
		.body("scope",  equalTo("APP"))
		
		//header is again used when it is for a response
		//is used to assert server which the response is coming to is "Apache/2.4.52 (Ubuntu)"
		//extract is a restassured method used for extracting
		// .extract().response() will extract the whole response of the API
		// .asString() is used to save to a String variable
		.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		//this will print the saved response on console 
		System.out.println(response);
		
		//Object for JsonPath is created and 
		JsonPath js= new JsonPath(response);
		
		
		String place_id= js.get("place_id");
		System.out.println(place_id);
		
		//---------------------------PUT--------------------------------
		
		String response1=given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+place_id+"\",\r\n"
				+ "\"address\":\"70 winter walk, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json") //this 'when' is where we decide whether the request is POST or PUT or GET or DELETE
		.then().log().all().assertThat().statusCode(200)
		.body("msg", equalTo("Address successfully updated"))
		
		.extract().response().asString();
				
		System.out.println(response1);
		
		
		//--------------------------GET----------------------------------------
		
		String response3= given().log().all().queryParam("key", "qaclick123").queryParam("place_id", place_id)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200)
		.extract().response().asString();
		
		
		
		JsonPath js1= new JsonPath(response3);
		
		
		String Updaddress= js1.get("address");
		System.out.println(Updaddress);
		

	}

}
