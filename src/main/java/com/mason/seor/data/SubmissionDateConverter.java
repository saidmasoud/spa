package com.mason.seor.data;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang3.time.FastDateFormat;

//nested class to convert date field
	public class SubmissionDateConverter extends XmlAdapter<String, Date> {
		
		public SubmissionDateConverter() {}

		public Date unmarshal(String v) throws Exception {
			FastDateFormat dateFormat = FastDateFormat.getInstance("yyyy-MM");
			Date date = dateFormat.parse(v);
			return date;
		}

		public String marshal(Date v) throws Exception {
			return v.toString();
		}

	}