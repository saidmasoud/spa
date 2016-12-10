package com.mason.seor.processor;

import static com.mason.seor.utils.DataUtils.isValidPe;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.InitializingBean;

import com.mason.seor.model.r1.ProgramElement;
import com.mason.seor.persistence.R1ProgramElement;

public class R1Processor implements ItemProcessor<ProgramElement, R1ProgramElement>, InitializingBean {

	String fileName;
	String fiscalYear;
	
	private static final String FISCAL_YEAR_PREFIX = "fy";

	@Override
	public R1ProgramElement process(ProgramElement item) throws Exception {

		// not an extractable row, toss
		if (item.getPe() == null || (item.getPe() != null && !item.getPe().substring(0, 2).matches("^[0-9]{2}"))) {
			return null;
		}

		Integer ba = Integer.valueOf(item.getPe().substring(2, 4));

		if(!isValidPe(item)){
			return null;
		}

		R1ProgramElement element = new R1ProgramElement();
		Integer year = Integer.valueOf(fiscalYear);

		// some of the BA's in the excel files don't match up with the BA
		// listed in the PE. Since we're taking the PE as the source of truth,
		// we'll use that one when we injest into the database
		element.setBa(ba);
		element.setOrganization(item.getOrganization());
		element.setBaTitle(item.getBaTitle());
		element.setFyReported(year);
		element.setPe(StringUtils.isNotBlank(item.getPe()) ? item.getPe() : "BLANK");
		element.setPeTitle(item.getPeTitle());
		
		// two years prior
		Field previousYear = element.getClass().getDeclaredField(FISCAL_YEAR_PREFIX + Double.toString((year - 2)).replaceFirst("\\.0", ""));
		previousYear.set(element, item.getTwoYearsPriorAmount());

		// previous year
		Field currentYear = element.getClass().getDeclaredField(FISCAL_YEAR_PREFIX + Double.toString((year - 1)).replaceFirst("\\.0", ""));
		currentYear.set(element, item.getPrevYearPriorAmount());

		// current year
		Field budgetYearOne = element.getClass().getDeclaredField(FISCAL_YEAR_PREFIX + Double.toString((year)).replaceFirst("\\.0", ""));
		budgetYearOne.set(element, item.getCurrentYearAmount());
		
		return element;
		/*switch (fiscalYear) {
		case "1998":
			element.setFy1996(item.getTwoYearsPriorAmount());
			element.setFy1997(item.getPrevYearPriorAmount());
			element.setFy1998(item.getCurrentYearAmount());
			return element;
		case "1999":
			element.setFy1997(item.getTwoYearsPriorAmount());
			element.setFy1998(item.getPrevYearPriorAmount());
			element.setFy1999(item.getCurrentYearAmount());
			return element;
		case "2000":
			element.setFy1998(item.getTwoYearsPriorAmount());
			element.setFy1999(item.getPrevYearPriorAmount());
			element.setFy2000(item.getCurrentYearAmount());
			return element;
		case "2001":
			element.setFy1999(item.getTwoYearsPriorAmount());
			element.setFy2000(item.getPrevYearPriorAmount());
			element.setFy2001(item.getCurrentYearAmount());
			return element;
		case "2002":
			element.setFy2000(item.getTwoYearsPriorAmount());
			element.setFy2001(item.getPrevYearPriorAmount());
			element.setFy2002(item.getCurrentYearAmount());
			return element;
		case "2003":
			element.setFy2001(item.getTwoYearsPriorAmount());
			element.setFy2002(item.getPrevYearPriorAmount());
			element.setFy2003(item.getCurrentYearAmount());
			return element;
		case "2004":
			element.setFy2002(item.getTwoYearsPriorAmount());
			element.setFy2003(item.getPrevYearPriorAmount());
			element.setFy2004(item.getCurrentYearAmount());
			return element;
		case "2005":
			element.setFy2003(item.getTwoYearsPriorAmount());
			element.setFy2004(item.getPrevYearPriorAmount());
			element.setFy2005(item.getCurrentYearAmount());
			return element;
		case "2006":
			element.setFy2004(item.getTwoYearsPriorAmount());
			element.setFy2005(item.getPrevYearPriorAmount());
			element.setFy2006(item.getCurrentYearAmount());
			return element;
		case "2007":
			element.setFy2005(item.getTwoYearsPriorAmount());
			element.setFy2006(item.getPrevYearPriorAmount());
			element.setFy2007(item.getCurrentYearAmount());
			return element;
		case "2008":
			element.setFy2006(item.getTwoYearsPriorAmount());
			element.setFy2007(item.getPrevYearPriorAmount());
			element.setFy2008(item.getCurrentYearAmount());
			return element;
		case "2009":
			element.setFy2007(item.getTwoYearsPriorAmount());
			element.setFy2008(item.getPrevYearPriorAmount());
			element.setFy2009(item.getCurrentYearAmount());
			return element;
		case "2010":
			element.setFy2008(item.getTwoYearsPriorAmount());
			element.setFy2009(item.getPrevYearPriorAmount());
			element.setFy2010(item.getCurrentYearAmount());
			return element;
		case "2011":
			element.setFy2009(item.getTwoYearsPriorAmount());
			element.setFy2010(item.getPrevYearPriorAmount());
			element.setFy2011(item.getCurrentYearAmount());
			return element;
		case "2012":
			element.setFy2010(item.getTwoYearsPriorAmount());
			element.setFy2011(item.getPrevYearPriorAmount());
			element.setFy2012(item.getCurrentYearAmount());
			return element;
		case "2013":
			element.setFy2011(item.getTwoYearsPriorAmount());
			element.setFy2012(item.getPrevYearPriorAmount());
			element.setFy2013(item.getCurrentYearAmount());
			return element;
		case "2014":
			element.setFy2012(item.getTwoYearsPriorAmount());
			element.setFy2013(item.getPrevYearPriorAmount());
			element.setFy2014(item.getCurrentYearAmount());
			return element;
		case "2015":
			element.setFy2013(item.getTwoYearsPriorAmount());
			element.setFy2014(item.getPrevYearPriorAmount());
			element.setFy2015(item.getCurrentYearAmount());
			return element;
		case "2016":
			element.setFy2014(item.getTwoYearsPriorAmount());
			element.setFy2015(item.getPrevYearPriorAmount());
			element.setFy2016(item.getCurrentYearAmount());
			return element;
		case "2017":
			element.setFy2015(item.getTwoYearsPriorAmount());
			element.setFy2016(item.getPrevYearPriorAmount());
			element.setFy2017(item.getCurrentYearAmount());
			return element;
		default:
			throw new IllegalArgumentException("cannot determine fiscal year, failing");
			
			 * for when the R1_2018 comes out. will also need to update the
			 * table in the database case "2018":
			 * element.setFy2016(item.getTwoYearsPriorAmount());
			 * element.setFy2017(item.getPrevYearPriorAmount());
			 * element.setFy2018(item.getCurrentYearAmount()); return element;
			 

		}*/

	}

	/**
	 * Pull out the digits so we can use to determine what year each amount
	 * value references
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Extracts fiscal year from file name
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		Pattern pattern = Pattern.compile("[1-2][0-9]{3}");
		Matcher matcher = pattern.matcher(fileName);

		if (matcher.find()) {
			fiscalYear = matcher.group();
		}

	}

}
