package week4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.stream.*;

public class frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    	ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Launch LeafGround
		driver.get("http://www.leafground.com/pages/frame.html");
				
		//Click
		driver.switchTo().frame(0);
		driver.findElementById("Click").click();
		String text = driver.findElementById("Click").getText();
		String s2 = "Hurray! You Clicked Me.";
		System.out.println("Clicked in a Frame " + text.equals(s2));

		driver.switchTo().defaultContent();
		
		//Click on nested frame
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		driver.findElementById("Click1").click();
		String text1 = driver.findElementById("Click1").getText();
		String s3 = "Hurray! You Clicked Me.";
		System.out.println("Clicked in a Frame " + text.equals(s3));

		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		
		//Find number of frames
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("The total number of iframes in Main Page are " + iframeElements.size());
		
		int innerframesize =0;
		
		for (int i = 0; i < iframeElements.size(); i++) {
			driver.switchTo().frame(i);
			System.out.println("innerframesize" + innerframesize);
			List<WebElement> innerframe = driver.findElementsByTagName("iframe");
			innerframesize = innerframe.size();
			innerframesize = innerframesize + 1;
			driver.switchTo().defaultContent();
		}
		System.out.println("The total number of Inner frames are " + innerframesize);
		driver.close();
	}

}
