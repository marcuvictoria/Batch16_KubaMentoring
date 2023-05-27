package lambda_test;

import Util.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test2 {
    @Test
    public  void namesAndEmail(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/");

        driver.findElement(By.xpath("//a[.='Table Pagination']")).click();

        WebElement rows = driver.findElement(By.cssSelector("#maxRows"));
        BrowserUtils.selectBy(rows,"0","index");
        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmails = driver.findElements(By.xpath("//tr//td[3]"));
//we use treeMap for the ascending order


        TreeMap<String,String> map = new TreeMap<>();
        for ( int i =0;i<allNames.size();i++){
            map.put(BrowserUtils.getText(allNames.get(i)), BrowserUtils.getText(allEmails.get(i)));
            //if we put the map in sout then the ascending order will be gone
        }
        System.out.println(map);
    }
    @Test
    public  void namesAndEmail2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/");

        driver.findElement(By.xpath("//a[.='Table Pagination']")).click();
        WebElement rows = driver.findElement(By.cssSelector("#maxRows"));
        BrowserUtils.selectBy(rows,"5000","value");
        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allNumbers = driver.findElements(By.xpath("//tr//td[4]"));

        Map<String,Long> map = new TreeMap<>();
        for ( int i=0;i<allNames.size();i++){
            String numbers = BrowserUtils.getText(allNumbers.get(i)).replace("-","");
            map.put(BrowserUtils.getText(allNames.get(i)), Long.valueOf(numbers));
        }
        System.out.println(map);
    }
}
