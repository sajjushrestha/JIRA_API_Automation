package jira;

import files.Body;
import files.Resources;
import files.Reusable;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Create_issue {

	static String id;
	/*static String projectKey="RES";
	static String summary="Summary-37";
	static String description="Description-27";*/
	
	//@Test
	public static String createIssue(String projectKey,String summary,String description) throws Exception
	{
		System.out.println(Body.JIRA_create(projectKey, summary, description));
		
		
		Response createResponse= 
				given().header("Content-Type", "application/json").
						header("Cookie", "JSESSIONID="+Reusable.retrieveValue()).
						body(Body.JIRA_create(projectKey, summary, description)).
						when().
						post(Resources.JIRA_createIssue()).
						then().assertThat().statusCode(201).
						extract().response();
		
		JsonPath js=Reusable.rawToJson(createResponse);
		id = js.get("id");
		
		//System.out.println("Issue is is ="+ id);
		return id;
	}
	
}
