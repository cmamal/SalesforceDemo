package com.salesforce.integration;

import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

public class ConnectionUtils 
{
	private static ConnectionUtils INSTANCE = new ConnectionUtils();
	private static final String SF_DEMO_USERNAME = "happysf@salesforce.com";
	private static final String SF_DEMO_TOKEN = "happy123aeq0UrA7FZnbFgf179FGXGaD3";
	private static final String SF_DEMO_ENDPOINT = "https://ap2.salesforce.com/services/Soap/c/30.0";
	private static final String SF_DEMO_QUERY_EMP = "select Name, ID__c, Joining_Date__c, Department__c from Employee__c";
	
	private ConnectionUtils(){		
	}
	
    public static ConnectionUtils getInstance(){
        return INSTANCE;
    }
    
	public ConnectorConfig getDefaultConnectorConfig(){
		ConnectorConfig nconfig = new ConnectorConfig();				
		nconfig.setUsername(SF_DEMO_USERNAME);
		nconfig.setPassword(SF_DEMO_TOKEN);		
		nconfig.setAuthEndpoint(SF_DEMO_ENDPOINT);
		return nconfig;
	}
	
	public ConnectorConfig createNewConnectorConfig(String username,String token, String endpoint){
		ConnectorConfig nconfig = new ConnectorConfig();				
		nconfig.setUsername(username);
		nconfig.setPassword(token);		
		nconfig.setAuthEndpoint(endpoint);
		return nconfig;
	}
	
	public EnterpriseConnection getSalesforceConnection(ConnectorConfig connectorConfig) throws ConnectionException{
		return new EnterpriseConnection(connectorConfig);
	}
	
	public QueryResult executeSalesforceQuery(EnterpriseConnection connection, String sfquery) throws Exception{
		QueryResult qr = connection.query(sfquery);
		return qr;
	}
	
}
