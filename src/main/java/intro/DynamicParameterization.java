package intro;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class DynamicParameterization {
	
	
	public void dynamicPara() {
		
		JsonPath js=files.ReusableMethods.rawToJson(Payload.dynamicParameterization());
		
		
		
		
	}

}
