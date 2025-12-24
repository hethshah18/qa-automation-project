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
//		driver.get("https://dashboard.beawms.com/");
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("admin@aits.com");
		driver.findElement(By.xpath("//*[@id=\"passContainer\"]")).sendKeys("Het@1234");
		driver.findElement(By.xpath("//*[@id=\"u_0_9_u0\"]")).click();
//		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/form/button")).click();
//		 Thread.sleep(10000);
//		driver.quit();
	}

}
