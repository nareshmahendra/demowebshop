package objectRepository;

import org.openqa.selenium.By;

public class ProductDetailsPage {
	public static By txtAddtoCartMessage = By.cssSelector("p.content");
	public static By txtSubTotal = By.xpath("//span[text()='Sub-Total:']/../..//td[2]//span[@class='product-price']");
	public static By chkTermsAndService = By.cssSelector("input#termsofservice");
	public static By btnCkeckOut = By.cssSelector("button#checkout");
}
