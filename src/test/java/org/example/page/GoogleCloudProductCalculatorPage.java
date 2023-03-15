package org.example.page;

import org.example.model.ComputeEngine;
import org.example.service.ComputeEngineCreator;
import org.example.utils.StringUtils;
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
    private ComputeEngine engine = ComputeEngineCreator.withInputsFromProperty();

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
    private By seriesValueBy = By.xpath("//md-option[@value='" + engine.getSeries().toLowerCase() + "']");

    private By machineValueBy = By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-" + StringUtils.getFirstPart(engine.getMachineType()) +"']");

    private By gpuValueBy = By.xpath("//md-option[@value='" + StringUtils.replaceSpaceToUnderscore(engine.getGpuModel()) + "']");

    private By gpuNumberValueBy = By.xpath("//md-option[@ng-disabled='item.value != 0 && item.value < listingCtrl.minGPU' and @value='"+engine.getGpuNumber()+"']");

    private By localSSDValueBy = By.xpath( "//md-option[@ng-repeat='item in listingCtrl.dynamicSsd.computeServer' and @value='"+StringUtils.getFirstNumber(engine.getLocalSSD())+"']");

    private By dataCenterLocationValueBy = By.xpath("//md-option[@ng-repeat='item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer' and @value='"+ StringUtils.getInsideParentheses(engine.getDataCenterLocation())+ "']");

    private By committedUsageValueBy = By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option[@value='"+StringUtils.getFirstPart(engine.getCommittedUsage())+"']");
                                                             //div[@class="md-select-menu-container md-active md-clickable"]/md-select-menu/md-content/md-option[@value="1"]

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

    public GoogleCloudProductCalculatorPage fillTechnicalForm(){
        switchToIframe();

        findWebElement(instances).sendKeys(engine.getInstances());

        findWebElement(series).click();

        findWebElement(seriesValueBy).click();

        findWebElement(machineType).click();

        findWebElement(machineValueBy).click();

        findWebElement(gpuCheckbox).click();

        findWebElement(gpuType).click();

        findWebElement(gpuValueBy).click();

        findWebElement(gpuNumber).click();

        findWebElement(gpuNumberValueBy).click();

        findWebElement(localSSD).click();

        findWebElement(localSSDValueBy).click();

        findWebElement(dataCenterLocation).click();

        findWebElement(dataCenterLocationValueBy).click();

        findWebElement(committedUsage).click();

        findWebElement(committedUsageValueBy).click();

        addToEstimateButton.click();
        emailEstimateButton.click();

        return this;
    }

    public Double getMonthlyCostInfo(){
        return StringUtils.getMonthlyCost(cost.getText());
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
