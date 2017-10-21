package jira;

import org.testng.annotations.Test;
import files.Body;
import files.Resources;
import files.Reusable;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class AddComment_issue {

	String commentID;
	String comment="Added Comment Succesfully";
	String issueID="RES-3";
	
	@Test
	public void addComment() throws Exception
	{
			
		Response createResponse= 
				given().header("Content-Type", "application/json").
						header("Cookie", "JSESSIONID="+Reusable.retrieveValue()).
						body(Body.JIRA_addCommenet(comment)).
						when().
						post(Resources.JIRA_addComment(issueID)).
						then().assertThat().statusCode(201).
						extract().response();
		
		JsonPath js=Reusable.rawToJson(createResponse);
		commentID = js.get("id");
		
		System.out.println("Comment Id is  ="+ commentID);
	}
	
}
