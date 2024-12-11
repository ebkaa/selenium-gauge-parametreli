package base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

import static java.lang.System.getenv;

public class BaseTest {

    private Logger logger = LoggerFactory.getLogger(BaseTest.class.getName());

    protected static WebDriver driver;

    @BeforeScenario
    public void setUp() throws Exception {

        DesiredCapabilities capabilities;

        if (StringUtils.isNotEmpty(System.getenv("key"))) {
            logger.info("Test Started");
            capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-translate");
            options.addArguments("--disable-notifications");
            options.addArguments("--start-fullscreen");

            capabilities.setCapability(ChromeOptions.CAPABILITY, options);

            capabilities.setCapability("key", System.getenv("key"));
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } else {
            System.setProperty("webdriver.chrome.driver", "/Users/sahabt/Dev/data/chromedriver");
            driver = new ChromeDriver();
        }
    }

    @AfterScenario
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

}
