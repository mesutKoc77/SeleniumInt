package day03_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_findElements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.amazon.com");

        List<WebElement> tümWebListesi=driver.findElements(By.className("a-spacing-micro"));
        System.out.println(tümWebListesi.size());
        for (WebElement each:tümWebListesi
             ) {
            System.out.println(each.getSize());
        }

        driver.close();

    }
}
