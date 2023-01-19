package Customer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameters {
	WebDriver driver = new ChromeDriver();

	String HomePage = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

	String Theuser = "Harry Potter";
	String TheAmountToWithdraw = "800";
	String TheAmountToAdd = "1000";

	SoftAssert myAssertion = new SoftAssert();

	@BeforeTest
	public void setup() {
		driver.get(HomePage);

		WebDriverManager.chromedriver().setup();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}
}
