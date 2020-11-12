import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class gggg {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver", "D:\\QA Automation\\Rozetka\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = (new WebDriverWait(driver, 5));
        driver.get("https://www.rozetka.com.ua");

    }

    @Test
    public void rozetka() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rz-banner-img")));
        driver.findElement(By.linkText("Ноутбуки и компьютеры")).click();

        driver.findElement(By.xpath("//a[@class='fat-link fat-link_type_popular']")).click();

        String titleOfProductInCatalog = driver.findElement(By.xpath("//a[@class='goods-tile__heading']")).getText();

        driver.findElement(By.xpath("//button[@class='buy-button goods-tile__buy-button']")).click();

        WebElement basketCounter = driver.findElement(By.xpath("//span[@class='header-actions__button-counter']"));
        String count = basketCounter.getText();

        Assert.assertEquals(count, "1", "В корзине больше одного товара");
        WebElement basket = driver.findElement(By.xpath("//a[@class='header-actions__button header-actions__button_type_basket header-actions__button_state_active']"));
        basket.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='button button_size_medium button_color_gray cart-footer__continue']")));
        String titleOfProductInBasket = driver.findElement(By.xpath("//a[@class='cart-product__title']")).getText();

        Assert.assertEquals(titleOfProductInCatalog, titleOfProductInBasket, "Товар в корзине отличается от товара из каталога");

    }

    @AfterMethod
    public void after() {

        driver.quit();
    }
}