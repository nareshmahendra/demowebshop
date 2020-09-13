package test;
import reusableLibrary.*;

import org.openqa.selenium.By;

import objectRepository.*;

public class CreateOrderScenario extends ReusableLibrary{


public static void main(String[] args) {
try {
	CreateOrderScenario createOrderScenario = new CreateOrderScenario();
	createOrderScenario.launchSite("http://demowebshop.tricentis.com/");
	
	// clicking login link 
	createOrderScenario.click(LogInPage.lnkLogIn, "Login Link");
	
	//verifying text
	createOrderScenario.verifyElementPresence(LogInPage.txtWelcomeSignIn);
	createOrderScenario.enterText(LogInPage.txtBoxEmail, "atest@gmail.com" , "username ");
	createOrderScenario.enterText(LogInPage.txtBoxPassword, "123456" , "password");
	createOrderScenario.click(LogInPage.btnLogin ,"Login Button");
	
	createOrderScenario.verifyElementPresence(LogInPage.txtWelcomeSignIn);
	
	// clearing shipping list 
	String shippingListCount = createOrderScenario.driver.findElement(HomePageAndProductsPage.lnkShoppingCartQuantity).getText().replaceAll("\\D+", "");
	System.out.println(shippingListCount);
	
	if(Integer.parseInt(shippingListCount)>0) {
		createOrderScenario.removeAllItemsInCartAndVerify();
		createOrderScenario.click(HomePageAndProductsPage.lnkHomePage, "Homepage/logo");
		
	}
	
	System.out.println("Shipping cart is cleared");
	

	
	// verifying 
	
	//selecting a product
	createOrderScenario.verifyText(HomePageAndProductsPage.lnkAccountName , "atest@gmail.com" , "Verifying UserID at top right");
	createOrderScenario.click(HomePageAndProductsPage.lnkBooks ," link Books");
	createOrderScenario.click(HomePageAndProductsPage.lnkBookProduct , "First book in products");
	String productPrice = createOrderScenario.driver.findElement(HomePageAndProductsPage.txtProdcutPrice).getText();
	System.out.println(productPrice);
	createOrderScenario.enterText(HomePageAndProductsPage.txtBoxProductQuantity, "10" , "Product quantity");
	createOrderScenario.click(HomePageAndProductsPage.btnAddToCart , "Add to cart button");
	
	
	//verifying product details & checkout
	createOrderScenario.verifyText(ProductDetailsPage.txtAddtoCartMessage , "Message" , "validating suceessmessage after add to cart ");
	createOrderScenario.scrollToElementUP();
	createOrderScenario.click(HomePageAndProductsPage.lnkShoppingCart , " Shppoing cart link");
	String actualSbutotal = createOrderScenario.driver.findElement(ProductDetailsPage.txtSubTotal).getText().trim();
	// write condition here for asserting subtotals
	createOrderScenario.click(ProductDetailsPage.chkTermsAndService , "Terms & Condition checkbox");
	createOrderScenario.click(ProductDetailsPage.btnCkeckOut , "Checkout button");
	
	
	//Creating billing address
	
	createOrderScenario.selectValue(BillingPage.ddlBillingAddress, "New Address" , "Billing Address");
	createOrderScenario.enterText(BillingPage.txtBoxFirstName, "test1" , "First Name");
	createOrderScenario.enterText(BillingPage.txtBoxLastname, "test1" , "Last NAme");
	createOrderScenario.enterText(BillingPage.txtBoxEmail, "test1@gmail.com" , " email ID");
	createOrderScenario.selectValue(BillingPage.ddlCountry, "India" , "Country" );
	createOrderScenario.enterText(BillingPage.txtBoxCity, "test1" , "City");
	createOrderScenario.enterText(BillingPage.txtBoxAddress1, "test1" , "Address ");
	createOrderScenario.enterText(BillingPage.txtBoxzip, "test1" , " zip/postal code ");
	createOrderScenario.enterText(BillingPage.txtBoxphone, "test1" , " phone number");
	createOrderScenario.click(BillingPage.btnBillingContinue , "continue billing button");
	
	//shipping address
	createOrderScenario.selectByPartialValue(BillingPage.ddlShippingAddress, "test1");
	createOrderScenario.click(BillingPage.btnShippingContinue , "continue billing button");
	
	//shipping method
	createOrderScenario.click(BillingPage.chbshippiingmEthod , "Shipping method");
	createOrderScenario.click(BillingPage.btnShippingMethodContinue , "continue shipping button");
	
	//payment
	createOrderScenario.click(BillingPage.chbCOD , "Billing Type");
	createOrderScenario.click(BillingPage.btnPaymentContinue , "continue payment button");
	
	//confirmation
	createOrderScenario.verifyText(BillingPage.txtCODmessage , "Message" , " COD acknownledge text");
	createOrderScenario.click(BillingPage.btnPaymentContinueAfterConfirmation ,"continue COD  button");
	
	// order confirmation
	createOrderScenario.click(BillingPage.btnConfirmOrder , " confirm order button" );
	createOrderScenario.verifyText(BillingPage.txtOrderConformationMessage , "Message" , " order acknownledge text");
	
	//order number
	String orderNumber = createOrderScenario.driver.findElement(BillingPage.txtOrderNumber).getText().replaceAll("\\D+","");
	System.out.println("Order number"+orderNumber);
	createOrderScenario.click(BillingPage.btnOderContinue  , "continue Order button");
	
	//loggingout
	createOrderScenario.click(HomePageAndProductsPage.linkLogout , " logoutLink "  );

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
