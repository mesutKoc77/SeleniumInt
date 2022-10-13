package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_DriverManageMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");

        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.manage().window().maximize();
        //yukarıdaki 4 kod sabittir.

        /*
        wait konusu ayrıntılı anlatılacak

        implicitly wait, driverin aradıgı elementleri bulabilmesi için kendisine erdigimiz suredir.
        o sure içerisinde bulamzsa hata verir.

         */
        driver.manage().window().fullscreen();

        System.out.println("fullscreen position"+driver.manage().window().getPosition());

        System.out.println("fullscreen size"+driver.manage().window().getSize());

        Thread.sleep(2000);

        driver.manage().window().maximize();

        System.out.println("maximiz in Size ı"+driver.manage().window().getSize());
        System.out.println("maximize in position ı"+driver.manage().window().getPosition());
        Thread.sleep(2000);

        driver.manage().window().minimize();

        System.out.println("minimize in position ı"+driver.manage().window().getPosition());
        System.out.println("minimize in size i"+driver.manage().window().getSize());

        Thread.sleep(2000);
        driver.close();

    }
}
