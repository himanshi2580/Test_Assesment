## Test_Assessment
1) GoogleTest- Please update username and password in Assessment1_gmail file line number 25

2) IRCTCTest

3) CustomerIOnTest

This detail everything required for rapid importing project, adding build path dependencies, setting up drivers, running UI tests & checking reports.


## Importing Project
1) Download Test_Assessment from GitHub.

2) Open Eclipse/IDE

3) Go to File -> Import

4) Select General -> Exisitng Projects into Workspace

5) Browse the Project

6) Click Finish


## How to add Dependencies
1) Go to pom.xml file and press Ctrl+S

## Drivers
- Please install chrome and firefox driver on your system for testing.

- WebDriverManager automatically updates the browser in the scripts

## Running UI Test

1) Expand Test_Assessment Folder

2) Go to src/test/java/testrunner/TestRunner.java

3) Open TestRunner.java

4) Right click on TestRunner.java, click on Run As and then click on JUnit Test

5) Test are ready to executing now.
## Reports
- Html reports is available in targert folder of Test_Assessment -> html:target/htmlReports.html"

- JSON report is available in targert folder of Test_Assessment -> "json:target/jsonReports.json"

- JUnit report is available in targert folder of Test_Assessment -> "junit:target/xmlReports.xml"

If unable to see the reports, please refresh the target folder.
