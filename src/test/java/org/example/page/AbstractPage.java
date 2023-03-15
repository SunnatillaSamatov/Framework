package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage
{
	protected WebDriver driver;

	protected abstract AbstractPage openPage();
	protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);

	protected AbstractPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public WebElement findWebElement(WebElement webElement){

		return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.elementToBeClickable(webElement));
	}

	public WebElement findWebElement(By webElementBy){

		return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.elementToBeClickable(webElementBy));
	}
}
