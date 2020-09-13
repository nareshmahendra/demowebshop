package testBVT;
import reusableLibrary.*;

import java.math.BigDecimal;

import org.openqa.selenium.By;

import objectRepository.*;

public class CreateOrderScenario extends ReusableLibrary{


public CreateOrderScenario() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

public static void main(String[] args) {
try {
	// instance of CreateOrderScenario 
	CreateOrderScenario cs = new CreateOrderScenario();
	
	// launching page
	cs.launchSite(cs.properties.getProperty("URL"));
	
	// clicking login link 
	cs.click(LogInPage.lnkLogIn, "Login Link");
	
	//verifying Welcome signIn text
	cs.verifyElementPresence(LogInPage.txtWelcomeSignIn);
	
	// Entering user credentials
	cs.enterText(LogInPage.txtBoxEmail, cs.properties.getProperty("userName") , "username ");
	cs.enterText(LogInPage.txtBoxPassword, cs.properties.getProperty("password") , "password");
	cs.click(LogInPage.btnLogin ,"Login Button");
	
	// verifying the loginText/Welcome text
	cs.verifyElementPresence(LogInPage.txtWelcomeSignIn);
	
	// clearing shipping list
	// checking if shopping list has items or NOT
	String shippingListCount = cs.driver.findElement(HomePageAndProductsPage.lnkShoppingCartQuantity).getText().replaceAll("\\D+", "");
	System.out.println(shippingListCount);
	
	// Clearing shopping list if items are greatern than 0
	if(Integer.parseInt(shippingListCount)>0) {
		cs.removeAllItemsInCartAndVerify();
		cs.click(HomePageAndProductsPage.lnkHomePage, "Homepage/logo");
		
	}
	
	System.out.println("Shipping cart is cleared");
	

	
	//selecting a product
	
	// verifying the account username  
	cs.verifyText(HomePageAndProductsPage.lnkAccountName , cs.properties.getProperty("userName") , "Verifying UserID at top right");
	
	//clicking on Books link
	cs.click(HomePageAndProductsPage.lnkBooks ," link Books");
	cs.click(HomePageAndProductsPage.lnkBookProduct , "First book in products");
	
	//Storing product price 
	BigDecimal productPrice = new BigDecimal(cs.driver.findElement(HomePageAndProductsPage.txtProdcutPrice).getText().trim());
	System.out.println(productPrice);
	
	// entering product quantity & adding to cart
	cs.enterText(HomePageAndProductsPage.txtBoxProductQuantity, cs.properties.getProperty("productQuantity"), "Product quantity");
	cs.click(HomePageAndProductsPage.btnAddToCart , "Add to cart button");
	
	//updated total product price 
	productPrice = productPrice.multiply(new BigDecimal(Integer.parseInt(cs.properties.getProperty("productQuantity"))));
	
	
	//verifying product details & checkout
	//verifying success message after add to cart 
	cs.verifyText(ProductDetailsPage.txtAddtoCartMessage , "Message" , "validating suceessmessage after add to cart ");
	cs.scrollToElementUP();
	
	//clicking on shopping cart link
	cs.click(HomePageAndProductsPage.lnkShoppingCart , " shopping cart link");
	BigDecimal actualSbutotal = new BigDecimal(cs.driver.findElement(ProductDetailsPage.txtSubTotal).getText().trim());
	
	
	// write condition here for asserting subtotals
	if(actualSbutotal.compareTo(productPrice)==0) {
		System.out.println("Subtotals were calculated correctly");
	}else {
		System.out.println("Subtotal are not calculated correctly actual is "+actualSbutotal+" expected is "+productPrice);
	}
	
	cs.click(ProductDetailsPage.chkTermsAndService , "Terms & Condition checkbox");
	cs.click(ProductDetailsPage.btnCkeckOut , "Checkout button");
	
	
	//Creating billing address
	
	cs.selectValue(BillingPage.ddlBillingAddress, "New Address" , "Billing Address");
	
	// adding for creating new billing address with unique first name everytime	
	String firstName = cs.properties.getProperty("firstName") + String.valueOf(System.currentTimeMillis()).substring(8);
	cs.enterText(BillingPage.txtBoxFirstName, firstName , "First Name");
	cs.enterText(BillingPage.txtBoxLastname, cs.properties.getProperty("lastName") , "Last NAme");
	cs.enterText(BillingPage.txtBoxEmail, cs.properties.getProperty("emailID") , " email ID");
	cs.selectValue(BillingPage.ddlCountry, cs.properties.getProperty("country") , "Country" );
	cs.enterText(BillingPage.txtBoxCity, cs.properties.getProperty("city") , "City");
	cs.enterText(BillingPage.txtBoxAddress1,cs.properties.getProperty("address1") , "Address ");
	cs.enterText(BillingPage.txtBoxzip, cs.properties.getProperty("zip") , " zip/postal code ");
	cs.enterText(BillingPage.txtBoxphone, cs.properties.getProperty("phone") , " phone number");
	cs.click(BillingPage.btnBillingContinue , "continue billing button");
	
	//shipping address
	cs.selectByPartialValue(BillingPage.ddlShippingAddress, firstName);
	cs.click(BillingPage.btnShippingContinue , "continue billing button");
	
	//shipping method
	cs.click(BillingPage.chbshippiingmEthod , "Shipping method");
	cs.click(BillingPage.btnShippingMethodContinue , "continue shipping button");
	
	//payment
	cs.click(BillingPage.chbCOD , "Billing Type");
	cs.click(BillingPage.btnPaymentContinue , "continue payment button");
	
	//confirmation
	cs.verifyText(BillingPage.txtCODmessage , "Message" , " COD acknownledge text");
	cs.click(BillingPage.btnPaymentContinueAfterConfirmation ,"continue COD  button");
	
	// order confirmation
	cs.click(BillingPage.btnConfirmOrder , " confirm order button" );
	cs.verifyText(BillingPage.txtOrderConformationMessage , "Message" , " order acknownledge text");
	
	//order number
	String orderNumber = cs.driver.findElement(BillingPage.txtOrderNumber).getText().replaceAll("\\D+","");
	System.out.println("Order number is "+orderNumber);
	cs.click(BillingPage.btnOderContinue  , "continue Order button");
	
	//loggingout
	cs.click(HomePageAndProductsPage.linkLogout , " logoutLink "  );
	
	//closing driver
	cs.driver.close();

} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	System.out.println("done");
}




}

private static void removeAllItems() {
	// TODO Auto-generated method stub
	
}


}
