package Steps;

import Pages.*;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemo {
    WebDriver driver = new ChromeDriver();
    MainPage mainPage;
    LoginPage loginPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutCompletePage checkoutCompletePage;


    @AfterStep
    public void afterStep() throws InterruptedException {
        Thread.sleep(1000);
    }

    public SauceDemo() {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @Given("user navigates to the main page")
    public void user_is_on_the_main_page() {
        driver.get("https://www.saucedemo.com");
    }

    @And("the user enters a valid username and password")
    public void the_user_insert_username_and_password() {
        loginPage.setStandardUsername();
        loginPage.setGlobalPassword();
    }

    @When("user clicks on Login button")
    public void user_click_on_Login() {
        loginPage.clickLoginBtn();
    }

    @Then("the user is logged in successfully")
    public void theUserIsLoggedIn() {
        mainPage.swagLabsLogoIsDisplayed();
        driver.quit();

    }

    @Then("the user is logged in")
    public void userLogIn() {
        mainPage.swagLabsLogoIsDisplayed();

    }

    @And("the user adds a product to cart")
    public void addItemsToCart() {
        mainPage.pressAddToCartBoltTshirtBtn();
        WebElement cartBadge = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a/span"));
        int cartBadgeInt = Integer.parseInt(cartBadge.getText());
        Assert.assertEquals(cartBadgeInt, 1);
    }

    @And("verifies that the desired quantity of products is added to the cart")
    public void checkCartQty() {
        mainPage.pressCartBtn();
        WebElement cartQty = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[1]"));
        int cartQtyInt = Integer.parseInt(cartQty.getText());
        Assert.assertEquals(cartQtyInt, 1);
    }

    @When("the user proceed to checkout and fills all the billing data")
    public void theUserProceedToCheckoutAndFillsAllTheBillingData() {
        cartPage.clickCheckoutBtn();
        checkoutPage.setFirstName();
        checkoutPage.setLastName();
        checkoutPage.setZipCode();
        checkoutPage.clickContinueCheckoutBtn();
    }

    @And("verifies all the final details")
    public void verifiesAllTheFinalDetails() {
        WebElement cartQty = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[1]"));
        int cartQtyInt = Integer.parseInt(cartQty.getText());
        Assert.assertEquals(cartQtyInt, 1);

       String itemPrice= mainPage.getItemPrice();
        String finalItemPrice = checkoutOverviewPage.getFinalItemPrice();
        Assert.assertEquals(itemPrice,finalItemPrice);
        checkoutOverviewPage.clickFinishBtn();
    }

    @Then("the purchase is complete.")
    public void thePurchaseIsComplete() {
checkoutCompletePage.thankYouMessageIsPresent();
        driver.quit();
    }

}