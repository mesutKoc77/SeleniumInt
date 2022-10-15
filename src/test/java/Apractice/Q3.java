package Apractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3 {
    /* ...Exercise3...
    go to url : https://www.techlistic.com/p/selenium-practice-form.html
    fill the firstname
    fill the lastname
    check the gender
    check the experience
    fill the date
    choose your profession -> Automation Tester
    choose your tool -> Selenium Webdriver
    choose your continent -> Europa
    choose your command  -> Browser Commands
    click submit button
 */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.findElement(By.xpath("//button[text()=\"Continue with Recommended Cookies\"]")).click();

        driver.findElement(By.xpath("//a[text()=\"Tamam\"]")).click();

        driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("MESUT");

        driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("KOC");

        WebElement radioButtonMan=driver.findElement(By.id("sex-0"));
        radioButtonMan.click();

        radioButtonMan.sendKeys(Keys.PAGE_DOWN);

        driver.findElement(By.id("exp-0")).click();

        driver.findElement(By.id("datepicker")).sendKeys("15.10.2022");

        driver.findElement(By.id("profession-1")).click();

        driver.findElement(By.id("tool-2")).click();

       WebElement europe =driver.findElement(By.xpath("//select[@id=\"continents\"]"));
       europe.sendKeys("Europe"+Keys.ENTER);

        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@id='selenium_commands']")).sendKeys("Wait Commands"+Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class=\"btn btn-info\"]")).click();
        Thread.sleep(1000);
        driver.close();
        driver.quit();


    }
}
