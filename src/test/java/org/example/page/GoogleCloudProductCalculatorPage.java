package org.example.page;

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

    private final String PAGE_URL="https://cloud.google.com/products/calculator";

    @FindBy(xpath="//*[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement primaryIframe;
    @FindBy(xpath="//iframe[@id='myFrame']")
    private WebElement secondaryIframe;
    @FindBy(xpath="//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement instances;
    @FindBy(xpath = "//md-select[@placeholder='Series' and @name='series']")
    private WebElement series;
    @FindBy(xpath = "//md-option[@value='n1']/div[@class='md-text ng-binding']")
    private WebElement seriesTextValue;

    @FindBy(xpath ="//md-select[@placeholder='Instance type']")
    private WebElement machineType ;
    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']/div[@class='md-text ng-binding']")
    private WebElement machineTextValue;
    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']" )
    private WebElement gpuCheckbox ;
    @FindBy(xpath = "//md-select[@placeholder='GPU type' and @aria-label='GPU type']")
    private WebElement gpuType ;
    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']/div[@class='md-text ng-binding']")
    private WebElement gpuTextValue;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']" )
    private WebElement gpuNumber ;
    @FindBy(xpath = "//md-option[@ng-disabled='item.value != 0 && item.value < listingCtrl.minGPU' and @value='1']/div[@class='md-text ng-binding']")
    private WebElement gpuNumberTextValue;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']" )
    private WebElement localSSD ;
    @FindBy(xpath = "//md-option[@ng-repeat='item in listingCtrl.dynamicSsd.computeServer' and @value='2']/div[@class='md-text ng-binding']")
    private WebElement localSSDTextValue;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement dataCenterLocation ;
    @FindBy(xpath = "//md-option[@ng-repeat='item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer' and @value='europe-west3']/div[@class='md-text ng-binding']")
    private WebElement dataCenterLocationTextValue;
    @FindBy(xpath = "//md-select[@placeholder='Committed usage' and @aria-label='Committed usage: None']" )
    private WebElement committedUsage ;
    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option[@ng-value='1']/div[@class='md-text']")
    private WebElement committedUsageTextValue;
    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
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
        WebElement seriesLiteral = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(seriesTextValue));
        checkWebElementTextAndGetItsParent(seriesLiteral,engine.getSeries()).click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(machineType)).click();
        WebElement machineTypeLiteral = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(machineTextValue));
        checkWebElementTextAndGetItsParent(machineTypeLiteral,engine.getMachineType()).click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(gpuCheckbox)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(gpuType)).click();
        WebElement gpuLiteral = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(gpuTextValue));
        checkWebElementTextAndGetItsParent(gpuLiteral,engine.getGpuModel()).click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(gpuNumber)).click();
        WebElement gpuNumberLiteral = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(gpuNumberTextValue));
        checkWebElementTextAndGetItsParent(gpuNumberLiteral,engine.getGpuNumber()).click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(localSSD)).click();
        WebElement localSSDLiteral = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(localSSDTextValue));
        checkWebElementTextAndGetItsParent(localSSDLiteral,engine.getLocalSSD()).click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(dataCenterLocation)).click();
        WebElement dataCenterLocationLiteral = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(dataCenterLocationTextValue));
        checkWebElementTextAndGetItsParent(dataCenterLocationLiteral, engine.getDataCenterLocation()).click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(committedUsage)).click();
        WebElement committedUsageLiteral = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(committedUsageTextValue));
        checkWebElementTextAndGetItsParent(committedUsageLiteral,engine.getCommittedUsage()).click();

        addToEstimateButton.click();
        emailEstimateButton.click();

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

    private WebElement checkWebElementTextAndGetItsParent(WebElement webElement, String engineItem){
        if(webElement.getText().equals(engineItem)){
            return webElement.findElement(By.xpath("./.."));
        }else {
            return null;
        }
    }

}
