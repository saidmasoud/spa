package com.mason.seor.model.r2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ProgramElementFunding")
public class ProgramElementFunding {
	
	Double PriorYear;
	Double CurrentYear;
	Double BudgetYearOne;
	Double BudgetYearOneBase;
	Double BudgetYearTwo;
	Double BudgetYearThree;
	Double BudgetYearFour;
	Double BudgetYearFive;
	
	@XmlElement(name = "PriorYear")
	public Double getPriorYear() {
		return PriorYear;
	}
	public void setPriorYear(Double priorYear) {
		this.PriorYear = priorYear;
	}
	@XmlElement(name = "CurrentYear")
	public Double getCurrentYear() {
		return CurrentYear;
	}
	public void setCurrentYear(Double currentYear) {
		this.CurrentYear = currentYear;
	}
	@XmlElement(name = "BudgetYearOne")
	public Double getBudgetYearOne() {
		return BudgetYearOne;
	}
	public void setBudgetYearOne(Double budgetYearOne) {
		this.BudgetYearOne = budgetYearOne;
	}
	@XmlElement(name = "BudgetYearOneBase")
	public Double getBudgetYearOneBase() {
		return BudgetYearOneBase;
	}
	public void setBudgetYearOneBase(Double budgetYearOneBase) {
		this.BudgetYearOneBase = budgetYearOneBase;
	}
	@XmlElement(name = "BudgetYearTwo")
	public Double getBudgetYearTwo() {
		return BudgetYearTwo;
	}
	public void setBudgetYearTwo(Double budgetYearTwo) {
		this.BudgetYearTwo = budgetYearTwo;
	}
	@XmlElement(name = "BudgetYearThree")
	public Double getBudgetYearThree() {
		return BudgetYearThree;
	}
	public void setBudgetYearThree(Double budgetYearThree) {
		this.BudgetYearThree = budgetYearThree;
	}
	@XmlElement(name = "BudgetYearFour")
	public Double getBudgetYearFour() {
		return BudgetYearFour;
	}
	public void setBudgetYearFour(Double budgetYearFour) {
		this.BudgetYearFour = budgetYearFour;
	}
	@XmlElement(name = "BudgetYearFive")
	public Double getBudgetYearFive() {
		return BudgetYearFive;
	}
	public void setBudgetYearFive(Double budgetYearFive) {
		this.BudgetYearFive = budgetYearFive;
	}
	
	

}
