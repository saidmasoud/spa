package com.mason.seor.tasklet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;

public class RunSqlTasklet implements Tasklet {
	
	DataSource dataSource;
	String sqlTemplate;
	String replace;
	List<String> years;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		for(String year:years){
			String sql = sqlTemplate.replace(replace, year);
			template.execute(sql);
		}
		return RepeatStatus.FINISHED;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setReplace(String replace) {
		this.replace = replace;
	}

	public void setSqlTemplate(String sqlTemplate) {
		this.sqlTemplate = sqlTemplate;
	}

	public void setYears(List<String> years) {
		this.years = years;
	}

}
