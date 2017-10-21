package pack;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.Body;
import files.Resources;
import files.Reusable;

public class Rest_API_get_retrieve_delete_XML {
	
	Properties prop;
	
	@BeforeTest
	
	public void getData() throws Exception
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream(".//Configuration//Data.properties");
		prop.load(fis);
	}
	
	
	
	

	@Test
	public  void postMethod() throws Exception {
		
				
	//Post method	
		RestAssured.baseURI=prop.getProperty("BaseURI");
		Response res=given().
				queryParam("key",prop.getProperty("key")).
				body(GenerateStringFromResources(".//XML_Files//post.xml")).
				when().
				post(Resources.postResoucesXML()).
				then().assertThat().statusCode(200).and().contentType(ContentType.XML).extract().response();
			
		XmlPath x=Reusable.rawToXML(res);
		String s=x.get("PlaceAddResponse.status");
		System.out.println(s);
		
				
	}
	
	
	public static String GenerateStringFromResources(String path) throws Exception
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}
	
	

}
