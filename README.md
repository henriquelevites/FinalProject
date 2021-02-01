# Full Stack Automation Final Project

## **_This project was created to demonstrate my knowledge and skills in Automation Testing._**

### **_About_**
The project demonstates a smart automation infrastructure. It is built in hierarchy order of modules. The modules contain number of classes with methods. There are main/common/helpers/actions/page_object modules. In this way, the tests can be created in very simple way with a minimum lines of code. Also the infrastructure allows to work with differend kinds of applications. Big advantage of the infrastructure is that it can be easy maintained!

### **_Project Overview_**
The project is an example of infrastructure for automation testing on different kinds of platforms:

- Web
- Mobile
- Rest API
- Electron
- Desktop

### **_Infrastructure project includes using of:_**

- Page Object Design Pattern
- Project Layers(Utilities/Extensions/Work Flows/Test Cases...)
- Support of Different Clients/Browsers
- Failure Mechanism
- Common Functionality
- External Files Support
- Reporting System (including screenshots)
- Visual Testing
- DB support
- CI support

### **_List of applications tested in this project:_**

- SwagLabs webpage (Web)
- ApiDemos (Mobile)
- Students List (API)
- ElectronApiDemos (Electron)
- Windows calculator (Desktop)

### **_Tools & Frameworks used in the project:_**

- TestNG - Testing Framework
- Listeners - interface used to generate logs and customize the TestNG reports
- MySQL Free Online DB - used for login to Grafana web page
- [Jenkins](https://www.jenkins.io/)- for tests execution
- REST Assured - for API testing
- [Allure](http://allure.qatools.ru/) Reports - as the main reporting system

### **Tests Execution:**

>Each of the applications has a few tests for demonstration purpose. These tests can be developed in a very simple way, due to a lot of work with the infrastructure. [Sanity Tests](https://github.com/henriquelevites/FullStackFinalProject/tree/main/src/test/java/sanity)

### **_Known Issues:_**

Sometimes can be conflicts with some dependencies the applications are using. 
For example, experitest libraries code and desktop application cannot run together. io.appium dependencies are used for desktop Windows tests, whereas io.appium and com.experitest dependencies cannot run together for mobile tests.
(io.appium dependencies should be marked with comments if you want to run Appium mobile tests). Hence, the project is for DEMO purpose only. In production it should be divided into several projects.
