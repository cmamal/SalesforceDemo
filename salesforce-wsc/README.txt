Steps to create salesforce webservice client jar and integrate to your application.

1. Get the enterprise wsdl from your salesforce instance, available at <yoursfurl> -> Setup -> Build -> Develop -> API -> Generate Enterprise WSDL.
2. Copy the wdsl contents to wsdl/enterprise.wdsl.
3. Do 'mvn clean install', and the client jar will be available as 'salesforce-wsc\target\salesforce-wsc-1.1.jar'.
4. Add this jar to repository and create dependencies to use salesforce webservice client in your application.
			<!-- Salesforce dependency-->
		<dependency>
			<groupId>com.salesforce.ws</groupId>
			<artifactId>salesforce-wsc</artifactId>
			<version>1.1</version>
		</dependency>