package com.mason.seor.model.r2;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.mason.seor.data.SubmissionDateConverter;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XmlRootElement(name = "ProgramElement")
public class ProgramElement {

	String MonetaryUnit;
	String ProgramElementNumber;
	String ProgramElementTitle;
	Integer R1LineNumber;
	Integer BudgetYear;
	String BudgetCycle;
	String SubmissionDate;
	String ServiceAgencyName;
	String AppropriationCode;
	String AppropriationName;
	Integer BudgetActivityNumber;
	String BudgetActivityTitle;
	ProgramElementFunding ProgramElementFunding;

	@XmlAttribute(name = "MonetaryUnit")
	public String getMonetaryUnit() {
		return MonetaryUnit;
	}

	public void setMonetaryUnit(String monetaryUnit) {
		this.MonetaryUnit = monetaryUnit;
	}

	@XmlElement(name = "ProgramElementNumber")
	public String getProgramElementNumber() {
		return ProgramElementNumber;
	}

	public void setProgramElementNumber(String programelementNumber) {
		this.ProgramElementNumber = programelementNumber;
	}

	@XmlElement(name = "ProgramElementTitle")
	public String getProgramElementTitle() {
		return ProgramElementTitle;
	}

	public void setProgramElementTitle(String programElementTitle) {
		this.ProgramElementTitle = programElementTitle;
	}

	@XmlElement(name = "R1LineNumber")
	public Integer getR1LineNumber() {
		return R1LineNumber;
	}

	public void setR1LineNumber(Integer r1LineNumber) {
		this.R1LineNumber = r1LineNumber;
	}

	@XmlElement(name = "BudgetYear")
	public Integer getBudgetYear() {
		return BudgetYear;
	}

	public void setBudgetYear(Integer budgetYear) {
		this.BudgetYear = budgetYear;
	}

	@XmlElement(name = "BudgetCycle")
	public String getBudgetCycle() {
		return BudgetCycle;
	}

	public void setBudgetCycle(String budgetCycle) {
		this.BudgetCycle = budgetCycle;
	}

	@XmlElement(name = "SubmissionDate")
	public String getSubmissionDate() {
		return SubmissionDate;
	}

	public void setSubmissionDate(String submissionDate) {
		this.SubmissionDate = submissionDate;
	}

	@XmlElement(name = "ServiceAgencyName")
	public String getServiceAgencyName() {
		return ServiceAgencyName;
	}

	public void setServiceAgencyName(String serviceAgencyName) {
		this.ServiceAgencyName = serviceAgencyName;
	}

	@XmlElement(name = "AppropriationCode")
	public String getAppropriationCode() {
		return AppropriationCode;
	}

	public void setAppropriationCode(String appropriationCode) {
		AppropriationCode = appropriationCode;
	}

	@XmlElement(name = "AppropriationName")
	public String getAppropriationName() {
		return AppropriationName;
	}

	public void setAppropriationName(String appropriationName) {
		this.AppropriationName = appropriationName;
	}

	@XmlElement(name = "BudgetActivityNumber")
	public Integer getBudgetActivityNumber() {
		return BudgetActivityNumber;
	}

	public void setBudgetActivityNumber(Integer budgetActivityNumber) {
		this.BudgetActivityNumber = budgetActivityNumber;
	}
	
	@XmlElement(name = "BudgetActivityTitle")
	public String getBudgetActivityTitle() {
		return BudgetActivityTitle;
	}

	public void setBudgetActivityTitle(String budgetActivityTitle) {
		this.BudgetActivityTitle = budgetActivityTitle;
	}

	@XmlElement(name = "ProgramElementFunding")
	public ProgramElementFunding getProgramElementFunding() {
		return ProgramElementFunding;
	}

	public void setProgramElementFunding(ProgramElementFunding programElementFunding) {
		this.ProgramElementFunding = programElementFunding;
	}

}
