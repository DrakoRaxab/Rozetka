import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class lesson25 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver", "D:\\QA Automation\\Rozetka\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = (new WebDriverWait(driver, 10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Открыть https://rozetka.com.ua/
        driver.get("https://rozetka.com.ua");
    }
    @Test
    public void test() throws IllegalAccessException {
        new MainPageLogic(driver, wait).typeTextSearchInput("Mac").findBtnClick();
        SearchPageLogic searchPageLogic = new SearchPageLogic(driver, wait);

        WebElement searchInput = driver.findElement(By.xpath("//input[@name='search']"));

        String title = searchPageLogic.firstProductTitleText();
        System.out.println(title);


        searchPageLogic.firstProductClick();


    }
    @AfterMethod
    public void after() {
//        driver.quit();
    }
}