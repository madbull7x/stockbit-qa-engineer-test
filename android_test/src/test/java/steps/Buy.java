package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import setup.Capabilities;
import utils.General;

public class Buy extends Capabilities {

    @Before
    public void setup()throws Exception{
        preparation();
    }

    @Given("User already on catalog page")
    public void userAlreadyOnCatalogPage() {
        try {
            driver.findElement(By.xpath("//*[@text='Products']"));
            assert true;
        } catch (NoSuchElementException e) {
            assert false;
        }
    }

    @When("User select an item Sauce Lab Back Packs")
    public void userSelectAnItemSauceLabBackPacks() {
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Sauce Lab Back Packs']")).click();
    }

    @Then("User should see Product Highlights page")
    public void userShouldSeeProductHighlightsPage() {
        try {
            driver.findElement(By.xpath("//*[@content-desc='Displays selected product']"));
            assert true;
        } catch (NoSuchElementException e) {
            assert false;
        }
    }

    @When("User select the blue color")
    public void userSelectTheBlueColor() {
        driver.findElement(By.xpath("//*[@content-desc='Blue color']")).click();
    }

    @Then("User should see indicator when color is selected")
    public void userShouldSeeIndicatorWhenColorIsSelected() {
        try {
            driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Blue color']//preceding-sibling::*[@content-desc='Indicates when color is selected']"));
            assert true;
        } catch (NoSuchElementException e) {
            assert false;
        }
    }

    @When("User add one more item")
    public void userAddOneMoreItem() {
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Increase item quantity']")).click();
    }

    @And("Click on button Add to cart")
    public void clickOnButtonAddToCart() {
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Tap to add product to cart']")).click();
    }

    @Then("User should see number of items in their cart")
    public void userShouldSeeNumberOfItemsInTheirCart() {
        try {
            driver.findElement(By.xpath("//android.widget.RelativeLayout[@content-desc='Displays number of items in your cart']"));
            assert true;
        } catch (NoSuchElementException e) {
            assert false;
        }
    }

    @When("User click on icon cart")
    public void userClickOnIconCart() {
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Displays number of items in your cart']")).click();
    }

    @And("Verify quantity and total price of items")
    public void verifyQuantityAndTotalPriceOfItems() {
        General general = new General();

        String raw_qty = driver.findElement(By.xpath("//*[contains(@text, 'Items')]")).getText();
        String raw_prc = driver.findElement(By.xpath("//*[contains(@text, 'Items')]//following-sibling::android.widget.TextView[1]")).getText();

        String qty = general.splitItems(raw_qty, 0);
        String prc = general.splitItems(raw_prc, 1);

        if (qty == "2" && prc == "59.98") {
            assert true;
        } else {
            assert false;
        }
    }

    @And("User click on button Proceed To Checkout")
    public void userClickOnButtonProceedToCheckout() {
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Confirms products for checkout']")).click();
    }

    @Then("User should see login page to login and continue checkout")
    public void userShouldSeeLoginPageToLoginAndContinueCheckout() {
        try {
            driver.findElement(By.xpath("//android.widget.TextView[@text='Login']"));
            assert true;
        } catch (NoSuchElementException e) {
            assert false;
        }
    }
}
