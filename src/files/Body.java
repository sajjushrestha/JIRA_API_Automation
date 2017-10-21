package files;

public class Body {

	public static String postBody()
	{
		
		String addBody="{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -33.8669710,\r\n" + 
				"    \"lng\": 151.1958750\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Google Shoes!\",\r\n" + 
				"  \"phone_number\": \"(02) 9374 4000\",\r\n" + 
				"  \"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\",\r\n" + 
				"  \"types\": [\"shoe_store\"],\r\n" + 
				"  \"website\": \"http://www.google.com.au/\",\r\n" + 
				"  \"language\": \"en-AU\"\r\n" + 
				"}";
		
		return addBody;
		
		
		
	}
	
	
	public static String deleteBody(String place_id)
	{
		
		String delBody="{\r\n" + 
				"  \"place_id\": \""+place_id+"\"\r\n" + 
				"}";
		
		return delBody;	
		
	}
	
	
	//  ======  JIRA ========   //
	
	public static String JIRA_addBody(String uname,String pwd)
	{
		
		String JIRAaddBody="{\"username\": \""+uname+"\", \"password\": \""+pwd+"\" }";
		
		return JIRAaddBody;	
		
	}
	
	public static String JIRA_create(String projectKey,String summary,String description)
	{
		
		String JIRAaddBody="{\r\n" + 
				" 	\"fields\": {\r\n" + 
				"        \"project\": \r\n" + 
				"        {\r\n" + 
				"            \"key\": \""+projectKey+"\"\r\n" + 
				"        },\r\n" + 
				"        \"summary\": \""+summary+"\",\r\n" + 
				"         \"description\": \""+description+"\",\r\n" + 
				"        \"issuetype\": \r\n" + 
				"        {\r\n" + 
				"            \"name\": \"Bug\"\r\n" + 
				"        }\r\n" + 
				" 	}\r\n" + 
				"}";
		
		return JIRAaddBody;	
		
	}
	
	
	public static String JIRA_addCommenet(String comment)
	{
		
		String JIRAaddComment="{\r\n" + 
				"    \"body\": \""+comment+"\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}";
		
		return JIRAaddComment;	
		
	}
	
	public static String JIRA_assignee(String name)
	{
		
		return new String ("{\r\n" + 
				"    \"name\": \""+name+"\"\r\n" + 
				"}");
		
	}
	
}
