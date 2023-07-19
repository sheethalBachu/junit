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
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultiSelection {
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
    public void multisel() throws InterruptedException {
        WebElement multi=driver.findElement(By.id("multiple-select-example"));
        Select sel=new Select(multi);
        sel.selectByIndex(2);
        sel.deselectByIndex(2);
        sel.selectByValue("orange");
        sel.selectByVisibleText("Peach");
        Thread.sleep(15000);
        sel.deselectAll();
        List<WebElement> selection=sel.getOptions();
        int size=selection.size();
        System.out.println("the size is " +size);




    }
    @After
    public void tearDown() {
        driver.close();
    }
}
