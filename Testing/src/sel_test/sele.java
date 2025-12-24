package sel_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.lang.ClassNotFoundException;
//import com.google.common.net.MediaType;
import org.openqa.selenium.chrome.ChromeDriver;



public class sele {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get("https://dashboard.beawms.com/");
		// driver.findElement(By.id("email")).sendKeys("admin@aits.com");
		// driver.findElement(By.id("password")).sendKeys("admiN@123$");
		// driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/form/button")).click();
		//  Thread.sleep(10000);
		// driver.quit();

		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("hethshah2000@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Het@1234");
		driver.findElement(By.xpath("(//*[contains(text(),'Log in')])[1]")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
