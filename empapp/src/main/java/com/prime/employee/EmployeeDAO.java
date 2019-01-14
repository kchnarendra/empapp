package com.prime.employee;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;


@Configuration
public abstract class EmployeeDAO {
	
	static Logger log = Logger.getLogger(EmployeeDAO.class.getName());
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
/* ######################################################## inserting data ################################################### */		
	
	@Transactional
	public void insertEmployee(EmployeeDTO edto) {
		
		log.info("insertEmployee() is stated");
		try {
			
			//hibernateTemplate.save(edto);
			hibernateTemplate.save(edto);
		}
		catch(Exception e) {
			
			// Even in case of failure control is not coming in this block
			// Its useless to use try catch because it is sending query only after insertEmployee() is completely executed.
		}
		log.info("insertEmployee() is endeded in DAO");
	}
	
/* ######################################################## retrieving data ################################################### */	

	public List<EmployeeVO> getAllEmployeesDAO() {
		
		log.info("getAllEmployeesDAO() is started in DAO");
		List<EmployeeVO> list = (List<EmployeeVO>)hibernateTemplate.findByCriteria(DetachedCriteria.forClass(EmployeeVO.class));
		log.info("getAllEmployeesDAO() is endeded in DAO");
		return list;
	}
	
/* ######################################################## deleting data ################################################### */
	
	public void deleteEmployeeDAO(EmployeeDTO employeeDTO ) {
		
		hibernateTemplate.delete(employeeDTO);
	}
	
}
