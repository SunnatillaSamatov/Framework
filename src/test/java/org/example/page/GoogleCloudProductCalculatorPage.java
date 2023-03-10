package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.ComputeEngine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;


public class GoogleCloudProductCalculatorPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL="https://cloud.google.com/products/calculator";

    @FindBy(xpath="//*[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement primaryIframe;
    @FindBy(xpath="//iframe[@id='myFrame']")
    private WebElement secondaryIframe;
    @FindBy(xpath="//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement instances;
    @FindBy(xpath = "//md-select[@placeholder='Series' and @name='series']")
    private WebElement series;

    @FindBy(xpath ="//md-select[@placeholder='Instance type']")
    private WebElement machineType ;
    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']" )
    private WebElement gpuCheckbox ;
    @FindBy(xpath = "//md-select[@placeholder='GPU type' and @aria-label='GPU type']")
    private WebElement gpuType ;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']" )
    private WebElement gpuNumber ;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']" )
    private WebElement localSSD ;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement dataCenterLocation ;
    @FindBy(xpath = "//md-select[@placeholder='Committed usage' and @aria-label='Committed usage: None']" )
    private WebElement committedUsage ;
    @FindBy(xpath = "//*[@id='mainForm']/div[2]/div/md-card/md-card-content/div/div[1]/form/div[20]/button")
    private WebElement addToEstimateButton ;
    @FindBy(xpath = "//*[@id='Email Estimate']")
    private WebElement emailEstimateButton ;
    @FindBy(xpath = "//div[@class='cpc-cart-total']/h2[@class='md-title']/b")
    private WebElement cost ;
    @FindBy(xpath = "//input[@name='description' and @type='email']")
    private WebElement userEmail ;
    @FindBy(xpath = "//md-dialog[@aria-label='Email Estiamte']/form/md-dialog-actions/button[2]")
    private WebElement sendButton ;

    public GoogleCloudProductCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    protected GoogleCloudProductCalculatorPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("ProductCalculator page opened");
        return this;
    }

    public void switchToIframe(){
        driver.switchTo().frame(primaryIframe);
        driver.switchTo().frame(secondaryIframe);

    }

    public GoogleCloudProductCalculatorPage fillTechnicalForm(ComputeEngine engine){
        switchToIframe();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(instances)).sendKeys(engine.getInstances());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(series)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(engine.getSeries()))).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(machineType)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(engine.getMachineType()))).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(gpuCheckbox)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(gpuType)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(engine.getGpuModel()))).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(gpuNumber)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(engine.getGpuNumber()))).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(localSSD)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(engine.getLocalSSD()))).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(dataCenterLocation)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(engine.getDataCenterLocation()))).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(committedUsage)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(engine.getCommittedUsage()))).click();
        addToEstimateButton.click();
        emailEstimateButton.click();
        logger.info("Technical form is filled on the ProductCalculator page");
        return this;
    }

    public String getMonthlyCostInfo(){
        return cost.getText();
    }


    public GoogleCloudProductCalculatorPage goToGoogleCloudProductCalculatorPageTab(){
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(0));
        switchToIframe();
        return this;
    }

    public GoogleCloudProductCalculatorPage sendMonthlyCostToEmail(String email){
        userEmail.sendKeys(email);
        sendButton.click();

        return this;
    }

}
