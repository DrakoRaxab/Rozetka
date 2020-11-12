import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By singInButton = By.xpath("//a[text()='sign-in']");
    private By singUpButton = By.xpath("//a[text()='Sign-up']");
    private By userNameField = By.xpath("//input[@id='user[login]']");
    private By emailField = By.xpath("//input[@id='user[email]']");
    private By passwordField = By.xpath("//input[@id='user[password]']");
    private By singUpFormButton = By.xpath("//button[text()='Sign up for GitHub']");

    public LoginPage clickSingIn() {
        driver.findElement(singInButton).click();
        return new LoginPage(driver);

    }

    public SingUpPage clickSingUpButton() {
        driver.findElement(singUpButton).click();
        return new SingUpPage(driver);
    }

    public SingUpPage clickSingUpFormButton() {
        driver.findElement(singUpFormButton).click();
        return new SingUpPage(driver);
    }

    public MainPage typeUserName(String username){
       driver.findElement(userNameField).sendKeys(username);
       return this;
    }

    public MainPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public MainPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SingUpPage register(String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSingUpFormButton();
        return new SingUpPage(driver);
    }
}
