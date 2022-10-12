package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) throws InterruptedException {
        //1- C01_TekrarTesti isimli bir class olusturun
        //2- https://www.amazon.com/ adresine gidin
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        //3- Browseri tam sayfa yapin


        //4- Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin

        String actualTitle=driver.getTitle();
        String arananMetin="Spend less";
        if (actualTitle.contains(arananMetin)){
            System.out.println("title contains target Word and test PASSED, Titel enthält Zielwort, Test BESTANDEN");
        } else {
            System.out.println("title contains not target Word and test FAILED, Der Titel enthält kein Zielwort und der Test ist FEHLGESCHLAGEN");
        }


        //6- Gift Cards sekmesine basin
        WebElement giftCard=driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_cs_gc']"));
        giftCard.click();
        //7- Birthday butonuna basin
        WebElement birthdayButton=driver.findElement(By.xpath("//img[@alt=\"Birthday gift cards\"]"));
        birthdayButton.click();
        //8- Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("//img[@alt=\"Amazon.com eGift Card\"][1]")).click();

        //9- Gift card details’den 25 $’i  secin
        driver.findElement(By.xpath("//span[@class=\"a-button a-button-toggle\"][1]")).click();
        //10-Urun ucretinin $25.00 oldugunu test edin
        WebElement ucretelementi=driver.findElement(By.xpath("//span[@class=\"a-color-price a-text-bold\"]"));
        String actualUcret=ucretelementi.getText();
        String expectedUcret="$25.00";

        if (actualUcret.equals(expectedUcret)){
            System.out.println("Gift Card testi PASSED");
        }else {
            System.out.println("Gift Card testi FAILED");
        }
        //11-Sayfayi kapatin
        Thread.sleep(5000);
        driver.close();







    }
}
