package base;

import com.thoughtworks.gauge.Step;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
    dfafafafa sfafsaf
     */
public class BasePageUtil extends BaseTest {

    /**
     * fgsdgsgs
     *
     * @param url
     */

    @Step("Go to <url>")
    public void openUrl(String url) {
        driver.get(url);
    }

    //sfafgaga

    /*
    dfafafafa sfafsaf
     */

    @Step("Find twitter button")
    public void findTwitClass() {
        WebElement twbt = driver.findElement(By.className("_twbt"));
    }

    @Step("Find weather arrow button")
    public void findUserLoginClass() {
        WebElement twbt = driver.findElement(By.className("weather__arrow"));
    }

    @Step("Find Search Bar button")
    public void findGmailClass() {
        WebElement twbt = driver.findElement(By.className("searchbar"));
        twbt.click();
    }

    @Step("Find Live Button in AlJazeera and click")
    public void findLiveButtonAlJazeera() {
        WebElement twbt = driver.findElement(By.className("site-header__logo"));
        twbt.click();
    }

    @Step("Find Home Button in NYT and click")
    public void findHomeButtonNYT() {
        WebElement twbt = driver.findElement(By.className("css-1wjnrbv"));
        //twbt.click();
    }

    @Step("Error occured")
    public void errorOccured() {
        throw new NullPointerException();
    }

    @Step("Wait <time> ms")
    public void sleep(Integer time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }
    /*
    dfafafafa sfafsaf
     */

    /**
     * <input1> alanı ekle <input2>, <input3>
     * Input alanı ekle <key> , <value>
     */
    @Step("<input1> alanı ekle <input2> , <input3>")
    public void xxx(String x, String y, String z) {
        System.out.printf("%s %s %s", x, y, z);
    }

    @Step("Input alanı ekle <key> , <value>")
    public void xxx(String key, String value) {
        System.out.printf("%s %s", key, value);
    }

    @Step("Get page source")
    public void screenShot() {
        driver.getPageSource();
    }

    @Step("Click random link")
    public void clickRandomLink2() throws Exception {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        for (WebElement webElement : elements) {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
            WebElement waitElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
            if (waitElement != null) {
                try {
                    webElement.click();
                    break;
                } catch (Exception e) {
                    continue;
                }
            }
        }
    }

    @Step("<key> yes ise true, no ise false olacak")
    public void cond(String cond){

        Assert.assertTrue("NO - False değeri geldi",cond.equalsIgnoreCase("yes"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

