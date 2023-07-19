package JunitExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
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

public class Assertion {
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
    public void priceassertion(){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,800)");
        WebElement price = driver.findElement(By.cssSelector("table[id='product'] tbody tr:nth-child(2) td:nth-child(3)"));
        //parent and child relation of CSS pATH
        String priceText=price.getText();
        System.out.println("the test is "+priceText);
        Assert.assertThat(priceText,CoreMatchers.is("35"));//varifying actual vs expected

    }
    @Test
    public void courseassertion(){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,800)");
        WebElement price = driver.findElement(By.cssSelector("table[id='product'] tbody tr:nth-child(3) td:nth-child(2)"));
        //parent and child relation of CSS pATH
        String courseText=price.getText();
        System.out.println("the test is "+courseText);
        Assert.assertThat(courseText,CoreMatchers.equalTo("Python Programming Language"));//varifying actual vs expected
        Assert.assertThat(courseText,CoreMatchers.endsWith("Language"));
    }


    @After
    public void tearDown() {
        driver.close();
    }
}
