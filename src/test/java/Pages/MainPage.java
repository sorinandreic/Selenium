package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "/html/body/div/div/div/div[2]/div/div/div/div[3]/div[2]/div[2]/button")
    private WebElement addToCartBoltTshirtBtn;
    public void pressAddToCartBoltTshirtBtn(){
        addToCartBoltTshirtBtn.click();
    }
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[1]/div[3]/a")
    private WebElement cartBtn;
    public void pressCartBtn(){
        cartBtn.click();
    }
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[1]/div[2]/div")
    private WebElement swagLabsLogo;
    public void swagLabsLogoIsDisplayed(){
        swagLabsLogo.isDisplayed();
    }
    @FindBy(xpath = "/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div")
    private WebElement itemPrice;
    public String getItemPrice(){
        itemPrice.getText();
        return null;
    }

}
