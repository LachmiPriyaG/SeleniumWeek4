package week4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class acme {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
/*
 1) Launch URL: https://acme-test.uipath.com/account/login
2) Enter UserName (kumar.testleaf@gmail.com) and TAB
3) Enter Password (leaf@12)
4) Click Login
5) Mouse Over on Vendors
6) Click Search Vendor
7) Enter Vendor Name (Blue Lagoon)
8) Click Search
9) Find the Country Name based on the Vendor
10) Click Log Out
11) Close browser
 */
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    	ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
				 
		//Drag and Drop
		  driver.get("https://acme-test.uipath.com/account/login");
	    
		  driver.findElementById("email").click();
		  driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		  driver.findElement(By.id("password")).click();
		  driver.findElement(By.id("password")).sendKeys("leaf@12");
		  driver.findElement(By.id("buttonLogin")).click();
		  	  
		  Thread.sleep(6000);
		  /* WebElement mouseover = driver.findElementByXPath("//button[contains(.,'Vendors')]");
	      Actions builder = new Actions(driver);
	      builder.moveToElement(mouseover).perform();	*/	 		  
	      
	      Actions builder = new Actions (driver);
	  	  WebElement mouseover= driver.findElement(By.xpath("(//button[@type='button'])[6]"));
	  	  builder.moveToElement(mouseover).perform();
	      
		  driver.findElement(By.linkText("Search for Vendor")).click();
		  driver.findElement(By.id("vendorName")).click();
		  driver.findElement(By.id("vendorName")).sendKeys("Blue Lagoon");
		  driver.findElement(By.id("buttonSearch")).click();
		  
		  String country = driver.findElementByXPath("//table[@class='table']/tbody[1]/tr[2]/td[5]").getText();
		  System.out.println(country);
		  driver.findElementByLinkText("Log Out").click();
		  driver.close();
	}

}
