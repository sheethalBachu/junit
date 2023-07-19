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

public class SelectExample {
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
    public void SelectByIndexExample(){
        WebElement selectIndex= driver.findElement(By.id("carselect"));
        Select sel=new Select(selectIndex);
        sel.selectByIndex(2);

    }
    @Test
    public void SelectByValueExample(){
        WebElement selectValue= driver.findElement(By.id("carselect"));
        Select sel=new Select(selectValue);
        sel.selectByValue("honda");

    }
    @Test
    public void SelectByVisibleExample(){
        WebElement selectVisible= driver.findElement(By.id("carselect"));
        Select sel=new Select(selectVisible);
        sel.selectByVisibleText("Benz");
        List<WebElement> total =sel.getOptions();
        int boxsize=total.size();
        System.out.println("the box is" +boxsize);
        for(int i=0;i<boxsize;i++){
            String names=total.get(i).getText();
            System.out.println("the names are " +names);

        }


    }

    @After
    public void tearDown() {
        driver.close();
    }
}
