package org.example.test;



import org.example.model.ComputeEngine;
import org.example.page.GoogleCloudMainPage;
import org.example.page.GoogleCloudProductCalculatorPage;
import org.example.page.YopmailGeneratorPage;
import org.example.page.YopmailMainPage;
import org.example.service.ComputeEngineCreator;
import org.example.utils.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MonthlyCostTest extends CommonConditions {
    @Test
    public void testMonthlyCost(){
        ComputeEngine engine = ComputeEngineCreator.withInputsFromProperty();
        String rawMonthlyCost = new GoogleCloudMainPage(driver)
                .openPage()
                .searchCalculator()
                .fillTechnicalForm(engine)
                .getMonthlyCostInfo();

        Double expectedMonthlyCost = StringUtils.getMonthlyCost(rawMonthlyCost);


        String genaratedEmail = new YopmailMainPage(driver)
                 .openPage()
                 .generateEmail()
                 .getGeneratedEamil();

        GoogleCloudProductCalculatorPage productCalculatorPage = new GoogleCloudProductCalculatorPage(driver)
                .goToGoogleCloudProductCalculatorPageTab()
                .sendMonthlyCostToEmail(genaratedEmail);

        String rawMonthlyCostInbox = new YopmailGeneratorPage(driver)
                .goToYopmailGeneratorTab()
                .getMonthlyCostFromInbox();

        Double actualMonthlyCost = StringUtils.getMonthlyCost(rawMonthlyCostInbox);

        Assert.assertEquals(actualMonthlyCost,expectedMonthlyCost);




    }




}
