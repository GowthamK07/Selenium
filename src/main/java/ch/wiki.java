package ch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class wiki {

	static int rvalue ;
	static int cvalue ;
		
	public static void main(String[] args) {
		
		try {
			
			WebDriverManager.chromiumdriver().setup();
			ChromeOptions o = new ChromeOptions();
			o.addArguments("--disable-popup");
			o.addArguments("--disable-notifications");
			o.addArguments("--headless");
			
			DesiredCapabilities des = new DesiredCapabilities();
			des.
			
			WebDriver driver = new ChromeDriver();
			
			
			driver.get("https://en.wikipedia.org/wiki/List_of_states_and_union_territories_of_India_by_area");
			
		int rsize = driver.findElements(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']//tbody//tr")).size();
		int csize = driver.findElements(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']//tr[1]//td")).size();	
			
		
		
		for (int i = 1; i <=rsize; i++) {
			
			for (int j = 1; j <=csize; j++) {
				
				WebElement ele = driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']//tr["+i+"]//td["+j+"]"));
		      
		    	String text = ele.getText();
		    	
		    	 if (text.contains("Tamil Nadu")) {
		    		 System.out.println(i);
		    		 
		    		 System.out.println(j);
		    		 
		    		 rvalue =i;
		    		 cvalue = j;
				}
		
		      }
		      
			}
				
		for (int k = 1; k <=rsize; k++) {
			WebElement ele = driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']//tr["+k+"]//td["+cvalue+"]"));
		String text = ele.getText();
		System.out.println(text);
		}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
		}
		
		
		
		
		
		
		
		
		
		
	}
	
}
