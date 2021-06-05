package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import static util.Decoder.decodePassword;

@Component
public class LoginMailPage {

    private WebDriver driver;

    @Value("${mail.page.url}")
    private String url;

    @Value("${password}")
    private String password;

    @Value("${login}")
    private String login;

    @Autowired
    private MainMailPage mainMailPage;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement inputLogin;

    @FindBy(xpath = "//button[@data-testid='enter-password']")
    private WebElement passwordButton;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@data-testid='login-to-mail']")
    private WebElement enterButton;

    @Autowired
    public LoginMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login() {
        driver.get(url);
        inputLogin.sendKeys(login);
        passwordButton.click();
        inputPassword.sendKeys(decodePassword(password));
        enterButton.click();
        Assert.assertEquals(mainMailPage.getFolderItems().size(), 8, "Folder items don't correspond to expected value");
    }
}
