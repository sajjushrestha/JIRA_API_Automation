package jira;

import org.testng.annotations.Test;
import files.Body;
import files.Resources;
import files.Reusable;
import static io.restassured.RestAssured.given;

public class Assigne_issue {


	String issueID="RES-5";
	String name="sajjushrestha@outlook.com";
	
	@Test
	public void addAssignee() throws Exception
	{
			
				given().header("Content-Type", "application/json").
						header("Cookie", "JSESSIONID="+Reusable.retrieveValue()).
						body(Body.JIRA_assignee(name)).
						when().
						put(Resources.JIRA_assignee(issueID)).
						then().assertThat().statusCode(204);
						
		
		
		
	}
	
}
