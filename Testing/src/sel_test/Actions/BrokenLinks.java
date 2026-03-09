package sel_test.Actions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {
    public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
        // Code to check for broken links will go here
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // broken URL
        //Step 1 - IS to get all tied up to the links using
        // Java methods will call URL's and gets you the status code
        // if status code then that is not working-> link which tied to url is broken 
        //'a[href*="soapui"]'
        
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a = new SoftAssert();

        for(WebElement link:links) 
        {
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URI(url).toURL().openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int resCode = conn.getResponseCode();
            System.out.println(resCode);
            a.assertTrue(resCode<400, link.getText()+" is broken link with code "+resCode);
        }
        
        a.assertAll();


        // String Url1 = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
        // String Url2 = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");

        // HttpURLConnection conn1 = (HttpURLConnection) new URI(Url1).toURL().openConnection();//for soup url
        // HttpURLConnection conn2 = (HttpURLConnection) new URI(Url2).toURL().openConnection();//for broken link

        // //for soup url
        // conn1.setRequestMethod("HEAD");
        // conn1.connect();
        // int resCode = conn1.getResponseCode();
        // System.out.println(resCode);

        // //for broken link
        // conn2.setRequestMethod("HEAD");
        // conn2.connect();
        // int resCode2 = conn2.getResponseCode();
        // System.out.println(resCode2);

    }
}
