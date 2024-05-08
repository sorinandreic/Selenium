package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input")
    private WebElement standardUsername;
    public void setStandardUsername(){
        standardUsername.sendKeys("standard_user");
    }
    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/form/div[2]/input")
    private WebElement globalPassword;
    public void setGlobalPassword(){
        globalPassword.sendKeys("secret_sauce");
    }
    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/form/input")
    private WebElement loginBtn;
            public void clickLoginBtn(){
        loginBtn.click();
            }
}
