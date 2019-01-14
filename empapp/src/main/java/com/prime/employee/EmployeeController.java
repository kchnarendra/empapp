package com.prime.employee;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	
	static Logger log = Logger.getLogger(EmployeeController.class.getName());
  
	@Autowired
	private EmployeeModel employeeModel;
	
/*	############################################ for viewing home page ############################################################ */	
	
	@RequestMapping(value="/")
	public String showHomePage() {
		
		log.info("home.jsp is displayed");
		return "home";
	}
	
/*	############################################ for inserting data ############################################################ */	
	
	@RequestMapping(value="/employee_form")
	public String employeeInsertForm(Model model) {
		
		log.info("employee_form.jsp is started");
		model.addAttribute("employeeDTO", new EmployeeDTO());
		//return "employee_form";
		return "employee_form";
	}
	
	@RequestMapping(value="/eds", method=RequestMethod.POST )
	public String employeeDataStorer(Model model, @Valid EmployeeDTO employeeDTO, BindingResult errors) {
		
		log.info("employeeDataStorer() stared");

		
		if(errors.hasErrors()) {
			
			return "employee_form";
		}
		
        boolean b = employeeModel.insertEmployeeMod(employeeDTO);
		if(b==true) {
			
			model.addAttribute("edto", employeeDTO);
			log.info("employeeDataStorer() capured employee_form data succesfully");
			return "success";
		}
		else {
			
			log.info("employeeDataStorer() failled to capture employee_form data");
			return "failure";
		}
	}
	
/*	############################################ for retrieving data ############################################################ */

	@RequestMapping(value="/allemp" )
	public ModelAndView allEmployeeViewer() {
		
		log.info("allEmployeeViewer() stared");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("employee_viewer");	
		mav.addObject("list", employeeModel.getAllEmployeesMod());
		log.info("allEmployeeViewer() ended");
		return mav;
	}
	
/*	############################################ for searching ############################################################ */
	
	@RequestMapping(value="/empbyletter" )
	public String searchFormViewer(Model emv) {
		
		emv.addAttribute("employeeDTOLetter", new EmployeeDTOLetter());
		return "search_form";
	}
	
	
	@RequestMapping(value="/empbyletter", method=RequestMethod.POST)
	public String getEmployeeByLetter(Model mav, @Valid EmployeeDTOLetter employeeDTOLetter, BindingResult searchEroor) {
		
		if(searchEroor.hasErrors()) {
			
			return "search_form";
		}
		
		mav.addAttribute("list", employeeModel.getEmployeeByLetter(employeeDTOLetter));
		return "search_form";
	}
	
/*	############################################ for deleting ############################################################ */
	
/*	@RequestMapping(value="/delete_emp_form", method=RequestMethod.GET)
	public void deleteEmployeViewer() {
		
		Model emv = new Model();
		searchFormViewer(emv);
		//return "/empbyletter";
	}*/
	
	
	
	
	@RequestMapping(value="/delemp" )
	public String deleteFormViewer(Model emv) {
		
/*		EmployeeDelListDTO edld = new EmployeeDelListDTO();
		List listTemp = new ArrayList();
		edld.setEmployeeDelList(listTemp);
		emv.addAttribute("employeeDelListDTO", edld);*/
		
		
		emv.addAttribute("employeeDTOLetter", new EmployeeDTOLetter());
		//emv.addAttribute("employeeDelListDTO", new EmployeeDelListDTO());
		
		
		return "delete_emp_form";
	}
	
	
	@RequestMapping(value="/delemp", method=RequestMethod.POST)
	public String deleteEmployeeWithCheckbox(Model mav, @Valid EmployeeDTOLetter employeeDTOLetter, BindingResult searchEroor) {
		
		if(searchEroor.hasErrors()) {
			
			return "delete_emp_form";
		}
		
		mav.addAttribute("list", employeeModel.getEmployeeByLetter(employeeDTOLetter));
		
		//EmployeeDelListDTO edld = new EmployeeDelListDTO();
		//List<EmployeeVO> listTemp = new ArrayList();
	//	edld.setEmployeeDelList(listTemp);
		mav.addAttribute("employeeDelListDTO", new EmployeeDelListDTO());
		return "delete_emp_form";
	}
	
	@RequestMapping(value="/delemplist")
	//public String deleteEmployeesFromList(@ModelAttribute EmployeeDelListDTO employeeDelListDTO ) {
	public String deleteEmployeesFromList(Model mavv,@Valid EmployeeDelListDTO employeeDelListDTO, BindingResult derror ) {
		
		//ModelAndView mavv = new ModelAndView();
		//mavv.setViewName("tempdisp");
		
		System.out.println(employeeDelListDTO);
		
		System.out.println(employeeDelListDTO.getEmployeeDelList());
		return "tempdisp";
	}
}




