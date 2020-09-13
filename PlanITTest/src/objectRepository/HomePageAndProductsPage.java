package objectRepository;

import org.openqa.selenium.By;

public class HomePageAndProductsPage {

	public static By lnkAccountName = By.xpath("//a[text()='atest@gmail.com']");
	public static By lnkBooks = By.xpath("//div[@class='listbox']//a[contains(text(),'Books')]");
	public static By lnkBookProduct = By.xpath("(//div[@class='details'])[1]//a");
	public static By txtProdcutPrice = By.xpath("//span[@itemprop='price']");
	public static By txtBoxProductQuantity = By.cssSelector("input.qty-input");
	public static By btnAddToCart = By.xpath("//input[@value='Add to cart']");
	public static By linkLogout = By.cssSelector("a.ico-logout");
	public static By lnkShoppingCart = By.cssSelector("li#topcartlink a.ico-cart");
	public static By lnkShoppingCartQuantity = By.cssSelector("li#topcartlink span.cart-qty");
	public static By txtboxQuantity = By.cssSelector("input.qty-input");
	public static By btnUpdateCart = By.xpath("//input[@name='updatecart']");
	public static By txtEmptyShoppingcartText = By.cssSelector("div.order-summary-content");
	public static By lnkHomePage = By.cssSelector("div.header-logo a");
	
}
