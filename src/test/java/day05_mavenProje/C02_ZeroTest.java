package day05_mavenProje;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ZeroTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.className("icon-signin")).click();

        //3. Login alanine  “username” yazdirin
        WebElement usernameButonu=driver.findElement(By.xpath("//input[@id=\"user_login\"]"));
        usernameButonu.sendKeys("username");
        //4. Password alanine “password” yazdirin
        driver.findElement(By.xpath("//input[@id=\"user_password\"]")).sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        driver.navigate().back();
        //6. Online bankings menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[text()=\"Pay Bills\"]")).click();

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.className("span1")).sendKeys("5000");
        //8. tarih kismina “2022-10-10” yazdirin\
        driver.findElement(By.xpath("//input[@id=\"sp_date\"]")).sendKeys("2022-10-10");
        //9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        //10. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement basariliYazisi=driver.findElement(By.xpath("//span[text()=\"The payment was successfully submitted.\"]"));
        String actualYazi=basariliYazisi.getText();
        String expextedYazi="The payment was successfully submitted.";

        if (actualYazi.equals(expextedYazi)){
            System.out.println("basarılı yazısı goronuyor PASSED");
        }else {
            System.out.println("basarılı yazısı gornmjuyor FAILED");
        }

        Thread.sleep(3000);
        driver.close();

    }
}
