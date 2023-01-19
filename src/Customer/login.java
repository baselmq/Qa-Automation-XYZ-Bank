package Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class login extends Parameters {

	@Test(priority = 1)
	public void LoginAsCustomer() {

		driver.get(HomePage);

		WebElement CustomerLoginButton = driver
				.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button"));

		CustomerLoginButton.click();

		WebElement TheSelectWebElementforTheCustomer = driver.findElement(By.xpath("//*[@id=\"userSelect\"]"));

		Select CustomerSelect = new Select(TheSelectWebElementforTheCustomer);

		CustomerSelect.selectByVisibleText(Theuser);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button")).click();

		String ActualText = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/strong/span")).getText();

		myAssertion.assertEquals(ActualText, Theuser);

		myAssertion.assertAll();

	}

	@Test(priority = 3)
	public void Withdraw_invalid_amount() {
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"))
				.sendKeys(TheAmountToWithdraw);

		String Balance = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]")).getText();
		int BalanceASInt = Integer.parseInt(Balance);
		int TheAmountToWithdrawAsInt = Integer.parseInt(TheAmountToWithdraw);

		if (BalanceASInt < TheAmountToWithdrawAsInt) {
			myAssertion.assertEquals(BalanceASInt < TheAmountToWithdrawAsInt, true);
			myAssertion.assertAll();
		}

	}

	@Test(priority = 2)
	public void AddingAmount() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")).click();

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"))
				.sendKeys(TheAmountToAdd);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
		Thread.sleep(3000);

		String theMessageThatIHaveAddedSuccessfully = driver
				.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span")).getText();
		myAssertion.assertEquals(theMessageThatIHaveAddedSuccessfully.contains("Successful"), true);
		myAssertion.assertAll();

	}
}
