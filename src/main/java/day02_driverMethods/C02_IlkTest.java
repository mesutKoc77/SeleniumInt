package day02_driverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class C02_IlkTest {
    public static void main(String[] args) {
      /*
          Gerekli ayarlamalari yapip amazon anasayfaya gidin
          1- sayfa basligi "amazon" kelimesi icermeli
          2- sayfa url'inde "Amazon" kelimesi olmali
         */

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");

        String expectedTitleIcerik="amazon";
        String expextedUrlIcerik="Amazon";

        String acturalUrl= driver.getCurrentUrl();
        String acturalTitle=driver.getTitle();

        if (acturalUrl.contains(expextedUrlIcerik)){
            System.out.println("Url test PASSED");

        }else {
            System.out.println("Url Test Failed");
            System.out.println("actual Url:"+acturalUrl);
            System.out.println("Actual Url Aranan"+expextedUrlIcerik+"kelimesini içermiyor");
        }

        //title test

        if (acturalTitle.contains(expectedTitleIcerik)){
            System.out.println("Title Test Passed");

        }else {
            System.out.println("Title Test Failed");
            System.out.println("actual Title :"+acturalTitle);
            System.out.println("Actual Title Aranan"+expectedTitleIcerik+"kelimesini içermiyor");
        }
        driver.quit();

        /*
        driver.close sadece açık olan browseri kapatırken
        driver.quit ise test çalışırken açılan tum browserları kapatır
         */



    }
}
