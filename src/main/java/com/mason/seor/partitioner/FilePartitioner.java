package com.mason.seor.partitioner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

public class FilePartitioner implements Partitioner {

	String fileLocationsProp;
	String fileNamesProp;
	String extension;

	@Override
	public Map<String, ExecutionContext> partition(int arg0){

		Map<String, ExecutionContext> partitionMap = new HashMap<>();
		String[] fileNames;
		if (fileNamesProp == null) {
			File filesDir = new File(fileLocationsProp.replace("file:", ""));
			if (!filesDir.isDirectory()) {
				throw new IllegalStateException(fileLocationsProp + " is not a directory!!!!!!!");
			}
			
			// create new filename filter
	         FilenameFilter fileNameFilter = new FilenameFilter() {
	   
	            @Override
	            public boolean accept(File dir, String name) {
	               if(name.lastIndexOf('.')>0)
	               {
	                  // get last index for '.' char
	                  int lastIndex = name.lastIndexOf('.');
	                  
	                  // get extension
	                  String str = name.substring(lastIndex);
	                  
	                  // match path name extension
	                  if(str.equals(extension))
	                  {
	                     return true;
	                  }
	               }
	               return false;
	            }
	         };
			
			fileNames = filesDir.list(fileNameFilter);
		} else {
			fileNames = fileNamesProp.split(",");
		}
		int counter = 0;

		for (String fileName : fileNames) {
			
			//trimXmlTags(fileLocationsProp,fileName);

			ExecutionContext context = new ExecutionContext();
			context.put("file.location", fileLocationsProp + fileName);
			context.put("file.name", fileName);
			counter++;
			partitionMap.put("file" + counter, context);
		}

		return partitionMap;
	}
	
	private void trimXmlTags(String fileLocation, String fileName){
			File xml = new File(fileLocation.replace("file:", "")+fileName);
			String charset = "UTF-8";
			// need to get rid of these prefixes for the XML tags and attributes
			String[] delete = {"r2:",":r2"};
			String[] replace = {"",""};
			// we don't need these lines
			String throwOut = "jb:";
			try {
				File temp = File.createTempFile("temp", ".xml", xml.getParentFile());
				
				//open file for reading
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(xml), charset));
				//open temp file for writing
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp), charset));
				
				for (String line; (line = reader.readLine()) != null;) {
					line = StringUtils.replaceEach(line, delete, replace);
					if(!line.contains(throwOut)){
						writer.println(line);
					}
				}
				
				reader.close();
				writer.close();
				
				xml.delete();
				temp.renameTo(xml);
				
				
			} catch (IOException e) {
				System.out.println("file location not found: "+xml.getParentFile());
				System.exit(1);
			}
	}

	public void setFileLocationsProp(String fileLocationsProp) {
		this.fileLocationsProp = fileLocationsProp;
	}

	public void setFileNamesProp(String fileNamesProp) {
		this.fileNamesProp = fileNamesProp;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

}
