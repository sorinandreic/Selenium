package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {
    private WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div")
    private WebElement finalItemPrice;
    public String getFinalItemPrice(){
        finalItemPrice.getText();
        return null;
    }
    @FindBy(xpath = "/html/body/div/div/div/div[2]/div/div[2]/div[9]/button[2]")
    private WebElement finishBtn;
    public void clickFinishBtn(){
        finishBtn.click();
    }
}
