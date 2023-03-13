package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GoogleCloudMainPage extends AbstractPage
{
	private final String BASE_URL = "https://cloud.google.com/";
	@FindBy(xpath="//input[@class='devsite-search-field devsite-search-query']")
	private WebElement searchBox;
	String searchItem ="Google Cloud Pricing Calculator";
	private By googleCloudCalculator = By.xpath("//a[b[contains(text(),'" + searchItem + "')]]");


	public GoogleCloudMainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}


	@Override
	public GoogleCloudMainPage openPage()
	{
		driver.navigate().to(BASE_URL);
		return this;
	}

	public GoogleCloudProductCalculatorPage searchCalculator(){
		searchBox.sendKeys("Google Cloud Platform Pricing Calculator");
		searchBox.sendKeys(Keys.ENTER);
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS )
				.until(ExpectedConditions.presenceOfElementLocated(googleCloudCalculator)).click();
		return new GoogleCloudProductCalculatorPage(driver);
	}

}
