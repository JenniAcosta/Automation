@authentication
Feature: Login's all good

  Rule: Customers needs to provide valid credentials to access the site
    @testLoginOK
    Example: Jennifer logs in with Jennifer's valid credentials
      Given Jennifer is on the login page
      When Jennifer logs in with valid credentials
      Then she should see their name logged "Jennifer" and the product catalog

    @testLoginError
    Scenario Outline: Login's with invalid credentials for <username>
      Given Jennifer is on the login page
      When Jennifer attempts to login with the following credentials:
        | username   | password   |
        | <username> | <password> |
      Then she should be presented with the error message <message>
      Examples:
        | username             | password       | message                              |
        | Jenniferac@gmail.com | pass123        | Your email or password is incorrect! |
        | wrong_user@gmail.com | wrong_password | Your email or password is incorrect! |