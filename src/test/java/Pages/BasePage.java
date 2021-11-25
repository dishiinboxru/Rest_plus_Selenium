package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    private WebDriver driver;

    //Page URL
    final static String petstoreUrl="http://petstore.swagger.io/";

    //Locators
    @FindBy(how = How.XPATH, using = "/html/body/div/section/div[2]/div[2]/div[4]/section/div/span[1]/div/div/div/span[2]/div/div[1]/button[1]/span[1]")
    private WebElement postPet;

    public BasePage(WebDriver driver){
        this.driver=driver;
        driver.get(petstoreUrl);
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddPet(){
        postPet.click();
    }

}
