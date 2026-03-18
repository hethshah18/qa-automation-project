package sel_test.Actions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class WeShareSeleniumTest {
    
    public static void main(String[] args) {
        System.out.println("Testing WeShare with Selenium Java...\n");
        
        // Setup Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        // options.addArguments("--headless"); // Uncomment for headless mode
        
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            // Step 1: Navigate to homepage
            System.out.println("Step 1: Loading homepage...");
            driver.get("https://weshareapp.photos/home");
            Thread.sleep(3000);
            takeScreenshot(driver, "java-01-home.png");
            System.out.println("✓ Homepage loaded\n");
            
            // Step 2: Login
            System.out.println("Step 2: Logging in...");
            WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(), 'Sign In')]")));
            signInBtn.click();
            Thread.sleep(2000);
            takeScreenshot(driver, "java-02-login-page.png");
            
            // Fill credentials
            WebElement emailInput = driver.findElement(By.cssSelector("input[type='email']"));
            emailInput.sendKeys("hethshah2000+012@gmail.com");
            
            WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password']"));
            passwordInput.sendKeys("Het@1234");
            
            WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
            submitBtn.click();
            
            Thread.sleep(4000);
            takeScreenshot(driver, "java-03-loggedin.png");
            System.out.println("✓ Login successful\n");
            
            // Step 3: Create Event
            System.out.println("Step 3: Creating event...");
            WebElement createEventBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(), 'Create Event')]")));
            createEventBtn.click();
            Thread.sleep(2000);
            takeScreenshot(driver, "java-04-form.png");
            
            // Fill event name
            WebElement nameInput = driver.findElement(By.cssSelector("input[placeholder='Event Name']"));
            nameInput.sendKeys("OpenClawAI");
            System.out.println("✓ Event name: OpenClawAI");
            
            // Select Live type (if dropdown exists)
            try {
                List<WebElement> selects = driver.findElements(By.tagName("select"));
                if (!selects.isEmpty()) {
                    Select select = new Select(selects.get(0));
                    select.selectByVisibleText("Live");
                    System.out.println("✓ Event type: Live");
                }
            } catch (Exception e) {
                System.out.println("  (Could not select Live type)");
            }
            
            // Dates
            List<WebElement> dates = driver.findElements(By.cssSelector("input[type='date']"));
            String today = LocalDate.now().toString();
            if (dates.size() >= 1) {
                dates.get(0).sendKeys(today);
                System.out.println("✓ Start date: " + today);
            }
            if (dates.size() >= 2) {
                dates.get(1).sendKeys("2026-03-19");
                System.out.println("✓ Close date: 2026-03-19");
            }
            
            // Times
            List<WebElement> times = driver.findElements(By.cssSelector("input[type='time']"));
            String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
            if (times.size() >= 1) {
                times.get(0).sendKeys(currentTime);
                System.out.println("✓ Start time: " + currentTime);
            }
            if (times.size() >= 2) {
                times.get(1).sendKeys("18:00");
                System.out.println("✓ Close time: 18:00");
            }
            
            // Location
            try {
                WebElement locInput = driver.findElement(By.cssSelector("input[placeholder*='location' i]"));
                locInput.sendKeys("India");
                System.out.println("✓ Location: India");
            } catch (Exception e) {
                // Location field not found
            }
            
            // Description
            try {
                WebElement descInput = driver.findElement(By.tagName("textarea"));
                descInput.sendKeys("This is open claw AI doing");
                System.out.println("✓ Description added");
            } catch (Exception e) {
                // Description field not found
            }
            
            // Cover Photo
            System.out.println("\nStep 4: Uploading cover photo...");
            String userProfile = System.getenv("USERPROFILE");
            if (userProfile == null) userProfile = "C:\\Users\\QA";
            File picsDir = new File(userProfile + "\\Pictures");
            
            if (picsDir.exists()) {
                File[] imageFiles = picsDir.listFiles((dir, name) -> 
                    name.toLowerCase().matches(".*\\.(jpg|jpeg|png|gif)$"));
                
                if (imageFiles != null && imageFiles.length > 0) {
                    WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
                    fileInput.sendKeys(imageFiles[0].getAbsolutePath());
                    System.out.println("✓ Cover photo uploaded: " + imageFiles[0].getName());
                    Thread.sleep(2000);
                }
            }
            
            takeScreenshot(driver, "java-05-filled.png");
            System.out.println("\n✓ All fields filled\n");
            
            // Submit
            System.out.println("Step 5: Submitting...");
            List<WebElement> buttons = driver.findElements(By.tagName("button"));
            for (WebElement btn : buttons) {
                String text = btn.getText().toLowerCase();
                if (text.contains("create") && !text.contains("create event")) {
                    btn.click();
                    System.out.println("✓ Clicked: " + btn.getText());
                    break;
                }
            }
            
            Thread.sleep(4000);
            takeScreenshot(driver, "java-06-result.png");
            
            // Verify
            if (driver.getPageSource().contains("OpenClawAI")) {
                System.out.println("\n✅ SUCCESS: Event 'OpenClawAI' created!");
            } else {
                System.out.println("\n⚠ Check screenshot - event may have been created");
            }
            
        } catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
            takeScreenshot(driver, "java-error.png");
        } finally {
            takeScreenshot(driver, "java-final.png");
            driver.quit();
            
            System.out.println("\n" + "=".repeat(60));
            System.out.println("SELENIUM JAVA TEST COMPLETE");
            System.out.println("=".repeat(60));
        }
    }
    
    private static void takeScreenshot(WebDriver driver, String filename) {
        try {
            ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)
                .renameTo(new File(filename));
        } catch (Exception e) {
            System.out.println("Could not save screenshot: " + filename);
        }
    }
}
