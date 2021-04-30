package CumcuberPOM;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POMBase {
	
	WebDriver driver;
		
	public WebDriver Connection() {
		System.setProperty(variables.SELENIUM_NAME, variables.SELENIUM_PATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public void presenceOfTheElementLocated(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, variables.GLOBAL_TIMEOUT);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (NoSuchElementException e) {
			System.out.println("Locator was not found");
		}
	}
	
	public void type(String inputText, By locator) {
		presenceOfTheElementLocated(locator);
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public void click(By locator) {
		presenceOfTheElementLocated(locator);
		driver.findElement(locator).click();
	}
	
	public boolean isDisplayed(By locator) {
		presenceOfTheElementLocated(locator);
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void selectOption(By locator, String value) {
		presenceOfTheElementLocated(locator);
		WebElement element = driver.findElement(locator);
		Select option = new Select(element);
		option.selectByValue(value);
	}
	
	public void asserTrue(By locator) {
		presenceOfTheElementLocated(locator);
		assertTrue(isDisplayed(locator));
	}
	
	public void assertEquals(String actualResult, String expectedResult) {
		assertEquals(actualResult, expectedResult);
	}
	
	public void visit(String url) {
		driver.navigate().to(url);
	}
	
	public void quit() {
		try {
			driver.quit();
		} catch (NoSuchElementException e) {
			System.out.println("There was an issue closing browser");
		}
	}
	
	public void failed() {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formate = new SimpleDateFormat("ddMMyyyyhhmmss");
		try {
			FileUtils.copyFile(srcFile, new File("./src/test/resources/ScreenShots/ErrorImage"+formate.format(calendar.getTime())+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void successed() {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formate = new SimpleDateFormat("ddMMyyyyhhmmss");
		try {
			FileUtils.copyFile(srcFile, new File("./src/test/resources/ScreenShots/Image"+formate.format(calendar.getTime())+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
