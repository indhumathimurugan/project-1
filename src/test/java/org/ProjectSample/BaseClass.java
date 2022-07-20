package org.ProjectSample;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver;
	
	public static WebDriver launhBrowser(String[] args) {
		return driver;
		
	
		}
	
	// browser
public static WebDriver ChromeBrowser() {
	   WebDriverManager.chromedriver().setup();
	    driver= new ChromeDriver();
	    return driver;
		
		
	}
   public static WebDriver firefoxBrowser() {
	   WebDriverManager.firefoxdriver().setup();
	    driver= new FirefoxDriver();
	    return driver;
		
   }
   public static WebDriver edgeBrowser() {
	   WebDriverManager.edgedriver().setup();
	    driver= new EdgeDriver();
	    return driver;
   }
   
   //url launch
   public static void urllanch(String url) {
	   driver.get(url);
}
   
   // maximize
   public static void maximaize() {
	   driver.manage().window().maximize();
	   
}
   
   //implicity
	public static  void implicitwait(long secs) {
		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
			
	}	
	
	//sendkeys
	
	public static void sendkeys(WebElement e, String value) {
		e.sendKeys(value);
		
	}
	
	public static void click(WebElement e) {
		e.click();
	}
	//current Url
	public static String currentUrl() {
		String url = driver.getCurrentUrl();
		return url;
		
	}
	
	//Title
	public static String title() {
		String title = driver.getTitle();
		return title;
		
	}
	
	//quit
	public static void quit() {
		driver.quit();
		
		
		}
	//GetAttribute
	public static  String getAttribute (WebElement e) {
		String att = e.getAttribute("value");
		return att;
	}
	// Actions
	public static void moveToElement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
		
		
	}
	
	
	public static void selectByindex(WebElement string, int i) {
		Select s = new Select(string);
		s.selectByIndex(i);
		
	}
	
	public static String alert() {
		Alert a = driver.switchTo().alert();
		String t = a.getText();
		return t;
		
		
	}
	
	public static void selectByvalue(WebElement e, String value) {
		Select s = new Select(e);
		s.selectByValue(value);
		
	
	}
	
	public static void selectByvisibleText(WebElement e, String value) {
		Select s = new Select(e);
		s.selectByVisibleText(value);
	}
	
	
	
	public static void getoptions(WebElement e) {
		Select s = new Select(e);
		s.getOptions();
	}
	
	public static void getAlloptions(WebElement e, String value) {
		Select s = new Select(e);
		s.getAllSelectedOptions();
	
	}
	
	
	public static void getfirstselectoption(WebElement e, String value) {
		Select s = new Select(e);
		s.getFirstSelectedOption();
	}
	public static void ismultiple(WebElement e) {
		Select s = new Select(e);
		s.isMultiple();
	}
	
	public static void deselectByIndex(WebElement e, int i) {
		Select s = new Select(e);
		s.deselectByIndex(i);
	}
	
	public static void delectedbByvalue(WebElement e, String value) {
		Select s = new Select(e);
		s.deselectByValue(value);
	}
	
	public static void deselectedByvisibleText(WebElement e, String value) {
		Select s = new Select(e);
		s.deselectByVisibleText(value);
	}
	
	public static void deselectAll(WebElement e) {
		Select s = new Select(e);
		s.deselectAll();
	}
	
	
	
	public static void Screenshot(WebElement e, String value) throws IOException {
		TakesScreenshot t = (TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File des = new File(value);
		FileUtils.copyFile(src, des);
		
	}
	
	
	


}
