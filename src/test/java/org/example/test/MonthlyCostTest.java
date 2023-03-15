package org.example.test;



import org.example.model.ComputeEngine;
import org.example.page.GoogleCloudMainPage;
import org.example.page.GoogleCloudProductCalculatorPage;
import org.example.page.YopmailGeneratorPage;
import org.example.page.YopmailMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MonthlyCostTest extends CommonConditions {
    @Test
    public void testMonthlyCost(){

        Double expectedMonthlyCost = new GoogleCloudMainPage(driver)
                .openPage()
                .searchCalculator()
                .fillTechnicalForm()
                .getMonthlyCostInfo();


        String genaratedEmail = new YopmailMainPage(driver)
                 .openPage()
                 .generateEmail()
                 .getGeneratedEamil();

        GoogleCloudProductCalculatorPage productCalculatorPage = new GoogleCloudProductCalculatorPage(driver)
                .goToGoogleCloudProductCalculatorPageTab()
                .sendMonthlyCostToEmail(genaratedEmail);

        Double actualMonthlyCost = new YopmailGeneratorPage(driver)
                .goToYopmailGeneratorTab()
                .getMonthlyCostFromInbox();


        Assert.assertEquals(actualMonthlyCost,expectedMonthlyCost);



    }

}
