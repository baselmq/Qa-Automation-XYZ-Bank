package Manager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameters {
	WebDriver driver = new ChromeDriver() ; 

	String HomePage = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

	String FirstName = "Basel" ;
	String LastName = "Qarqa" ;
	int PostalCodeRandomNumber = (int) (Math.random() * 10000);
	String PostalCodeString = Integer.toString(PostalCodeRandomNumber);
	String Currency = "Dollar";
	String CustomerName = "ahmad";


	SoftAssert myAssertion = new SoftAssert();

	@BeforeTest
	public void setup() {
		driver.get(HomePage);

		WebDriverManager.chromedriver().setup();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}
}
