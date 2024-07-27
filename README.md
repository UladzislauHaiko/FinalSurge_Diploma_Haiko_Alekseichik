# Test Automation Project

<a href="https://log.finalsurge.com/">    
<img src="https://finalsurgelivestore.blob.core.windows.net/branding/finalsurge_logo.png" align="right" height="150" />
</a>

### **Overview**

Final Surge is the training and coaching platform that empowers athletes and coaches to reach fitness and performance
excellence like never before.
Final Surge has all of the features you need to track and analyze your training, from communicating with coaches and
planning future workouts
to importing workout and GPS data from your fitness devices.

### **Project Description**

This code represents a set of tests for automated testing of an application using Selenium and TestNG. It describes
various test scenarios for verifying the functionality of the application, such as logging in, creating and editing
workouts, creating equipment, uploading files and etc.

#

### **Clone the repository into your projects directory:**

https://github.com/UladzislauHaiko/FinalSurge_Diploma_Haiko_Alekseichik.git

### Installation:

* IDE: IntelliJ
* Programming Language: JAVA
* Project Type: Maven

### Stack:

* Selenium [4.19.1]
* TestNG [7.10.1]
* JavaFaker [1.0.2]
* Lombok [1.18.34]
* Log4j [2.23.1]
* Jackson [2.12.3]

### Patterns used:

* Page Object
* Element Decorators (Wrappers)
* Value Object
* Builder
* Loadable Page
* Enums

### Reporting:

* Allure reporting

### Global Usage:

* GitHub

#

### Checklist:

#### Login

* Verify successful login with valid credentials.
* Verify unsuccessful login with empty email.
* Verify unsuccessful login with empty password.
* Verify unsuccessful login with incorrect data.

#### Equipment

* Verify successful creation of running shoes with valid data.
* Verify unsuccessful creation of running shoes with invalid data.
* Verify successful deletion of running shoes.

#### Workouts

* Verify successful workout creation with valid data.
* Verify unsuccessful workout creation with invalid data.

#### Calendar

* Verify workout report is generated when selecting valid dates.
* Verify empty report is generated when selecting dates without workouts.
* Verify validation is displayed when selecting invalid dates.

#### File Upload

* Verify successful file upload with valid data.
* Verify unsuccessful file upload with invalid extension.

#

> [!NOTE]
> #### Instructions for running of tests:
>1. Open resources directory
>2. Open config.properties file
>3. Change base_url
>4. Change email
>5. Change password
> #### TestNG command for running all tests and getting report:
>-mvn clean test
>
>-allure generate target/allure-results
>
>-allure serve target/allure-results

###### By Uladzislau Haiko 👩🏽‍💻
























