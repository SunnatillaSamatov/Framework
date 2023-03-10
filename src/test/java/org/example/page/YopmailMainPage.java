package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YopmailMainPage extends AbstractPage{

    private final String BASE_URL = "https://yopmail.com/";
    @FindBy(xpath = "//*[@id='listeliens']/a[1]")
    private WebElement randomMailGeneratorButton;
    public YopmailMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public YopmailMainPage openPage() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(BASE_URL);
        return this;
    }

    public YopmailGeneratorPage generateEmail(){
        randomMailGeneratorButton.click();
        return new YopmailGeneratorPage(driver);
    }


}
