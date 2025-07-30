Feature: Homepage

  Background: Homepage
    Given To Check Homepage user is navigating to Candidate Portal URL is "https://portal.nextestify.com/"
    When To Check Homepage Enter username and password are "sankaracandidate1@gmail.com" and "Thirumaran@123"
    And Click the Homepage button To Check Login

  @TC_01
  Scenario: Homepage:View Profile Check
    Given Click profile button in homepage
    When Click view account button in profile button
    And Check view account page is displayed or not
    Then Close Homepage page

  @TC_02
  Scenario: Homepage:View Profile:Personal Information Firstname Check
    Given Click profile button in homepage
    When Click view account button in profile button
    And Clear the details in the first name tab
    Then Enter valid name "Test" in the first name tab
    And Check new user name "Test" is displayed or not in the first name tab
    Then Close Homepage page

  @TC_03
  Scenario: Homepage:View Profile:Personal Information Lastname Check
    Given Click profile button in homepage
    When Click view account button in profile button
    And Clear the details in the last name tab
    Then Enter valid name "User" in the last name tab
    And Check new user name "User" is displayed or not in the last name tab
    Then Close Homepage page

  @TC_04
  Scenario: Homepage:View Profile: Personal Information Gender Check
    Given Click profile button in homepage
    When Click view account button in profile button
    And Click "Female" radio button in personal information page
    Then Click "Male" radio button in personal information page
    And Click update button in personal information page
    Then Check success message is displayed or not in personal information page
    Then Close Homepage page

  @TC_05
  Scenario: Homepage:View Profile: Personal Information Time Zone Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Modify "America/New_York" timezone in personal information page
    And Click update button in personal information page
    Then Check success message is displayed or not in personal information page
    Then Close Homepage page

  @TC_06
  Scenario: Homepage:Security Information:2FA Check
    Given Click profile button in homepage
    When Click view account button in profile button
    And Click Security Information tab
    Then Click "No" radio button in Security Information tab
    And Check No radio button is selected or not in Security Information
    Then Close Homepage page

  @TC_07
  Scenario: Homepage:Security Information:2FA Check
    Given Click profile button in homepage
    When Click view account button in profile button
    And Click Security Information tab
    Then Click "Yes" radio button in Security Information tab
    And Click "Email" radio button in 2FA tab
    Then Click update button in 2FA tab
    And Check success message is displayed or not in Security Information tab
    Then Click "No" radio button in Security Information tab
    Then Click update button in 2FA tab
    And Check success message is displayed or not in Security Information tab
    Then Close Homepage page

  @TC_08
  Scenario: Homepage:Security Information:2FA Check
    Given Click profile button in homepage
    When Click view account button in profile button
    And Click Security Information tab
    Then Click "Yes" radio button in Security Information tab
    And Click "SMS" radio button in 2FA tab
    Then Click update button in 2FA tab
    And Check success message is displayed or not in Security Information tab
    Then Click "No" radio button in Security Information tab
    Then Click update button in 2FA tab
    And Check success message is displayed or not in Security Information tab
    Then Close Homepage page

  @TC_09
  Scenario: Homepage:Security Information:Change Password Check
    Given Click profile button in homepage
    When Click view account button in profile button
    And Click Security Information tab
    Then Click update button in change password tab
    And Check error message is displayed or not in new password tab
    Then Check error message is displayed or not in confirm password tab
    Then Close Homepage page

  @TC_10
  Scenario: Homepage:Security Information:Change Password Check
    Given Click profile button in homepage
    When Click view account button in profile button
    And Click Security Information tab
    Then Enter the password "Thirumaran@Thiru" in new password tab
    And Enter the password "Thirumaran@Thi" in confirm password tab
    Then Click update button in change password tab
    Then Check error message is displayed or not in confirm password tab
    Then Close Homepage page

  @TC_11
  Scenario: Homepage:Security Information:Change Password Check
    Given Click profile button in homepage
    When Click view account button in profile button
    And Click Security Information tab
    Then Enter the password "thirumaran@thiru" in new password tab
    And Enter the password "thirumaran@thiru" in confirm password tab
    Then Click update button in change password tab
    Then Check error message is displayed or not in new password tab
    Then Close Homepage page

  @TC_12
  Scenario: Homepage:Security Information:Change Password Check
    Given Click profile button in homepage
    When Click view account button in profile button
    And Click Security Information tab
    Then Enter the password "thirumaran" in new password tab
    And Enter the password "thirumaran" in confirm password tab
    Then Click update button in change password tab
    Then Check error message is displayed or not in new password tab
    Then Close Homepage page

  #@TC_13
  #Scenario: Homepage:Security Information:Change Password Check
    #Given Click profile button in homepage
    #When Click view account button in profile button
    #And Click Security Information tab
    #Then Enter the password "Thirumaran@123456" in new password tab
    #And Enter the password "Thirumaran@123456" in confirm password tab
    #Then Click update button in change password tab
    #Then Check success message is displayed or not in security info
    #Then Enter the password "Thirumaran@12345" in new password tab
    #And Enter the password "Thirumaran@12345" in confirm password tab
    #Then Click update button in change password tab
    #Then Check error message for previous password is displayed or not in security info
    #Then Enter the password "Thirumaran@1234567" in new password tab
    #And Enter the password "Thirumaran@1234567" in confirm password tab
    #Then Click update button in change password tab
    #Then Enter the password "Thirumaran@123456" in new password tab
    #And Enter the password "Thirumaran@123456" in confirm password tab
    #Then Click update button in change password tab
    #Then Check error message for previous password is displayed or not in security info
    #Then Enter the password "Thirumaran@12345678" in new password tab
    #And Enter the password "Thirumaran@12345678" in confirm password tab
    #Then Click update button in change password tab
    #Then Enter the password "Thirumaran@1234567" in new password tab
    #And Enter the password "Thirumaran@1234567" in confirm password tab
    #Then Click update button in change password tab
    #Then Check error message for previous password is displayed or not in security info
    #Then Enter the password "Thirumaran@123456789" in new password tab
    #And Enter the password "Thirumaran@123456789" in confirm password tab
    #Then Click update button in change password tab
    #Then Enter the password "Thirumaran@12345678" in new password tab
    #And Enter the password "Thirumaran@12345678" in confirm password tab
    #Then Click update button in change password tab
    #Then Check error message for previous password is displayed or not in security info
    #Then Enter the password "Thirumaran@1234567890" in new password tab
    #And Enter the password "Thirumaran@1234567890" in confirm password tab
    #Then Click update button in change password tab
    #Then Enter the password "Thirumaran@123456789" in new password tab
    #And Enter the password "Thirumaran@123456789" in confirm password tab
    #Then Click update button in change password tab
    #Then Check error message for previous password is displayed or not in security info
    #Then Enter the password "Thirumaran@123" in new password tab
    #And Enter the password "Thirumaran@123" in confirm password tab
    #Then Click update button in change password tab
    #Then Check success message is displayed or not in security info
    #Then Close Homepage page

  @TC_14
  Scenario: Homepage:Profile Upload Close Check
    Given Click profile button in homepage
    When Click view account button in profile button
    And Click profile button profile page
    Then Click close button in upload profile page
    Then Close Homepage page

  @TC_15
  Scenario: Subscription Information: Subscribe :Back Check
  Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click back button in select payment method popup
    And Check the landing page from select payment method popup
    Then Close Homepage page

  @TC_16
  Scenario: Subscription Information: Subscribe:Landing Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "Bank Account" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Check the landing page within select payment method popup
    Then Close Homepage page

  @TC_17
  Scenario: Subscription Information: Subscribe:Landing Check
   Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "UPI Payment" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Check the landing page within select payment method popup
    Then Close Homepage page

  @TC_18
  Scenario: Subscription Information: Subscribe:Landing Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "Credit / Debit Card" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Check the landing page within select payment method popup
    Then Close Homepage page

  @TC_19
  Scenario: Subscription Information: Subscribe:Landing Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "Bank Account" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Click back button in Payment Bank Account
    And Check the landing page from Payment Bank Account
    Then Close Homepage page

  @TC_20
  Scenario: Subscription Information: Subscribe:Landing Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "UPI Payment" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Click back button in Payment UPI ID
    And Check the landing page from Payment UPI ID
    Then Close Homepage page

  @TC_21
  Scenario: Subscription Information: Subscribe:Landing Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "UPI Payment" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Click back button in Payment Credit Debit Card
    And Check the landing page from Payment Credit Debit Card
    Then Close Homepage page

  @TC_22
  Scenario: Subscription Information: Subscribe:Pay Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "Bank Account" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Click Pay button in Payment Bank Account
    And Check error popup is displayed or not  in Payment Bank Account
    Then Close Homepage page

  @TC_23
  Scenario: Subscription Information: Subscribe:Pay Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "UPI Payment" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Click Pay button in Payment UPI ID
    And Check error popup is displayed or not  in Payment UPI ID
    Then Close Homepage page

  @TC_24
  Scenario: Subscription Information: Subscribe:Pay Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "Credit / Debit Card" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Clear payment details in all tab in Payment Credit Debit Card
    Then Click Pay button in Payment Credit Debit Card
    And Check error popup is displayed or not in Payment Credit Debit Card
    Then Close Homepage page

  @TC_25
  Scenario: Subscription Information: Subscribe:Pay Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "Bank Account" radio button in select payment method popup
    And Click proceed button in select payment method popup
     Then Enter alpha characters "Test account number" in account number tab
    And Check tab is empty or not in account number tab
    Then Enter special characters "!@#$%^" in account number tab
    And Check tab is empty or not in account number tab
    Then Close Homepage page

  @TC_26
  Scenario: Subscription Information: Subscribe:Pay Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "Bank Account" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Enter numerical characters "1234567890" in account number tab
    And Check entered text "1234567890" is displayed or not in account number tab
    Then Close Homepage page

  @TC_27
  Scenario: Subscription Information: Subscribe:Pay Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "Bank Account" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Enter alpha characters "Test routing number" in routing number tab
    And Check tab is empty or not in routing number tab
    Then Enter special characters "!@#$%" in routing number tab
    And Check tab is empty or not in routing number tab
    Then Close Homepage page

  @TC_28
  Scenario: Subscription Information: Subscribe:Pay Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "Bank Account" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Enter numerical characters "125008547" in routing number tab
    And Check entered text "125008547" is displayed or not in account number tab
    Then Close Homepage page

  @TC_29
  Scenario: Subscription Information: Subscribe:Pay Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "Bank Account" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Enter numerical characters "1234567890" in Name on Account  tab
    And Check tab is empty or not in Name on Account tab
    Then Enter special characters "!@#$%" in Name on Account tab
    And Check tab is empty or not in Name on Account tab
    Then Close Homepage page

  @TC_30
  Scenario: Subscription Information: Subscribe:Pay Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "Bank Account" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Enter alpha characters "Test user" in Name on Account tab
    And Check entered text "Test user" is displayed or not in Name on Account tab
    Then Close Homepage page

  @TC_31
  Scenario: Subscription Information: Subscribe:Pay Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "Bank Account" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Enter numerical characters "1234567890" in Name on Account  tab
    And Check tab is empty or not in Bank Name tab
    Then Enter special characters "!@#$%" in Bank Name tab
    And Check tab is empty or not in Bank Name tab
    Then Close Homepage page

  @TC_32
  Scenario: Subscription Information: Subscribe:Pay Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "Bank Account" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Enter alpha characters "Test bank" in Bank Name tab
    And Check entered text "Test bank" is displayed or not in Bank Name tab
    Then Close Homepage page

  @TC_33
  Scenario: Subscription Information: Subscribe:Pay Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "Bank Account" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Enter alpha characters "Test bank name" in Bank Address tab
    And Check entered text "Test bank name" is displayed or not in Bank Address tab
    Then Enter numerical characters "1234567890" in Bank Address  tab
    And Check entered text "1234567890" is displayed or not in Bank Address tab
    Then Enter special characters "!@#$%" in Bank Address tab
    And Check entered text "!@#$%" is displayed or not in Bank Address tab
    Then Close Homepage page

  @TC_34
  Scenario: Subscription Information: Subscribe:Pay Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "UPI Payment" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Enter alpha characters "Test Mobile Number" in phone number tab in UPI ID type
    And Check phone number tab is empty or not in UPI ID type
    Then Enter special characters "!@#$%" in phone number tab in UPI ID type
    And Check phone number tab is empty or not in UPI ID type
    Then Close Homepage page
@Test
  @TC_35
  Scenario: Subscription Information: Subscribe:Pay Check
    Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "UPI Payment" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Enter numerical characters "8870671212" in phone number tab in UPI ID type
    And Check entered phone number "8870671212" is displayed or not in UPI ID type
    Then Close Homepage page

  @TC_36
  Scenario: Subscription Information: Subscribe:Pay Check
   Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "Credit / Debit Card" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Enter alpha characters "Test Card" in Card number tab in credit debit type
    And Check Card number tab is empty or not in credit debit type
    Then Enter special characters "!@#$%" in Card number tab in credit debit type
    And Check Card number tab is empty or not in credit debit type
    Then Close Homepage page
@Test
  @TC_37
  Scenario: Subscription Information: Subscribe:Pay Check
   Given Click profile button in homepage
    When Click view account button in profile button
    Then Click Subscription Information button
    Then Click next button in Subscription Information
    And Click the subscribe button for a subject
    Then Click "Credit / Debit Card" radio button in select payment method popup
    And Click proceed button in select payment method popup
    Then Enter numerical characters "4242424242424242" in Card number tab in credit debit type
    And Check entered Card number "4242 4242 4242 4242" is displayed or not in credit debit type
    Then Close Homepage page
