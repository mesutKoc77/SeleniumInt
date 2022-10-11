package day03_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_noSuchElementExceptionExc {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

       List< WebElement> sonucWebElementListesi=driver.findElements(By.id("twotabsearchtextbox11"));
        System.out.println(sonucWebElementListesi.size());
        //findelemement ile locate eediln webelementlerde locator da sorun olursa driver bu elemneti bulamaz
        //ve NoSuchElementException fırlatır

        //ama findelements ile locate edilen liste locater hatalı ıolsa bile exceptionvermez
        //boş bir liste dondurur


        driver.close();




    }
}
