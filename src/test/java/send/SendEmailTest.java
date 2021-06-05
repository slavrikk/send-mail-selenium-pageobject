package send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import ui.config.ConfigUITestContext;
import ui.pages.LoginMailPage;
import ui.pages.MainMailPage;

@ContextConfiguration(classes = ConfigUITestContext.class)
public class SendEmailTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private LoginMailPage loginMailPage;

    @Autowired
    private MainMailPage mainMailPage;

    @Value("${login}")
    private String mailDestination;

    @Test
    public void sendEmailToAddressAndVerifySuccess() {
        loginMailPage.login();
        mainMailPage.sendLetterTo(mailDestination, "Hello from Test!");
    }

}
