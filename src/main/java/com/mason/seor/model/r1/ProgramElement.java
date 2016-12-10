package com.mason.seor.model.r1;

public class ProgramElement {
	
	String organization;
	Integer ba;
	String baTitle;
	String pe;
	String peTitle;
	Double twoYearsPriorAmount;
	Double prevYearPriorAmount;
	Double currentYearAmount;

	
	public String getOrganization() {
		return organization;
	}
	
	/**
	 * Column C
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public Integer getBa() {
		return ba;
	}

	/**
	 * Column E
	 */
	public void setBa(Integer ba) {
		this.ba = ba;
	}

	public String getBaTitle() {
		return baTitle;
	}

	/**
	 * Column F
	 */
	public void setBaTitle(String baTitle) {
		this.baTitle = baTitle;
	}

	public String getPe() {
		return pe;
	}

	/**
	 * Column G
	 */
	public void setPe(String pe) {
		this.pe = pe;
	}

	public String getPeTitle() {
		return peTitle;
	}
	/**
	 * Column H
	 */
	public void setPeTitle(String peTitle) {
		this.peTitle = peTitle;
	}

	public Double getTwoYearsPriorAmount() {
		return twoYearsPriorAmount;
	}

	/**
	 * Column J
	 */
	public void setTwoYearsPriorAmount(Double twoYearsPriorAmount) {
		if(twoYearsPriorAmount==null){
			this.twoYearsPriorAmount=0.0;
			return;
		}
		this.twoYearsPriorAmount = twoYearsPriorAmount;
	}

	public Double getPrevYearPriorAmount() {
		return prevYearPriorAmount;
	}
	/**
	 * Column K
	 */
	public void setPrevYearPriorAmount(Double prevYearPriorAmount) {
		if(prevYearPriorAmount==null){
			this.prevYearPriorAmount=0.0;
			return;
		}
		this.prevYearPriorAmount = prevYearPriorAmount;
	}

	public Double getCurrentYearAmount() {
		return currentYearAmount;
	}
	/**
	 * Column L
	 */
	public void setCurrentYearAmount(Double currentYearAmount) {
		if(currentYearAmount==null){
			this.currentYearAmount=0.0;
			return;
		}
		this.currentYearAmount = currentYearAmount;
	}

}
