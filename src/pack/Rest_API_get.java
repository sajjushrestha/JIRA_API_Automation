package pack;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Rest_API_get {

	@Test
	public  void getMethod() {
		
		
		RestAssured.baseURI="https://maps.googleapis.com";
		
		given().
				param("location","-33.8670522,151.1957362").
				param("radius","500").
				param("key","AIzaSyD4myutOCQdanyupG_BRnnvvvGnR3Ar26M").
				
				when().
				get("/maps/api/place/nearbysearch/json").
				
				then().assertThat().
				statusCode(200).and().contentType(ContentType.JSON).and().
				body("results[0].name" ,equalTo("Sydney")).and().
				header("Server", "pablo").extract().response();
				
			

	}

}
