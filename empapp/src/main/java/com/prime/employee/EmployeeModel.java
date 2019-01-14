package com.prime.employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeModel {

	static Logger log = Logger.getLogger(EmployeeModel.class.getName());
	
	@Autowired
	private EmployeeDAOConfirmer employeeDAOConfirmer;
	
	public EmployeeDAOConfirmer getEmployeeDAOConfirmer() {
		return employeeDAOConfirmer;
	}

/*	############################################ for inserting data ############################################################ */	

	public boolean insertEmployeeMod(EmployeeDTO edto ) {
		
		log.info("insertEmployeeMod() is started");
		boolean bm = false;
		boolean b = employeeDAOConfirmer.insertEmloyeeCon(edto);
		
		if(b == true) {
			
			bm = true;
		}
		else {
			
			log.info("insertEmployeeMod() is failled");
		}
		log.info("insertEmployeeMod() is endeded succesfully");
		return bm;
	}
	
/*	############################################ for retrieving data ############################################################ */
	
	public List<EmployeeVO> getAllEmployeesMod() {
		
		log.info("getAllEmployeesMod() started");
		List<EmployeeVO> list =  employeeDAOConfirmer.getAllEmployeesCon();
		log.info("getAllEmployeesMod() ended");

		return list;
	}
	
	public List<EmployeeVO> getEmployeeByLetter(EmployeeDTOLetter employeeDTOLetter) {
		
		List<EmployeeVO> empList = new ArrayList<EmployeeVO>();
		List<EmployeeVO> list = employeeDAOConfirmer.getAllEmployeesCon();
		Iterator<EmployeeVO> iterator = list.iterator();
		
		String nameFirstLetter = employeeDTOLetter.getNameFirstLetter().trim();
		char nameFirstChar = nameFirstLetter.charAt(0);
		
		while(iterator.hasNext()) {
			
			EmployeeVO tempList = iterator.next();
			if((tempList.getName().charAt(0)) == nameFirstChar) {
			
				empList.add(tempList);
			}
			
		}
		//employeeDTOLetter.getNameFirstLetter()
		return empList;
	}
	
/* ######################################################## deleting data ################################################### */

	public boolean deleteEmployeeModel(EmployeeDTO employeeDTO) {

		boolean b = false;
		try {
			
			
			b = employeeDAOConfirmer.deleteEmployeeCon(employeeDTO);
		}
		catch(Exception e) {
			
			log.info("deleteEmployeeModel() failed to delete record"); 
		}
		
		return b;
	}
}









