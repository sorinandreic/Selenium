package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "/html/body/div/div/div/div[2]/div/div[2]/button[2]")
    private WebElement checkoutBtn;
    public void clickCheckoutBtn(){
        checkoutBtn.click();
    }
}
