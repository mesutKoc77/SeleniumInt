package day05_mavenProje;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev2 {
      /*
    // 1. "https://www.saucedemo.com" Adresine gidin
// 2. Username kutusuna "standard_user" yazdirin
// 3. Password kutusuna "secret_sauce" yazdirin
// 4. Login tusuna basin
// 5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
// 6. Add to Cart butonuna basin
// 7. Alisveris sepetine tiklayin
// 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
// 9. Sayfayi kapatin
// 10.Collapse
     */

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement theFirstProduct=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String stringTheFirst=theFirstProduct.getText();
        theFirstProduct.click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("shopping_cart_link")).click();
        if(driver.getPageSource().contains(stringTheFirst)) System.out.println("Sepette TEST PASSED");
        else System.out.println("sepetteDegil TEST FAILED");

        Thread.sleep(5000);



        driver.close();


    }
}
