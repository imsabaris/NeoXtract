@execute
Feature: To Validate the Login module

  #TC_RTC_006
  Scenario Outline: Verify loginb page with valid credentials
    Given User must be in login page
    When User must enter valid "<username>" and "<password>"
    And User must click on submit button
    Then To Verify user redirected to neoxtract page

    Examples: 
      | username                 | password       |
      | kprashanth1822@gmail.com | Prashanth@1822 |

      # Prashanth@1823
      # neouser1@yopmail.com  ---> Neo@1234

      
      
      #//span[text()='cluster 1']/following::span[@title='Go to settings Workspace']