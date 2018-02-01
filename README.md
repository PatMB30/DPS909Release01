Build status of the latest master branch:
![Status](https://travis-ci.org/PatMB30/DPS909Release01.svg?branch=master)

# DPS909Release01: What is it?
As part of the DPS909 Release 0.1 project, this project is a simple Java Webserver following the RESTful API,
using Google's libphonenumber library to retrieve phone numbers in one of two ways;
* via GET request to the server by appending a parameter after the URL
* via POST request to the server by appending "file" to the end of the URL

# Functionality

*   Retrieves phone numbers from a string entered as a URL parameter via GET request
*   Retrieves phone numbers from a text file within the project directory via POST request

# Installation
*   To test the program, you must have a working Eclipse Software IDE. The one I used is Eclipse IDE for Java EE
    developers, oxygen 2 version.
*   From there, you must open the project onto Eclipse by going to File -> Open Projects From File System...
*   On the right side of the "Import source: " field, click the "Directory..." button to browse where the project
    folder is located on your computer.
    
# Examples & How To Run
*   Before running the project, we need to set up the server by using Apache Tomcat. Follow this link: 
    http://www.codejava.net/ides/eclipse/how-to-create-deploy-and-run-java-servlet-in-eclipse and scroll down to Step
    number 3 called "Deploy the Servlet". After that, follow the steps but select Apache Tomcat Server 9.0 instead of 
    7.0 whenever possible. After selecting "Apache Tomcat version 9.0" on the window, if Eclipse mentions "Unknown
    version of Tomcat was specified", download the library using this link: https://tomcat.apache.org/download-90.cgi
    and download either 32-bit or 64-bit Windows zip file. After that, redirect the Tomcat installation directory to
    where your downloaded library is by clicking the "Browse..." button on the right side of the Tomcat installation
    directory field. It should now allow you to click the finish button at the bottom right of the window.
*   Make sure your Server console at the bottom of the Eclipse IDE window shows your Apache Tomcat server, and
    then right-click it, and select the "Start" option. This should require a bit of loading time, but the server
    will be ready once it says "Synchronized" on the right side of it.
*   On the "Run" button at the top toolbar of the window, click on the dropdown arrow, and make sure to select
    the "JavaServer01" as the code to run. If it does not appear in the dropdown list, open the source document in the
    project explorer and find the JavaServer01.java file. Run the code while having this class opened in the editor.
    If this is your first time running it, it will ask you to select a server. Clicking finish should be fine here.
    After this, try running the code from the JavaServer01 class again and it should work. This should run an internal 
    web browser from Eclipse, and the initial page for the web browser should be blank. The URL should show
    "http://localhost:8080/DPS909Release01/JavaServer01" if you've kept the same project folder and Java class names.
    
*   -----> Testing the GET functionality.
    After completing the steps mentioned above, add a "?" followed by a string containing a phone number to the end 
    of the current URL. You should receive a parsed JSON response on the screen containing phone number(s) if it 
    found any. 
    NOTE: if the string you entered did not contain any phone numbers, the site will send back an HTTP500 error
          caused by unexpected input.
          
*   -----> Testing the POST functionality.
    To test the post functionality, follow the initial steps mentioned above, and add "?" and the keyword
    "file" to the end of the current URL. This will tell the server to go look at the input file named "Base64.txt"
    inside the project's Java Resources -> src -> release01 folder. Any test input should be added onto the file 
    before running the project.
    NOTE: if you want to test multiple times, please restart the server and code to start from a fresh slate.
    
