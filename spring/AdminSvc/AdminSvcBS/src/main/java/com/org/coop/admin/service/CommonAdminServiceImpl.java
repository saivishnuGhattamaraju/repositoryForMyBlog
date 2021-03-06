package com.org.coop.admin.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.coop.admin.servicehelper.CommonAdminServiceHelperImpl;
import com.org.coop.society.data.admin.entities.SecurityQuestion;

@Service
public class CommonAdminServiceImpl {
	private static final Logger log = Logger.getLogger(AdminLoginSvcImpl.class); 
	
	@Autowired
	private CommonAdminServiceHelperImpl commonAdminServiceHelperImpl;
	
	
	
	public List<SecurityQuestion> getAllSecurityQuestions() {
		return commonAdminServiceHelperImpl.getAllSecurityQuestions();
	}
	
	public Map<String, String> getBranchRules(String username) {
		return commonAdminServiceHelperImpl.getBranchRules(username);
	}
	
	public String getBranchRuleValueByKey(String username, String key) {
		return commonAdminServiceHelperImpl.getBranchRuleValueByKey(username, key);
	}
	
	public Date getDateByString(String dateInString) {
		return commonAdminServiceHelperImpl.getDateByString(dateInString);
	}
}
