package deals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class FunctionalTestCase01 {

	public static void main(String[] args) throws InterruptedException, IOException {
ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demo.dealsdray.com/");
	    Thread.sleep(1000);
	    
	    driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
	    Thread.sleep(1000);
	    driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("button[type='submit']")).click();
	    Thread.sleep(1000);
	    
	    WebElement orderButton = driver.findElement(By.xpath("(//span[contains(text(),'Order')])[1]"));
        orderButton.click();
        
        Thread.sleep(1000);
        
        WebElement ordersOption = driver.findElement(By.xpath("(//span[contains(text(),'Orders')])[1]"));
        ordersOption.click();
        
        Thread.sleep(1000);
        
         WebElement addBulkOrderButton = driver.findElement(By.xpath("//button[contains(text(),'Add Bulk Order')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(addBulkOrderButton).click().build().perform();
        Thread.sleep(1000);
	   
	     WebElement chooseFileButton = driver.findElement(By.xpath("//input[@type='file']"));
         chooseFileButton.sendKeys("C:\\\\Users\\\\HP\\\\Desktop\\\\New folder\\\\demo-data.xlsx");
     Thread.sleep(2000);
     WebElement importButton = driver.findElement(By.xpath("//button[contains(text(),'Import')]"));
     importButton.click();
     Thread.sleep(2000);
     
     File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     Files.copy(f, new File("C:\\Users\\HP\\Downloads\\Sample\\dealsdrayscreenshot.png"));
     Thread.sleep(2000);
     
     driver.close();

	}

}
