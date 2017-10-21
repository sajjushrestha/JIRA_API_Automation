package pack;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.Reusable;

public class Rest_API_get_Advanced {

	
Properties prop;
	
	@BeforeTest
	
	public void getData() throws Exception
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream(".//Configuration//Data.properties");
		prop.load(fis);	
	}
	
	
	
	@Test
	public  void getMethod() {
		
		
		RestAssured.baseURI=prop.getProperty("BaseURI");
		
		Response res=given().log().all().
				param("location","-33.8670522,151.1957362").
				param("radius","500").
				param("key",prop.getProperty("key")).
				
				when().
				get("/maps/api/place/nearbysearch/json").
				
				then().log().all().assertThat().
				statusCode(200).and().contentType(ContentType.JSON).and().
				body("results[0].name" ,equalTo("Sydney")).and().
				header("Server", "pablo").extract().response();
		//System.out.println(res.asString());		
		
		JsonPath x=Reusable.rawToJson(res);
		int size=x.get("results.size()");
		
		for(int i=0;i<size;i++)
		{
			String name=x.get("results["+i+"].name");
			System.out.println(name);
		}
				

	}

}
