package core;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AppPageFactory1 {

	static String text_case_id_01 = "TC-001.01";
	// String text_case_id_02 = "TC-001.02";
	// String text_case_id_03 = "TC-001.03";
	// String text_case_id_04 = "TC-001.04";
	// String text_case_id_05 = "TC-001.05";
	static String url = "http://alex.academy/exercises/signup/v1/";
	// String title_sign_up_expected = "Welcome to Sign Up";
	// String title_facebook_expected = "Welcome to Facebook - Log In, Sign Up
	// or Learn More";
	// String error_fname_empty_expected = "Please enter First Name";
	// String fname = "Alex";
	// String lname = "Viktor";
	// String email = "viktor-alexander@gmail.com";
	// String phone = "415 555-0000";

	// @FindBy(how=How.XPATH, using = )
	@FindBy(how = How.ID, using = "id_quotes")
	@CacheLookup
	static WebElement quotes_field;

	public static void main(String[] args) {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"C:/workspace47/JSON_API/src/main/resources/browsers/pc/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("-start-fullscreen");
		driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);

		driver.get(url);

		PageFactory.initElements(driver, AppPageFactory1.class);

		// TC-001.01 verify_content_quotes
		String quote = quotes_field.getText();

		if (quote != null && quote.length() < 103 && quote.length() > 36) {
			System.out.println("Test Case ID:\t\t" + text_case_id_01 + " - PASSED");
			System.out.println("Quote length:\t\t" + quote.length());
			System.out.println("=======================================");
		} else {
			System.out.println("Test Case ID: \t\t" + text_case_id_01 + " - FAILED");
			System.out.println("Quote length: " + quote.length());
			System.out.println("=======================================");
		}
		driver.quit();

	}
}
