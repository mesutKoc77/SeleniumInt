package day03_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_webElementMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("Nutella");
        searchBox.clear();
        searchBox.sendKeys("Java");

        System.out.println(searchBox.getSize());//arama kutusunun boyutu.
        System.out.println(searchBox.getTagName());//input muş tag ismi
        System.out.println(searchBox.getAttribute("name"));//name attribute nın degeri field-keywords

        System.out.println(searchBox.isDisplayed());//true
        System.out.println(searchBox.isEnabled());//true
        System.out.println(searchBox.isSelected());//false

        driver.close();

    }

}
