package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input")
    private WebElement firstNameField;
            public void setFirstName(){
        firstNameField.sendKeys("Zach");
    }
    @FindBy(xpath = "/html/body/div/div/div/div[2]/div/form/div[1]/div[2]/input")
    private WebElement lastNameField;
            public void setLastName(){
                lastNameField.sendKeys("Bryan");
            }
            @FindBy(xpath = "/html/body/div/div/div/div[2]/div/form/div[1]/div[3]/input")
    private WebElement zipCodeField;
            public void setZipCode(){
                zipCodeField.sendKeys("040663");
            }
            @FindBy(xpath = "/html/body/div/div/div/div[2]/div/form/div[2]/input")
    private WebElement continueCheckoutBtn;
            public void clickContinueCheckoutBtn(){
                continueCheckoutBtn.click();
            }



}
