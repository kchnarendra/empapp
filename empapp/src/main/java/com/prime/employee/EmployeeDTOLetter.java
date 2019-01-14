package com.prime.employee;

import javax.validation.constraints.Pattern;

public class EmployeeDTOLetter {

	//@Size(max=1, message="* Please enter only one leller")
	//@NotEmpty(message="* Enter first letter of name")
	//@NotNull(message="Dont enter space")
	@Pattern(regexp="[a-zA-Z]", message="* Please enter only first alphabate name")
	//@NotBlank(message="* Blank is no acceptable")
	private String nameFirstLetter;

	public String getNameFirstLetter() {
		return nameFirstLetter;
	}

	public void setNameFirstLetter(String nameFirstLetter) {
		this.nameFirstLetter = nameFirstLetter;
	}
}
