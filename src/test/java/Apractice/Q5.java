package Apractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q5 {

      /*
    Navigate to website https://testpages.herokuapp.com/styled/index.html
    Under the ORIGINAL CONTENTS
    click on Alerts
    print the URL
    navigate back
    print the URL
    Click on Basic Ajax
    print the URL
    enter value 20 and ENTER
    and then verify Submitted Values is displayed open page
    close driver
     */
      public static void main(String[] args) throws InterruptedException {
          System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
          WebDriver driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

          driver.get("https://testpages.herokuapp.com/styled/index.html");
          Thread.sleep(2000);
          driver.findElement(By.id("alert")).click();
          Thread.sleep(2000);
          System.out.println(driver.getCurrentUrl());
          Thread.sleep(2000);
          driver.navigate().back();
          Thread.sleep(2000);
          System.out.println(driver.getCurrentUrl());
          Thread.sleep(2000);
          driver.findElement(By.id("basicajax")).click();
          Thread.sleep(2000);
          System.out.println(driver.getCurrentUrl());
          Thread.sleep(2000);
          driver.findElement(By.id("lteq30")).sendKeys("20" + Keys.ENTER);
          Thread.sleep(2000);
          WebElement submittedValuesYazisi = driver.findElement(By.xpath("//p[text()='Submitted Values']"));

          //diger yontem

         /*
          String expectedYazi = "Submitted Values";
          String actualYazi = driver.findElement(By.xpath("//p[text()='Submitted Values']")).getText();
          if (expectedYazi.equals(actualYazi)) {
              System.out.println("yazı Passed");
          } else {
              System.out.println("yazı FAiled");

          */


              Thread.sleep(2000);
              System.out.println(submittedValuesYazisi.isDisplayed() ? "yazı gorunuyor" : "yazi gorunmuyor");
              Thread.sleep(2000);

              driver.close();
              driver.quit();


          }

      }


