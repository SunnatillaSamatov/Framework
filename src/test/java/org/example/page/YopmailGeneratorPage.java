package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;


public class YopmailGeneratorPage extends AbstractPage{

    private final String PAGE_URL = "https://yopmail.com/email-generator";

    private By emailBy = By.xpath("//*[@id='geny']/span[1]");

    private By inboxButton = By.xpath("/html/body/div/div[2]/main/div/div[2]/div/div[1]/div[2]/button[2]");

    private By refreshButton = By.xpath("//*[@id='refresh']");

    private By frame = By.xpath("//*[@id='ifmail']");

    private By inboxMessage = By.xpath("//*[@id='mail']/div/div/table/tbody/tr[2]/td/h2");


    public YopmailGeneratorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected YopmailGeneratorPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public String getGeneratedEamil(){
        WebElement generatedEmail = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(emailBy));
        return generatedEmail.getText()+"@yopmail.com";

    }

    public YopmailGeneratorPage goToYopmailGeneratorTab(){
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        return new YopmailGeneratorPage(driver);
    }
    public String getMonthlyCostFromInbox(){

        driver.findElement(inboxButton).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(refreshButton)).click();
        driver.switchTo().frame(driver.findElement(frame));
        WebElement message = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(inboxMessage));
        message.click();
        return message.getText();

    }
}
