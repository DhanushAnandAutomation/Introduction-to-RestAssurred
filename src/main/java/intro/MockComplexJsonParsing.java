package intro;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class MockComplexJsonParsing {
	
	
	public static void main (String Args[]) {
	
	//mock API String is mainly used in AGile environments when dev has not yet developed the API.
	//we testers get the API contract earlier and we start creating the automation scripts by using this principle
	
	JsonPath js=files.ReusableMethods.rawToJson(Payload.MockComplexJson());
	
	int count=js.getInt("courses.size()");
	
	System.out.println(count);
	
	
	}

}
	
