# Web UI Automation Cucumber

## Description

This project is a Web UI Automation Testing Framework for the SauceDemo 
website using Java, Selenium WebDriver, Cucumber, Gherkin, JUnit, Gradle, 
and Page Object Model (POM).

The framework is designed to automate login functionality and validate 
both successful and unsuccessful login scenarios.

Target website:

https://www.saucedemo.com/

## Objective

The objectives of this project are:

* Build a structured Web UI Automation Testing Framework.
* Implement automated UI testing using Selenium WebDriver.
* Use Cucumber and Gherkin for behavior-driven test scenarios.
* Implement Page Object Model (POM) to separate test logic from page 
elements.
* Create positive, negative, and boundary test scenarios.
* Generate Cucumber HTML and JSON test reports.
* Use Gradle as the build and test automation tool.
* Organize the project into pages, steps, runners, utilities, and feature 
files.

## Technology Stack

* Java 17
* Selenium WebDriver 4.20.0
* Cucumber 7.18.0
* JUnit 5
* Gradle 9.3.0
* WebDriverManager 5.8.0
* Gherkin
* Page Object Model (POM)

## Project Structure

```text
web-ui-automation-cucumber/
├── build.gradle
├── settings.gradle
├── gradlew
├── gradlew.bat
├── README.md
└── src/
    └── test/
        ├── java/
        │   └── com/
        │       └── automation/
        │           ├── pages/
        │           │   ├── LoginPage.java
        │           │   └── InventoryPage.java
        │           ├── runners/
        │           │   └── TestRunner.java
        │           ├── steps/
        │           │   └── LoginSteps.java
        │           └── utils/
        │               └── DriverManager.java
        └── resources/
            └── features/
                └── login.feature
```

## Test Scenarios

The framework contains the following login scenarios:

1. Login with valid credentials
2. Login with invalid password
3. Login with empty username
4. Login with empty password
5. Login with locked out user

The scenarios cover positive, negative, and boundary test cases.

## Page Object Model

The project applies the Page Object Model pattern.

### LoginPage

`LoginPage.java` contains the elements and actions related to the 
SauceDemo login page, including:

* Username field
* Password field
* Login button
* Login error message

### InventoryPage

`InventoryPage.java` contains validation for the inventory page after 
successful login.

## Cucumber Feature

The test scenarios are written using Gherkin syntax in:

```text
src/test/resources/features/login.feature
```

Example:

```gherkin
Scenario: Login with valid credentials
  Given I am on the SauceDemo login page
  When I enter username "standard_user"
  And I enter password "secret_sauce"
  And I click the login button
  Then I should be successfully logged in
```

## Running the Tests

Run all tests using the Gradle Wrapper:

```bash
./gradlew clean test
```

A successful execution should display:

```text
BUILD SUCCESSFUL
```

## Test Reports

After running the tests, Cucumber generates reports in:

```text
build/reports/cucumber/
```

HTML report:

```text
build/reports/cucumber/cucumber.html
```

JSON report:

```text
build/reports/cucumber/cucumber.json
```

The HTML report can be opened in a browser to view the test execution 
results.

## Driver Management

The project uses WebDriverManager to automatically manage the ChromeDriver 
required by Selenium.

The WebDriver lifecycle is handled by:

```text
DriverManager.java
```

The browser is initialized before each scenario and closed after each 
scenario.

## Test Runner

Cucumber tests are executed through:

```text
TestRunner.java
```

The runner uses the JUnit Platform and generates both HTML and JSON 
Cucumber reports.

## Expected Result

All five login scenarios should pass successfully when the SauceDemo 
website is available and the test environment is configured correctly.

