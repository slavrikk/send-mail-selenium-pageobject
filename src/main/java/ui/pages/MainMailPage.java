package ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import java.util.List;

@Component
@Getter
public class MainMailPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='nav-folders']//a")
    private List<WebElement> folderItems;

    @FindBy(xpath = "//a[@title='Написать письмо']")
    private WebElement writeLetterButton;

    @FindBy(xpath = "//div[@data-type='to']//input")
    private WebElement destinationMailInput;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement textBox;

    @FindBy(xpath = "//span[@title='Отправить']")
    private WebElement sendButton;

    @FindBy(xpath = "//div[@class='layer-sent-page']")
    private WebElement sentLayerPage;

    @Autowired
    public MainMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendLetterTo(String mail, String letter) {
        writeLetterButton.click();
        destinationMailInput.sendKeys(mail);
        textBox.sendKeys(letter);
        sendButton.click();
        Assert.assertTrue(sentLayerPage.isEnabled(), "Successful sender message window is not enabled");
    }

}
