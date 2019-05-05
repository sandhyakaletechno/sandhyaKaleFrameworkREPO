package com.TCS.Google.base;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.TCS.Google.CONSTANT.FilePaths;

import customExceptions.ElementNotEnabledException;

public class PredefinedActions {
	private static WebDriver driver;

	@Test
	public static void initialization() {
		System.setProperty("webdriver.chrome.driver", FilePaths.CHROMEEXEPATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.borland.com/gmopost/");
		// driver.get("https://www.google.com/");

	}

	// [id]:-abc
	protected static WebElement getElement(String locator) {
		String locatorType = getLocatorType(locator);
		String locatorvalue = getLocatorValue(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);

		switch (locatorType.toUpperCase()) {
		case "ID":
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorvalue)));

		case "XPATH":
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorvalue)));
		case "NAME":
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorvalue)));
		default:
			return null;

		}

	}

	private static void setBorderVisibility(WebElement element, boolean flag) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (flag)
			js.executeScript("arguments[0].style.border='3px red solid'", element);
		else
			js.executeScript("arguments[0].style.border='0px red solid'", element);

	}

	public static void click(String locator) {
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		setBorderVisibility(element,true);
		element.click();
		

	}
	

		
	
	/*public static void clickOnElement(String locator){
		driver.findElement(By.xpath(locator)).click();
	}*/

	private static String getLocatorType(String locator) {
		return locator.split(":-")[0].replace("[", "").replace("]", "");
	}

	private static String getLocatorValue(String locator) {
		return locator.split(":-")[1];

	}

	protected void setText(String locator, String value) {
		WebElement element = getElement(locator);
		if (element.isEnabled()) {
			element.sendKeys(value);
			// return;
		} else
			throw new ElementNotEnabledException(locator + "is not enabled ,expected to be enabled");

	}
	protected void setText(String locator, String value,boolean ignoredException) {
		WebElement element = getElement(locator);
		if (element.isEnabled()) {
			element.sendKeys(value);
			// return;
		} else
			throw new ElementNotEnabledException(locator + "is not enabled ,expected to be enabled");

	}
	public String getText(String locator) {
		WebElement element = getElement(locator);
		return element.getText();
		
	}

	protected String getPageTitle() {
		return driver.getTitle();

	}

	public static String getPageURL() {
		return driver.getCurrentUrl();
	}

	public static boolean visibilityOfElement(String locator) {
		WebElement element = null;
		try {
			element = getElement(locator);
			/*
			 * if(element.isDisplayed()){ return true; }else{ return false; }
			 */
			return element.isDisplayed();
			//element.isEnabled();
		} catch (NoSuchElementException ne) {
			return false;
		}
	}
		public static boolean isElementClickable(String locator){ 
			WebElement element = null;
			try{
				element = getElement(locator);
				return element.isEnabled();
			}catch(NoSuchElementException ne){
			
			return false;
		}

	}

		public String getTextOnAlert(){
			return driver.switchTo().alert().getText();
		}
		
		
		public boolean isAlertAccepted(){
			try{
				
					driver.switchTo().alert().accept();	
				
				return true;
			}catch(NoAlertPresentException ne){
				return false;
			}
			
			
		}
		
		public void goToBackPage(){
			driver.navigate().back();
		}
		
		public String getItemNumber(String locator){
			return getText(locator);
		}
		
		
		public boolean verifyIncreasingOrderOfItemNumber(String locator){
			int number=1000;
			for(int i = 0;i<6;i++){
		String itemNumber = getText(locator);
		System.out.println(itemNumber+" in predefined");
		Integer itemNumber1 = Integer.parseInt(itemNumber);
			if(itemNumber1==number){
				System.out.println(itemNumber1+"="+number+" "+"in if condition");
				
				number++;
			}else{
				return false;
			}
			}
			return true;
			
			
		}
		
}
