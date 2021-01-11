#Scenario     :  login in Gmail via stackoverflow
#Application  :  Gmail
Feature: Create and send letter

  Background:
    Given start browser "chrome" on node port 5556

  @ExampleScenario
  Scenario Outline: Login to gmail through a third-party service and sending a letter
    Given user want to Login to gmail through a third-party service
    Then user verify the "<title>" in the app
    When user enter the and Login to the app
    Given user wants to go to Gmail, enter: recipient, subject, number of letters from the user and send a letter
    Then user checks that there is an inscription "<title2>"



    Examples:
      | title                  |    title2              |
      | Вход – Google Аккаунты |   Письмо отправлено.   |
