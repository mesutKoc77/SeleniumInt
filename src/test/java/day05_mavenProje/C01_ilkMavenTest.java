package day05_mavenProje;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_ilkMavenTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        //2- arama kutusunu locate edelim
        WebElement aramaKutusuElementi=driver.findElement(By.id("twotabsearchtextbox"));
        //3- “Samsung headphones” ile arama yapalim
        aramaKutusuElementi.sendKeys("Samsung headphones"+ Keys.ENTER);
        //4- Bulunan sonuc sayisini yazdiralim
       WebElement sonucSayisiElementi=driver.findElement(By.xpath("(//div[@class=\"a-section a-spacing-small a-spacing-top-small\"])[1]"));
        System.out.println(sonucSayisiElementi.getText());
        String sonucSayisiStr=sonucSayisiElementi.getText();//1-16 of 220 results for "Samsung headphones"

        //System.out.println(sonucSayisiStr.indexOf("of"));//5
        //System.out.println(sonucSayisiStr.indexOf("for"));//20

        sonucSayisiStr=sonucSayisiStr.substring(
                           (sonucSayisiStr.indexOf("of")+3),
                           (sonucSayisiStr.indexOf("for")-1)
        );
        System.out.println(sonucSayisiStr);//220 results

        // sonuc sayisinin 100'den fazla oldugunu test edin

        sonucSayisiStr=sonucSayisiStr.substring(0,
                (sonucSayisiStr.indexOf("results")-1));
      if((Integer.parseInt(sonucSayisiStr))>100){
          System.out.println("sonuc sayısı 100 den buyuk Passed");
      } else System.out.println("sonuc sayısı 100 den buyuk degil FAILED");
        System.out.println(sonucSayisiStr);

        //5- Ilk urunu tiklayalim
        WebElement ilkUruneLementi=driver.findElement(By.xpath("(//img[@class=\"s-image\"])[1]"));
        ilkUruneLementi.click();
        //6- Sayfadaki tum basliklari yazdiralim

        driver.navigate().back();
       List<WebElement> baslikElementList=driver.findElements(By.xpath("//span[@class=\"a-size-base a-color-base\"]"));

        for (WebElement each:baslikElementList
             ) {
            System.out.print(each.getText()+"\n");
        }
        driver.close();








    }
}
