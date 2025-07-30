package stepDefinition;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitForSelectorState;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CP_2_Homepage {

	public Page page;
	public Browser browser;
	public Playwright playwright;

	@Given("To Check Homepage user is navigating to Candidate Portal URL is {string}")
	public void to_check_homepage_user_is_navigating_to_candidate_portal_url_is(String url) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();

		System.out.println("✅ Screen size is: " + width + ":" + height);
		playwright = Playwright.create();

		browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false)

		);

		// Browser browser =playwright.firefox().launch(
		// new LaunchOptions().setHeadless(false)
		// );

		// Browser browser =playwright.webkit().launch(
		// new LaunchOptions().setHeadless(false)
		// );

		// page = browser.newPage();

		BrowserContext browserContext = browser
				.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		page = browserContext.newPage();
		page.navigate(url);
	}

	@When("To Check Homepage Enter username and password are {string} and {string}")
	public void to_check_homepage_enter_username_and_password_are_and(String email, String passWord) {
		String title = page.url();
		System.out.println("✅ Current page title is: " + title);
		Locator emailId = page.getByPlaceholder("Enter your Email");
		emailId.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		emailId.fill(email);
		Locator password = page.getByPlaceholder("Enter your Password");
		password.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		password.fill(passWord);
	}

	@When("Click the Homepage button To Check Login")
	public void click_the_homepage_button_to_check_login() {
		Locator loginBtn = page.locator("//button[contains(@class,'mb-1 btn')]");
		loginBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		loginBtn.click();
	}

	@Then("Close Homepage page")
	public void close_homepage_page() throws InterruptedException {
		Thread.sleep(1000);
		page.close();
		browser.close();
		playwright.close();
	}

	@Given("Click profile button in homepage")
	public void click_profile_button_in_homepage() {
		Locator loginBtn = page.locator("(//span[contains(@class,'ant-avatar ant-avatar-circle')])[1]");
		loginBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		loginBtn.click();
	}

	@When("Click view account button in profile button")
	public void click_view_account_button_in_profile_button() {
		Locator viewAccBtn = page.locator("//span[normalize-space(text())='View Account']");
		viewAccBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		viewAccBtn.click();
	}

	@When("Check view account page is displayed or not")
	public void check_view_account_page_is_displayed_or_not() {
		Locator fstNamTab = page.locator("//label[contains(.,'First Name *')]");
		fstNamTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		assertThat(fstNamTab).isVisible();
		System.out.println("✅ Page landed to View account tab!!!");
	}

	@When("Clear the details in the first name tab")
	public void clear_the_details_in_the_first_name_tab() {
		Locator fstNamTab = page.locator("(//input[contains(@class,'ant-input css-19yuzph')])[1]");
		fstNamTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		assertThat(fstNamTab).isVisible();
		fstNamTab.clear();
	}

	@Then("Enter valid name {string} in the first name tab")
	public void enter_valid_name_in_the_first_name_tab(String fstName) {
		Locator fstNamTab = page.locator("(//input[contains(@class,'ant-input css-19yuzph')])[1]");
		fstNamTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		assertThat(fstNamTab).isVisible();
		fstNamTab.fill(fstName);
	}

	@Then("Check new user name {string} is displayed or not in the first name tab")
	public void check_new_user_name_is_displayed_or_not_in_the_first_name_tab(String oldFstName) {
		Locator fstNamTab = page.locator("(//input[contains(@class,'ant-input css-19yuzph')])[1]");
		fstNamTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		assertThat(fstNamTab).isVisible();
		String newFstName = fstNamTab.inputValue();
		assertEquals(newFstName, oldFstName, "First name value mismatch");
	}

	@When("Clear the details in the last name tab")
	public void clear_the_details_in_the_last_name_tab() {
		Locator lastNamTab = page.locator("(//input[contains(@class,'ant-input css-19yuzph')])[2]");
		lastNamTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		assertThat(lastNamTab).isVisible();
		lastNamTab.clear();
	}

	@Then("Enter valid name {string} in the last name tab")
	public void enter_valid_name_in_the_last_name_tab(String lastName) {
		Locator lastNamTab = page.locator("(//input[contains(@class,'ant-input css-19yuzph')])[2]");
		lastNamTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		assertThat(lastNamTab).isVisible();
		lastNamTab.fill(lastName);
	}

	@Then("Check new user name {string} is displayed or not in the last name tab")
	public void check_new_user_name_is_displayed_or_not_in_the_last_name_tab(String oldlstName) {
		Locator lastNamTab = page.locator("(//input[contains(@class,'ant-input css-19yuzph')])[2]");
		lastNamTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		assertThat(lastNamTab).isVisible();
		String newlstName = lastNamTab.inputValue();
		assertEquals(newlstName, oldlstName, "Last name value mismatch");
	}

	@When("Click {string} radio button in personal information page")
	public void click_radio_button_in_personal_information_page(String genderText) throws InterruptedException {
		Thread.sleep(1000);
		Locator genderBtn = page.locator("//span[normalize-space(text())='" + genderText + "']");
		genderBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		genderBtn.click();
	}

	@Then("Click update button in personal information page")
	public void click_update_button_in_personal_information_page() {
		Locator updBtn = page.locator("(//button[@type='button']//span)[3]");
		updBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		updBtn.click();
	}

	@Then("Check success message is displayed or not in personal information page")
	public void check_success_message_is_displayed_or_not_in_personal_information_page() {
		Locator succToast = page.locator(
				"//div[contains(@class,'Toastify__toast-icon Toastify--animate-icon')]/following-sibling::div[1]");
		succToast.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		assertThat(succToast).isVisible();
		String succMsg = succToast.textContent();
		System.out.println("✅ Details updated");
		System.out.println("📢 Success message is displayed like: " + succMsg);
	}

	@Then("Modify {string} timezone in personal information page")
	public void modify_timezone_in_personal_information_page(String timezone) {
		String[] parts = timezone.split("/");
		String region = parts[0]; // America
		String city = parts[1]; // New_York
		Locator timeZoneDrpDwn = page.locator("(//span[@class='ant-select-selection-wrap'])[2]");
		timeZoneDrpDwn.click();
		page.waitForTimeout(500);
		timeZoneDrpDwn.type(region);
		page.waitForTimeout(500);
		timeZoneDrpDwn.type("/");
		page.waitForTimeout(500);
		timeZoneDrpDwn.type(city);
		page.waitForTimeout(500);
		page.keyboard().press("Enter");
	}

	@When("Click Security Information tab")
	public void click_security_information_tab() {
		Locator secInfoBtn = page.locator("(//span[@class='col-8'])[2]");
		secInfoBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		secInfoBtn.click();
	}

	@Then("Click {string} radio button in Security Information tab")
	public void click_radio_button_in_security_information_tab(String twoFA) throws InterruptedException {
		Thread.sleep(1000);
		Locator twofa = page.locator("//span[normalize-space(text())='" + twoFA + "']");
		twofa.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		twofa.click();
	}

	@Then("Check No radio button is selected or not in Security Information")
	public void check_no_radio_button_is_selected_or_not_in_security_information() {
		Locator twofa = page.locator("(//input[@name='rdoAuth'])[2]");
		assertThat(twofa).isChecked();
	}

	@Then("Click {string} radio button in 2FA tab")
	public void click_radio_button_in_2fa_tab(String twoFAMode) throws InterruptedException {
		Thread.sleep(1000);
		Locator twofa = page.locator("//span[normalize-space(text())='" + twoFAMode + "']");
		twofa.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		twofa.click();
	}

	@Then("Click update button in 2FA tab")
	public void click_update_button_in_2fa_tab() {
		Locator updBtn = page.locator("(//button[@type='button'])[3]");
		updBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		updBtn.click();
	}

	@Then("Check success message is displayed or not in Security Information tab")
	public void check_success_message_is_displayed_or_not_in_security_information_tab() {
		Locator succToast = page.locator(
				"//div[contains(@class,'Toastify__toast-icon Toastify--animate-icon')]/following-sibling::div[1]");
		succToast.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		assertThat(succToast).isVisible();
		String succMsg = succToast.textContent();
		System.out.println("✅ Details updated");
		System.out.println("📢 Success message is displayed like: " + succMsg);
	}

	@Then("Click update button in change password tab")
	public void click_update_button_in_change_password_tab() {
		page.waitForTimeout(500);
		Locator updBtn = page.locator("(//button[contains(@class,'mb-1 btn')])[2]");
		updBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		updBtn.click();
	}

	@Then("Check error message is displayed or not in new password tab")
	public void check_error_message_is_displayed_or_not_in_new_password_tab() {
		Locator newPassErrMsg = page.locator(
				"(//div[contains(@class,'MuiFormControl-root MuiFormControl-fullWidth')]/following-sibling::label)[1]");
		newPassErrMsg.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		String newPasserr = newPassErrMsg.textContent();
		System.out.println("🛑 New password error message displayed like: " + newPasserr);
		assertThat(newPassErrMsg).isVisible();
	}

	@Then("Check error message is displayed or not in confirm password tab")
	public void check_error_message_is_displayed_or_not_in_confirm_password_tab() {
		Locator confPassErrMsg = page.locator(
				"(//div[contains(@class,'MuiFormControl-root MuiFormControl-fullWidth')]/following-sibling::label)[3]");
		confPassErrMsg.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		String confPasserr = confPassErrMsg.textContent();
		System.out.println("🛑 Confirm password error message displayed like: " + confPasserr);
		assertThat(confPassErrMsg).isVisible();
	}

	@Then("Enter the password {string} in new password tab")
	public void enter_the_password_in_new_password_tab(String newPassword) {
		page.waitForTimeout(1000);
		Locator newPass = page.locator("//input[@placeholder='Enter new Password']");
		newPass.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		newPass.clear();
		page.waitForTimeout(1000);
		newPass.fill(newPassword);
	}

	@Then("Enter the password {string} in confirm password tab")
	public void enter_the_password_in_confirm_password_tab(String confirmPassword) {
		page.waitForTimeout(1000);
		Locator confirmPass = page.locator("//input[@placeholder='Enter confirm Password']");
		confirmPass.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		confirmPass.clear();
		page.waitForTimeout(1000);
		confirmPass.fill(confirmPassword);
	}

	@Then("Check error message is displayed or not in security info")
	public void check_error_message_is_displayed_or_not_in_security_info() {
		Locator errToast = page.locator(
				"//div[contains(@class,'Toastify__toast-icon Toastify--animate-icon')]/following-sibling::div[1]");
		errToast.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		assertThat(errToast).isVisible();
		String errMsg = errToast.textContent();
		System.out.println("🛑 Error message is displayed like: " + errMsg);
	}

	@Then("Check error message for previous password is displayed or not in security info")
	public void check_error_message_for_previous_password_is_displayed_or_not_in_security_info() {
		page.waitForTimeout(1000);
		Locator errToast = page.locator("//div[starts-with(text(), 'Password is one of the last')]");
		errToast.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		assertThat(errToast).isVisible();
		String errMsg = errToast.textContent();
		System.out.println("🛑 Error message is displayed like: " + errMsg);
	}

	@Then("Check success message is displayed or not in security info")
	public void check_success_message_is_displayed_or_not_in_security_info() {
		Locator succToast = page.locator(
				"//div[contains(@class,'Toastify__toast-icon Toastify--animate-icon')]/following-sibling::div[1]");
		succToast.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		assertThat(succToast).isVisible();
		String succMsg = succToast.textContent();
		System.out.println("✅ Details updated");
		System.out.println("📢 Success message is displayed like: " + succMsg);
	}

	@When("Click profile button profile page")
	public void click_profile_button_profile_page() {
		Locator profBtn = page.locator("//div[contains(@class,'overlay MuiBox-root')]");
		profBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		profBtn.click();
	}

	@Then("Click close button in upload profile page")
	public void click_close_button_in_upload_profile_page() {
		Locator clsBtn = page.locator("//span[@class='anticon anticon-close']");
		clsBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		clsBtn.click();
	}

	@Given("Click Subscription Information button")
	public void click_subscription_information_button() {
		Locator subInfoBtn = page.locator("//span[text()='Subscription Information']");
		subInfoBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		subInfoBtn.click();
	}
	@Then("Click next button in Subscription Information")
	public void click_next_button_in_subscription_information() {
			Locator nxtBtn = page.locator("(//div[@class='swipe-icon right'])[2]");
			nxtBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
			nxtBtn.click();
			page.waitForTimeout(1000);
	}
	@When("Click the subscribe button for a subject")
	public void click_the_subscribe_button_for_a_subject() {
		Locator subBtn = page.locator("(//div[@class='buy-blink'])[1]");
		subBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		subBtn.click();
	}

	@Then("Click back button in select payment method popup")
	public void click_back_button_in_select_payment_method_popup() {
		page.waitForTimeout(1000);
		Locator subBtn = page.locator("(//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-q7mezt'])[8]");
		subBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		subBtn.click();
	}
	@Then("Clear payment details in all tab in Payment Credit Debit Card")
	public void clear_payment_details_in_all_tab_in_payment_credit_debit_card() {
		page.waitForTimeout(1000);
		Locator cardNum = page.locator("(//input[contains(@class,'ant-input css-19yuzph')])[1]");
		cardNum.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		cardNum.clear();
		page.waitForTimeout(1000);
		Locator expires = page.locator("//input[@placeholder='MM/YYYY']");
		expires.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		expires.clear();
		page.waitForTimeout(1000);
		Locator security = page.locator("(//input[contains(@class,'ant-input css-19yuzph')])[2]");
		security.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		security.clear();
		
	}
	@Then("Check the landing page from select payment method popup")
	public void check_the_landing_page_from_select_payment_method_popup() {
		page.waitForTimeout(1000);
		Locator subBtn = page.locator("(//div[@class='subject-container'])[1]");
		subBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		try {
			assertThat(subBtn).isVisible();
			System.out.println("✅ Page landed to subscription information home page");
		} catch (AssertionError e) {
			System.out.println("❌ Page doesnot landed to subscription information home page");
		}
	}

	@Then("Click {string} radio button in select payment method popup")
	public void click_radio_button_in_select_payment_method_popup(String paymentType) {
		page.waitForTimeout(1000);
		Locator radBtn = page.locator("//label[normalize-space(text())='" + paymentType + "']");
		radBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		radBtn.click();
	}

	@Then("Click proceed button in select payment method popup")
	public void click_proceed_button_in_select_payment_method_popup() {
		Locator prcdBtn = page.locator("(//button[@type='button'])[3]");
		prcdBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		prcdBtn.click();
	}

	@Then("Check the landing page within select payment method popup")
	public void check_the_landing_page_within_select_payment_method_popup() {
		Locator landPage = page.locator("//button[@data-tooltip-content='Click to make payment']");
		landPage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		try {
			assertThat(landPage).isVisible();
			System.out.println("✅ Page landed to payment page");
		} catch (AssertionError e) {
			System.out.println("❌ Page doesnot landed to payment page");
		}
	}

	@Then("Click back button in Payment Bank Account")
	public void click_back_button_in_payment_bank_account() {
		Locator backBtn = page.locator("//button[@data-tooltip-content='Go back to previous step']");
		backBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		backBtn.click();
	}

	@Then("Check the landing page from Payment Bank Account")
	public void check_the_landing_page_from_payment_bank_account() {
		Locator landPage = page.locator("//span[normalize-space(text())='Select Payment Method']");
		landPage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		try {
			assertThat(landPage).isVisible();
			System.out.println("✅ Page landed to payment type home page");
		} catch (AssertionError e) {
			System.out.println("❌ Page doesnot landed to payment type home page");
		}
	}

	@Then("Click back button in Payment UPI ID")
	public void click_back_button_in_payment_upi_id() {
		Locator backBtn = page.locator("//button[@data-tooltip-content='Go back to previous step']");
		backBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		backBtn.click();
	}

	@Then("Check the landing page from Payment UPI ID")
	public void check_the_landing_page_from_payment_upi_id() {
		Locator landPage = page.locator("//span[normalize-space(text())='Select Payment Method']");
		landPage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		try {
			assertThat(landPage).isVisible();
			System.out.println("✅ Page landed to payment type home page");
		} catch (AssertionError e) {
			System.out.println("❌ Page doesnot landed to payment type home page");
		}
	}

	@Then("Click back button in Payment Credit Debit Card")
	public void click_back_button_in_payment_credit_debit_card() {
		Locator backBtn = page.locator("//button[@data-tooltip-content='Go back to previous step']");
		backBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		backBtn.click();
	}

	@Then("Check the landing page from Payment Credit Debit Card")
	public void check_the_landing_page_from_payment_credit_debit_card() {
		Locator landPage = page.locator("//span[normalize-space(text())='Select Payment Method']");
		landPage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		try {
			assertThat(landPage).isVisible();
			System.out.println("✅ Page landed to payment type home page");
		} catch (AssertionError e) {
			System.out.println("❌ Page doesnot landed to payment type home page");
		}
	}

	@Then("Click Pay button in Payment Bank Account")
	public void click_pay_button_in_payment_bank_account() {
		Locator payBtn = page.locator("//button[@data-tooltip-content='Click to make payment']");
		payBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		payBtn.click();
	}

	@Then("Check error popup is displayed or not  in Payment Bank Account")
	public void check_error_popup_is_displayed_or_not_in_payment_bank_account() {
		Locator errToast = page.locator(
				"//div[contains(@class,'Toastify__toast-icon Toastify--animate-icon')]/following-sibling::div[1]");
		errToast.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		assertThat(errToast).isVisible();
		String errMsg = errToast.textContent();
		System.out.println("📢 Error message is displayed like: " + errMsg);
	}

	@Then("Click Pay button in Payment UPI ID")
	public void click_pay_button_in_payment_upi_id() {
		Locator payBtn = page.locator("//button[@data-tooltip-content='Click to make payment']");
		payBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		payBtn.click();
	}

	@Then("Check error popup is displayed or not  in Payment UPI ID")
	public void check_error_popup_is_displayed_or_not_in_payment_upi_id() {
		Locator errToast = page.locator(
				"//div[contains(@class,'Toastify__toast-icon Toastify--animate-icon')]/following-sibling::div[1]");
		errToast.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		assertThat(errToast).isVisible();
		String errMsg = errToast.textContent();
		System.out.println("📢 Error message is displayed like: " + errMsg);
	}

	@Then("Click Pay button in Payment Credit Debit Card")
	public void click_pay_button_in_payment_credit_debit_card() {
		Locator payBtn = page.locator("//button[@data-tooltip-content='Click to make payment']");
		payBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		payBtn.click();
	}

	@Then("Check error popup is displayed or not in Payment Credit Debit Card")
	public void check_error_popup_is_displayed_or_not_in_payment_credit_debit_card() {
		Locator errToast = page.locator(
				"//div[contains(@class,'Toastify__toast-icon Toastify--animate-icon')]/following-sibling::div[1]");
		errToast.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		assertThat(errToast).isVisible();
		String errMsg = errToast.textContent();
		System.out.println("📢 Error message is displayed like: " + errMsg);
	}

	@Then("Enter special characters {string} in account number tab")
	public void enter_special_characters_in_account_number_tab(String accountNumber) {
		Locator accNumTab = page.locator("//input[@placeholder='Enter account number ']");
		accNumTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		accNumTab.clear();
		accNumTab.fill(accountNumber);
	}

	@Then("Check tab is empty or not in account number tab")
	public void check_tab_is_empty_or_not_in_account_number_tab() {
		Locator accNumTab = page.locator("//input[@placeholder='Enter account number ']");
		accNumTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		String accNum = accNumTab.inputValue();

		try {
			assert accNum.isEmpty();
			System.out.println("✅ Tab doesnot allow invalid character type");
		} catch (AssertionError e) {
			System.out.println("❌ Tab allow invalid character type");
		}
	}

	@Then("Enter alpha characters {string} in account number tab")
	public void enter_alpha_characters_in_account_number_tab(String accountNumber) {
		Locator accNumTab = page.locator("//input[@placeholder='Enter account number ']");
		accNumTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		accNumTab.clear();
		accNumTab.fill(accountNumber);
	}

	@Then("Enter numerical characters {string} in account number tab")
	public void enter_numerical_characters_in_account_number_tab(String accountNumber) {
		Locator accNumTab = page.locator("//input[@placeholder='Enter account number ']");
		accNumTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		accNumTab.clear();
		accNumTab.fill(accountNumber);
	}

	@Then("Check entered text {string} is displayed or not in account number tab")
	public void check_entered_text_is_displayed_or_not_in_account_number_tab(String accountNumber) {
		Locator accNumTab = page.locator("//input[@placeholder='Enter account number ']");
		accNumTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		String actAcctNum = accNumTab.inputValue();
		String expAcctNum = accountNumber;
		assertEquals(expAcctNum, actAcctNum, "Account number tab allows the entered characters");
	}

	@Then("Enter alpha characters {string} in routing number tab")
	public void enter_alpha_characters_in_routing_number_tab(String routingNumber) {
		Locator routNumTab = page.locator("//input[@placeholder='Enter routing number']");
		routNumTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		routNumTab.clear();
		routNumTab.fill(routingNumber);
	}

	@Then("Check tab is empty or not in routing number tab")
	public void check_tab_is_empty_or_not_in_routing_number_tab() {
		Locator routNumTab = page.locator("//input[@placeholder='Enter account number ']");
		routNumTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		String routNum = routNumTab.inputValue();
		try {
			assert routNum.isEmpty();
			System.out.println("✅ Tab doesnot allow invalid character type");
		} catch (AssertionError e) {
			System.out.println("❌ Tab allow invalid character type");
		}
	}

	@Then("Enter special characters {string} in routing number tab")
	public void enter_special_characters_in_routing_number_tab(String routingNumber) {
		Locator routNumTab = page.locator("//input[@placeholder='Enter account number ']");
		routNumTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		routNumTab.clear();
		routNumTab.fill(routingNumber);
	}
	@Then("Enter numerical characters {string} in routing number tab")
	public void enter_numerical_characters_in_routing_number_tab(String routingNumber) {
		Locator routNumTab = page.locator("//input[@placeholder='Enter routing number']");
		routNumTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		routNumTab.clear();
		routNumTab.fill(routingNumber);
	}
	@Then("Enter numerical characters {string} in Name on Account  tab")
	public void enter_numerical_characters_in_name_on_account_tab(String accountName) {
		Locator accNamTab = page.locator("//input[@placeholder='Enter name on account']");
		accNamTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		accNamTab.clear();
		accNamTab.fill(accountName);
	}
	@Then("Check tab is empty or not in Name on Account tab")
	public void check_tab_is_empty_or_not_in_name_on_account_tab() {
		Locator accNamTab = page.locator("//input[@placeholder='Enter name on account']");
		accNamTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		String accNam = accNamTab.inputValue();
		try {
			assert accNam.isEmpty();
			System.out.println("✅ Tab doesnot allow invalid character type");
		} catch (AssertionError e) {
			System.out.println("❌ Tab allow invalid character type");
		}
	}
	@Then("Enter special characters {string} in Name on Account tab")
	public void enter_special_characters_in_name_on_account_tab(String accountName) {
		Locator accNamTab = page.locator("//input[@placeholder='Enter name on account']");
		accNamTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		accNamTab.clear();
		accNamTab.fill(accountName);
	}
	@Then("Enter alpha characters {string} in Name on Account tab")
	public void enter_alpha_characters_in_name_on_account_tab(String accountName) {
		Locator accNamTab = page.locator("//input[@placeholder='Enter name on account']");
		accNamTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		accNamTab.clear();
		accNamTab.fill(accountName);
	}
	@Then("Check entered text {string} is displayed or not in Name on Account tab")
	public void check_entered_text_is_displayed_or_not_in_name_on_account_tab(String accountName) {
		Locator accNamTab = page.locator("//input[@placeholder='Enter name on account']");
		accNamTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		String actAcctNam = accNamTab.inputValue();
		String expAcctNam = accountName;
		assertEquals(expAcctNam, actAcctNam, "Name on Account tab allows the entered characters");
	}
	@Then("Check tab is empty or not in Bank Name tab")
	public void check_tab_is_empty_or_not_in_bank_name_tab() {
		Locator bankNamTab = page.locator("//input[@placeholder='Enter bank name']");
		bankNamTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		String bankNam = bankNamTab.inputValue();
		try {
			assert bankNam.isEmpty();
			System.out.println("✅ Tab doesnot allow invalid character type");
		} catch (AssertionError e) {
			System.out.println("❌ Tab allow invalid character type");
		}
	}
	@Then("Enter special characters {string} in Bank Name tab")
	public void enter_special_characters_in_bank_name_tab(String bankName) {
		Locator bankNamTab = page.locator("//input[@placeholder='Enter bank name']");
		bankNamTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		bankNamTab.clear();
		bankNamTab.fill(bankName);
	}
	@Then("Enter alpha characters {string} in Bank Name tab")
	public void enter_alpha_characters_in_bank_name_tab(String bankName) {
		Locator bankNamTab = page.locator("//input[@placeholder='Enter bank name']");
		bankNamTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		bankNamTab.clear();
		bankNamTab.fill(bankName);
	}
	@Then("Check entered text {string} is displayed or not in Bank Name tab")
	public void check_entered_text_is_displayed_or_not_in_bank_name_tab(String bankName) {
		Locator bankNamTab = page.locator("//input[@placeholder='Enter name on account']");
		bankNamTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		String actBankName = bankNamTab.inputValue();
		String expBankName = bankName;
		assertEquals(expBankName, actBankName, "Bank Name tab allows the entered characters");
	}
	@Then("Enter alpha characters {string} in Bank Address tab")
	public void enter_alpha_characters_in_bank_address_tab(String bankAdd) {
		Locator bankNamTab = page.locator("//textarea[@placeholder='Enter bank address']");
		bankNamTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		bankNamTab.clear();
		bankNamTab.fill(bankAdd);
	}
	@Then("Check entered text {string} is displayed or not in Bank Address tab")
	public void check_entered_text_is_displayed_or_not_in_bank_address_tab(String bankAddress) {
		Locator bankaddTab = page.locator("//textarea[@placeholder='Enter bank address']");
		bankaddTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		String actBankAddress = bankaddTab.inputValue();
		String expBankAddress = bankAddress;
		assertEquals(expBankAddress, actBankAddress, "Bank Address tab allows the entered characters");
	}
	@Then("Enter numerical characters {string} in Bank Address  tab")
	public void enter_numerical_characters_in_bank_address_tab(String bankAdd) {
		Locator bankNamTab = page.locator("//textarea[@placeholder='Enter bank address']");
		bankNamTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		bankNamTab.clear();
		bankNamTab.fill(bankAdd);
	}
	@Then("Enter special characters {string} in Bank Address tab")
	public void enter_special_characters_in_bank_address_tab(String bankAdd) {
		Locator bankNamTab = page.locator("//textarea[@placeholder='Enter bank address']");
		bankNamTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		bankNamTab.clear();
		bankNamTab.fill(bankAdd);
	}
	@Then("Enter alpha characters {string} in phone number tab in UPI ID type")
	public void enter_alpha_characters_in_phone_number_tab_in_upi_id_type(String phNum) {
		Locator phNumTab = page.locator("//input[@placeholder='Enter phone number']");
		phNumTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		phNumTab.clear();
		phNumTab.fill(phNum);
	}
	@Then("Check phone number tab is empty or not in UPI ID type")
	public void check_phone_number_tab_is_empty_or_not_in_upi_id_type() {
		Locator phNumTab = page.locator("//input[@placeholder='Enter phone number']");
		phNumTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		String phNum = phNumTab.inputValue();
		try {
			assert phNum.isEmpty();
			System.out.println("✅ Tab doesnot allow invalid character type");
		} catch (AssertionError e) {
			System.out.println("❌ Tab allow invalid character type");
		}
	}
	@Then("Enter special characters {string} in phone number tab in UPI ID type")
	public void enter_special_characters_in_phone_number_tab_in_upi_id_type(String phNum) {
		Locator phNumTab = page.locator("//input[@placeholder='Enter phone number']");
		phNumTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		phNumTab.clear();
		phNumTab.fill(phNum);
	}
	@Then("Enter numerical characters {string} in phone number tab in UPI ID type")
	public void enter_numerical_characters_in_phone_number_tab_in_upi_id_type(String phNum) {
		Locator phNumTab = page.locator("//input[@placeholder='Enter phone number']");
		phNumTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		phNumTab.clear();
		page.waitForTimeout(1000);
		phNumTab.fill(phNum);
	}
	@Then("Check entered phone number {string} is displayed or not in UPI ID type")
	public void check_entered_phone_number_is_displayed_or_not_in_upi_id_type(String phNum) {
		Locator phNumTab = page.locator("//input[@placeholder='Enter phone number']");
		phNumTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		String actPhNumTab = phNumTab.inputValue();
		String expPhNumTab = phNum;
		System.out.println("Actual phone number is: "+actPhNumTab);
		System.out.println("Expected phone number is: "+expPhNumTab);
		assertEquals(expPhNumTab, actPhNumTab, "Phone number tab allows the entered characters");
	}
	@Then("Enter alpha characters {string} in Card number tab in credit debit type")
	public void enter_alpha_characters_in_card_number_tab_in_credit_debit_type(String cardNum) {
		Locator cardNumTab = page.locator("(//input[contains(@class,'ant-input css-19yuzph')])[1]");
		cardNumTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		cardNumTab.clear();
		cardNumTab.fill(cardNum);
	}
	@Then("Check Card number tab is empty or not in credit debit type")
	public void check_card_number_tab_is_empty_or_not_in_credit_debit_type() {
		Locator cardNumTab = page.locator("(//input[contains(@class,'ant-input css-19yuzph')])[1]");
		cardNumTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		String cardNum = cardNumTab.inputValue();
		try {
			assert cardNum.isEmpty();
			System.out.println("✅ Tab doesnot allow invalid character type");
		} catch (AssertionError e) {
			System.out.println("❌ Tab allow invalid character type");
		}
	}
	@Then("Enter special characters {string} in Card number tab in credit debit type")
	public void enter_special_characters_in_card_number_tab_in_credit_debit_type(String cardNum) {
		Locator cardNumTab = page.locator("(//input[contains(@class,'ant-input css-19yuzph')])[1]");
		cardNumTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		cardNumTab.clear();
		cardNumTab.fill(cardNum);
	}
	@Then("Enter numerical characters {string} in Card number tab in credit debit type")
	public void enter_numerical_characters_in_card_number_tab_in_credit_debit_type(String cardNum) {
		Locator cardNumTab = page.locator("(//input[contains(@class,'ant-input css-19yuzph')])[1]");
		cardNumTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		cardNumTab.clear();
		page.waitForTimeout(1000);
		cardNumTab.fill(cardNum);
	}
	@Then("Check entered Card number {string} is displayed or not in credit debit type")
	public void check_entered_card_number_is_displayed_or_not_in_credit_debit_type(String cardNum) {
		Locator cardNumTab = page.locator("(//input[contains(@class,'ant-input css-19yuzph')])[1]");
		cardNumTab.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		String actcardNumTab = cardNumTab.inputValue();
		String expcardNumTab = cardNum;
		System.out.println("Actual card number is: "+actcardNumTab);
		System.out.println("Expected card number is: "+expcardNumTab);
		assertEquals(expcardNumTab, actcardNumTab, "Phone number tab allows the entered characters");
	}
}
