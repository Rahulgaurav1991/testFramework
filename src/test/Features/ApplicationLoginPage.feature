Feature: 'ApplicationLogin Page Testing

  Background: Navigate to
    Given user Navigate to 'Application Login Page'
    Then user verify 'Application Login Page:Logo' is displayed

  Scenario: with valid User
    When user enters 'Application Login Page:UserName'
    Then user enters 'Application Login Page:Password'
    And user clicks 'Application Login Page:Submit Button'
    And user verify 'Application Login Page:Login Successfully'

  @Demo
  Scenario Outline: with Invalid User
    When user enters '<USER_NAME>' in Application Login Page:UserName'
    Then user enters '<PASSWORD>'in Application Login Page:Password'
    And user clicks 'Application Login Page:Submit Button'
    Then user verify 'Application Login Page:Error message' equals 'Invalid login credentials'
    And user verify 'Application Login Page:Home Page' is not displayed'
    Examples:
      | USER_NAME | PASSWORD  |
      | ABC       | July@2022 |
      | ABC       | july@2022 |
      | Xyz@123   | July@2022 |
      | rahul     | @abc2022  |


  Scenario: With Blank User And Password
    When user enters '' in Application Login Page:UserName'
    Then user verify 'Application Login Page:Username' error message 'equals 'Please enters your user name'
    When user enters '' in Application Login Page:UserName'
    Then user verify 'Application Login Page:Password' error message 'equals 'Please enters your password'
    And user verify 'Application Login Page:Login Button' is disabled

  Scenario Outline: Forgot Password with invalid emails
    When user clicks 'Application Login Page:Forgot Link '
    Then user navigate to 'Application Forgot Password Page'
    And user enters '<EMAIL_ID>'in Application:Forgot Password Page email id'
    And  user clicks 'Application Forgot Password Page:Reset Password Button'
    Then user verify 'Application Forgot Password Page:Forgot Password' error message 'equals 'No account with this email address exists.'

    Examples:
      | EMAIL_ID           |
      | ABC                |
      | Abc.1234@gmail.com |
      | 123.zxc@gmail.com  |



