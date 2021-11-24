import Pages.AddPetPage;
import Pages.BasePage;
import org.apache.http.HttpStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumTestClass {
    WebDriver driver;

    String jsonBody = "{\n" +
            "  \"id\": 444,\n" +
            "  \"category\": {\n" +
            "    \"id\": 0,\n" +
            "    \"name\": \"lucky\"\n" +
            "  },\n" +
            "  \"name\": \"doggie\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 0,\n" +
            "      \"name\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"available\"\n" +
            "}";

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
    //Initiating your chromedriver
        driver= new ChromeDriver();
    //Applied wait time
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //maximize window
        driver.manage().window().maximize();
    }

    @Test
    public void addPetTest(){

        BasePage basePage = new BasePage(driver);
        basePage.clickOnAddPet();

        //click on try
        AddPetPage addPetPage = new AddPetPage(driver);
        addPetPage.clickOnTry();
        //click on post

        addPetPage.sendPetText(jsonBody);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        //assert the success was received - ?

        Assert.assertEquals(addPetPage.getResponseCode(), HttpStatus.SC_OK);






    }

    @AfterTest(enabled = true)
    public void teardown(){
        //finish and close the driver - maybe to teardown
         driver.close();
    }

}