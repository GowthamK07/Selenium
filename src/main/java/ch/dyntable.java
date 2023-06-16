package ch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class dyntable {
	
	public static void main(String[] args) {
		try {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://qavbox.github.io/demo/webtable/");
		
		driver.manage().window().maximize();
		
		int rsize = driver.findElements(By.xpath("//table[@id='table02']//tbody//tr")).size();
		int csize = driver.findElements(By.xpath("//table[@id='table02']//tbody//tr[1]//td")).size();
		
		for (int i = 1; i <=rsize ; i++) {
			
			for (int j = 1; j <=csize; j++) {
				WebElement ele = driver.findElement(By.xpath("//table[@id='table02']//tbody//tr["+i+"]//td["+j+"]"));
				
				String text = ele.getText();
				System.out.print(text+  "\t");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
		catch (Exception e) {
		System.out.println(e.toString());
		}
		
	}
	

}
