@execute
Feature: To Validate the Billing
  When User closes the browser

  #TC_RTC_007
  Scenario Outline: Verifying the Add Workspace functionality from Subscription page of admin panel.
    #When User must enter valid "<username>" and "<password>"
    #And user must click on submit button
    And select admin panel
    And click on workspace setup tab on header
    When click on Add workspace button
    And Selects the individual monthly plan
    When user must make payment with valid card "<Card number>","<expiry date>","<cvc>","<zip>"
    Then verify the last workspace added

    Examples: 
      | username                 | password       | Card number      | expiry date | cvc | zip   |
      | kprashanth1822@gmail.com | Prashanth@1822 | 4242424242424242 | 02/28       | 123 | 12345 |

  @Reset_password @close
  Scenario Outline: Verify Password Reset functionality from user set up of Admin Panel
    Given User must be in login page
    When User must enter valid "<username>" and "<password>"
    And User must click on submit button
    When User clicks the change password icon in the admin panel
    When User enters the existing and new password "<password>" "<new_password>"
    When User clicks the logout
    When User must enter valid "<username>" and "<new_password>"
    And User must click on submit button
    And User validates the username "<username>"

    Examples: 
      | username                 | password       | new_password   |
      | kprashanth1822@gmail.com | Prashanth@1823 | Prashanth@1822 |

  @Add_workspace_Billing @close
  Scenario Outline: Verify Password Reset functionality from user set up of Admin Panel
    Given User must be in login page
    When User must enter valid "<username>" and "<password>"
    And User must click on submit button
    And select admin panel
    When User selects the subscription from Billing
    #----- This can be used for add workspace in the Billing Subscription----
    And click on workspace setup tab on header
    When User clicks the add workspace from the subscription of the Billing header
    And Selects the individual monthly plan
    When user must make payment with valid card "<Card number>","<expiry date>","<cvc>","<zip>"
    When User selects the subscription from Billing
    Then verify the last workspace added for Billing Subscriptions

    Examples: 
      | username                 | password       | Card number      | expiry date | cvc | zip   |
      | kprashanth1822@gmail.com | Prashanth@1822 | 4242424242424242 | 02/28       | 123 | 12345 |

  @add_cluster_team+ @close
  Scenario Outline: Add clusters for Team+ in Admin panel
    Given User must be in login page
    When User must enter valid "<username>" and "<password>"
    And User must click on submit button
    And select admin panel
    And click on workspace setup tab on header
    When User click the Team+ icon in the workspace setup
    When User clicks the edit icon in the Team+
    When User deletes the existing clusters and add three new clusters
      | cluster 1 | cluster 2 | cluster 3 |

    Examples: 
      | username                 | password       |
      | kprashanth1822@gmail.com | Prashanth@1822 |

  @Add_fields_Team+ @close
  Scenario Outline: Add 15 fields for clusters for Team+ in Admin panel
    Given User must be in login page
    When User must enter valid "<username>" and "<password>"
    And User must click on submit button
    And select admin panel
    And click on workspace setup tab on header
    When User click the Team plus icon in the workspace setup
    When User clicks the edit icon in the Team plus
    When User deletes the existing clusters and add three new clusters
      | cluster 1 | cluster 2 | cluster 3 |
    When User clicks the gear icon in the cluster to add fields "<clusterName>"
    When User clicks adds the fied in the cluster
      | Field 1 | Field 2 | Field 3 | Field 4 | Field 5 | Field 6 | Field 7 | Field 8 | Field 9 | Field 10 | Field 11 | Field 12 | Field 13 | Field 14 | Field 15 |
    When user validates the add field after adding 15 fields

    Examples: 
      | username                 | password       | clusterName |
      | kprashanth1822@gmail.com | Prashanth@1822 | cluster 1   |

  @Add_fields_Team_WS_setUp
  Scenario Outline: Add 15 fields for Team in Workspace setup in Admin panel
    Given User must be in login page
    When User must enter valid "<username>" and "<password>"
    And User must click on submit button
    And select admin panel
    And click on workspace setup tab on header
    When User click the Team icon in the workspace setup
    When User clicks the edit icon in the Team plus
    #When User deletes the existing clusters and add three new clusters
    #| cluster 1 | cluster 2 | cluster 3 |
    #When User clicks the gear icon in the cluster to add fields "<clusterName>"
    When User clicks adds the fied in the cluster
      | Field 1 | Field 2 | Field 3 | Field 4 | Field 5 | Field 6 | Field 7 | Field 8 | Field 9 | Field 10 | Field 11 | Field 12 | Field 13 | Field 14 | Field 15 |
    When user validates the add field after adding all fields

    Examples: 
      | username                 | password       | clusterName |
      | kprashanth1822@gmail.com | Prashanth@1822 | cluster 1   |

  @User_Assignment_Team
  Scenario Outline: Add 3 users in the user assignment in Team in workspace header
    Given User must be in login page
    When User must enter valid "<username>" and "<password>"
    And User must click on submit button
    And select admin panel
    And click on workspace setup tab on header
    When User click the Team icon in the workspace setup
    When User clicks the edit icon in the Team plus
    When User deletes and selects the users from the user assignment
      | Prasanth Kumar (kprashanth1822@gmail.com) | arun (sbsdjv@gmail.com) | kumar (jhjcjhsnn@hgsdj.com) |
    When user validates the user assign field after adding three fields

    Examples: 
      | username                 | password       | clusterName |
      | kprashanth1822@gmail.com | Prashanth@1822 | cluster 1   |

  @TestCase_17&19
  Scenario Outline: Verifying the Add Workspace functionality from Subscription page of admin panel.
    Given User must be in login page
    When User must enter valid "<username>" and "<password>"
    And User must click on submit button
    Then To Verify user redirected to neoxtract page
    And select admin panel
    And click on workspace setup tab on header
    When click on Add workspace button
    And Selects the individual monthly plan
    When user must make payment with valid card "<Card number>","<expiry date>","<cvc>","<zip>"
    Then verify the last workspace added
    When User clicks the edit icon of last workspace created
    When User edits the name of the workspace "<WorkSpace>"
    When User clicks the Activate in the workspace
    When User checks for the alert for the unassigned user
    When User clicks adds the fied in the cluster
      | Field 1 | Field 2 |
    When User clicks the Activate in the workspace
    When User checks the checkbox in the alert and clicks activate
    And user validates the active status
    #When User clicks the edit icon for the workspace "<WorkSpace>"
    When User edits the activated field
    When User deletes the activated field

    Examples: 
      | username                 | password       | Card number      | expiry date | cvc | zip   | WorkSpace          |
      | kprashanth1822@gmail.com | Prashanth@1822 | 4242424242424242 | 02/28       | 123 | 12345 | WorkSpace_28_01_23 |

  @TestCase_18&20
  Scenario Outline: Verifying the Add Workspace functionality from Subscription page of admin panel.
    Given User must be in login page
    When User must enter valid "<username>" and "<password>"
    And User must click on submit button
    Then To Verify user redirected to neoxtract page
    And select admin panel
    And click on workspace setup tab on header
    When click on Add workspace button
    And Selects the monthly team plus plan
    When user must make payment with valid card "<Card number>","<expiry date>","<cvc>","<zip>"
    Then verify the last workspace added
    When User clicks the edit icon of last workspace created
    #When User edits the name of the workspace "<WorkSpace>"
    When User clicks the edit icon for the workspace "<WorkSpace>"
    When User deletes the existing clusters and add three new clusters
      | cluster 1 | cluster 2 | cluster 3 |
    When User clicks the gear icon in the cluster to add fields "<clusterName>"
    When User clicks the Activate in the workspace
    When User checks for the alert for the unassigned user
    When User clicks adds the fied in the cluster
      | Field 1 | Field 2 |
    When User clicks the Activate in the workspace
    When User checks the checkbox in the alert and clicks activate
    And user validates the active status
    When User edits the activated field
    When User deletes the activated field

    Examples: 
      | username                 | password       | Card number      | expiry date | cvc | zip   | WorkSpace             | clusterName |
      | kprashanth1822@gmail.com | Prashanth@1822 | 4242424242424242 | 02/28       | 123 | 12345 | WorkSpace_Team_plus_1 | cluster 1   |

  @TestCase_21
  Scenario Outline: Verifying the Add Workspace functionality from Subscription page of admin panel.
    Given User must be in login page
    When User must enter valid "<username>" and "<password>"
    And User must click on submit button
    Then To Verify user redirected to neoxtract page
    And select admin panel
    And click on workspace setup tab on header
    When click on Add workspace button
    And Selects the individual monthly plan
    When user must make payment with valid card "<Card number>","<expiry date>","<cvc>","<zip>"
    Then verify the last workspace added
    When User clicks the edit icon of last workspace created
    When User edits the name of the workspace "<WorkSpace>"
    When User clicks the Activate in the workspace
    When User checks for the alert for the unassigned user
    When User clicks adds the fied in the cluster
      | Field 1 | Field 2 |
    When User clicks the Activate in the workspace
    When User checks the checkbox in the alert and clicks activate
    And user validates the active status
    #When User clicks the edit icon for the workspace "<WorkSpace>"
    When User edits the activated field
    When User deletes the activated field
    When User clicks the add template icon
    When user saves the template name and description "<templateName>" "<templateDescription>"
    When User clicks the build template
    When User clicks the edit icon on the corresponding column of the template
    When User clicks the add segment icon
    When User selects the transformation and extraction field
      #| Bookmark | Field 1 |                    |
      | Currency | Field 1 | Currency Code(USD) |
    When User clicks the create icon

    Examples: 
      | username                 | password       | Card number      | expiry date | cvc | zip   | WorkSpace          | templateName  | templateDescription |
      | kprashanth1822@gmail.com | Prashanth@1822 | 4242424242424242 | 02/28       | 123 | 12345 | WorkSpace_28_01_23 | Template Book | Bookmark            |

  @TestCase_22_23_24
  Scenario Outline: Verifying the Add Workspace functionality from Subscription page of admin panel.
    Given User must be in login page
    When User must enter valid "<username>" and "<password>"
    And User must click on submit button
    Then To Verify user redirected to neoxtract page
    And select admin panel
    When User clicks the user setup on header of the dashboard
    When User clicks the create new user icon
    When User enters the name,email and employee id "<name>" "<email>" "<employee_id>"
    When User selects the active or Inactive state "<state>"
    When User clicks the save button
    #When User validates the created user setup "<name>" "<email>" "<employee_id>" "<state>"
    When User clicks the edit button "<email>"
    When User edits the user name and employee id of the user setup "<nameEdit>" "<employeeIdEdit>"
    When User selects the active or Inactive state "Inactive"
    When User clicks the save button
    When User clicks the checkbox to make the user active "<email>"

    #When User clicks the checkbox to make the user inactive "<email>"
    Examples: 
      | username                 | password       | name     | email                | employee_id | state  | nameEdit | employeeIdEdit |
      | kprashanth1822@gmail.com | Prashanth@1822 | NeoUser8 | neouser8@yopmail.com | user008     | Active | NeoEdit8 | UserEdit008    |

  @TestCase_25
  Scenario Outline: Checking the Invoice of the last created user
    Given User must be in login page
    When User must enter valid "<username>" and "<password>"
    And User must click on submit button
    Then To Verify user redirected to neoxtract page
    And select admin panel
    When User clicks the invoice in the billing
    #When User gets the invoice count before billing
    And click on workspace setup tab on header
    When click on Add workspace button
    And Selects the individual monthly plan
    When user must make payment with valid card "<Card number>","<expiry date>","<cvc>","<zip>"
    Then verify the last workspace added
    When User clicks the invoice in the billing

    #When User validates the invoice after billing
    Examples: 
      | username                 | password       | Card number      | expiry date | cvc | zip   |
      | kprashanth1822@gmail.com | Prashanth@1822 | 4242424242424242 | 02/28       | 123 | 12345 |

  @TestCase_26_29
  Scenario Outline: Verifying the Add Workspace functionality from Subscription page of admin panel.
    Given User must be in login page
    When User must enter valid "<username>" and "<password>"
    And User must click on submit button
    Then To Verify user redirected to neoxtract page
    And select admin panel
    And click on workspace setup tab on header
    When click on Add workspace button
    And Selects the individual monthly plan
    When user must make payment with valid card "<Card number>","<expiry date>","<cvc>","<zip>"
    Then verify the last workspace added
    When User selects the subscription from Billing
    When User clicks the dropdown of the workspace in the subscription
    When User upgrades the subscription plan "<subscription>"
    When User clicks update and confirm the subscription
    When user clicks the go back after subscription
    When User upgrades the cycle of the subscription "<cycle>"
    When User clicks update and confirm the subscription
    When user clicks the go back after subscription
    When User clicks the invoice in the billing

    Examples: 
      | username                 | password       | Card number      | expiry date | cvc | zip   | subscription | cycle  |
      | kprashanth1822@gmail.com | Prashanth@1822 | 4242424242424242 | 02/28       | 123 | 12345 | Team+        | Yearly |

  @TestCase_30
  Scenario Outline: Verifying the Add Workspace functionality from Subscription page of admin panel.
    Given User must be in login page
    When User must enter valid "<username>" and "<password>"
    And User must click on submit button
    Then To Verify user redirected to neoxtract page
    And select admin panel
    And click on workspace setup tab on header
    When click on Add workspace button
    And Selects the individual monthly plan
    When user must make payment with valid card "<Card number>","<expiry date>","<cvc>","<zip>"
    Then verify the last workspace added
    When User selects the subscription from Billing
    When User clicks the dropdown of the workspace in the subscription
    When User clicks the cancel after clicks the product dropdown in subscription

    Examples: 
      | username                 | password       | Card number      | expiry date | cvc | zip   | subscription | cycle  |
      | kprashanth1822@gmail.com | Prashanth@1822 | 4242424242424242 | 02/28       | 123 | 12345 | Team+        | Yearly |

  @TestCase_36
  Scenario Outline: Verifying the Add Workspace functionality from Subscription page of admin panel.
    Given User must be in login page
    When User must enter valid "<username>" and "<password>"
    And User must click on submit button
    Then To Verify user redirected to neoxtract page
    And select admin panel
    When User clicks the documents from operatios on header
    When User clicks upload button in the documents
    When User uploads the file in the documents"<fileName>"
    When User enters the country,publish year,language,document type and publisher name "<country>" "<publishYear>" "<language>" "<documentType>" "<publisherName>"
    When User clicks upload and close

    Examples: 
      | username                 | password       | Card number      | expiry date | cvc | zip   | subscription | cycle  | fileName                 | country     | publishYear | language     | documentType | publisherName |
      | kprashanth1822@gmail.com | Prashanth@1822 | 4242424242424242 | 02/28       | 123 | 12345 | Team+        | Yearly | Untitled_spreadsheet.pdf | India (IND) |        2023 | English (En) | pdf          | Admin         |

  @TestCase_37
  Scenario Outline: Verifying the Add Workspace functionality from Subscription page of admin panel.
    Given User must be in login page
    When User must enter valid "<username>" and "<password>"
    And User must click on submit button
    Then To Verify user redirected to neoxtract page
    When User selects the workspace from the dropdown in extraction homepage "<workSpace>"
    #When User Uploads the file "<fileName>"
    When User clicks upload button in the extraction page
    When User uploads the file in the extraction page"<fileName>"
    #When User enters the country,publish year,language,document type and publisher name "<country>" "<publishYear>" "<language>" "<documentType>" "<publisherName>"
    When User clicks upload and close

    #And select admin panel
    #When User clicks the documents from operatios on header
    #When User clicks upload and uploads the file
    Examples: 
      | username                 | password       | Card number      | expiry date | cvc | zip   | subscription | cycle  | workSpace    | fileName                 | country     | publishYear | language     | documentType | publisherName |
      | kprashanth1822@gmail.com | Prashanth@1822 | 4242424242424242 | 02/28       | 123 | 12345 | Team+        | Yearly | workspace_01 | Untitled_spreadsheet.pdf | IND (India) |        2023 | En (English) | pdf          | Admin         |

  @TestCase_38
  Scenario Outline: documnet validation for assigned user created in Team+ for corresponding user and validate in corresponding user
    Given User must be in login page
    When User must enter valid "<username>" and "<password>"
    And User must click on submit button
    And select admin panel
    And click on workspace setup tab on header
    When click on Add workspace button
    And Selects the monthly team plus plan
    When user must make payment with valid card "<Card number>","<expiry date>","<cvc>","<zip>"
    Then verify the last workspace added
    When User click the Team plus icon in the workspace setup
    When User clicks the edit icon in the Team plus
    When User edits the name of the workspace "<WorkSpace>"
    When User deletes the existing clusters and add three new clusters
      | cluster 1 |
    When User clicks the gear icon in the cluster to add fields "<clusterName>"
    When User clicks adds the fied in the cluster
      | Field 1 | Field 2 |
    When User clicks the Activate in the workspace
    When User checks the checkbox in the alert and clicks activate
    And User clicks back to container workspace
    #When user validates the add field after adding 15 fields
    #When User clicks the edit icon in the Team plus
    When User deletes and selects the users from the user assignment
      | NeoEdit7 (neouser7@yopmail.com) | NeoEdit8 (neouser8@yopmail.com) | Prasanth Kumar (kprashanth1822@gmail.com) |
    When User clicks the Activate in the workspace
    When User checks the checkbox in the alert and clicks activate
    And user validates the active status
    And User switches to tab
    When User selects the workspace from the dropdown in extraction homepage "<WorkSpace>"
    When User clicks upload button in the extraction page
    When User uploads the file in the extraction page"<fileName>"
    #When User enters the country,publish year,language,document type and publisher name "<country>" "<publishYear>" "<language>" "<documentType>" "<publisherName>"
    When User clicks upload and close
    When User clicks the logout
    When User must enter valid "neouser7@yopmail.com" and "Neouser7"
    And User must click on submit button
    And User validates the username "neouser7@yopmail.com"
    When User selects the workspace from the dropdown in extraction homepage "<WorkSpace>"
    When User clicks the assigned and extraction
    When User selects the file "<fileName>"
    When User locks the file and validates it "<fileName>"
    When User selects the file "<fileName>"
    When User unlocks the file and validates it "<fileName>"

    #When user validates the user assign field after adding three fields
    Examples: 
      | username                 | password       | Card number      | expiry date | cvc | zip   | clusterName | WorkSpace     | fileName                 |
      | kprashanth1822@gmail.com | Prashanth@1822 | 4242424242424242 | 02/28       | 123 | 12345 | cluster 1   | WS_TeamPlus_1 | Untitled_spreadsheet.pdf |

  @TestCase_39_40
  Scenario Outline: documnet validation for assigned user created in Team+ for corresponding user and validate in corresponding user
    Given User must be in login page
    #When User must enter valid "<username>" and "<password>"
    #And User must click on submit button
    #And select admin panel
    #And click on workspace setup tab on header
    #When click on Add workspace button
    #And Selects the monthly team plus plan
    #When user must make payment with valid card "<Card number>","<expiry date>","<cvc>","<zip>"
    #Then verify the last workspace added
    #When User click the Team plus icon in the workspace setup
    #When User clicks the edit icon in the Team plus
    #When User edits the name of the workspace "<WorkSpace>"
    #When User deletes the existing clusters and add three new clusters
    #| cluster 1 |
    #When User clicks the gear icon in the cluster to add fields "<clusterName>"
    #When User clicks adds the fied in the cluster
    #| Field 1 | Field 2 |
    #When User clicks the Activate in the workspace
    #When User checks the checkbox in the alert and clicks activate
    #
    #And User clicks back to container workspace
    #When user validates the add field after adding 15 fields
    #When User clicks the edit icon in the Team plus
    #When User deletes and selects the users from the user assignment
    #| NeoEdit7 (neouser7@yopmail.com) | NeoEdit8 (neouser8@yopmail.com) |Prasanth Kumar (kprashanth1822@gmail.com)|
    #When User clicks the Activate in the workspace
    #When User checks the checkbox in the alert and clicks activate
    #And user validates the active status
    #And User switches to tab
    #When User selects the workspace from the dropdown in extraction homepage "<WorkSpace>"
    #When User clicks upload button in the extraction page
    #When User uploads the file in the extraction page"<fileName>"
    #When User enters the country,publish year,language,document type and publisher name "<country>" "<publishYear>" "<language>" "<documentType>" "<publisherName>"
    #When User clicks upload and close
    #When User clicks the logout
    When User must enter valid "neouser7@yopmail.com" and "Neouser7"
    And User must click on submit button
    And User validates the username "neouser7@yopmail.com"
    When User selects the workspace from the dropdown in extraction homepage "<WorkSpace>"
    When User clicks the assigned and extraction
    When User selects the file "<fileName>"
    When User locks the file and validates it "<fileName>"
    When User clicks the logout
    When User must enter valid "neouser8@yopmail.com" and "Neouser8"
    And User must click on submit button
    And User validates the username "neouser8@yopmail.com"
    When User selects the workspace from the dropdown in extraction homepage "<WorkSpace>"
    When User clicks the assigned and extraction
    When User selects the file "<fileName>"
    When User clicks the lock as a user who didnt lock the file
    When User clicks the logout
    When User must enter valid "neouser7@yopmail.com" and "Neouser7"
    And User must click on submit button
    And User validates the username "neouser7@yopmail.com"
    When User selects the workspace from the dropdown in extraction homepage "<WorkSpace>"
    When User clicks the assigned and extraction
    When User selects the file "<fileName>"
    When User unlocks the file and validates it "<fileName>"

    #When user validates the user assign field after adding three fields
    Examples: 
      | username                 | password       | Card number      | expiry date | cvc | zip   | clusterName | WorkSpace     | fileName                 |
      | kprashanth1822@gmail.com | Prashanth@1822 | 4242424242424242 | 02/28       | 123 | 12345 | cluster 1   | WS_TeamPlus_1 | Untitled_spreadsheet.pdf |

  @TestCase_41
  Scenario Outline: documnet validation for assigned user created in Team+ for corresponding user and validate in corresponding user
    Given User must be in login page
    #When User must enter valid "<username>" and "<password>"
    #And User must click on submit button
    #And select admin panel
    #And click on workspace setup tab on header
    #When click on Add workspace button
    #And Selects the monthly team plus plan
    #When user must make payment with valid card "<Card number>","<expiry date>","<cvc>","<zip>"
    #Then verify the last workspace added
    #When User click the Team plus icon in the workspace setup
    #When User clicks the edit icon in the Team plus
    #When User edits the name of the workspace "<WorkSpace>"
    #When User deletes the existing clusters and add three new clusters
    #| cluster 1 |
    #When User clicks the gear icon in the cluster to add fields "<clusterName>"
    #When User clicks adds the fied in the cluster
    #| Field 1 | Field 2 |
    #When User clicks the Activate in the workspace
    #When User checks the checkbox in the alert and clicks activate
    #
    #And User clicks back to container workspace
    #When user validates the add field after adding 15 fields
    #When User clicks the edit icon in the Team plus
    #When User deletes and selects the users from the user assignment
    #| NeoEdit7 (neouser7@yopmail.com) | NeoEdit8 (neouser8@yopmail.com) |Prasanth Kumar (kprashanth1822@gmail.com)|
    #When User clicks the Activate in the workspace
    #When User checks the checkbox in the alert and clicks activate
    #And user validates the active status
    #And User switches to tab
    #When User selects the workspace from the dropdown in extraction homepage "<WorkSpace>"
    #When User clicks upload button in the extraction page
    #When User uploads the file in the extraction page"<fileName>"
    #When User enters the country,publish year,language,document type and publisher name "<country>" "<publishYear>" "<language>" "<documentType>" "<publisherName>"
    #When User clicks upload and close
    #When User clicks the logout
    When User must enter valid "neouser7@yopmail.com" and "Neouser7"
    And User must click on submit button
    And User validates the username "neouser7@yopmail.com"
    When User selects the workspace from the dropdown in extraction homepage "<WorkSpace>"
    When User clicks the assigned and extraction
    #When User selects the file "<fileName>"
    #When User locks the file and validates it "<fileName>"
    #When User clicks the logout
    #When User must enter valid "neouser8@yopmail.com" and "Neouser8"
    #And User must click on submit button
    #And User validates the username "neouser8@yopmail.com"
    #When User selects the workspace from the dropdown in extraction homepage "<WorkSpace>"
    #When User clicks the assigned and extraction
    #When User selects the file "<fileName>"
    #When User clicks the lock as a user who didnt lock the file
    #When User clicks the logout
    #When User must enter valid "neouser7@yopmail.com" and "Neouser7"
    #And User must click on submit button
    #And User validates the username "neouser7@yopmail.com"
    #When User selects the workspace from the dropdown in extraction homepage "<WorkSpace>"
    #When User clicks the assigned and extraction
    When User gets the current window
    #When User selects the file "<fileName>"
    #When User unlocks the file and validates it "<fileName>"
    When User clicks the open icon in the file "<fileName>"
    When User clicks the pause extraction
    #When User clicks the Add new record in the extracting page
    #When User selects the text and selects the field to put text "<textSelect>" "<fieldSelect>"
    When User closes the current window
    When user validates the file lock after extraction "<fileName>"

    #When user validates the user assign field after adding three fields
    Examples: 
      | username                 | password       | Card number      | expiry date | cvc | zip   | clusterName | WorkSpace     | fileName                 | textSelect | fieldSelect |
      | kprashanth1822@gmail.com | Prashanth@1822 | 4242424242424242 | 02/28       | 123 | 12345 | cluster 1   | WS_TeamPlus_1 | Untitled_spreadsheet.pdf | Mechanics  | Field 1     |

  @TestCase_41_42_43_44_45
  Scenario Outline: documnet validation for assigned user created in Team+ for corresponding user and validate in corresponding user
    Given User must be in login page
    #When User must enter valid "<username>" and "<password>"
    #And User must click on submit button
    #And select admin panel
    #And click on workspace setup tab on header
    #When click on Add workspace button
    #And Selects the monthly team plus plan
    #When user must make payment with valid card "<Card number>","<expiry date>","<cvc>","<zip>"
    #Then verify the last workspace added
    #When User click the Team plus icon in the workspace setup
    #When User clicks the edit icon in the Team plus
    #When User edits the name of the workspace "<WorkSpace>"
    #When User deletes the existing clusters and add three new clusters
    #| cluster 1 |
    #When User clicks the gear icon in the cluster to add fields "<clusterName>"
    #When User clicks adds the fied in the cluster
    #| Field 1 | Field 2 |
    #When User clicks the Activate in the workspace
    #When User checks the checkbox in the alert and clicks activate
    #And User clicks back to container workspace
    #When user validates the add field after adding 15 fields
    #When User clicks the edit icon in the Team plus
    #When User deletes and selects the users from the user assignment
    #| NeoEdit7 (neouser7@yopmail.com) | NeoEdit8 (neouser8@yopmail.com) |Prasanth Kumar (kprashanth1822@gmail.com)|
    #When User clicks the Activate in the workspace
    #When User checks the checkbox in the alert and clicks activate
    #And user validates the active status
    #And User switches to tab
    #When User selects the workspace from the dropdown in extraction homepage "<WorkSpace>"
    #When User clicks upload button in the extraction page
    #When User uploads the file in the extraction page"<fileName>"
    #When User enters the country,publish year,language,document type and publisher name "<country>" "<publishYear>" "<language>" "<documentType>" "<publisherName>"
    #When User clicks upload and close
    #When User clicks the logout
    When User must enter valid "neouser7@yopmail.com" and "Neouser7"
    And User must click on submit button
    And User validates the username "neouser7@yopmail.com"
    When User selects the workspace from the dropdown in extraction homepage "<WorkSpace>"
    #------------------------TEST CASE 42---------------------------------
    #When User clicks upload button in the extraction page
    #When User uploads the file in the extraction page"<fileName>"
    #When User clicks upload and close
    #When User waits for two minutes
    #When User clicks the refresh in the extraction page
    When User gets the current window
    When User clicks the assigned and extraction
    When User clicks the open icon in the file "<fileName>"
    When User clicks the Add new record in the extracting page
    When User selects the text and selects the field to put text "<textSelect>" "<fieldSelect>"
    #---------------------------TEST CASE 43-----------------------------------
    When User selects the text and selects the field to put text "more" "Field 2"
    When User clicks the highlight all value in a page marker icon
    When User verifies the highlighted text "<textSelect>"
    #--------------------------TEST CASE 44-----------------
    When User verifies the hihlighted text in the field panel "<textSelect>" "<fieldSelect>"
    #--------------------------- TEST CASE 45--------------------------
    When User selects the text and selects the field to put text "Continued" "Field 2"
    When User clicks the highlight all value in a page marker icon
    #When User verifies the highlighted text "Continued"
    When User verifies the hihlighted text in the field panel "Continued" "Field 2"
    #--------------------------- TEST CASE 46--------------------------
    When User adds more text to the selected field
      | small | Field 2 |
    When User clicks the highlight all value in a page marker icon
    When User verifies the highlighted text "small"
    #----------------------TEST CASE 49-------------------
    When User clicks the Add to context marker for the text "small"
    When User verifies the hihlighted text in the field panel "small" "Field 2"
    #--------------------------- TEST CASE 47--------------------------
    When User clicks the image mode in the extracting page
    When User selects the area for the image
    When User selects the field for the image "Field 1"
    When User clicks the image on the field panel and validates the image area "Field 1"
    #--------------------------TEST CASE 48---------------------------
    When User clicks the back button
    #When user selects the field for extraction
    When User selects all the fileds for Field Scanning

    #When User closes the current window
    #When user validates the file lock after extraction "<fileName>"
    #When user validates the user assign field after adding three fields
    Examples: 
      | username                 | password       | Card number      | expiry date | cvc | zip   | clusterName | WorkSpace     | fileName   | textSelect | fieldSelect |
      | kprashanth1822@gmail.com | Prashanth@1822 | 4242424242424242 | 02/28       | 123 | 12345 | cluster 1   | WS_TeamPlus_1 | sample.pdf | Mechanics  | Field 1     |

  @TestCase_50_51
  Scenario Outline: Validating the sortcut keys
    Given User must be in login page
    #When User must enter valid "<username>" and "<password>"
    #And User must click on submit button
    #And select admin panel
    #And click on workspace setup tab on header
    #When click on Add workspace button
    #And Selects the monthly team plus plan
    #When user must make payment with valid card "<Card number>","<expiry date>","<cvc>","<zip>"
    #Then verify the last workspace added
    #When User click the Team plus icon in the workspace setup
    #When User clicks the edit icon in the Team plus
    #When User edits the name of the workspace "<WorkSpace>"
    #When User deletes the existing clusters and add three new clusters
    #| cluster 1 |
    #When User clicks the gear icon in the cluster to add fields "<clusterName>"
    #When User clicks adds the fied in the cluster
    #| Field 1 | Field 2 |
    #When User clicks the Activate in the workspace
    #When User checks the checkbox in the alert and clicks activate
    #And User clicks back to container workspace
    #When user validates the add field after adding 15 fields
    #When User clicks the edit icon in the Team plus
    #When User deletes and selects the users from the user assignment
    #| NeoEdit7 (neouser7@yopmail.com) | NeoEdit8 (neouser8@yopmail.com) |Prasanth Kumar (kprashanth1822@gmail.com)|
    #When User clicks the Activate in the workspace
    #When User checks the checkbox in the alert and clicks activate
    #And user validates the active status
    #And User switches to tab
    #When User selects the workspace from the dropdown in extraction homepage "<WorkSpace>"
    #When User clicks upload button in the extraction page
    #When User uploads the file in the extraction page"<fileName>"
    #When User clicks upload and close
    #When User clicks the logout
    When User must enter valid "neouser7@yopmail.com" and "Neouser7"
    And User must click on submit button
    And User validates the username "neouser7@yopmail.com"
    When User selects the workspace from the dropdown in extraction homepage "<WorkSpace>"
    When User gets the current document page
    #When User uploads the multiple files
    #| sample.pdf | Untitled_spreadsheet.pdf | sample.pdf | Untitled_spreadsheet.pdf | sample.pdf | Untitled_spreadsheet.pdf | sample.pdf | Untitled_spreadsheet.pdf | sample.pdf | Untitled_spreadsheet.pdf | sample.pdf | Untitled_spreadsheet.pdf |
    When User clicks the Documents on the left panel
    When User clicks the shortcut key to go to next page
    When User clicks the shortcut key to go to previous page
    #------------------TEXT CASE 51------------------
    When User clicks the up shortcut key to go to next page
    When User clicks the down shortcut key to go to previos page

    Examples: 
      | username                 | password       | Card number      | expiry date | cvc | zip   | clusterName | WorkSpace     | fileName   | textSelect | fieldSelect |
      | kprashanth1822@gmail.com | Prashanth@1822 | 4242424242424242 | 02/28       | 123 | 12345 | cluster 1   | WS_TeamPlus_1 | sample.pdf | Mechanics  | Field 1     |

  @TestCase_52
  Scenario Outline: Validating the sortcut keys
    Given User must be in login page
    When User must enter valid "neouser7@yopmail.com" and "Neouser7"
    And User must click on submit button
    And User validates the username "neouser7@yopmail.com"
    When User selects the workspace from the dropdown in extraction homepage "<WorkSpace>"
    When User clicks the assigned and extraction
    When User clicks the open icon in the file "<fileName>"
    When User clicks the shortcut key to Add new field in extraction page
    Examples: 
      | username                 | password       | Card number      | expiry date | cvc | zip   | clusterName | WorkSpace     | fileName   | textSelect | fieldSelect |
      | kprashanth1822@gmail.com | Prashanth@1822 | 4242424242424242 | 02/28       | 123 | 12345 | cluster 1   | WS_TeamPlus_1 | sample.pdf | Mechanics  | Field 1     |
    
    
    #---------------------TEST CASE 54---------------
    @TestCase_54_55
     Scenario Outline: Validating the sortcut keys for field in the extraction page
    Given User must be in login page
    When User must enter valid "neouser7@yopmail.com" and "Neouser7"
    And User must click on submit button
    And User validates the username "neouser7@yopmail.com"
    When User selects the workspace from the dropdown in extraction homepage "<WorkSpace>"
    When User clicks the assigned and extraction
    When User clicks the open icon in the file "<fileName>"
    
    When User clicks the Add new record in the extracting page
    When User selects the text and selects the field to put text "Continued" "Field 1"
    When User navigates to the field using shortcut keys in extraction page "Field 1" "Field 2"
    

    Examples: 
      | username                 | password       | Card number      | expiry date | cvc | zip   | clusterName | WorkSpace     | fileName   | textSelect | fieldSelect |
      | kprashanth1822@gmail.com | Prashanth@1822 | 4242424242424242 | 02/28       | 123 | 12345 | cluster 1   | WS_TeamPlus_1 | sample.pdf | Mechanics  | Field 1     |

      @TestCase_54_55
       Scenario Outline: Validating the sortcut keys for field in the extraction page
    Given User must be in login page
    When User must enter valid "neouser7@yopmail.com" and "Neouser7"
    And User must click on submit button
    And User validates the username "neouser7@yopmail.com"
    When User selects the workspace from the dropdown in extraction homepage "<WorkSpace>"
    When User clicks the assigned and extraction
    When User clicks the open icon in the file "<fileName>"
    
    When User clicks the Add new record in the extracting page
    When User selects the text and selects the field to put text "tutorials" "Field 1"
    When User selects the text and selects the field to put text "small" "Field 2"
    When User add new extracted field for extraction 
    When User selects the text and selects the field to put text "Mechanics" "Field 1"
    When User selects the text and selects the field to put text "This" "Field 2"
   When User add new extracted field for extraction 
    When User selects the text and selects the field to put text "And" "Field 1"
    When User selects the text and selects the field to put text "Even" "Field 2"
    When User clicks the back button
    #When User navigates to the document record fields
    
    When User uses the shortcut key to go to field view of the selected record
    When user uses the shortcut key to go back to document records
    
    When User uses shortcut key to submit extraction
   

    Examples: 
      | username                 | password       | Card number      | expiry date | cvc | zip   | clusterName | WorkSpace     | fileName   | textSelect | fieldSelect |
      | kprashanth1822@gmail.com | Prashanth@1822 | 4242424242424242 | 02/28       | 123 | 12345 | cluster 1   | WS_TeamPlus_1 | sample.pdf | Mechanics  | Field 1     |
      