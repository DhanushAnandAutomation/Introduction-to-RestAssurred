package intro;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class AdditionLogicWithTestNG {
	
	
	@Test
	public void sumOfSales() {
		
		
		//verify sum of all price matches the purhcase amount using @test annotation and assertEquals
		
		int sum=0;
		
		JsonPath js=files.ReusableMethods.rawToJson(Payload.MockComplexJson());
		
		int count= js.getInt("courses.size()");
		
		for(int i=0;i<count;i++)
		{
			int price=js.get("courses["+i+"].price");
			int copies=js.get("courses["+i+"].copies");
			
			sum=sum + price * copies;
			
		
			
		}
		System.out.println("Total sum is "+ sum);
		
		int purchaseAmount=js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
		
		
		
		}
		
	
	

}
