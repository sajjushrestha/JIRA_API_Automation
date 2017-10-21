package jira;

import org.testng.annotations.Test;
import files.Body;
import files.Resources;
import files.Reusable;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Delete_issue {

	//String issueID ="RES-5" ;
	
	
	//@Test
	public static void deleteIssue(String issueID) throws Exception
	{
		
				given().
						header("Cookie", "JSESSIONID="+Reusable.retrieveValue()).
						when().
						delete(Resources.JIRA_deleteIssue(issueID)).
						then().assertThat().statusCode(204);	
	}
	
}
