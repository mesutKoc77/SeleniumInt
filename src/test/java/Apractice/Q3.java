package Apractice;

import org.openqa.selenium.By;
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
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.findElement(By.xpath("//button[text()=\"Continue with Recommended Cookies\"]")).click();

        driver.findElement(By.xpath("//a[text()=\"Tamam\"]")).click();

        driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("MESUT");

        driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("KOC");

        driver.findElement(By.id("sex-0")).click();
        driver.findElement(By.id("exp-0")).click();
        driver.findElement(By.id("datepicker")).sendKeys("15.10.2022");
        driver.findElement(By.id("profession-1")).click();
        driver.findElement(By.id("tool-2")).click();
        driver.findElement(By.xpath("//select[@id=\"continents\"]")).click();
        driver.findElement(By.xpath("//option[text()=\"Europe\"]"));

        driver.findElement(By.id("//option[text()=\"Browser Commands\"]")).click();
        driver.findElement(By.className("btn btn-info"));
        driver.close();


    }
}
