package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddPetPage {
    private WebDriver driver;

    @FindAll({@FindBy(how = How.NAME, using = "Try it out"),
            @FindBy(how = How.XPATH, using = "/html/body/div/section/div[2]/div[2]/div[4]/section/div/span[1]/div/div/div/span[2]/div/div[2]/div/div[1]/div[1]/div[2]/button")})
    private WebElement tryPost;

    @FindBy(how = How.XPATH, using = "/html/body/div/section/div[2]/div[2]/div[4]/section/div/span[1]/div/div/div/span[2]/div/div[2]/div/div[1]/div[2]/div/table/tbody/tr/td[2]/div[2]/div/div/textarea")
    private WebElement bodyText;

    @FindBy(how = How.XPATH, using = "/html/body/div/section/div[2]/div[2]/div[4]/section/div/span[1]/div/div/div/span[2]/div/div[2]/div/div[2]/button")
    private WebElement executeButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/section/div[2]/div[2]/div[4]/section/div/span[1]/div/div/div/span[2]/div/div[2]/div/div[3]/div[2]/div/div/table/tbody/tr/td[1]")
    private WebElement responseCode;


    //Constructor
    public AddPetPage(WebDriver driver){
        this.driver=driver;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void clickOnTry(){
        tryPost.click();
    }

    public void sendPetText ( String jsonBody){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        bodyText.clear();
        bodyText.sendKeys(jsonBody);
        js.executeScript("window.scrollBy(0,100)", "");

        executeButton.click();
    }

    public int getResponseCode(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", responseCode);
        return Integer.parseInt(responseCode.getText().substring(0,3));
    }
}
