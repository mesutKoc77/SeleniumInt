package day05_mavenProje;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev1 {
    /*
    / 1-C01_TekrarTesti isimli bir class olusturu
/ 2- https://www.google.com/ adresine gidin.
// 3- cookies uyarisini kabul ederek kapatin
// 4-Sayfa basliginin "Google" ifadesi icerdigini test edin.
// 5- Arama cubuguna "Nutella" yazip aratin.
// 6-Bulunan sonuc sayisini yazdirin.
// 7- sonuc sayisinin 10 milyon'dan fazla oldugunu test edin.
// 8-Sayfayi kapatin.
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//div[text()='Tümünü kabul et']")).click();
        String actualTitle= driver.getTitle();
        String expectedTitle="Google";

        if (actualTitle.contains("Google"))
            System.out.println("Title PASSED");
        else System.out.println("TİTLE FAILED");

        driver.findElement(By.xpath("//input[@jsaction='paste:puy29d;']")).sendKeys("Nutella"+ Keys.ENTER);
        String resultText= driver.findElement(By.xpath("//div[@class=\"LHJvCe\"]")).getText();

        System.out.println(resultText);//Yaklaşık 153.000.000 sonuç bulundu (0,59 saniye)

        String duzenliResult=resultText.substring((resultText.indexOf("ık")+3),(resultText.indexOf("s")-1));
        //System.out.println(duzenliResult);//153.000.000

        String end=duzenliResult.replaceAll("\\.", "");

       int endInt=Integer.parseInt(end);

       if (endInt>10000000) System.out.println("Sonuc 10 milyondan fazla TEST PASSED");
       else System.out.println("Sonuc 10 milyondan eksik TEST FAILED");


        driver.close();


    }
}
