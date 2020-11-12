import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.xpath("//input[@id='login_field']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By singInButton = By.xpath("//input[@type='submit']");
    private By heading = By.xpath("//h1[contains(text(),'Sign in to GitHub')]");
    private By error = By.xpath("//div[@class='container-lg px-2']");
    private By createAccLink = By.xpath("//a[contains(text(),'Create an account')]");

    public LoginPage typeUserName(String username){
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public LoginPage loginWithInvalidCreds(String username, String password){
        this.typeUserName(username);
        this.typePassword(password);
        driver.findElement(singInButton).click();
        return new LoginPage(driver);
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public String getErrorText(){
        return driver.findElement(error).getText();
    }

    public SingUpPage createAccLink(){
        driver.findElement(createAccLink).click();
        return new SingUpPage(driver);
    }
}
