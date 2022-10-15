package Apractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q2 {
    /* ...Exercise2...
 1 - Driver olusturalim
 2 - Java class'imiza chromedriver.exe'yi tanitalim
 3 - Driver'in tum ekrani kaplamasini saglayalim
 4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
     söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
 5 - "https://www.otto.de" adresine gidelim
 6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
 7 - Title ve url'nin "OTTO" kelimesini icerip icermedigini kontrol edelim
 8 - Ardindan "https://wisequarter.com/" adresine gidelim
 9 - Bu adresin basligini ve Url alalim ve "Quarter" kelimesini icerip icermedigini
     kontrol edelim
 10- Bir onceki web sayfamiza geri donelim
 11- Sayfayi yenileyelim
 12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
 13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.otto.de");
        String title=driver.getTitle();
        String urlsi=driver.getCurrentUrl();

        System.out.println("title ı:"+title);
        System.out.println("urlsi: "+urlsi);

        String expectedTitle="OTTO";
        String expectedUrl="OTTO";

        if (title.contains(expectedTitle)){
            System.out.println("title OTTO yu içeriyor");
        }else {
            System.out.println("title OTTO yu içermiyor Faıled");
        }
        if (urlsi.contains(expectedUrl)){
            System.out.println("URL OTTO yu içeriyor");
        }else {
            System.out.println("URL OTTO yu içermiyor Faıled");
        }

        driver.navigate().to("https://wisequarter.com/");
        String titleofQuarter =driver.getTitle();
        String urlOfQuarter=driver.getCurrentUrl();

        System.out.println(" titleofQuarter : "+titleofQuarter);
        System.out.println("urlOfQuarter : "+urlOfQuarter);

        if (titleofQuarter.contains("Quarter")){
            System.out.println("title Quarter içeriyor PAssed ");
        } else {
            System.out.println("title Quarte içermiyor Failde");
        }
        if (urlOfQuarter.contains("quarter")){
            System.out.println("urlsi Quarter içeriyor PAssed");
        }else {
            System.out.println("urlsi Quarter içermiyor Failed");
        }
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

        driver.close();
        driver.quit();




    }


}
