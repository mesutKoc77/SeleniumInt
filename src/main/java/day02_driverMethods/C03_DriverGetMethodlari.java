package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverGetMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        System.out.println(driver.getWindowHandles());
        //bize açılan browswerin handle degerini dondurur.
        //  [CDwindow-1E2791DCE4851FD8B87F80D8791AD63B]
        // [CDwindow-40BEF3F744482E8664583B085CD0697C]

        System.out.println(driver.getWindowHandles());
        /*
        eger test esnasında birden fazla window açılırsa, acılan bu tum windowların window handle degerleri bir Set ola
        rak bize doner.
        window lar arası gecis ise bu window handle degerlerri ile yapılır.
         */
        driver.get("https://www.amazon.com");
        System.out.println(driver.getPageSource());
        //ilgili websayfasının tum kaynak kodlarını bize getirir.
        driver.close();



    }
}
