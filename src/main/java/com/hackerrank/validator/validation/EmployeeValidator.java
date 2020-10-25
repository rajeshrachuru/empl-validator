package com.hackerrank.validator.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hackerrank.validator.model.Employee;

public class EmployeeValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Employee.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object employeeObject, Errors errors) {
    	Employee emp = (Employee) employeeObject;
    	if(emp.getFullName() == null || "".equals(emp.getFullName())) {
    		errors.rejectValue("fullName", "", "The fullName is a mandatory field");
    	}
    	
    	if(emp.getMobileNumber() == null || emp.getMobileNumber().toString().length() != 10) {
    		errors.rejectValue("mobileNumber", "", "The mobileNumber is a mandatory field");
    	}
    	
    	if(emp.getEmailId() == null || "".equals(emp.getEmailId())) {
    		errors.rejectValue("emailId", "", "The emailId is a mandatory field");
    	}else if(emp.getEmailId().indexOf("@") < 0) {
    		errors.rejectValue("emailId", "", "The emailId should be in a valid email format");
    	}
    	
    	String regex = "^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$";
    	 String dob = emp.getDateOfBirth();
    	
    	if(dob == null || "".equals(dob)) {
    		errors.rejectValue("dateOfBirth", "", "The dateOfBirth is a mandatory field");
    	}else if(!dob.matches(regex)) {
    		errors.rejectValue("dateOfBirth", "", "The dateOfBirth should be in YYYY-MM-DD format");
    	}
    	
    }
}
