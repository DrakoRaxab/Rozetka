import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Main {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\QA Automation\\Rozetka\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        wait = (new WebDriverWait(driver, 5));
        driver.get("https://github.com/");
        MainPage mainPage = new MainPage(driver);
        mainPage.register("rtehfgjgu", "dgdsjgjgj", "fjdfjd");
    }
}
