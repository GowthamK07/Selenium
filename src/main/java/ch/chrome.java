package ch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked;

public class chrome {

	public static void main(String[] args) throws Exception {

		try {
			WebDriverManager.gecko().setup();
			WebDriverManager.chromedriver().setup();

			WebDriver driver = new ChromeDriver();

			WebDriverWait w = new WebDriverWait(driver, 10);
			driver.get("https://www.flipkart.com");
			driver.manage().window().maximize();

			WebElement a = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));

			a.click();

			driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone 13");

			driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();

			w.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[contains(text(),'APPLE iPhone 13 (Starlight, 128 GB)')]")))
					.click();
			Set<String> wh = driver.getWindowHandles();

			List<String> list = new ArrayList<String>(wh);
			driver.switchTo().window(list.get(1));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			TakesScreenshot sh = (TakesScreenshot) driver;

			w.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'256 GB')]")));

			WebElement down = driver.findElement(By.xpath("//a[contains(text(),'256 GB')]"));

			js.executeScript("arguments[0].scrollIntoView(true)", down);

			down.click();

			WebElement pin = driver.findElement(By.xpath("//input[@id='pincodeInputId']"));

			w.until(ExpectedConditions.elementToBeClickable(pin)).sendKeys("600078");

			w.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Check']"))).click();

			File src = sh.getScreenshotAs(OutputType.FILE);

			File des = new File("/Users/gowtham/eclipse-workspace/ch/src/main/resources/product.png");

			FileUtils.copyFile(src, des);

//     driver.findElement(By.xpath("//a[contains(text(),'256 GB')]")).click();

//     driver.findElement(By.xpath("//div[contains(text(),'APPLE iPhone 13 (Starlight, 128 GB)')]")).click();
//     List<WebElement> name = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
//     
//     int size1 = name.size();
//     System.out.println(size1);
//     

//   
//     File f = new File("/Users/gowtham/eclipse-workspace/ch/driver/111newfmob.xlsx");
//     Workbook w = new XSSFWorkbook();
//       Sheet s = w.createSheet("iphone");
//       
//       
//       
//        for (int i = 0; i <name.size(); i++) {
//        	WebElement header = name.get(i);
//        	String names = header.getText();
//        	
//   	
//   List<WebElement> price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
//    
//    for (int j = i;j==i; j++) {
//       WebElement el = price.get(j);
//       String text2 = el.getText();
//      
//		Map<String,String> map = new  LinkedHashMap<String, String>();
//		  map.put(names, text2);
//		  Set<Entry<String, String>> entrySet = map.entrySet();
//		for (Entry<String, String> entry : entrySet) {
//			System.out.println(entry);
//		}
//	
//        }		
//		}
//     
		} catch (Exception e) {

			System.out.println(e.toString());
		}

	}

}
