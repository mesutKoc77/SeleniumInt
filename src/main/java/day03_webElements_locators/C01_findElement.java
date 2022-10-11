package day03_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_findElement {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        //bir web sitesinde bir elmeneti kullanbilmke için o web elementi kodlarımıza tanıtmalıyız.

        WebElement amazonAramaKutusu=driver.findElement(By.name("field-keywords"));
        //WebElement amazonAramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        Thread.sleep(5000);

        driver.close();


        /*
        Selen ium da 8 adet locater vardır.
        bunlardan 6 tanesi tag veya attribute lere goredir.
        2 tanesi ise, 6 tane ile buladmıgımız eleemntleri locate etmek için kullanırıız.

        1- By.id
        id genelde unique verilr, yani id varsa once by İd kullanılırsa daha iyi olur.

        2- className
        class attribute u genelde aynı işlevi yapan webelemntleri gruplandırır.
        bu gruplandırmalar ile css yardımıyla bu webelementleri tek bir yerden şekillendirme yapılaır.

       class attribute'u kullanılırken eger class value de space varsa class name ile yapılan locate ler hata
       verebilir.

       classname ile yapılan locate ler birden fazla webelement dondurecegınden List<WebElement> şeklinde
       bir List e kaydolur.

       Bu listedeki elemntler WebElmentler oldugu için direkt yazılamaz.
       for each loop kullanılarak webeleemnt ozellikleri yazdırılabailir.

       3- name
       name attribute, eger html de name attribute u varsa kullanılabilir.

       4-tagname
       tagname de class gibi benzer ozellikte olanları gruplandırdırgıdan bir element degil
       birden çok elemente ulaşılabilir.

       5- LinkText
       linktext sadece linkler için kullanılır ve her link html elemnet inin uzerinde bir link yazısı olur
       bu yazı geneldekullanıcının front end de gordugu yazı ile aynıdır. bazen space gibi farkedilmeyecek
       eklemeler olabilir. locate ederken linktext kullanılırsa link yazısının tamamı kullanılmakıdır.
       varsa boşluk vb locate alınırken yazılmalıdır.

       6-PartiallinkText

       linktext gibi sadece linkler için kullanılır
       linktext ten farkkı ise tum yazı degil de yazının parçası da kullanılabilir.



         */






    }
}
