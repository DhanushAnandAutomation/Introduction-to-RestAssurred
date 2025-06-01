package intro;

import java.util.Scanner;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class MockComplexJsonParsing {
	
	
	public static void main (String Args[]) {
	
	//mock API String is mainly used in AGile environments when dev has not yet developed the API.
	//we testers get the API contract earlier and we start creating the automation scripts by using this principle
	
	JsonPath js=files.ReusableMethods.rawToJson(Payload.MockComplexJson());
	
	//to get the size of an array
	int count=js.getInt("courses.size()");
	System.out.println("Number of courses are "+count);
	
	//navigating inside a json file
	int puramnt=js.getInt("dashboard.purchaseAmount");
	System.out.println("Total purchase amount is " +puramnt);
	
	//listing content inside a array position
	String title1=js.get("courses[0].title");
	System.out.println(title1);
	String title2=js.get("courses[2].title");
	System.out.println(title2);
	
	
	//listing all the elements in a json array
	System.out.println("listing all the elements in a json array");
	for(int i=0;i<count;i++)
	{
		String title3=js.get("courses["+i+"].title");
		System.out.println(title3);
		System.out.println(js.get("courses["+i+"].price").toString()); 
	
		
	}
	
	//listing particular title's no. of copies sold
	
	//scanner is used to use input functionality
	Scanner myObj = new Scanner(System.in);
	
	System.out.println("Enter the title which you want to print the number of copies");
	
	String titleInput = myObj.nextLine();
	
	for(int i=0;i<count;i++) {
		
		String title4=js.get("courses["+i+"].title");
		
		if(title4.equalsIgnoreCase(titleInput))
		{
			System.out.println(js.get("courses["+i+"].copies").toString()); 
			break;
		}
	}
	
	
	//verify sum of all price matches the purhcase amount
	
	int sum=0;
	
	for(int i=0;i<count;i++)
	{
		int price=js.get("courses["+i+"].price");
		int copies=js.get("courses["+i+"].copies");
		
		sum=sum + price * copies;
		
	
		
	}
	System.out.println("Total sum is "+ sum);
	
	
	
	}

}
	
