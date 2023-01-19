package Manager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class login extends Parameters {

	@Test(priority = 1)
	public void LoginAsManager() {

		driver.get(HomePage);

		WebElement ManagerLoginBtn = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button"));

		ManagerLoginBtn.click();
	}

	@Test(priority = 2)
	public void AddCustomer() {
		WebElement AddCustomerBtn = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]"));

		AddCustomerBtn.click();

		WebElement AddFirstName = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/div[1]/input"));

		AddFirstName.sendKeys(FirstName);

		WebElement AddLastName = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/div[2]/input"));

		AddLastName.sendKeys(LastName);

		WebElement AddPostCode = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/div[3]/input"));

		AddPostCode.sendKeys(PostalCodeString);

		WebElement SendAddCustomerBtn = driver
				.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button"));

		SendAddCustomerBtn.click();

		String textAlert = driver.switchTo().alert().getText();

		boolean myCheck = textAlert.contains("successfully");

		driver.switchTo().alert().accept();
		myAssertion.assertEquals(myCheck, true);
		myAssertion.assertAll();

	}

	@Test(priority = 3)
	public void OpenAccount() {
		WebElement OpenAccountBtn = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]"));

		OpenAccountBtn.click();

		WebElement SelectCustomer = driver.findElement(By.xpath("//*[@id=\"userSelect\"]"));

		Select CustomerSelect = new Select(SelectCustomer);

		CustomerSelect.selectByVisibleText(FirstName + " " + LastName);

		WebElement SelectCurrency = driver.findElement(By.xpath("//*[@id=\"currency\"]"));

		Select CurrencySelect = new Select(SelectCurrency);

		CurrencySelect.selectByVisibleText(Currency);

		WebElement ProcessBtn = driver
				.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button"));

		ProcessBtn.click();

		String AlertOpenAccount = driver.switchTo().alert().getText();

		boolean checkMsgOpenAccount = AlertOpenAccount.contains("successfully");
		driver.switchTo().alert().accept();
		myAssertion.assertEquals(checkMsgOpenAccount, true);
		myAssertion.assertAll();

	}

	@Test(priority = 4)
	public void CustomersTable() {
		WebElement CustomersBtn = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]"));

		CustomersBtn.click();

		WebElement SearchCustomer = driver
				.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input"));

		SearchCustomer.sendKeys(CustomerName);

	List<WebElement> myUsers = driver.findElements(By.xpath("//tbody/tr"));
		
		int myActualUsers = myUsers.size();

		myAssertion.assertEquals(myActualUsers, 1);

		myAssertion.assertAll();
		
		

	}

}
