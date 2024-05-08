package Steps;

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
    @AfterStep
    public void afterStep() throws InterruptedException {
        Thread.sleep(1000);
    }


    WebDriver driver = new ChromeDriver();

    @Given("user navigates to the main page")
    public void user_is_on_the_main_page() {
        driver.get("https://www.saucedemo.com");
    }

    @And("the user enters a valid username and password")
    public void the_user_insert_username_and_password() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("user clicks on Login button")
    public void user_click_on_Login() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("the user is logged in successfully")
    public void theUserIsLoggedIn() {
        boolean loggedIn = driver.findElement(By.className("inventory_item")).isDisplayed();
        assert (loggedIn);
        driver.quit();

    }
    @Then("the user is logged in")
    public void userLogIn() {
        boolean loggedIn = driver.findElement(By.className("inventory_item")).isDisplayed();
        assert (loggedIn);
    }

    @And("the user adds a product to cart")
    public void addItemsToCart() {
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[3]/div[2]/div[2]/button")).click();
        WebElement cartBadge = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a/span"));
        int cartBadgeInt = Integer.parseInt(cartBadge.getText());
        Assert.assertEquals(cartBadgeInt, 1);
    }

    @And("verifies that the desired quantity of products is added to the cart")
    public void checkCartQty() {
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
        WebElement cartQty = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[1]"));
        int cartQtyInt = Integer.parseInt(cartQty.getText());
        Assert.assertEquals(cartQtyInt, 1);
    }

    @When("the user proceed to checkout and fills all the billing data")
    public void theUserProceedToCheckoutAndFillsAllTheBillingData() {
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/button[2]")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input")).sendKeys("Zach");
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[2]/input")).sendKeys("Bryan");
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[3]/input")).sendKeys("040663");
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input")).click();
    }

    @And("verifies all the final details")
    public void verifiesAllTheFinalDetails() {
        WebElement cartQty = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[1]"));
        int cartQtyInt = Integer.parseInt(cartQty.getText());
        Assert.assertEquals(cartQtyInt, 1);

        WebElement itemPrice = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div"));
        WebElement finalItemPrice = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div"));
        Assert.assertEquals(itemPrice, finalItemPrice);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[9]/button[2]")).click();

    }

    @Then("the purchase is complete.")
    public void thePurchaseIsComplete() {
        boolean purchaseComplete = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/h2")).isDisplayed();

        driver.quit();
    }

}