package week4;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class mergeLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
/*
 *      * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 2. Enter UserName and Password Using Id Locator
		 * 3. Click on Login Button using Class Locator
		 * 4. Click on CRM/SFA Link
	     * 5. Click on contacts Button
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 7. Click on Widget of From Contact
		 * 8. Click on First Resulting Contact
		 * 9. Click on Widget of To Contact
		 * 10. Click on Second Resulting Contact		  
		 * 11. Click on Merge button using Xpath Locator	 
		 * 12. Accept the Alert		 
		 * 13. Verify the title of the page
 */
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    	ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Launch LeafGround
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElementById("username").sendKeys("Demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		
		//Merge Contacts
		driver.findElement(By.linkText("Contacts")).click();
	    driver.findElement(By.xpath("//a[@href='/crmsfa/control/mergeContactsForm']")).click();
	    	    
	    driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();	
	    String parentcallpWindowHandle = driver.getWindowHandle();
	    Set<String> allWindowHandlescp = driver.getWindowHandles();
	    for(String handle1 : allWindowHandlescp)
	    {
	     driver.switchTo().window(handle1); 
	    }
	    driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();		
	    driver.switchTo().window(parentcallpWindowHandle);
	    
	    driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();	
	    String parentcallpWindowHandle1 = driver.getWindowHandle();
	    Set<String> allWindowHandlescp1 = driver.getWindowHandles();
	    for(String handle2 : allWindowHandlescp1)
	    {
	         driver.switchTo().window(handle2); 
	    }
	    driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/following::table/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();		
	    driver.switchTo().window(parentcallpWindowHandle);
	   
	    driver.findElementByLinkText("Merge").click();
	    
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	
	    Thread.sleep(5000);
	    System.out.println("Title of PAge is : " + driver.getTitle());
	    driver.close();
	}

}
