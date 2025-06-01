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
	
	int puramnt=js.getInt("dashboard.purchaseAmount");
	System.out.println(puramnt);
	
	String title1=js.get("courses[0].title");
	
	System.out.println(title1);
	
	String title2=js.get("courses[2].title");
	
	System.out.println(title2);
	
	for(int i=0;i<count;i++)
	{
		String title3=js.get("courses["+i+"].title");
		System.out.println(title3);
		//aa
		
	}
	
	
	}

}
	
