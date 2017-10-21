package jira;

import org.testng.Assert;
import org.testng.annotations.Test;
import files.Body;
import files.Resources;
import files.Reusable;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UpdateComment_issue {

	String commentID="10002";
	String comment="Updated Comment Succesfully from aut";
	String issueID="RES-3";
	
	@Test
	public void updateComment() throws Exception
	{
			
		
				given().header("Content-Type", "application/json").
						header("Cookie", "JSESSIONID="+Reusable.retrieveValue()).
						body(Body.JIRA_addCommenet(comment)).
						when().
						put(Resources.JIRA_updateComment(issueID,commentID)).
						then().assertThat().statusCode(200);
						
		
		
		
	}
	
}
