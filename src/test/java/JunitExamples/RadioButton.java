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

public class RadioButton {
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
    public void benzClick() {
        WebElement benz = driver.findElement(By.id("benzradio"));
        benz.click();


    }

    @Test
    public void bmwClick() {

        WebElement bmw = driver.findElement(By.cssSelector("#bmwradio"));
        bmw.click();
    }

    @Test
    public void hondaClick() {
        WebElement honda = driver.findElement(By.xpath("//input[@id='hondaradio']"));
        honda.click();
        if (honda.isSelected()) {
            System.out.println("test will pass");
        } else {
            System.out.println("test will fail");
        }
    }


    @After
    public void tearDown() {
        driver.close();
    }
}






