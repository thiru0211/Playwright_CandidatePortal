package base;

import com.microsoft.playwright.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseSetup {

	private static Playwright playwright;
	private static Browser browser;
	private static Page page;

	@Before(order = 1)
	public void setUp() {
		System.out.println("✅ BaseSetup @Before hook executed");
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
	}

	@After(order = 1)
	public void tearDown() {
		System.out.println("Closing browser and Playwright...");
		if (page != null) {
			page.close();
			System.out.println("🔒 Page closed.");
		}

		if (browser != null) {
			browser.close();
			System.out.println("🔒 Browser closed.");
		}

		if (playwright != null) {
			playwright.close();
			System.out.println("🔒 Playwright closed.");
		}
	}

	public static Page getPage() {
		return page;
	}
}
