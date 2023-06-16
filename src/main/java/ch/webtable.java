package ch;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.util.PaneInformation;
import org.apache.poi.ss.usermodel.AutoFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellRange;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.CosNaming.NamingContextPackage.NotFoundReasonHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webtable {
	
	static int htext ;
	static int cvalue ;
	

	public static void main(String[] args)   {
		
		
	try {	
WebDriverManager.chromedriver().setup();
		
		WebDriver driver =new ChromeDriver();
	
		
	WebDriverWait w = new WebDriverWait(driver, 10);
		driver.get("https://qavbox.github.io/demo/webtable/");
		driver.manage().window().maximize();
		
	int rsize = driver.findElements(By.xpath("//table[@id='table02']//tbody//tr")).size();
	int csize = driver.findElements(By.xpath("//table[@id='table02']//tr[1]//td")).size();	
	
	System.out.println(rsize);
	System.out.println(csize);	
	
	File f = new File("/Users/gowtham/eclipse-workspace/ch/src/main/resources/table3.xlsx");
	Workbook wb = new XSSFWorkbook();
	Sheet sheet = wb.createSheet();
	
	List<WebElement> list = driver.findElements(By.xpath("//table[@id='table02']//thead//tr//th"));
	int head = list.size();
	System.out.println("h size "+head);
	
	
	for (WebElement hlist : list) {
		
		String htext = hlist.getText();
		System.out.println(htext);
	      Row ro = sheet.createRow(0);
	      
	
			
			
		
		
		
	}
	
		for (int i = 1; i <= rsize; i++) {
			Row row = sheet.createRow(i);
			
			for (int j = 1; j <=csize; j++) {
				WebElement element = driver.findElement(By.xpath("//table[@id='table02']//tbody//tr["+ i +"]//td["+ j+ "]"));
				
				String text = element.getText();
				Cell hcell = row.createCell(j);	
				hcell.setCellValue(htext);
				Cell cell = row.createCell(j);
				cell.setCellValue(text);
				System.out.print(text +"     \t");
			}
			System.out.println();
		}
		
	
		FileOutputStream f2 = new FileOutputStream(f);
		
		wb.write(f2);
		f2.close();	
		
		
		
	}
	catch (Exception e) {
		System.out.println(e.toString());
	}
	
	}
	

}
