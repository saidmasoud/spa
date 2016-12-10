package com.mason.seor.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class FileListener implements StepExecutionListener{
	
	String fileName;

	@Override
	public void beforeStep(StepExecution stepExecution) {
		String[] split = fileName.split("/");
		System.out.println("Working on " + split[split.length-1]);
		
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		// do nothing
		return null;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
