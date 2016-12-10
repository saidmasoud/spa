package com.mason.seor.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="r1")
public class R1ProgramElement implements Serializable{
	
	private static final long serialVersionUID = -2603681007089621669L;
	
	@Id
	@Column(name="PE")
	public String pe;
	@Id
	@Column(name="FY_reported")
	public Integer fyReported;
	@Column(name="BA")
	public Integer ba;
	@Column(name="BA_Title")
	public String baTitle;
	@Column(name="PE_Title")
	public String peTitle;
	@Column(name="Organization")
	public String organization;
	@Column(name="FY_1996")
	public Double fy1996;
	@Column(name="FY_1997")
	public Double fy1997;
	@Column(name="FY_1998")
	public Double fy1998;
	@Column(name="FY_1999")
	public Double fy1999;
	@Column(name="FY_2000")
	public Double fy2000;
	@Column(name="FY_2001")
	public Double fy2001;
	@Column(name="FY_2002")
	public Double fy2002;
	@Column(name="FY_2003")
	public Double fy2003;
	@Column(name="FY_2004")
	public Double fy2004;
	@Column(name="FY_2005")
	public Double fy2005;
	@Column(name="FY_2006")
	public Double fy2006;
	@Column(name="FY_2007")
	public Double fy2007;
	@Column(name="FY_2008")
	public Double fy2008;
	@Column(name="FY_2009")
	public Double fy2009;
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
	public String getPe() {
		return pe;
	}
	public void setPe(String pe) {
		this.pe = pe;
	}
	public Integer getFyReported() {
		return fyReported;
	}
	public void setFyReported(Integer fyReported) {
		this.fyReported = fyReported;
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
	public String getPeTitle() {
		return peTitle;
	}
	public void setPeTitle(String peTitle) {
		this.peTitle = peTitle;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public Double getFy1996() {
		return fy1996;
	}
	public void setFy1996(Double fy1996) {
		this.fy1996 = fy1996;
	}
	public Double getFy1997() {
		return fy1997;
	}
	public void setFy1997(Double fy1997) {
		this.fy1997 = fy1997;
	}
	public Double getFy1998() {
		return fy1998;
	}
	public void setFy1998(Double fy1998) {
		this.fy1998 = fy1998;
	}
	public Double getFy1999() {
		return fy1999;
	}
	public void setFy1999(Double fy1999) {
		this.fy1999 = fy1999;
	}
	public Double getFy2000() {
		return fy2000;
	}
	public void setFy2000(Double fy2000) {
		this.fy2000 = fy2000;
	}
	public Double getFy2001() {
		return fy2001;
	}
	public void setFy2001(Double fy2001) {
		this.fy2001 = fy2001;
	}
	public Double getFy2002() {
		return fy2002;
	}
	public void setFy2002(Double fy2002) {
		this.fy2002 = fy2002;
	}
	public Double getFy2003() {
		return fy2003;
	}
	public void setFy2003(Double fy2003) {
		this.fy2003 = fy2003;
	}
	public Double getFy2004() {
		return fy2004;
	}
	public void setFy2004(Double fy2004) {
		this.fy2004 = fy2004;
	}
	public Double getFy2005() {
		return fy2005;
	}
	public void setFy2005(Double fy2005) {
		this.fy2005 = fy2005;
	}
	public Double getFy2006() {
		return fy2006;
	}
	public void setFy2006(Double fy2006) {
		this.fy2006 = fy2006;
	}
	public Double getFy2007() {
		return fy2007;
	}
	public void setFy2007(Double fy2007) {
		this.fy2007 = fy2007;
	}
	public Double getFy2008() {
		return fy2008;
	}
	public void setFy2008(Double fy2008) {
		this.fy2008 = fy2008;
	}
	public Double getFy2009() {
		return fy2009;
	}
	public void setFy2009(Double fy2009) {
		this.fy2009 = fy2009;
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
}
