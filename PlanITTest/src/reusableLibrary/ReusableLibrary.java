package reusableLibrary;

import objectRepository.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

import org.jsoup.select.Selector;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableLibrary {
	public WebDriver driver;
	public String propertiesFilePath = System.getProperty("user.dir") + "\\config.properties";
	public Properties properties = new Properties();
	String cWorkingFolder = System.getProperty("user.dir");

	public ReusableLibrary() throws Exception {
//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", cWorkingFolder +"\\"+ getPropertyValue("chromeDriverPath"));
		driver = new ChromeDriver();

		FileInputStream fileInputStream = new FileInputStream(propertiesFilePath);
		properties.load(fileInputStream);
	}

	public void launchSite(String url) {
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("Webpage is launched is " + url);

	}

	public boolean verifyElementPresence(By by) {
		List<WebElement> elements = driver.findElements(by);
		if (elements.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void verifyText(By by, String expectedText, String message) {
		waitForElementPresence(by);
		String actualText = driver.findElement(by).getText().trim();
		if (actualText.equals(expectedText)) {
			System.out.println(message + "successfull and text is  " + expectedText);
		} else {
			System.out.println(
					message + "Unsuccessfull and expect text is  " + expectedText + " and actual is " + actualText);
		}

	}

	public void click(By by, String elementName) {
		waitForElementPresence(by);
		driver.findElement(by).click();
		System.out.println("Perofrmed click action on element " + elementName);

	}

	public void enterText(By by, String value, String elementName) {
		waitForElementPresence(by);
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);
		System.out.println("Entered text " + value + " in to " + elementName);

	}

	public void waitForElementPresence(By by) {
		WebDriverWait waitSelenium = new WebDriverWait(driver, 60);
		waitSelenium.until(ExpectedConditions.visibilityOfElementLocated(by));
		waitSelenium.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void scrollToElementUP() throws Exception {
		try {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);

		} catch (Exception exc) {

			exc.printStackTrace();

		}

	}

	public void selectValue(By by, String value, String elementName) {
		Select select = new Select(driver.findElement(by));
		select.selectByVisibleText(value);
		System.out.println("Selected " + elementName + " in dropdown list");
	}

	public void selectByPartialValue(By by, String value) {
		waitForElementPresence(by);
		Select select = new Select(driver.findElement(by));
		List<WebElement> elements = select.getOptions();
		for (WebElement webElement : elements) {
			System.out.println(webElement.getText());
			if (webElement.getText().contains(value)) {
				select.selectByVisibleText(webElement.getText().trim());
				break;
			}
		}
	}

	public void removeAllItemsInCartAndVerify() {
		click(HomePageAndProductsPage.lnkShoppingCart, "Shopping Cart");
		List<WebElement> elements = driver.findElements(HomePageAndProductsPage.txtBoxProductQuantity);
		for (WebElement webElement : elements) {
			webElement.clear();
			webElement.sendKeys("0");
		}
		driver.findElement(HomePageAndProductsPage.btnUpdateCart).click();
		waitForElementPresence(HomePageAndProductsPage.txtEmptyShoppingcartText);
		verifyText(HomePageAndProductsPage.txtEmptyShoppingcartText, "Your Shopping Cart is empty!",
				"verifying shopping cart empty");

	}

	public String getPropertyValue(String key) throws Exception {
		FileInputStream fileInputStream = new FileInputStream(propertiesFilePath);
		properties.load(fileInputStream);
		return properties.get(key).toString();
	}

}
