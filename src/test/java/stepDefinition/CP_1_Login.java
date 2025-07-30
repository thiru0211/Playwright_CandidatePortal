package stepDefinition;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Response;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CP_1_Login {
	public Page page;
	public Browser browser;
	public Playwright playwright;

	@Given("To Check Login user is navigating to Candidate Portal URL is {string}")
	public void to_check_login_user_is_navigating_to_candidate_portal_url_is(String url) {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();

		System.out.println("Screen size is: " + width + ":" + height);
		playwright = Playwright.create();

		browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));

//		Browser browser =playwright.firefox().launch(
//				new LaunchOptions().setHeadless(false)
//				);

//		Browser browser =playwright.webkit().launch(
//				new LaunchOptions().setHeadless(false)
//				);

//		page = browser.newPage();
		BrowserContext browserContext = browser
				.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		page = browserContext.newPage();
		page.navigate(url);
	}

	@When("To Check Login Enter username and password are {string} and {string}")
	public void to_check_login_enter_username_and_password_are_and(String email, String passWord) {
		String title = page.url();
		System.out.println("Current page title is: " + title);
		Locator emailId = page.getByPlaceholder("Enter your Email");
		emailId.fill(email);
		Locator password = page.getByPlaceholder("Enter your Password");
		password.fill(passWord);
	}

	@When("Click the Login button To Check Login")
	public void click_the_login_button_to_check_login() {
		Locator loginBtn = page.locator("//button[contains(@class,'mb-1 btn')]");
		loginBtn.click();
	}

	@Then("Check display homepage or not To Check Login")
	public void check_display_homepage_or_not_to_check_login() {
		Locator userLogoBtn = page.locator("//span[contains(@class,'ant-avatar ant-avatar-circle')]");
		userLogoBtn.waitFor(new Locator.WaitForOptions().setTimeout(25000));
		assertThat(userLogoBtn).isVisible();
		System.out.println("Dashboard is displayed successfully!!!");
	}

	@Then("Close Login page")
	public void close_login_page() {
		page.close();
		browser.close();
		playwright.close();
	}

	@Then("Click User logo button in Top right corner")
	public void click_user_logo_button_in_top_right_corner() {
		Locator userLogoBtn = page.locator("//span[contains(@class,'ant-avatar ant-avatar-circle')]");
		userLogoBtn.waitFor(new Locator.WaitForOptions().setTimeout(25000));
		userLogoBtn.click();
	}

	@Then("Click SignOut button")
	public void click_sign_out_button() {
		Locator logOutBtn = page.locator("//spn[normalize-space(text())='Logout']");
		logOutBtn.click();
	}

	@Then("Check login page is displayed or not using assert")
	public void check_login_page_is_displayed_or_not_using_assert() {
		Locator emailId = page.getByPlaceholder("Enter your Email");
		assertThat(emailId).isVisible();
		System.out.println("Logged out successfully!!!");
	}

	@When("To Check Login Enter Invalid username and valid password are {string} and {string}")
	public void to_check_login_enter_invalid_username_and_valid_password_are_and(String email, String passWord) {
		Locator emailId = page.getByPlaceholder("Enter your Email");
		emailId.fill(email);
		Locator password = page.getByPlaceholder("Enter your Password");
		password.fill(passWord);
	}

	@Then("Check alert message is displayed or not in email tab")
	public void check_alert_message_is_displayed_or_not_in_email_tab() {
		Locator errMsg = page.locator("(//div[contains(@class,'col-sm-12 col-md-9')]//label)[2]");
		assertThat(errMsg).isVisible();
		String errMsgText = errMsg.textContent();
		System.out.println("Error Message displayed like: " + errMsgText);
	}

	@When("To Check Login Enter valid username and Invalid password are {string} and {string}")
	public void to_check_login_enter_valid_username_and_invalid_password_are_and(String email, String passWord) {
		Locator emailId = page.getByPlaceholder("Enter your Email");
		emailId.fill(email);
		Locator password = page.getByPlaceholder("Enter your Password");
		password.fill(passWord);
	}

	@Then("Check alert message is displayed or not in password tab")
	public void check_alert_message_is_displayed_or_not_in_password_tab() {
		Locator errMsg = page.locator(
				"//div[contains(@class,'MuiFormControl-root MuiFormControl-fullWidth')]/following-sibling::label[1]");
		assertThat(errMsg).isVisible();
		String errMsgText = errMsg.textContent();
		System.out.println("Error Message displayed like: " + errMsgText);
	}

	@When("To Check Login Enter Invalid username and Invalid password are {string} and {string}")
	public void to_check_login_enter_invalid_username_and_invalid_password_are_and(String email, String passWord) {
		Locator emailId = page.getByPlaceholder("Enter your Email");
		emailId.fill(email);
		Locator password = page.getByPlaceholder("Enter your Password");
		password.fill(passWord);
	}

	@When("To Check Login Enter username only {string}")
	public void to_check_login_enter_username_only(String email) {
		Locator emailId = page.getByPlaceholder("Enter your Email");
		emailId.fill(email);
	}

	@When("To Check Login Enter password only {string}")
	public void to_check_login_enter_password_only(String passWord) {
		Locator password = page.getByPlaceholder("Enter your Password");
		password.fill(passWord);
	}

	@When("Without enter email id click Forget password button")
	public void without_enter_email_id_click_forget_password_button() {
		Locator frgtPwdBtn = page.locator("(//span[@class='d-flex justify-content-between']//label)[2]");
		frgtPwdBtn.click();
	}

	@When("To Check Forget Password Enter valid email id {string}")
	public void to_check_forget_password_enter_valid_email_id(String email) {
		Locator emailId = page.getByPlaceholder("Enter your Email");
		emailId.fill(email);
	}

	@When("click Forget password button")
	public void click_forget_password_button() {
		Locator frgtPwdBtn = page.locator("(//span[@class='d-flex justify-content-between']//label)[2]");
		frgtPwdBtn.click();
	}

	@Then("Check verification page is displayed or not in forgot password page")
	public void check_verification_page_is_displayed_or_not_in_forgot_password_page() {
		Locator verifyMsg = page.locator("//h3[normalize-space(text())='Verify Your Identity']");
		assertThat(verifyMsg).isVisible();
	}

	@When("Enter username and password are {string} and {string}")
	public void enter_username_and_password_are_and(String string, String email) {
		Locator emailId = page.getByPlaceholder("Enter your Email");
		emailId.fill(email);
	}

	@When("Enter valid username and valid password are {string} and {string}")
	public void enter_valid_username_and_valid_password_are_and(String email, String passWord) {
		Locator emailId = page.getByPlaceholder("Enter your Email");
		emailId.fill(email);
		Locator password = page.getByPlaceholder("Enter your Password");
		password.fill(passWord);
	}

	@When("Press ENTER button")
	public void press_enter_button() {
		Locator password = page.getByPlaceholder("Enter your Password");
		password.press("Enter");
	}

	@Then("Check landing page after press Enter button")
	public void check_landing_page_after_press_enter_button() {
		Locator userLogoBtn = page.locator("//span[contains(@class,'ant-avatar ant-avatar-circle')]");
		userLogoBtn.waitFor(new Locator.WaitForOptions().setTimeout(25000));
		assertThat(userLogoBtn).isVisible();
		System.out.println("Dashboard is displayed successfully!!!");
	}
	@Then("Check the landing page using assert function")
	public void check_the_landing_page_using_assert_function() {
		Locator twoFAVerifyText = page.locator("//div[@class='two-factor-container']//h4[1]");
		assertThat(twoFAVerifyText).isVisible();
		System.out.println("Two-Factor Authentication is displayed successfully!!!");
	}
	
//	@Then("Enter two fa code in the verification page")
//	public void enter_two_fa_code_in_the_verification_page() {
//		 page.onResponse(response -> {
//		        if (response.url().contains("/candidateGenerateAndSendToken") && response.status() == 200) {
//		            String body = response.text();
//		            Matcher matcher = Pattern.compile("\"code\"\\s*:\\s*\"(\\d{6})\"").matcher(body);
//		            if (matcher.find()) {
//		                String otp = matcher.group(1);
//		                System.out.println("OTP found: " + otp);
//
//		                // Fill and submit OTP
//		                page.getByPlaceholder("Enter verification code").fill(otp);
//		                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Verify")).click();
//
//		                // Optional: Remove listener after success
//		                page.offResponse(this); // `this` works only if wrapped in a named class, else use a ref
//		            }
//		        }
//		    });
//
//		    // ✅ Trigger the action that sends the OTP
//		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click(); 
//		}
	
	}