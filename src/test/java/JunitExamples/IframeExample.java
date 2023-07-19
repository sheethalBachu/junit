package JunitExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IframeExample {
    WebDriver driver;
    @Before
    public void openUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("disable-notifications");
        driver = new ChromeDriver(option);
        driver.get("https://www.letskodeit.com/practice");

    }

    @Test
    public void priceassertion() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,900)");
        WebElement iframe= driver.findElement(By.id("courses-iframe"));
        driver.switchTo().frame(iframe);
        WebElement searchbox= driver.findElement(By.xpath("//input[@id='search']"));
        searchbox.sendKeys("java");
        Thread.sleep(150);
        driver.switchTo().parentFrame();

    }
    @After
    public void tearDown() {
        driver.close();
    }
}
