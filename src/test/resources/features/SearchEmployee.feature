Feature: Searching the employee
  Background:
    When user enters valid "admin" and valid "Hum@nhrm123"
    And click on login button
    When user clicks on PIM option

  @empID
  Scenario: Search Employee by Id
    When user enters valid employee Id
    And clicks on search button
    And user sees employee information displayed


  Scenario: Search Employee by Job Title
    When user selects job title
    And clicks on search button
    And user sees employee information displayed