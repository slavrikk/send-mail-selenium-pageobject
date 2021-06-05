package ui.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan(basePackages = "ui")
@PropertySource("classpath:config.properties")
public class ConfigUITestContext {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public WebDriver webDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return chromeDriver;
    }

}
