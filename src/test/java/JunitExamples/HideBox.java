package JunitExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HideBox {
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
    public void hide() {

        WebElement box = driver.findElement(By.cssSelector("input[id='displayed-text']"));
        box.sendKeys("");
        WebElement hide = driver.findElement(By.id("hide-textbox"));
        hide.click();
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
