package day03_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_LocaterTesti {
    public static void main(String[] args) throws InterruptedException {
        // 2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //	a.web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com");
        //	b. Search(ara) “city bike”
        WebElement searchKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        searchKutusu.sendKeys("city bike");
        searchKutusu.submit();
        //	c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        List<WebElement> sonuclar=driver.findElements(By.className("sg-col-inner"));

        // bu listenin 1.elementi bulunan sonuc sayisi
        System.out.println(sonuclar.get(0).getText());//
        System.out.println(sonuclar.size());
        //	d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.

        driver.findElement(By.className("s-image")).click();
        /*
        eger bir locate ile birden fazla element bulunyorsa,
        selenium ilk elementi kullanır.
         */
        Thread.sleep(5000);
        driver.close();








    }
}
