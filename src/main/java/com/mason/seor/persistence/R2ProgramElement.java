package com.mason.seor.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="r2")
public class R2ProgramElement implements Serializable{

	private static final long serialVersionUID = -1432248472976158884L;
	
	@Id
	@Column(name="PE")
	String pe;
	@Column(name="PE_Title")
	String peTitle;
	@Id
	@Column(name="Budget_Year")
	Integer budgetYear;
	@Column(name="Budget_Cycle")
	String budgetCycle;
	@Temporal(TemporalType.DATE)
	@Column(name="Submission_Date")
	Date submissionDate;
	@Column(name="Service_Agency_Name")
	String serviceAgencyName;
	@Column(name="Appropriation_Code")
	Integer appropriationCode;
	@Column(name="Appropriation_Name")
	String appropriationName;
	@Column(name="BA")
	Integer ba;
	@Column(name="BA_Title")
	String baTitle;
	@Column(name="FY_2010")
	public Double fy2010;
	@Column(name="FY_2011")
	public Double fy2011;
	@Column(name="FY_2012")
	public Double fy2012;
	@Column(name="FY_2013")
	public Double fy2013;
	@Column(name="FY_2014")
	public Double fy2014;
	@Column(name="FY_2015")
	public Double fy2015;
	@Column(name="FY_2016")
	public Double fy2016;
	@Column(name="FY_2017")
	public Double fy2017;
	@Column(name="FY_2018")
	public Double fy2018;
	@Column(name="FY_2019")
	public Double fy2019;
	@Column(name="FY_2020")
	public Double fy2020;
	@Column(name="FY_2021")
	public Double fy2021;
	@Column(name="FY_2022")
	public Double fy2022;
	@Column(name="FY_2023")
	public Double fy2023;
	public String getPe() {
		return pe;
	}
	public void setPe(String pe) {
		this.pe = pe;
	}
	public String getPeTitle() {
		return peTitle;
	}
	public void setPeTitle(String peTitle) {
		this.peTitle = peTitle;
	}
	public Integer getBudgetYear() {
		return budgetYear;
	}
	public void setBudgetYear(Integer budgetYear) {
		this.budgetYear = budgetYear;
	}
	public String getBudgetCycle() {
		return budgetCycle;
	}
	public void setBudgetCycle(String budgetCycle) {
		this.budgetCycle = budgetCycle;
	}
	public Date getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}
	public String getServiceAgencyName() {
		return serviceAgencyName;
	}
	public void setServiceAgencyName(String serviceAgencyName) {
		this.serviceAgencyName = serviceAgencyName;
	}
	public Integer getAppropriationCode() {
		return appropriationCode;
	}
	public void setAppropriationCode(Integer appropriationCode) {
		this.appropriationCode = appropriationCode;
	}
	public String getAppropriationName() {
		return appropriationName;
	}
	public void setAppropriationName(String appropriationName) {
		this.appropriationName = appropriationName;
	}
	public Integer getBa() {
		return ba;
	}
	public void setBa(Integer ba) {
		this.ba = ba;
	}
	public String getBaTitle() {
		return baTitle;
	}
	public void setBaTitle(String baTitle) {
		this.baTitle = baTitle;
	}
	public Double getFy2010() {
		return fy2010;
	}
	public void setFy2010(Double fy2010) {
		this.fy2010 = fy2010;
	}
	public Double getFy2011() {
		return fy2011;
	}
	public void setFy2011(Double fy2011) {
		this.fy2011 = fy2011;
	}
	public Double getFy2012() {
		return fy2012;
	}
	public void setFy2012(Double fy2012) {
		this.fy2012 = fy2012;
	}
	public Double getFy2013() {
		return fy2013;
	}
	public void setFy2013(Double fy2013) {
		this.fy2013 = fy2013;
	}
	public Double getFy2014() {
		return fy2014;
	}
	public void setFy2014(Double fy2014) {
		this.fy2014 = fy2014;
	}
	public Double getFy2015() {
		return fy2015;
	}
	public void setFy2015(Double fy2015) {
		this.fy2015 = fy2015;
	}
	public Double getFy2016() {
		return fy2016;
	}
	public void setFy2016(Double fy2016) {
		this.fy2016 = fy2016;
	}
	public Double getFy2017() {
		return fy2017;
	}
	public void setFy2017(Double fy2017) {
		this.fy2017 = fy2017;
	}
	public Double getFy2018() {
		return fy2018;
	}
	public void setFy2018(Double fy2018) {
		this.fy2018 = fy2018;
	}
	public Double getFy2019() {
		return fy2019;
	}
	public void setFy2019(Double fy2019) {
		this.fy2019 = fy2019;
	}
	public Double getFy2020() {
		return fy2020;
	}
	public void setFy2020(Double fy2020) {
		this.fy2020 = fy2020;
	}
	public Double getFy2021() {
		return fy2021;
	}
	public void setFy2021(Double fy2021) {
		this.fy2021 = fy2021;
	}
	public Double getFy2022() {
		return fy2022;
	}
	public void setFy2022(Double fy2022) {
		this.fy2022 = fy2022;
	}
	public Double getFy2023() {
		return fy2023;
	}
	public void setFy2023(Double fy2023) {
		this.fy2023 = fy2023;
	}

}
