package Apractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q4 {

    /*
    Navigate to  https://testpages.herokuapp.com/styled/index.html

    Click on  Calculater under Micro Apps
    Type any number in the first input
    Type any number in the second input
    Click on Calculate
    Get the result
    Print the result
    */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.id("calculatetest")).click();
        WebElement calculateWord=driver.findElement(By.xpath("//h1[text()='Simple Calculator']"));
        System.out.println(calculateWord.isDisplayed() ? "Calculate Yazısı PASSED" : "calculate yazısı Fail");
        driver.findElement(By.id("number1")).sendKeys("15");
        driver.findElement(By.id("function")).sendKeys("minus"+ Keys.ENTER);
        driver.findElement(By.id("number2")).sendKeys("10");
        driver.findElement(By.id("calculate")).click();
        WebElement result=driver.findElement(By.xpath("//span[@id=\"answer\"]"));
        System.out.println("sonuc: "+result.getText());

        int Intsonuc=Integer.parseInt((result.getText()));
        int yeni=15+Intsonuc;
        System.out.println("yeni: "+yeni);
        driver.close();
        driver.quit();


    }
}
