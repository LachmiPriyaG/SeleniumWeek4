package week4;

import org.apache.poi.hpsf.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class zoomCar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    	ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.zoomcar.com/chennai");
	    
		driver.findElementByLinkText("Start your wonderful journey").click();
		
		driver.findElementByXPath("//div[text()[normalize-space()='Thuraipakkam']]").click();
		
		driver.findElementByClassName("proceed").click();
		  
		Calendar calendar = Calendar.getInstance();
		java.util.Date today = calendar.getTime();
		
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		java.util.Date tomorrow = calendar.getTime();
		
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		java.util.Date DAT = calendar.getTime();
		
		DateFormat dateFormat = new SimpleDateFormat("EE");
		String todayAsString = dateFormat.format(today);
		String tomorrowAsString = dateFormat.format(tomorrow);
		String DATAsString = dateFormat.format(DAT);
	
		Thread.sleep(1000);
		System.out.println(todayAsString);
		System.out.println(tomorrowAsString);
		System.out.println(DATAsString);
		
		//driver.findElementByXPath("//div[contains(@class,'day picked')]/following-sibling::div[1]").click();
		String xpath = "//div[text()='" + tomorrowAsString + "']";
		System.out.println(xpath);
		driver.findElementByXPath(xpath).click();
				                             
		Thread.sleep(100);
		driver.findElementByClassName("proceed").click();
		Thread.sleep(100);
		
		String xpath1 = "//div[text()='" + DATAsString + "']";
		System.out.println(xpath1);
		driver.findElementByXPath(xpath1).click();
		driver.findElementByClassName("proceed").click();
			
		Thread.sleep(7000);
		WebDriverWait wait = new WebDriverWait (driver , 25);
		driver.findElementByXPath("//div[text()=' Price: High to Low ']").click();
		
		Thread.sleep(7000);
		List<WebElement> noofcars = driver.findElementsByClassName("car-listing");
		System.out.println("Total Number of cars available " + noofcars.size());
		
		for (int i=0; i<noofcars.size();i++){
			WebElement element = noofcars.get(i);
			System.out.println(element.getText());
	    }
		
		System.out.println("Get model and price list");
		List<WebElement> model = driver.findElementsByXPath("(//div[@class='details']//h3)");
		List<WebElement> price = driver.findElementsByXPath("//div[@class='price']");
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();

		for (int i = 0; i < model.size(); i++) 
		{
			System.out.println(model.get(i).getText());
		}
		
		for (int i = 0; i < price.size(); i++) 
		{
			System.out.println(price.get(i).getText());
		}
		
		Map maps = new LinkedHashMap();
		 for(int i=0;i<noofcars.size();i++){
			 String value = price.get(i).getText();
			 String value1 = value.substring(2);
			 maps.put(model.get(i).getText(), value1 );
		 }
		 
    	Set<String> keys = maps.keySet();
		for (String eachKey : keys) {
			System.out.println(eachKey+" -> "+maps.get(eachKey));
			}
		 
		// getting maximum value using max() 
        String maxMap = Collections.max(maps.values()); 
        System.out.println("Maximum priced car model is: " + maxMap); 
        
        for(int i=0;i<noofcars.size();i++){	 
       
			if ((noofcars.get(i).getText().contains(maxMap)))
			{
				driver.findElementByName("book-now").click();
			}
		 }
        
        Thread.sleep(5000);
		driver.close();
	}
}














