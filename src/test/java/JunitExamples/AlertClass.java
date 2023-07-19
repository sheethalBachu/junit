package JunitExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertClass {
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
    public void alert() {

        WebElement box = driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']"));
        box.sendKeys("sheetu");
        WebElement popalert = driver.findElement(By.id("alertbtn"));
        popalert.click();
        Alert acc=driver.switchTo().alert();

    }

    @After
    public void tearDown() {
        driver.close();
    }
}
