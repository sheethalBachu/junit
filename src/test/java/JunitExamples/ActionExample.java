package JunitExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionExample {
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
    public void mousehover() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,800)");
       WebElement hover= driver.findElement(By.cssSelector("#mousehover"));
       Actions act=new Actions(driver);
       act.moveToElement(hover).build().perform();
       WebElement topclick= driver.findElement(By.xpath("//div[@class='mouse-hover-content']"));

       topclick.click();
       Thread.sleep(15000);

    }

    @After
    public void tearDown() {
        driver.close();
    }
}
