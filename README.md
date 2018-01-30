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
*   Make sure your Server console at the bottom of the Eclipse IDE window shows your Apache Tomcat server, and
    then right-click it, and select the "Start" option. This should require a bit of loading time, but the server
    will be ready once it says "Synchronized" on the right side of it.
*   On the "Run" button at the top toolbar of the window, click on the dropdown arrow, and make sure to select
    the "JavaServer01" as the code to run. This should run an internal web browser from Eclipse, and the initial
    page for the web browser should be blank. The URL should show "http://localhost:8080/DPS909Release01/JavaServer01"
    if you've kept the same project folder and Java class names.
    
*   -----> Testing the GET functionality
    After completing the steps mentioned above, add a "?" followed by a string containing a phone number to the end 
    of the current URL. You should receive a parsed JSON response on the screen containing phone number(s) if it 
    found any. 
    NOTE: if the string you entered did not contain any phone numbers, the site will send back an HTTP500 error
          caused by unexpected input.
          
*   -----> Testing the POST functionality
    To test the post functionality, follow the initial steps mentioned above, and add "?" and the keyword
    "file" to the end of the current URL. This will tell the server to go look at the input file named "Base64.txt"
    inside the project's Java Resources -> src -> release01 folder. Any test input should be added onto the file 
    before running the project.
    NOTE: if you want to test multiple times, please restart the server and code to start from a fresh slate.
    
