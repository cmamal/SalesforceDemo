package com.acm.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acm.pojo.EmployeeVO;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Employee__c;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import com.salesforce.integration.ConnectionUtils;

@Controller
public class BaseController {

	private static final String VIEW_INDEX = "index";	
	private static final String SF_QUERY_EMP = "select Name, ID__c, Joining_Date__c, Department__c from Employee__c";
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listEmployees(ModelMap model) throws ConnectionException {

		logger.debug("[listEmployees] ");
		ConnectorConfig conconf = ConnectionUtils.getInstance().getDefaultConnectorConfig();
		EnterpriseConnection conn = ConnectionUtils.getInstance().getSalesforceConnection(conconf);
		try {
			QueryResult qr = ConnectionUtils.getInstance().executeSalesforceQuery(conn, SF_QUERY_EMP);
			SObject[] records = qr.getRecords();
			List<EmployeeVO> emplist = new ArrayList<EmployeeVO>(); 
			for (SObject sobj: records){
				Employee__c emp = (Employee__c) sobj;
				EmployeeVO evo = new EmployeeVO();
				evo.setDepartment(emp.getDepartment__c());
				evo.setId(emp.getID__c());
				evo.setJoiningDate(emp.getJoining_Date__c().getTime());
				evo.setName(emp.getName());
				emplist.add(evo);
				emp.setDepartment__c("IMSS");
			}
			model.addAttribute("emplist", emplist);
		} catch (ConnectionException e) {
			model.addAttribute("error", "Connection Exception");
			e.printStackTrace();
		} catch (Exception e) {
			model.addAttribute("error", "Unknown Exception");
			e.printStackTrace();
		}
		return VIEW_INDEX;

	}

}