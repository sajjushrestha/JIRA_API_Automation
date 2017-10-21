package files;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Resources {

	public static String postResouces()
	{
		String add="/maps/api/place/add/json";
		return add;
	}
	
	public static String deleteResouces()
	{
		String delete="/maps/api/place/delete/json";
		return delete;
	}
	
	public static String postResoucesXML()
	{
		String add="/maps/api/place/add/xml";
		return add;
	}
	
	public static String deleteResoucesXML()
	{
		String delete="/maps/api/place/delete/xml";
		return delete;
	}
	
	
	// ======= JIRA ========== //
	
	public static String JIRA_createIssue()
	{
		return new String("/rest/api/2/issue");
		
	}

	public static String JIRA_retrieveValue() {
		
		return new String("/rest/auth/1/session");
		
	}
	
	public static String JIRA_deleteIssue(String issueID)
	{
		return new String("/rest/api/2/issue/"+issueID);
		
	}
	
	public static String JIRA_addComment(String issueID)
	{
		return new String("/rest/api/2/issue/"+issueID+"/comment");
		
	}
	
	public static String JIRA_updateComment(String issueID,String commentID)
	{
		return new String("/rest/api/2/issue/"+issueID+"/comment/"+commentID);
		
	}
	
	
	public static String JIRA_assignee(String issueID)
	{
		return new String("/rest/api/2/issue/"+issueID+"/assignee");
		
	}
	
	
}
