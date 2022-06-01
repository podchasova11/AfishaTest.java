package javawebui.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.openqa.selenium.WindowType.TAB;


public class SetupDriverExamples {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        //chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://google.com");


        Thread.sleep(3000);


        driver.switchTo().newWindow(TAB);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://ya.ru");

        Thread.sleep(3000);
        driver.close();
        Thread.sleep(3000);

        driver.switchTo().window(tabs.get(0));
        ((JavascriptExecutor)driver).executeScript("window.open('https://ya.ru', '_blank').focus();");
        Thread.sleep(3000);

        driver.quit();


    }
}
