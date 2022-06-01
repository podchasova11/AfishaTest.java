package javawebui.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class AutomationPractiseTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationpractice.com/index.php?id_category=8&controller=category#/");

        WebElement casualDressesCheckbox = driver.findElement(By.id("layered_category_9"));
        casualDressesCheckbox.click();

        //Thread.sleep(5000);

        driver.findElement(By.xpath("//a[@title='Cansel']")).click();

        Thread.sleep(5000);

        driver.quit();


    }


}
