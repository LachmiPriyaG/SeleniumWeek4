package week4;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.stream.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    	ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Launch LeafGround
		driver.get("http://www.leafground.com/pages/table.html");
				
		WebElement eleTable = driver.findElementById("table_id");
		
		//Find nnumber of rows
		List<WebElement> allRows = eleTable.findElements(By.tagName("tr"));
		System.out.println("Number of rows available in table :" + allRows.size());
		
		//Find number of columns
		int Col = 0;
		for (int i = 1; i < allRows.size(); i++) {
			WebElement eachRow = allRows.get(i);
			List<WebElement> allCols = eachRow.findElements(By.tagName("td"));
			Col = allCols.size();
		}
		
		System.out.println("Number of Columns available in table :" + Col );
		
		//Get Progress value of learn to interact with elements
		
		String cell = driver.findElementByXPath("//td[text()='Learn to interact with Elements']/following-sibling::td").getText();
	    System.out.println ("Progress value of Learn to interact with Elements is : " + cell);
		
	    WebElement ele = driver.findElementByXPath("(//input[@name='vital'])[3]");
	    driver.findElementByXPath("(//input[@name='vital'])[3]").click();
	    System.out.println("The least vital element is : " + ele.isSelected());
	    driver.close();
	    		
	}
}
