package lambda_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test1 {

    @Test
    public void validate(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/");

        driver.findElement(By.linkText("Input Form Submit")).click();


        WebElement name = driver.findElement(By.xpath("//input[@name ='name']"));
        name.sendKeys("Victoria Marcu");

        WebElement email = driver.findElement(By.xpath("//input[@id='inputEmail4']"));
        email.sendKeys("marcuvic@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='inputPassword4']"));
        password.sendKeys("vic123");

        WebElement company = driver.findElement(By.xpath("//input[@name='company']"));
        company.sendKeys("techtorial");

        WebElement website = driver.findElement(By.xpath("//input[@id='websitename']"));
        website.sendKeys("https://www.techtorialacademy.com/");

        WebElement countryBox = driver.findElement(By.xpath("//select[@name='country']"));
        Select country = new Select(countryBox);
        country.selectByValue("US");

        WebElement city = driver.findElement(By.xpath("//input[@id='inputCity']"));
        city.sendKeys("Tampa");

        WebElement address1 = driver.findElement(By.xpath("//input[@id='inputAddress1']"));
        address1.sendKeys("123 Rock Drive");

        WebElement address2 = driver.findElement(By.xpath("//input[@id='inputAddress2']"));
        address2.sendKeys("Apt 205");

        WebElement state = driver.findElement(By.xpath("//input[@id='inputState']"));
        state.sendKeys("Florida");

        WebElement zipCode = driver.findElement(By.xpath("//input[@name='zip']"));
        zipCode.sendKeys("55698");

        List<WebElement> buttons = driver.findElements(By.cssSelector("button[type='submit']"));

        for (int i =0; i< buttons.size();i++){
            if (buttons.get(i).getText().equalsIgnoreCase("submit")){
                buttons.get(i).click();
            }
        }

        List<WebElement> messages = driver.findElements(By.xpath("//p"));
        for ( int i=0; i<messages.size();i++){
            if ( messages.get(i).getText().contains("Thanks")){
                System.out.println(messages.get(i).getText());
                Assert.assertTrue(messages.get(i).isDisplayed());
            }
        }


    }
}
