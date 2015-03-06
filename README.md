# SalesforceDemo
Web Project : Connect to Salesforce and fetch data from salesforce schema
Projects include 3 module
1. salesforce-wsc : generates client jars for given salesforce wsdl.
2. salesforce-integration : utilities to connect to salesforce and retrieve salesforce objects using SOQL queries.
3. salesforce-web : A web project which shows a list of employees (a custom salesforce object) retrieved from salesforce.

Steps to execute
1. cd SalesforceDemo ;mvn clean install
2. cd salesforce-web ;mvn tomcat:run'
3. Paste this link in browser : http://localhost:8080/salesforce-web/
