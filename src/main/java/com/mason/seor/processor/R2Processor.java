package com.mason.seor.processor;

import static com.mason.seor.utils.DataUtils.isValidPe;

import java.lang.reflect.Field;
import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.batch.item.ItemProcessor;

import com.mason.seor.model.r2.ProgramElement;
import com.mason.seor.persistence.R2ProgramElement;

public class R2Processor implements ItemProcessor<ProgramElement, R2ProgramElement> {

	private static final String FISCAL_YEAR_PREFIX = "fy";

	/** 
	 * Use Reflection to dynamically set the fields in the persistence object
	 */
	@Override
	public R2ProgramElement process(ProgramElement item) throws Exception {
		
		if(item.getProgramElementNumber()==null){
			return null;
		}

		R2ProgramElement element = new R2ProgramElement();
		Integer integ = item.getBudgetYear();
		Double year = item.getBudgetYear().doubleValue();
		FastDateFormat dateFormat = FastDateFormat.getInstance("yyyy-MM");
		Date submissionDate = dateFormat.parse(item.getSubmissionDate());
		
		if(!isValidPe(item)){
			return null;
		}
		
		element.setPe(item.getProgramElementNumber());
		element.setPeTitle(item.getProgramElementTitle());
		element.setBudgetYear(item.getBudgetYear());
		element.setBudgetCycle(item.getBudgetCycle());
		element.setSubmissionDate(submissionDate);
		element.setServiceAgencyName(item.getServiceAgencyName());
		element.setAppropriationCode(Integer.valueOf(item.getAppropriationCode()));
		element.setAppropriationName(item.getAppropriationName());
		element.setBa(Integer.valueOf(item.getProgramElementNumber().substring(2, 4)));
		element.setBaTitle(item.getBudgetActivityTitle());
		
		
		// previous year
		Field previousYear = element.getClass().getDeclaredField(FISCAL_YEAR_PREFIX + Double.toString((year - 1)).replaceFirst("\\.0", ""));
		previousYear.set(element, item.getProgramElementFunding().getPriorYear());

		// current year
		Field currentYear = element.getClass().getDeclaredField(FISCAL_YEAR_PREFIX + Double.toString((year)).replaceFirst("\\.0", ""));
		currentYear.set(element, item.getProgramElementFunding().getCurrentYear());

		// budget year one
		Field budgetYearOne = element.getClass().getDeclaredField(FISCAL_YEAR_PREFIX + Double.toString((year+1)).replaceFirst("\\.0", ""));
		budgetYearOne.set(element, item.getProgramElementFunding().getBudgetYearOne());

		// budget year two
		Field budgetYearTwo = element.getClass().getDeclaredField(FISCAL_YEAR_PREFIX + Double.toString((year+2)).replaceFirst("\\.0", ""));
		budgetYearTwo.set(element, item.getProgramElementFunding().getBudgetYearTwo());
		
		// budget year three
		Field budgetYearThree = element.getClass().getDeclaredField(FISCAL_YEAR_PREFIX + Double.toString((year+3)).replaceFirst("\\.0", ""));
		budgetYearThree.set(element, item.getProgramElementFunding().getBudgetYearThree());
		
		// budget year four
		Field budgetYearFour = element.getClass().getDeclaredField(FISCAL_YEAR_PREFIX + Double.toString((year+4)).replaceFirst("\\.0", ""));
		budgetYearFour.set(element, item.getProgramElementFunding().getBudgetYearFour());
		
		// budget year four
		Field budgetYearFive = element.getClass().getDeclaredField(FISCAL_YEAR_PREFIX + Double.toString((year+5)).replaceFirst("\\.0", ""));
		budgetYearFive.set(element, item.getProgramElementFunding().getBudgetYearFive());
		return element;
	}

}
