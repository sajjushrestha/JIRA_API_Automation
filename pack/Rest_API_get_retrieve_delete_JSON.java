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


import files.Body;
import files.Resources;

public class Rest_API_get_retrieve_delete_JSON {
	
	Properties prop;
	
	@BeforeTest
	
	public void getData() throws Exception
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream(".//Configuration//Data.properties");
		prop.load(fis);	
	}
	
	@Test
	public  void deleteMethod() throws Exception {
	
//Post method	
RestAssured.baseURI=prop.getProperty("BaseURI");
Response res=given().
		queryParam("key",prop.getProperty("key")).
		body(Body.postBody()).
		when().
		post(Resources.postResouces()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK")).
		extract().response();

//======Converting raw data of res into String format	=========== //		
String responseString=res.asString();

System.out.println(responseString);
//======Converting String in to Json format  ===================//
JsonPath js=new JsonPath(responseString);
//=======Retrieving the place id ================//
String place_id=js.get("place_id");
System.out.println(place_id);


// ======== Deleting method ============//
given().
		queryParam("key",prop.getProperty("key")).
		body(Body.deleteBody(place_id)).
		when().
		post(Resources.deleteResouces()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK"));


		
		
}
	
	

}
