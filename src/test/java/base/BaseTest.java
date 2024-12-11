package base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();

        if (StringUtils.isNotEmpty(getenv("key"))) {
            //capabilities.setCapability("testinium:ignoreScreenshotForCommands", "element");
            //capabilities.setCapability("testinium:ignoreLogForCommands", "element");
            capabilities.setCapability("key", System.getenv("key"));
            //driver = new RemoteWebDriver(new URL("http://192.168.70.50:4444/wd/hub"), capabilities);
            driver = new RemoteWebDriver(new URL("http://hub.testinium.io/wd/hub"), capabilities);
        } else {
            System.setProperty("webdriver.chrome.driver", "/Users/sahabt/Dev/data/chromedriver");
            driver = new ChromeDriver();
        }
        //driver.manage().timeouts().implicitlyWait(30 * 1000, TimeUnit.MILLISECONDS);
    }

    /*@BeforeStep
    public void beforeStep(ExecutionContext context) {
        String testStepText = context.getCurrentStep().getText();
        logger.info("Test Step Text :" + testStepText);
        ((JavascriptExecutor) driver).executeScript("logCommand", new String[]{testStepText.replace("\"", "＂")});
        //bsp.executeJS("logCommand",new String[]{"\"deneme\""});
    }*/

    @AfterScenario
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

}
