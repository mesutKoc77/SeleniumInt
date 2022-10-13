package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");

        WebDriver driver=new ChromeDriver();

        //driver objesi oluşturunca selenium web driver bilgisayarımızdaki chrome browser dan bir boş sayfa açtırır.
        //eger firefox veya safari gibi başka bir browser kullanmak istersek selenium sitesinden o browserin web driverini
        //indirip projemize eklememiz gerekir.

        driver.get("https://www.amazon.com");

        //eger kodlarımız belirli bir sure bekletme istersek

        Thread.sleep(5000);//yazilan milisaniye kdar kodları bekletir.

        System.out.println("sayfa Url i: "+driver.getCurrentUrl());

        System.out.println("sayfanin Title ı: "+driver.getTitle());

        //

        driver.close();



    }
}
