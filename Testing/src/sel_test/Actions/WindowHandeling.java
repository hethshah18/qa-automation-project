package sel_test.Actions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandeling {
    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText")).click();

        Set <String> windows = driver.getWindowHandles();//[parentid,childid.subchildid]
        Iterator <String> it = windows.iterator();//to iterate set collection
        String parentId = it.next();//first id is parent
        String childId = it.next();//second id is child
        driver.switchTo().window(childId);//switch to child window
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());//get text from child window
        String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        driver.switchTo().window(parentId);//switch back to parent window
        driver.findElement(By.id("username")).sendKeys(emailId);//enter email id in parent window
    }
}
