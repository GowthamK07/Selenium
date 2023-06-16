package ch;


	
	
	import java.util.List;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import io.github.bonigarcia.wdm.WebDriverManager;
	public class irctc {
		
		public static void main(String[] args) {
			try {
		

			WebDriverManager.chromedriver().setup();
			ChromeOptions o = new ChromeOptions();
			o.addArguments("--disable-popup");
			o.addArguments("--disable-notifications");
//			o.addArguments("--headless");
					
					WebDriver driver = new ChromeDriver(o);
					WebDriverWait wait = new WebDriverWait(driver, 30);
					
					driver.get("https://www.irctc.co.in/nget/train-search");
					
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@CLASS='ng-tns-c57-8 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']")));
					
					driver.findElement(By.xpath("//input[@CLASS='ng-tns-c57-8 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']")).click();
				
	driver.findElement(By.xpath("//span[text()='CHENNAI EGMORE - MS']")).click();
	
	driver.findElement(By.xpath("//input[@CLASS='ng-tns-c57-9 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']")).click();
	driver.findElement(By.xpath("//span[text()='MADURAI JN - MDU']")).click();
	
	
	WebElement date = driver.findElement(By.xpath("//input[@class='ng-tns-c58-10 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']"));
	date.sendKeys("26/06/2023");
	
	
	
	
String month = "August";


Thread.sleep(2000);
driver.findElement(By.xpath("//input[@class='ng-tns-c58-10 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']")).click();
   while (true) {
String text = driver.findElement(By.xpath("//*[@id=\"jDate\"]/span/div/div/div[1]/div/span[1]")).getText();
 if (text.equals(month))
 {
	 break;
 }
 else {
	 driver.findElement(By.xpath("//*[@id=\"jDate\"]/span/div/div/div[1]/a[2]/span")).click();
	 
 }

	
   }
	
   driver.findElement(By.xpath("//a[text()='20']")).click();
   
   
   driver.findElement(By.xpath("//button[@type='submit']")).click();
   
   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" (//i[@class='fa fa-align-justify'])[1]"))).click();
   
   
  
   driver.findElement(By.xpath(" //button[text()='LOGIN']")).click();
   
   driver.findElement(By.xpath("//input[@placeholder='User Name']")).sendKeys("gowthamk55");
   driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Gowtham@07");
   


	
	
		}	
			catch (Exception e) {
				System.out.println(e.toString());
				
			}
		
		}
	}



