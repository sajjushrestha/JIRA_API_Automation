package files;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Reusable {

	
	
	
	public static XmlPath rawToXML(Response r)
	{
	
		
		String respon=r.asString();
		XmlPath xml_path=new XmlPath(respon);
		return xml_path;
		
	}
	
	public static JsonPath rawToJson(Response r)
	{ 
		String respon=r.asString();
		JsonPath json_path=new JsonPath(respon);
		return json_path;
	}
	

	public static String retrieveValue() throws Exception
	{	
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(".//Configuration//Data.properties");
		prop.load(fis);
	
		String uname=prop.getProperty("user");
		String pwd=prop.getProperty("pass");
		
		RestAssured.baseURI=prop.getProperty("JIRA_BaseURI");
		
		Response res=given().header("Content-Type", "application/json").
		body(Body.JIRA_addBody(uname, pwd)).
		when().
		post(Resources.JIRA_retrieveValue()).
		then().assertThat().statusCode(200).extract().response();
		
		String resString=res.asString();

		JsonPath js=new JsonPath(resString);
		
		String value=js.get("session.value");
			
		return value;
		
	}
	
	
}
