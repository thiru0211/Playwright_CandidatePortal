Feature: Login

  #Background: Login
  #Given To Check Login user is navigating to Candidate Portal URL is "https://portal.nextestify.com/"
  #When To Check Login Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@123"
  #And Click the Login button To Check Login
  #Then Click Login button
  
  @TC_01
  Scenario: Login:Login Check
    Given To Check Login user is navigating to Candidate Portal URL is "https://portal.nextestify.com/"
    When To Check Login Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@1234"
    And Click the Login button To Check Login
    Then Check display homepage or not To Check Login
    Then Close Login page

  @TC_02
  Scenario: Login:Sign Out Check
    Given To Check Login user is navigating to Candidate Portal URL is "https://portal.nextestify.com/"
    When To Check Login Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@1234"
    And Click the Login button To Check Login
    Then Click User logo button in Top right corner
    And Click SignOut button
    Then Check login page is displayed or not using assert
    Then Close Login page

  @TC_03
  Scenario: Login:Invalid Check
    Given To Check Login user is navigating to Candidate Portal URL is "https://portal.nextestify.com/"
    When To Check Login Enter Invalid username and valid password are "thirumaran1@sankarasoftware.com" and "Thirumaran@123"
    And Click the Login button To Check Login
    Then Check alert message is displayed or not in email tab
    Then Close Login page

  @TC_04
  Scenario: Login:Invalid Check
    Given To Check Login user is navigating to Candidate Portal URL is "https://portal.nextestify.com/"
    When To Check Login Enter valid username and Invalid password are "thirumaran@sankarasoftware.com" and "Thirumaran12345"
    And Click the Login button To Check Login
    Then Check alert message is displayed or not in password tab
    Then Close Login page

  @TC_05
  Scenario: Login:Invalid Check
    Given To Check Login user is navigating to Candidate Portal URL is "https://portal.nextestify.com/"
    When To Check Login Enter Invalid username and Invalid password are "0211thiru@gmailss.com" and "Thirumaran12345"
    And Click the Login button To Check Login
    Then Check alert message is displayed or not in email tab
    Then Close Login page

  @TC_06
  Scenario: Login:Without Password Check
    Given To Check Login user is navigating to Candidate Portal URL is "https://portal.nextestify.com/"
    When To Check Login Enter username only "thirumaran@sankarasoftware.com"
    And Click the Login button To Check Login
    Then Check alert message is displayed or not in password tab
    Then Close Login page

  @TC_07
  Scenario: Login:Without Mail Id Check
    Given To Check Login user is navigating to Candidate Portal URL is "https://portal.nextestify.com/"
    When To Check Login Enter password only "Thirumaran@123"
    And Click the Login button To Check Login
    Then Check alert message is displayed or not in email tab
    Then Close Login page

  @TC_08
  Scenario: Login:Forget Password Check
    Given To Check Login user is navigating to Candidate Portal URL is "https://portal.nextestify.com/"
    When Without enter email id click Forget password button
    Then Check alert message is displayed or not in email tab
    Then Close Login page

  @TC_09
  Scenario: Login:Forget Password Check
    Given To Check Login user is navigating to Candidate Portal URL is "https://portal.nextestify.com/"
    When To Check Forget Password Enter valid email id "forgotpasswrdsankara@gmail.com"
    And click Forget password button
    Then Check verification page is displayed or not in forgot password page
    Then Close Login page

  @TC_10
  Scenario: Login:Lock Account
    Given To Check Login user is navigating to Candidate Portal URL is "https://portal.nextestify.com/"
    When Enter username and password are "jacksparrowsankara@gmail.com" and "Thirumaran2123456"
    And Click the Login button To Check Login
    Then Check alert message is displayed or not in password tab
    And Click the Login button To Check Login
    Then Check alert message is displayed or not in password tab
    And Click the Login button To Check Login
    Then Check alert message is displayed or not in password tab
    And Click the Login button To Check Login
    Then Check alert message is displayed or not in password tab
    Then Close Login page

  @TC_11
  Scenario: Login:Lock Account
    Given To Check Login user is navigating to Candidate Portal URL is "https://portal.nextestify.com/"
    When Enter username and password are "jacksparrowsankara@gmail.com" and "Thirumaran@001231"
    And Click the Login button To Check Login
    Then Check alert message is displayed or not in password tab
    Then Close Login page

  #@TC_12
  #Scenario: Login:Unlock Account
    #Given To Check Login user is navigating to Candidate Portal URL is "https://portal.nextestify.com/"
    #When Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@123"
    #And Click the Login button To Check Login
    #Then Click Admin button to unlock account
    #And Click Users button to unlock account
    #And Search valid username "0211thiru@gmail.com" in the searchbox to unlock the account
    #Then Click edit button to unlock the account
    #And Click unlock button to unlock the account
    #Then Close Login page

  @TC_12
  Scenario: Login:Enter button check
    Given To Check Login user is navigating to Candidate Portal URL is "https://portal.nextestify.com/"
    When Enter valid username and valid password are "thirumaran@sankarasoftware.com" and "Thirumaran@1234"
    And Press ENTER button
    Then Check landing page after press Enter button
    Then Close Login page

  @TC_13
  Scenario: Login:2FA Enabled User Check
    Given To Check Login user is navigating to Candidate Portal URL is "https://portal.nextestify.com/"
    When Enter valid username and valid password are "0211thiru@gmail.com" and "Thirumaran@123"
    And Click the Login button To Check Login
    Then Close Login page
