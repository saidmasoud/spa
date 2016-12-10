# Budget Exhibit Analysis Tool (BEAT) Java/Spring Batch Application

----
## Foreword

This code was developed in conjunction with the BEAT project: a Masters capstone project undertaken for the George Mason University Systems Engineering and Operation Research Department for the Fall 2016 semester. For more information on the project, visit our [Wordpress](https://gmuseorspa.wordpress.com) site. I encourage you to visit the site and view our presentation (under the "Deliverables" tab) before reading the rest of this README.

Parts of the code have been intentionally been left out, such as the Excel template which was developed by [Chris Anderson](https://www.linkedin.com/in/chris-anderson-74164744) and is not my intellectual property.

----
## Background
The following Java/Spring project contains three Spring Batch jobs:

* spa___r1___data__load: Read an R-1 Excel file and write the data to a database.
* spa___r2___data__load: Read an R-2 XML file and write the data to a database.
* spa___excel___generator: Read the R-1 and R-2 data from the database and populate an Excel template.

The R-1 and R-2 data is unclassified and publicly available from [DTIC (Defense Technical Information Center)](https://www.dtic.mil)

----
## R-1 Data Load

This job reads in one or more R-1 Excel files and injects the data into a database. Historically speaking, the R-1 Excel files have not followed a standardized format. Therefore, some manual manipulation was required in order to be able to read the input data. The batch job has been set up to expect the following field/value associations:

Because the R-1 files have come in various formats throughout the years, it was necessary to "standardize" the columns so that boilerplate code did not have to be written for this job. That column standardization is as follows:

* Column C: Organization name
* Column E: Budget Activity
* Column F: Budget Activity Title
* Column G: Program Element
* Column H: Program Element Title
* Column J: Two Years’ Prior Budget Amount (e.x. for an R-1 from FY 2017 this column would contain FY 2015 data)
* Column K: Previous Year Budget Amount
* Column L: Current Year Budget Amount

The properties for this job are as follows:

* file.location: the directory of the R-1 documents to inject into the database
* file.names: if there are specific files you would like to inject, specify the file names here and separate them with commas. This will ignore the other files in the file.location directory

This job will filter out all PE’s that do not belong to DoD program 6 (RDT&E) or BA’s 2-4. Once the PE’s have been filtered, they are written to the database, and the financial data are written to the respective columns in the database.

----
## R-2 Data Load

This job reads in one or more R-2 XML files and injects them into the database. Since the R-2s follow a specific schema, there is no need to modify the files before running the job. The properties for this job are the same as for the R-1 job. This job will only read files in the specified directory that have an extension of “.xml” and will ignore others.

This job will filter out all PE’s that do not belong to DoD program 6 (RDT&E) or BA’s 2-4. Once the PE’s have been filtered, they are written to the database, and the financial data are written to the respective columns in the database.

----
## Excel Generator

This job reads all the data form the R-1 and R-2 tables within the database, and populates a pre-formatted Excel template file. The template will be copied into a specified location, and any template that already exists in the specified location with the same name will be deleted, so be careful when executing the job multiple times. Once the template has been created, two macros must be run within the Excel file itself before it is ready for use. Inside the project you will find a VBS script that will execute the two macros. The execution of the second macro fails with the script, therefore buttons have been created to execute the macros manually within the Excel file after opening it (more in the BEAT tool section). The code for executing the VBS script has been commented out in the “R2ExcelWriter.java” file in the case that the script may be of some use in the future.

The properties for this job are as follows:

* excel.template: location of the Excel template. This will be stored within the project’s directory and should not need to be changed
* excel.end.location: the target directory to copy the Excel template into. Note that this property also specifies the name of the file, so if a file with the same name already exists in that directory, it will be deleted
* vbs.script: location nof the VBS script
* vbs.end.location: target directory to copy the VBS script to, should be the same as the Excel target directory

----
## changelog
* 12/9/2016 Initial commit/Github publish

----
## Links
* [Sponsor: Systems Planning and Analysis](https://www.spa.com/about.aspx)

* [GMU SEOR department](http://seor.gmu.edu/)

* [Team SPA Site](https://gmuseorspa.wordpress.com)

----
## Notes

I will most likely not accept any PR requests, as the school project is over and am no longer working on the code. The purpose of this repo is to serve as a showcase for the work I performed on the project. However, feel free to clone the repo if you find any of the code useful!!!!!